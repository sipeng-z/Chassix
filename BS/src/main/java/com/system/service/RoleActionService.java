package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.system.domain.entity.Actions;
import com.system.domain.entity.RoleAction;
import com.system.domain.model.input.RoleActionInput;
import com.system.domain.model.output.*;
import com.utils.MapperName;
import com.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleActionService extends AbstractService<RoleActionInput, RoleActionOutput> {
    private String mapperName = MapperName.Name.ActionMenuName;


    @Override
    public String getMapperName() {
        return mapperName;
    }


    public List<RoleMenuDataOutput> getList(String roleid) throws Exception {
        PageData pageData = new PageData();
        pageData.put("roleId", roleid);
        //根据角色获得动作
        List<RoleActionOutput> roleActionList = (List<RoleActionOutput>) daoImp.findForList(MapperName.Name.RoleActionName + "findListByRoleId", pageData);
        //根据角色id获得菜单以及动作
        List<RoleMenuDataOutput> list = menuAndActionTree(roleid);
        for (RoleActionOutput roleaction : roleActionList) {
            for (RoleMenuDataOutput roleMenu : list) {
                if ((roleaction.getActionId().equals(roleMenu.getTag()) && roleaction.getMenuId().equals(roleMenu.getpId())) || roleaction.getMenuId().toString().equals(roleMenu.getId())) {
                    roleMenu.setChecked(true);
                }
            }
        }
        for (RoleMenuDataOutput rmo : list) {
            if (rmo.isChecked() == true) {
                for (RoleMenuDataOutput rrmo : list) {
                    if (rmo.getpId().toString().equals(rrmo.getId())) {
                        rrmo.setChecked(true);
                    }
                }
            }
        }
        return list;
    }


    @Transactional
    public boolean save(String id, String idList) throws Exception {
        PageData pageData = new PageData();
        pageData.put("roleId",id);
        daoImp.delete(mapperName+"deleteByRoleId",pageData);
        if (!"".equals(idList)) {
            String[] strs = idList.split(";");
            for (String str : strs) {
                String[] idStr = str.split(",");
                if (idStr[0].equals(AppConsts.defaultGuId)||idStr[0]==null) {
                    continue;
                }
                RoleAction roleaction = new RoleAction();
                roleaction.setRoleActionId(super.getGUID());
                roleaction.setActionId(idStr[0]);
                roleaction.setMenuId(idStr[1]);
                roleaction.setRoleId(id);
                daoImp.save(mapperName+"insertSelective",roleaction);

            }

        }
        return true;

    }


    /**
     * 获取菜单和按钮的组合树结构
     *
     * @param roleid
     * @return
     */
    private List<RoleMenuDataOutput> menuAndActionTree(String roleid) throws Exception {
        PageData pageData = new PageData();
        pageData.put("roleId",roleid);
        //根据角色id获得菜单列表（rolemenu表和menu表关联）
        List<MenuOutput> menuList = (List<MenuOutput>)daoImp.findForList(MapperName.Name.MenuName+"findMenuListByRoleId",pageData);
        List<ActionsOutput> actionsList = new ArrayList<ActionsOutput>();
        //获得动作列表
        actionsList = (List<ActionsOutput>)daoImp.findForList(MapperName.Name.ActionName+"list",null);

        List<RoleMenuDataOutput> list = new ArrayList<RoleMenuDataOutput>();
        RoleMenuDataOutput roleMenuDataOutput = null;
        for (MenuOutput menu : menuList) {
            roleMenuDataOutput = new RoleMenuDataOutput();
            roleMenuDataOutput.setId(menu.getMenuId().toString());
            roleMenuDataOutput.setpId(menu.getParentid());
            roleMenuDataOutput.setName(menu.getName());
//            roleMenuDataOutput.setIcon(menu.getIcon());
            roleMenuDataOutput.setTag(AppConsts.defaultGuId);
            list.add(roleMenuDataOutput);
            for (Actions action : actionsList) {
                if (!menu.getParentId().equals(AppConsts.defaultGuId) && (action.getMenuId().equals(menu.getMenuId()))) {
                    roleMenuDataOutput = new RoleMenuDataOutput();
                    String str = StringUtils.randomString(16);
                    roleMenuDataOutput.setId(str);
                    roleMenuDataOutput.setpId(menu.getMenuId());
                    roleMenuDataOutput.setName(action.getName());
//                    roleMenuDataOutput.setIcon(action.getIcon());
                    roleMenuDataOutput.setTag(action.getId());
                    list.add(roleMenuDataOutput);
                }
            }
        }
        return list;
    }


}
