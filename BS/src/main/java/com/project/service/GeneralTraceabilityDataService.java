package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralTraceabilityData;
import com.project.domain.model.input.GeneralTraceabilityDataInput;
import com.project.domain.model.output.GeneralTraceabilityDataOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralTraceabilityDataService extends AbstractService<GeneralTraceabilityDataInput,GeneralTraceabilityDataOutput>{


    private String mapperName = AppConsts.GeneralTraceabilityDataName;


    @Override
    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }


    public List<GeneralTraceabilityDataOutput> generallist(boolean isPager, PageData pageData ,String line,String device) throws Exception {



        this.setMapperName(AppConsts.GeneralTraceabilityDataName.replace("General",line+device));



        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if(pageData.containsKey("DateStringInList")){
            sb.append("AND Date_String in ("+pageData.getMap().get("DateStringInList")+")");
        }
        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }

        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }
        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());

        return (List<GeneralTraceabilityDataOutput>) daoImp.findForListSql(mapperName + "list", sqlModel);


    }

    /**
     * get Quantity
     * @return
     * @throws Exception
     */
    public Integer getQuantitySum(String DateString,Integer StartRecordNO,Integer EndRecordNO,String line,String device) throws Exception{
        this.setMapperName(AppConsts.GeneralTraceabilityDataName.replace("General",line+device));

        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        PageData pageData4tra = new PageData();
        pageData4tra.put("DateString",DateString);
        pageData4tra.put("inList",inList);
        List<GeneralTraceabilityDataOutput>  tralist = this.generallist(false,pageData4tra,line,device);
        Integer actuallypieces = tralist.size();

        //计算合格品的数量 quality

      Integer goodpieces = tralist.size();
        for (GeneralTraceabilityData gtra : tralist ){
            if(gtra.getPartstatus()!=0){
                goodpieces--;
            }
        }
        if(actuallypieces==0){
            return 0;
        }
        return goodpieces;

    }

}
