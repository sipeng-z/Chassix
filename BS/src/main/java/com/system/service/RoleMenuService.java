package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.entity.RoleMenu;
import com.system.domain.model.input.RoleMenuInput;
import com.system.domain.model.output.MenuOutput;
import com.system.domain.model.output.RoleMenuDataOutput;
import com.system.domain.model.output.RoleMenuOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuService extends AbstractService<RoleMenuInput, RoleMenuOutput> {

    private String mapperName = MapperName.Name.RoleMenuName;

    @Override
    public String getMapperName() {
        return mapperName;
    }

    /**
     * 菜单权限列表
     * @param id
     * @return
     */
    public List<RoleMenuDataOutput> getList(String id) throws Exception {
        List<MenuOutput> menuList = new ArrayList<MenuOutput>();
        PageData pageData = new PageData();
        if(/*this.WorkContext.isSuperAdministrator()*/true){
            menuList = (List<MenuOutput>)daoImp.findForList(MapperName.Name.MenuName+"list",null);
        }else {
            String userid = this.WorkContext.getUserId();
//            userid = 1;//测试数据
            pageData.put("userId",userid);

            menuList = (List<MenuOutput>)daoImp.findForList(MapperName.Name.MenuName+"findMenuListByUserId",pageData);

        }
        pageData.put("id",id);
        List<RoleMenuOutput> roleMenuList = (List<RoleMenuOutput>)daoImp.findForList(mapperName+"findListByRoleId",pageData);
        List<RoleMenuDataOutput> list = new ArrayList<RoleMenuDataOutput>();
        RoleMenuDataOutput roleMenuDataOutput = null;
        for(MenuOutput menu : menuList) {
            roleMenuDataOutput = new RoleMenuDataOutput();
            roleMenuDataOutput.setName(menu.getName());
            roleMenuDataOutput.setId(menu.getMenuId().toString());
            roleMenuDataOutput.setpId(menu.getParentid());
//            roleMenuDataOutput.setIcon(menu.getIcon());
            roleMenuDataOutput.setChecked(false);
            for(RoleMenu roleMenu : roleMenuList) {
                if(menu.getMenuId().equals(roleMenu.getMenuId())) {
                    roleMenuDataOutput.setChecked(true);
                }
            }
            list.add(roleMenuDataOutput);
        }



        return list;
    }

    @Transactional
    public boolean save(String id,String idList) throws Exception {
        PageData pageData = new PageData();
        pageData.put("roleId",id);
        daoImp.delete(mapperName+"deleteByRoleId",pageData);
        if(!"".equals(idList)){
            String[] strs = idList.split(",");
            for(String str : strs) {
                RoleMenu rolemenu = new RoleMenu();
                rolemenu.setRoleMenuId(super.getGUID());
                rolemenu.setMenuId(str);
                rolemenu.setRoleId(id);
                daoImp.save(mapperName+"insertSelective",rolemenu);
            }
        }
        return true;

    }






}
