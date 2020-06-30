package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.AppConsts;
import com.project.domain.entity.EMP2ASSYTraceabilityData;
import com.project.domain.entity.GeneralPQData;
import com.project.domain.entity.GeneralTraceabilityData;
import com.project.domain.model.input.GeneralPQDataInput;
import com.project.domain.model.output.GeneralPQDataOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EMP2ASSYPQDataService extends AbstractService<GeneralPQDataInput, GeneralPQDataOutput> {
    private String mapperName = AppConsts.GeneralPQDataName;

    @Autowired
    private ConversionToolService conversionToolService;

    @Override
    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }

    /**
     * get data
     * @param isPager
     * @param pageData
     * @param line
     * @param device
     * @return
     * @throws Exception
     */
    public List<GeneralPQDataOutput> generallist(boolean isPager, PageData pageData, String line, String device) throws Exception {

        this.setMapperName(AppConsts.GeneralPQDataName.replace("General",line+device));

        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }

        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {

            return super.pageList(pageData, mapperName + "generallist", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralPQDataOutput> )daoImp.findForListSql(mapperName+"generallist",sqlModel);

    }

    /**
     * get data
     * @param isPager
     * @param pageData
     * @param line
     * @param device
     * @return
     * @throws Exception
     */
    public List<GeneralPQData> listForCycle(boolean isPager, PageData pageData, String line, String device) throws Exception {

        this.setMapperName(AppConsts.GeneralPQDataName.replace("General",line+device));

        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }

        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            Integer pagesize = pageData.getRows();
            Integer page = pageData.getPageIndex();
            PageHelper.startPage(page, pagesize);
            PageData sqlModel = new PageData();
            sqlModel.put("retrieveSql",sb.toString());
            Page<GeneralPQData> dataList = (Page<GeneralPQData>) daoImp.findForListSql(mapperName,sqlModel);
            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralPQData> )daoImp.findForListSql(mapperName+"listForCycle",sqlModel);

    }

    /**
     * get ASSY data
     * @param isPager
     * @param pageData
     * @param line
     * @param device
     * @return
     * @throws Exception
     */
    public List<EMP2ASSYTraceabilityData> listForCycle1(boolean isPager, PageData pageData, String line, String device) throws Exception {

        this.setMapperName("com.project.mapper.mybatis.EMP2ASSYTraceabilityDataMapper.");

        StringBuilder sb = new StringBuilder();

        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }

        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            Integer pagesize = pageData.getRows();
            Integer page = pageData.getPageIndex();
            PageHelper.startPage(page, pagesize);
            PageData sqlModel = new PageData();
            sqlModel.put("retrieveSql",sb.toString());
            Page<EMP2ASSYTraceabilityData> dataList = (Page<EMP2ASSYTraceabilityData>) daoImp.findForListSql(mapperName,sqlModel);
            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<EMP2ASSYTraceabilityData> )daoImp.findForListSql(mapperName+"listForCycle",sqlModel);

    }
    public List<Integer> cycleTimeAverage(String dateString ,String line,String device) throws Exception{

        PageData pageData = new PageData();
        pageData.put("DateString",dateString);
        List<GeneralPQData> listForCycle = (List<GeneralPQData>) this.listForCycle(false,pageData,line,device);

        List<Integer> resultList = new ArrayList<>();
        for(int i =0;i<6;i++){
            Integer cycleTime = conversionToolService.DateMinus(listForCycle.get(i).getVmTime(),listForCycle.get(i+1).getVmTime());
            resultList.add(cycleTime);
        }

        return resultList;
    }

    /**
     * according to pq record , get cycle time and calculate the average and based on average values
     * latest 7 cycle time
     * @param dateString
     * @param line
     * @param device
     * @return
     * @throws Exception
     */
    public List<Integer> cycleTimeAverageASSY(String dateString ,String line,String device) throws Exception{

        PageData pageData = new PageData();
        pageData.put("DateString",dateString);
        List<EMP2ASSYTraceabilityData> listForCycle = (List<EMP2ASSYTraceabilityData>) this.listForCycle1(false,pageData,line,device);

        List<Integer> resultList = new ArrayList<>();
        for(int i =0;i<6;i++){
            Integer cycleTime = conversionToolService.DateMinus(listForCycle.get(i+1).getE1e2CompletedTime(),listForCycle.get(i).getE1e2CompletedTime());
            resultList.add(cycleTime);
        }

        return resultList;
    }

}
