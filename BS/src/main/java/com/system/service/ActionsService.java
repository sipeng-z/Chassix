package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.system.domain.entity.Actions;
import com.system.domain.model.input.ActionsInput;
import com.system.domain.model.output.ActionsOutput;
import com.system.domain.model.output.AuthorizeActionOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ActionsService  extends AbstractService<ActionsInput,ActionsOutput>{

    String mapperName = MapperName.Name.ActionName;

    @Override
    public String getMapperName() {
        return mapperName;
    }



    /**
     * 新增
     * @param actionsInput
     * @return
     */
    @Override
    public boolean add(ActionsInput actionsInput) throws Exception {
        actionsInput.setId(super.getGUID());
        if(actionsInput.getMenuId()==null){
            actionsInput.setMenuId(AppConsts.defaultGuId);
        }
        if(actionsInput.getCode()==null){
            actionsInput.setCode("0");
        }
        if(actionsInput.getDisplayOrder()==null){
            actionsInput.setDisplayOrder(0);
        }
        if(actionsInput.getType()==null){
            actionsInput.setType(0);
        }
        if(actionsInput.getState()==null){
            actionsInput.setState(0);
        }
        if(actionsInput.getAuditState()==null){
            actionsInput.setAuditState(0);
        }
        if(actionsInput.getAuditUserId()==null){
            actionsInput.setAuditUserId("0");
        }
        return super.add(actionsInput);
    }

    /**
     * 修改
     * @param actionsInput
     * @return
     */
    @Override
    public boolean update(ActionsInput actionsInput) throws Exception {

        return super.update(actionsInput);
    }

    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<ActionsOutput> list(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if(pageData.containsKey("menuId")){
            sb.append(" AND menu_id = "+"'"+pageData.getMap().get("menuId")+"'");
        }
        sb.append(new PageData().where(pageData));
        if(isPager){
            return super.pageList(pageData,mapperName+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",sb.toString());
        return (List<ActionsOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }
    /**
     * 动作(Actions)实体信息查询
     *
     * @param id
     * @return
     */
    public ActionsOutput get(Integer id) throws Exception {
        PageData pageData = new PageData();
        pageData.put("id",id);
        ActionsOutput actions = (ActionsOutput) daoImp.findForObject(mapperName+"findByPkId",pageData);
        return actions;
    }



    public List<ActionsOutput> getActionListByMenuId(Integer id) throws Exception {

        PageData pageData = new PageData();
        pageData.put("menuId",id);
        return (List<ActionsOutput>) daoImp.findForList(mapperName+"findByMenuId",pageData);
    }

    public List<ActionsOutput> getAuthorizeActionListByModule(String module) throws Exception {
        PageData pageData = new PageData();
        pageData.put("module",module);
        return (List<ActionsOutput>) daoImp.findForList(mapperName+"findAuthorizeActionListByModule",pageData);

    }

    public List<ActionsOutput> getAuthorizeActionListByModuleUserId(String module, String userId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("module",module);
        pageData.put("userId",userId);
        return (List<ActionsOutput>) daoImp.findForList(mapperName+"findAuthorizeActionListByModuleUserId",pageData);

    }

    public boolean hasAccessModuleAction(String userId,String module,String action) throws Exception {
        boolean result=false;
        List<ActionsOutput> list= getAuthorizeActionListByModuleUserId( module, userId);
        if(list!=null&&list.size()>0) {
            Set<String> actionCodeList= ModuleActionCode(list);
            result= actionCodeList.contains(action);
        }
        return result;
    }

    public Set<String> getAuthorizeActionSet(String userId,String module) throws Exception {
        List<ActionsOutput> list= getAuthorizeActionListByModuleUserId( module, userId);
        return ModuleActionCode(list);
    }

    private Set<String> ModuleActionCode(List<ActionsOutput> list){
        Set<String> actionCode=new HashSet<>();
        if(list!=null&&list.size()>0) {
            for (Actions actionsInfo:list) {
                actionCode.add(actionsInfo.getCode());
            }
        }
        return actionCode;
    }


    public List<ActionsOutput> getAuthorizeAllActionListByModule(String module) throws Exception {
        List<ActionsOutput> list = null;
        if (WorkContext.isSuperAdministrator()) {
            list = getAuthorizeActionListByModule(module);
        } else {
            list = getAuthorizeActionListByModuleUserId(module, WorkContext.getUserId());
        }
        return list;
    }


    public List<AuthorizeActionOutput> convertAction2AuthorizeActionOutput(List<ActionsOutput> list){
        List<AuthorizeActionOutput> _authorizeActionOutputList=new ArrayList<AuthorizeActionOutput>();
        AuthorizeActionOutput authorizeActionOutput=null;
        if(list!=null&&list.size()>0) {
            for(ActionsOutput actions:list) {
                authorizeActionOutput=new AuthorizeActionOutput();
                authorizeActionOutput.setActionid(actions.getId());
                authorizeActionOutput.setName(actions.getName());
                authorizeActionOutput.setCode(actions.getCode());
                _authorizeActionOutputList.add(authorizeActionOutput);
            }
        }
        return _authorizeActionOutputList;
    }



}
