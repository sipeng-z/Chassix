package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.system.domain.entity.Menu;
import com.system.domain.model.input.MenuInput;
import com.system.domain.model.output.AuthorizeMenuOutput;
import com.system.domain.model.output.MenuOutput;
import com.system.domain.model.output.ZtreeInfo;
import com.utils.MapperName;
import com.utils.TreeUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MenuService extends AbstractService<MenuInput,MenuOutput> {
    private String mapperName = MapperName.Name.MenuName;


    @Override
    public String getMapperName() {
        return mapperName;
    }


    /**
     * 新增
     * @param menuInput
     * @return
     * @throws Exception
     */
    @Override
    public boolean add(MenuInput menuInput) throws Exception {
        //如果添加一个顶级菜单
        String parentid = menuInput.getParentId();
        menuInput.setMenuId(this.getGUID());
        if(parentid.equals(AppConsts.defaultGuId)) {
            return super.add(menuInput);
        }
        //查找父菜单的layer
        MenuOutput rawSystemconfig = (MenuOutput) this.daoImp.findForObject(mapperName+"findByPkId",parentid);
        int layer = rawSystemconfig.getLayer();
        menuInput.setLayer(++layer);
        rawSystemconfig.setHaschild(1);
        this.daoImp.update(mapperName+"updateByPrimaryKeySelective",rawSystemconfig);
        return super.add(menuInput);
    }

    /**
     * 修改
     * @param menuInput
     * @return
     * @throws Exception
     */
    @Override
    public boolean update(MenuInput menuInput) throws Exception {
        //查看当前要改变的菜单，现在数据库中的数据
        MenuOutput menu = (MenuOutput) this.daoImp.findForObject(mapperName+"findByPkId",menuInput.getMenuId());
        int parentidLayer = 0;
        MenuOutput parentMenu = null;
        String parentid = menuInput.getParentId();
        //获得将要成为父级的菜单
        if(parentid!=null && !parentid.equals(AppConsts.defaultGuId)) {
            parentMenu =((MenuOutput)this.daoImp.findForObject(mapperName+"findByPkId",parentid));
            //将要成为父菜单的layer
            parentidLayer = parentMenu.getLayer();
        }
        int childLayer = menu.getLayer();//子菜单的layer
        int result = childLayer-parentidLayer;

        //如果相同则直接更改,即不修改父级
        if(menu.getParentId().equals(menuInput.getParentId()) && result<=1) {
            if(super.update(menuInput)) {
                return true;
            }
        }
        //更新自身
        //给当前对象设置新的layer
        menuInput.setLayer(++parentidLayer);
        if(super.update(menuInput)) {
            PageData pageData = new PageData();
            //判断原来的父级有没有其他子级，若有不更新否则haschild为0
            List<MenuInput> listByParentId = (List<MenuInput>) this.daoImp.findForList(mapperName+"findByParentId",menu.getParentid());
            if(listByParentId==null||listByParentId.size()<=0){
                pageData.put("haschild",0);
                pageData.put("id",menu.getParentId());
            }
            this.daoImp.update(mapperName+"updatehaschild",pageData);
            pageData.put("haschild",1);
            pageData.put("id",menuInput.getParentId());
            this.daoImp.update(mapperName+"updatehaschild",pageData);
            //查找是否有子菜单
            List<MenuInput> list = (List<MenuInput>) this.daoImp.findForList(mapperName+"findByParentId",menu.getMenuId());
            //没有则返回true
            if(listByParentId==null||list.size()<=0) {
                return true;
            }
            //循环调用此方法修改
            for(MenuInput m : list) {
                update(m);
            }
        }
        return true;
    }

    /**
     * 删除
     * @param ids
     * @return
     * @throws Exception
     */
    public int deleteMenu(String ids) throws Exception {
        //查找是否有子菜单
        String[] str = ids.split(",");
        String configid = str[0];
        List<MenuInput> list = (List<MenuInput>) this.daoImp.findForList(mapperName+"findByParentId",configid);
        //如果有子菜单则不允许删除
        if(list.size()>0) {
            return 1; //表示当前菜单存在子菜单无法删除
        }
        //获得该菜单的实体
        MenuOutput systemconfig = (MenuOutput) this.daoImp.findForObject(mapperName+"findByPkId",configid);
        //若该菜单不是一级菜单
        if(systemconfig.getParentId()!=null && !systemconfig.getParentId().equals(AppConsts.defaultGuId)){
            //获得当前菜单的父级菜单
            systemconfig = (MenuOutput) this.daoImp.findForObject(mapperName+"findByPkId",systemconfig.getParentId());
            //获得当前菜单的同级菜单个数
            List<MenuInput> list1 = (List<MenuInput>) this.daoImp.findForList(mapperName+"findByParentId",systemconfig.getMenuId());
            //若当前菜单的同级菜单个数为1则将父级菜单haschild设置为0表示没有子菜单
            if(list1.size()<2){
                systemconfig.setHaschild(0);
                if(this.daoImp.update(mapperName+"updateByPrimaryKeySelective",systemconfig)>0){
                    if(super.delete(ids)){
                        return 0;//表示删除成功
                    }else{
                        return 3;//表示删除菜单失败
                    }
                }else {
                    return 2; //表示父类未更新成功
                }
            }
        }
        if(super.delete(ids)){
            return 0;//表示删除成功
        }else{
            return 3;//表示删除菜单失败
        }
    }


    /**
     * 获取集合,并根据书结构排序
     * @return
     */
    public List<MenuOutput> treeList(PageData pageData) throws Exception {
        System.out.println(this.WorkContext.isSuperAdministrator());
        System.out.println(this.WorkContext.getUserId());
        List<MenuOutput> list = (List<MenuOutput>) daoImp.findForList(mapperName + "list", null);
        String parentid = AppConsts.defaultGuId;
        for (Map.Entry<String, String> entry : pageData.getMap().entrySet()) {
            switch (entry.getKey()) {
                case "parentid":
                    parentid = entry.getValue();
                    break;
            }
        }
        return TreeUtils.tree(parentid, list);
    }

    /**
     * 获得一级菜单
     * @return
     */
    public List<MenuOutput> firstLevelMenu() throws Exception {
        List<MenuOutput> list = (List<MenuOutput>)daoImp.findForList(mapperName+"firstLevelMenu",null);
        return list;
    }








    public List<MenuOutput> getMenuList() throws Exception {
        System.out.println(this.WorkContext.isSuperAdministrator());
        System.out.println(this.WorkContext.getUserId());
        if(this.WorkContext.isSuperAdministrator()){
            return (List<MenuOutput>) daoImp.findForList(mapperName+"getMenuList",null);
        }else {
            PageData pageData = new PageData();
            pageData.put("userId",this.WorkContext.getUserId());
            return (List<MenuOutput>) daoImp.findForList(mapperName+"getMenuList",null);
        }

    }

    public MenuOutput getAuthorizeMenuByModuleUserId(String module, String userId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("module",module);
        pageData.put("userId",userId);
        return (MenuOutput) daoImp.findForObject(mapperName+"findAuthorizeMenuByModuleUserId",pageData);


    }

    public boolean hasAccessModule(String UserId, String module) throws Exception {
        MenuOutput menuInfo = getAuthorizeMenuByModuleUserId(module, UserId);
        return menuInfo != null && menuInfo.getMenuId() != null && !menuInfo.getMenuId().equals("0");
    }

    public List<MenuOutput> getAuthorizeMenuListByType(Integer type) throws Exception {
        PageData pageData = new PageData();
        pageData.put("type",type);
        return (List<MenuOutput>) daoImp.findForList(mapperName+"findAuthorizeMenuListByTypeIsShow",pageData);

    }

    public List<MenuOutput> getAuthorizeMenuListByTypeUserId(Integer type, String userId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("type",type);
        pageData.put("userId",userId);
        return (List<MenuOutput>) daoImp.findForList(mapperName+"findAuthorizeMenuListByTypeUserId",pageData);


    }

    public List<MenuOutput> getAuthorizeMenuList() throws Exception {
        List<MenuOutput> list = null;

        if (this.WorkContext.isSuperAdministrator()) {
            list = getAuthorizeMenuListByType(0);
        } else {
            list = getAuthorizeMenuListByTypeUserId(0, this.getCurrentUserId());
        }
        return list;
    }

    public List<AuthorizeMenuOutput> convertAuthorizeMenuList(List<MenuOutput> list) {
        List<AuthorizeMenuOutput> authorizeMenuOutputList = null;
        AuthorizeMenuOutput authorizeMenuOutput = null;
        if (list != null && list.size() > 0) {
            for (Menu menu : list) {
                if (menu.getParentid().equals(0)) {
                    authorizeMenuOutput = Menu2AuthorizeMenuOutput(menu);
                    List<MenuOutput> childList = recursionAuthorizeMenuList(list, authorizeMenuOutput.getMenuid());
                    List<ZtreeInfo> zreeInfoList = MenuList2ZtreeInfoList(childList);
                    if (zreeInfoList != null && zreeInfoList.size() > 0) {
                        authorizeMenuOutput.setChildNodeList(zreeInfoList);
                    }
                    if (authorizeMenuOutputList == null)
                        authorizeMenuOutputList = new ArrayList<AuthorizeMenuOutput>();

                    authorizeMenuOutputList.add(authorizeMenuOutput);
                }
            }
        }
        return authorizeMenuOutputList;
    }

    private List<MenuOutput> recursionAuthorizeMenuList(List<MenuOutput> list, String currentMenuId) {
        List<MenuOutput> childList = new ArrayList<MenuOutput>();
        if (list != null && list.size() > 0) {
            List<MenuOutput> _childList = getChildList(list, currentMenuId);
            if (_childList != null && _childList.size() > 0) {
                childList.addAll(_childList);

                for (Menu menu : _childList) {
                    List<MenuOutput> __childList = recursionAuthorizeMenuList(list, menu.getMenuId());

                    if (__childList != null && __childList.size() > 0) {
                        childList.addAll(__childList);
                    }
                }
            }
        }
        return childList;
    }

    private List<MenuOutput> getChildList(List<MenuOutput> list, String currentMenuId) {
        List<MenuOutput> childsList = new ArrayList<MenuOutput>();
        Iterator<MenuOutput> it = list.iterator();
        while (it.hasNext()) {
            MenuOutput child = it.next();
            if (child.getParentid().equals(currentMenuId)) {
                childsList.add(child);
            }
        }
        return childsList;
    }

    private AuthorizeMenuOutput Menu2AuthorizeMenuOutput(Menu menu) {
        AuthorizeMenuOutput authorizeMenuOutput = null;

        authorizeMenuOutput = new AuthorizeMenuOutput();
        authorizeMenuOutput.setMenuid(menu.getMenuId());
        authorizeMenuOutput.setParentid(menu.getParentid());
        authorizeMenuOutput.setName(menu.getName());
        authorizeMenuOutput.setLink(menu.getLink());
        authorizeMenuOutput.setModule(menu.getModule());
        authorizeMenuOutput.setStyle(menu.getStyle());
        authorizeMenuOutput.setIcon(menu.getIcon());
        authorizeMenuOutput.setTarget(menu.getTarget());
        authorizeMenuOutput.setLayer(menu.getLayer());

        return authorizeMenuOutput;
    }

    private ZtreeInfo Menu2ZtreeInfo(MenuOutput menu) {
        ZtreeInfo ztreeInfo = null;

        ztreeInfo = new ZtreeInfo();
        ztreeInfo.setId(menu.getMenuId());
        ztreeInfo.setpId(menu.getParentid());
        ztreeInfo.setName(menu.getName());
        ztreeInfo.setTag(menu.getLink());
        ztreeInfo.setIcon(menu.getIcon());

        return ztreeInfo;
    }

    private List<ZtreeInfo> MenuList2ZtreeInfoList(List<MenuOutput> menuList) {
        List<ZtreeInfo> zreeInfoList = new ArrayList<ZtreeInfo>();

        if (menuList != null & menuList.size() > 0) {
            for (MenuOutput menu : menuList) {
                ZtreeInfo ztreeInfo = Menu2ZtreeInfo(menu);
                zreeInfoList.add(ztreeInfo);
            }
        }

        return zreeInfoList;
    }




}
