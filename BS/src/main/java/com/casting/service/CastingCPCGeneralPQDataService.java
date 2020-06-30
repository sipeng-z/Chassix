package com.casting.service;

import com.casting.domain.entity.CastingCPCGeneralPQData;
import com.casting.domain.model.input.CastingCPCGeneralPQDataInput;
import com.casting.domain.model.output.CastingCPCGeneralPQDataOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.AppConsts;
import com.project.domain.entity.GeneralTraceabilityData;
import com.project.service.ConversionToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CastingCPCGeneralPQDataService extends AbstractService<CastingCPCGeneralPQDataInput,CastingCPCGeneralPQDataOutput> {




    private String mapperName = AppConsts.CastingCPCGeneralPQDataName;

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
     * @param device
     * @return
     * @throws Exception
     */
    public List<CastingCPCGeneralPQDataOutput> generallist(boolean isPager, PageData pageData, String device) throws Exception {

        this.setMapperName(AppConsts.CastingCPCGeneralPQDataName.replace("General",device));

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
        return (List<CastingCPCGeneralPQDataOutput> )daoImp.findForListSql(mapperName+"generallist",sqlModel);

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
    public List<CastingCPCGeneralPQData> listForCycle(boolean isPager, PageData pageData, String line, String device) throws Exception {

        this.setMapperName(AppConsts.CastingCPCGeneralPQDataName.replace("General",line+device));

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
            Page<CastingCPCGeneralPQData> dataList = (Page<CastingCPCGeneralPQData>) daoImp.findForListSql(mapperName,sqlModel);
            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<CastingCPCGeneralPQData> )daoImp.findForListSql(mapperName+"listForCycle",sqlModel);

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
    public List<GeneralTraceabilityData> listForCycle1(boolean isPager, PageData pageData, String line, String device) throws Exception {

        this.setMapperName(AppConsts.GeneralTraceabilityDataName.replace("General",line+device));
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
            Page<GeneralTraceabilityData> dataList = (Page<GeneralTraceabilityData>) daoImp.findForListSql(mapperName,sqlModel);
            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralTraceabilityData> )daoImp.findForListSql(mapperName+"listForCycle",sqlModel);

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
    public List<Integer> cycleTimeAverage(String dateString ,String line,String device) throws Exception{

        PageData pageData = new PageData();
        pageData.put("DateString",dateString);
        List<CastingCPCGeneralPQData> listForCycle = (List<CastingCPCGeneralPQData>) this.listForCycle(false,pageData,line,device);

        List<Integer> resultList = new ArrayList<>();
        for(int i =0;i<6;i++){
            Integer cycleTime = conversionToolService.DateMinus(listForCycle.get(i).getVmTime(),listForCycle.get(i+1).getVmTime());
            resultList.add(cycleTime);
        }

        return resultList;
    }





}
