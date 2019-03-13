package com.system.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.system.domain.entity.SystemDataLogs;
import com.system.domain.model.input.SystemDataLogsInput;
import com.system.domain.model.output.SystemDataLogsOutput;
import com.utils.MapperName;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SystemDataLogsService extends AbstractService<SystemDataLogsInput,SystemDataLogsOutput>  {
    private String mapperName = MapperName.Name.SystemDataLogsName;

    @Override
    public String getMapperName() {
        return mapperName;
    }



    /**
     * 新增
     * @param systemDataLogsInput
     * @return
     */
    @Override
    public boolean add(SystemDataLogsInput systemDataLogsInput) throws Exception {
        systemDataLogsInput.setDataLogsId(super.getGUID());

        return super.add(systemDataLogsInput);
    }


    /**
     * 公共方法 记录
     * @param
     * @return
     */

    public boolean pub(String businessId ,String businessTable,Integer actionType,String dataLog) throws Exception {
        SystemDataLogsInput systemDataLogsInput = new SystemDataLogsInput();
        systemDataLogsInput.setDataLogsId(super.getGUID());
        systemDataLogsInput.setBusinessId(businessId);

        systemDataLogsInput.setBusinessTable(businessTable);
        systemDataLogsInput.setActionType(actionType);
        systemDataLogsInput.setDataLog(dataLog);
        String businessType;
        switch (businessTable){
            case "project_risk":
                businessType="风险";
                break;
            case "project_team":
                businessType="成员";
                break;
            case "project_goal":
                businessType="目标";
                break;
            case "project_plan":
                businessType="阶段任务";
                break;
            case "project_type":
                businessType="类型";
                break;
            case "project_meeting":
                businessType="会议";
                break;
            case "project":
                businessType="项目";
                break;
            case "project_change":
                businessType="变更";
                break;
            case "project_communication":
                businessType="沟通计划";
                break;
            case "project_status_report":
                businessType="状态报告";
                break;
            case "project_conclusion":
                businessType="总结";
                break;
            case "project_result":
                businessType="成果";
                break;
            default:
                businessType="";
                break;
        }
        systemDataLogsInput.setBusinessType(businessType);
        return super.add(systemDataLogsInput);

    }




    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    @Override
    public List<SystemDataLogsOutput> list(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if(pageData.containsKey("businessId")){
            sb.append(" AND business_id = "+"'"+pageData.getMap().get("businessId")+"'");
        }
        if(pageData.containsKey("businessTable")){
            sb.append(" AND business_table = "+"'"+pageData.getMap().get("businessTable")+"'");
        }

        sb.append(new PageData().where(pageData));
        if(isPager){
            return super.pageList(pageData,mapperName+"list",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",sb.toString());

        return (List<SystemDataLogsOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }

    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<SystemDataLogsOutput> nolimitlist(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if(pageData.containsKey("businessId")){
            sb.append(" AND business_id = "+"'"+pageData.getMap().get("businessId")+"'");
        }
        if(pageData.containsKey("businessTable")){
            sb.append(" AND business_table = "+"'"+pageData.getMap().get("businessTable")+"'");
        }

        sb.append(new PageData().where(pageData));
        if(isPager){
            return super.pageList(pageData,mapperName+"nolimitlist",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",sb.toString());

        return (List<SystemDataLogsOutput>) daoImp.findForListSql(mapperName+"nolimitlist",sqlModel);
    }

    /**
     * 分页列表/全部列表
     * @param pageData
     * @return
     * @throws Exception
     */

    public List<SystemDataLogsOutput> textlist(boolean isPager, PageData pageData) throws Exception {
        StringBuilder sb = new StringBuilder();
        if(pageData.containsKey("businessId")){
            sb.append(" AND business_id = "+"'"+pageData.getMap().get("businessId")+"'");
        }
        if(pageData.containsKey("businessTable")){
            sb.append(" AND business_table = "+"'"+pageData.getMap().get("businessTable")+"'");
        }

        sb.append(new PageData().where(pageData));
        if(isPager){
            return super.pageList(pageData,mapperName+"textlist",sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql",sb.toString());
        return (List<SystemDataLogsOutput>) daoImp.findForListSql(mapperName+"textlist",sqlModel);
    }





}











