package com.system.controller;

import com.authorize.annotation.Authorize;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.response.ResponseResult;
import com.system.domain.model.input.MenuInput;
import com.system.domain.model.output.MenuOutput;
import com.system.service.MenuService;
import com.system.service.MenuTreeViewService;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;


@Authorize(ignore = true)
@RequestMapping(value = "menu")
@RestController
public class MenuController extends GenericController<MenuInput,MenuOutput> {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @Override
    protected void OnActionExecuting() {
        menuService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<MenuInput,MenuOutput> getService() {
        return menuService;
    }


    /**
     * 新增/修改
     * @param id
     * @param input
     * @return
     */
    @Override
    @RequestMapping(value = "formpost",method = RequestMethod.POST)
    public ResponseResult formPost(String id,@RequestBody MenuInput input) {
        ResponseResult result = new ResponseResult();
        try{
            return super.formPost(id,input);
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * 删除
     * @param idList
     * @return
     */
    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ResponseResult delete(String idList) {
        try{
            logger.info(this.WorkContext.getUserId()+": 进入delete");
            ResponseResult result = new ResponseResult();
            String rtMge = "";
            if(idList == null || "".equals(idList)){
                rtMge = "未选中删除对象";
                result.setSuccess(false);
            }
            int resultvalue = menuService.deleteMenu(idList);
            if(resultvalue ==0){
                rtMge = "删除成功";
                result.setSuccess(true);
            }else if(resultvalue ==1){
                rtMge = "删除失败,当前菜单存在子菜单无法删除";
                result.setSuccess(false);
            }else if(resultvalue ==2){
                rtMge = "更新父菜单失败";
                result.setSuccess(false);
            }else if(resultvalue ==3){
                rtMge = "删除失败";
                result.setSuccess(false);
            }
            result.setMessage(rtMge);
            return result;
        }catch (Exception e){
            logger.error("-----------------------delete异常-------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * 菜单管理列表
     * **/
    @RequestMapping(value = "menulist",method = RequestMethod.GET)
    public ResponseResult list(HttpServletRequest request){
        try{
            List<MenuOutput> menuOutputs = menuService.treeList(new PageData(request));
            List<MenuOutput> newList = new LinkedList<MenuOutput>();
            for (MenuOutput menu : menuOutputs) {
                if (menu.getParentId() != null && menu.getParentId().equals(AppConsts.defaultGuId)) {
                    menu.setExpanded(true);
                } else {
                    menu.setExpanded(false);
                }
                if (menu.getHaschild().equals(1)) {
                    menu.setLeaf(false);
                } else {
                    menu.setLeaf(true);
                }
                newList.add(menu);
            }
            return ResponseResult.success(newList);
        }catch (Exception e){
            logger.error("-----------------------list异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * 菜单管理列表
     * **/
    @RequestMapping(value = "firstlevelmenu",method = RequestMethod.GET)
    public ResponseResult firstLevelMenu(){
        try{
            List<MenuOutput> menuOutputs = menuService.firstLevelMenu();
            return ResponseResult.success(menuOutputs);
        }catch (Exception e){
            logger.error("-----------------------list异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * 根据首页头部的导航栏获得左侧的菜单栏（目前只左侧只显示两级）
     * **/
    @RequestMapping(value = "leftmenu",method = RequestMethod.GET)
    public ResponseResult leftMenu(HttpServletRequest request) {

        try {
            List<MenuOutput> list = menuService.getMenuList();
            return ResponseResult.success(list);
        } catch (Exception e) {
            return ResponseResult.error("处理过程中发生异常:" + e);
        }
    }


    /**
     * 根据menuid获取单个对象
     * @param id
     * @return
     */
    @Override
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseResult get(String id) {
        try{
            if(id == null){
                return ResponseResult.error("参数menuid不能为空");
            }
            return super.get(id);
        }catch (Exception e){
            logger.error("-----------------------get异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    @RequestMapping(value = "/menutreeviewlist", method = RequestMethod.GET)
    public ResponseResult menutreeviewlist(HttpServletRequest request) {
        this.Initialize();
        try {
            List<MenuOutput> list = menuService.treeList(new PageData(request));
            MenuTreeViewService menuTreeViewService = new MenuTreeViewService();
            list = menuTreeViewService.getChildTreeObjects(list, AppConsts.defaultGuId);

            return ResponseResult.success(list);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseResult.error("处理过程中发生异常:" + e);
        }
    }




/*    *//**
     *
     * 当前登录用户权限信息
     *
     * @param request
     * @return
     *//*
    @GetMapping("/me")
    public ResponseResult me(HttpServletRequest request) {
        ResponseResult result = new ResponseResult();

        List<AuthorizeMenuOutput> authorizeMenuOutputList = menuService
                .convertAuthorizeMenuList(menuService.getAuthorizeMenuList());
        result.setData(authorizeMenuOutputList);
        if (authorizeMenuOutputList != null && authorizeMenuOutputList.size() > 0) {
            result.setSuccess(true);
            result.setMessage("查询成功");
        } else {
            result.setMessage("查询失败");
        }
        return result;
    }*/

}
