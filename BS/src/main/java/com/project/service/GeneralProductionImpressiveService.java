package com.project.service;

import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.model.AppConsts;
import com.project.domain.entity.GeneralImpressive;
import com.project.domain.entity.GeneralProductionTemporary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralProductionImpressiveService extends AbstractService<GeneralImpressive,GeneralImpressive> {



    private final String generalName = AppConsts.GeneralProductionTemporaryName;
    private String mapperName = generalName;

    @Override
    public String getMapperName() {
        return mapperName;
    }


    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }







    /**
     * impressiveList
     * @param isPager
     * @param pageData
     * @return
     * @throws Exception
     */
    public List<GeneralImpressive> impressiveList(boolean isPager, PageData pageData, String line, String device) throws Exception {
        String replaceName =line+device;
        this.setMapperName(AppConsts.GeneralProductionTemporaryName.replace("General",replaceName));
        StringBuilder sb = new StringBuilder();
        if (pageData.containsKey("DateString")) {
            sb.append(" AND Date_String = " + "'" + pageData.getMap().get("DateString") + "'");
        }
        if (pageData.containsKey("Description")) {
            sb.append(" AND Description like " + "'%" + pageData.getMap().get("Description") + "%'");
        }
        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }
        if(pageData.containsKey("inList")){
            sb.append("AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if (pageData.containsKey("mark")) {
            sb.append(" AND mark = "  + pageData.getMap().get("mark"));
        }


        if(pageData.containsKey("inList")){
            sb.append(" AND RecordNO in ("+pageData.getMap().get("inList")+")");
        }

        if(pageData.containsKey("DateStringInList")){
            sb.append(" AND Date_String in ("+pageData.getMap().get("DateStringInList")+")");
        }

        if (pageData.containsKey("NoMark")) {
            sb.append(" AND mark != "  + pageData.getMap().get("NoMark"));
        }


        sb.append(new PageData().where(pageData));
        if (isPager) {


            Integer pagesize = pageData.getRows();
            Integer page = pageData.getPageIndex();
            PageHelper.startPage(page, pagesize);
            PageData sqlModel = new PageData();
            sqlModel.put("retrieveSql",sb.toString());
            Page<GeneralImpressive> dataList = (Page<GeneralImpressive>) daoImp.findForListSql(mapperName + "list",sqlModel);

            return dataList;
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<GeneralImpressive>) daoImp.findForListSql(mapperName+"impressive",sqlModel);
    }








}
