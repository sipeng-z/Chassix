package com.casting.service;

import com.casting.domain.entity.*;
import com.casting.domain.model.input.CastingCPCGeneralOEEDataInput;
import com.casting.domain.model.output.CastingCPCGeneralOEEDataOutput;
import com.casting.domain.model.output.CastingCPCGeneralPQDataOutput;
import com.casting.domain.model.output.CastingCPCGeneralPvFurnaceChamberCurveOutput;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.GeneralPQData;
import com.utils.MapperName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CastingCPCGeneralOEEDataService extends AbstractService<CastingCPCGeneralOEEDataInput,CastingCPCGeneralOEEDataOutput> {





    private final String generalName = AppConsts.CastingCPCGeneralOEEDataName;
    private String mapperName = generalName;

    public void setMapperName(String mapperName){
        this.mapperName = mapperName;
    }

    @Override
    public String getMapperName() {
        return mapperName;
    }


    @Autowired
    private CastingCPCGeneralPvFurnaceChamberCurveService castingCPCGeneralPvFurnaceChamberCurveService;

    @Autowired
    private CastingCPCGeneralPQDataService castingCPCGeneralPQDataService;


    /**
     * use different device name to get correct xml to operate db
     * add
     * @param input
     * @param device
     * @return
     * @throws Exception
     */
    public boolean generaladd(CastingCPCGeneralOEEDataInput input,String device)throws  Exception{


        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));

        Integer lunchtime = input.getLunchTime();
        Integer breaktime = input.getBreakTime();
        Integer preventionMaintenance = input.getPreventionMaintenance();
        Integer setupPreparation = input.getSetupPreparation();
        Integer changeOvers = input.getChangeOvers();
        Integer unplannedDowntime = input.getUnplannedDowntime();
        Integer plantime = 900;

        plantime = 900-lunchtime-breaktime-preventionMaintenance-setupPreparation-changeOvers-unplannedDowntime;
        input.setPlannedRunTime(plantime);

        int isDeleted=0;
        PageData pageData = super.poToMap(input);
        pageData.put("createdUserId",this.WorkContext.getUserId());
        pageData.put("createdUserName",this.WorkContext.getName());
        pageData.put("createdDateTime",this.getNowTime());
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        pageData.put("isDeleted", AppConsts.IsDelete_No);
        pageData.put("auditState",AppConsts.Audit_Default);
        pageData.put("isDeleted",isDeleted);
        if(daoImp.save(mapperName+"insertSelective",pageData)>0){
            return true;
        }
        return false;

    }

    /**
     * use different device name to get correct xml to operate db
     * update
     * @param input
     * @param device
     * @return
     * @throws Exception
     */

    public boolean generalupdate(CastingCPCGeneralOEEDataInput input,String device) throws Exception{

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));

        Integer lunchtime = input.getLunchTime();
        Integer breaktime = input.getBreakTime();
        Integer preventionMaintenance = input.getPreventionMaintenance();
        Integer setupPreparation = input.getSetupPreparation();
        Integer changeOvers = input.getChangeOvers();
        Integer unplannedDowntime = input.getUnplannedDowntime();

        if(input.getPlannedRunTime()!=null&&!input.getPlannedRunTime().equals("")){

            Integer plantime = input.getPlannedRunTime();
            plantime = 900-lunchtime-breaktime-preventionMaintenance-setupPreparation-changeOvers-unplannedDowntime;
            input.setPlannedRunTime(plantime);

        }else {
            return false;
        }

        PageData pageData = super.poToMap(input);
        pageData.put("lastUpdatedUserId",this.WorkContext.getUserId());
        pageData.put("lastUpdatedUserName",this.WorkContext.getName());
        pageData.put("lastUpdatedDateTime",this.getNowTime());
        if(daoImp.update(mapperName+"updateByPrimaryKeySelective",pageData)>0){
            return true;
        }
        return false;


    }

    /**
     * use different device name to get correct xml to operate db
     *  get list
     * @param isPager
     * @param pageData
     * @param device
     * @return
     * @throws Exception
     */

    public List<CastingCPCGeneralOEEDataOutput> generallist(boolean isPager, PageData pageData,String device) throws Exception {

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));

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
        if (pageData.containsKey("Description")) {
            sb.append(" AND Description like " + "'%" + pageData.getMap().get("Description") + "%'");
        }
        if (pageData.containsKey("RecordNO")) {
            sb.append(" AND RecordNO = " + "'" + pageData.getMap().get("RecordNO") + "'");
        }

        if (pageData.containsKey("mark")) {
            sb.append(" AND mark = "  + pageData.getMap().get("mark"));
        }
        if (pageData.containsKey("nomark")) {
            sb.append(" AND( mark is null or mark = 0 )" ); //to judge mark is null or mark is 0;
        }

        sb.append(new PageData().where(pageData));
        if (isPager) {
            return super.pageList(pageData, mapperName + "list", sb.toString());
        }
        PageData sqlModel = new PageData();
        sqlModel.put("retrieveSql", sb.toString());
        return (List<CastingCPCGeneralOEEDataOutput>) daoImp.findForListSql(mapperName+"list",sqlModel);
    }



    /**
     * get by ItemNO
     * @param ItemNO
     * @return
     * @throws Exception
     */
    public CastingCPCGeneralOEEData getByItemNO(Integer ItemNO,String device) throws Exception {
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        PageData pageData = new PageData();
        pageData.put("ItemNO",ItemNO.toString());
        return (CastingCPCGeneralOEEData) daoImp.findForObject(mapperName+"findByPkId",pageData);
    }




    /**
     * itemno
     * @param itemno
     * @return
     * @throws Exception
     */
    public boolean updatePlannedTimeByItemno (Integer itemno,String device) throws Exception{

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        PageData pageData = new PageData();
        pageData.put("mark","1");
        pageData.put("plannedRunTime","900");
        pageData.put("itemno",itemno.toString());

        if(daoImp.update(mapperName+"updateByItemno",pageData)>0){
            return true;
        }
        return false;

    }



    /**
     * itemno
     * @param input
     * @return
     * @throws Exception
     */
    public boolean updatePlannedTime (CastingCPCGeneralOEEData input,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        PageData pageData = new PageData();
        pageData.put("itemno",input.getItemno().toString());
        pageData.put("mark","1");
        pageData.put("plannedRunTime","0");

        if(input.getPreventionMaintenance()!=null&&!input.getPreventionMaintenance().equals("")){
            pageData.put("preventionMaintenance",input.getPreventionMaintenance().toString());
        }

        if(input.getSetupPreparation()!=null&&!input.getSetupPreparation().equals("")){
            pageData.put("setupPreparation",input.getSetupPreparation().toString());
        }

        if (input.getChangeOvers()!=null&&!input.getChangeOvers().equals("")){
            pageData.put("changeOvers",input.getChangeOvers().toString());
        }

        if(input.getUnplannedDowntime()!=null&&!input.getUnplannedDowntime().equals("")){
            pageData.put("unplannedDowntime",input.getUnplannedDowntime().toString());
        }

        if(input.getLunchTime()!=null&&!input.getLunchTime().equals("")){
            pageData.put("lunchTime",input.getLunchTime().toString());
        }
        if(input.getBreakTime()!=null&&!input.getBreakTime().equals("")){
            pageData.put("breakTime",input.getBreakTime().toString());
        }



        if(daoImp.update(mapperName+"updateByItemno",pageData)>0){
            return true;
        }
        return false;
    }




    /**
     * get unplanned downtime
     * planned running time - (planned unrunning time  + actually running time)
     * throws Exception
     */
    public CastingOEETime getUnplannedRunningTime(String DateString, Integer StartRecordNO, Integer EndRecordNO,String device) throws Exception{

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Integer result;
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO+1;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)){
                inList+=",";
            }
        }

        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);
        list4oee = this.generallist(false,pageData,device);


        Integer plannedRunningTime = 0;
        Integer actuallyRunningTime = 0;
        Integer plannedDownTime = 0;

        for(CastingCPCGeneralOEEData g:list4oee){
            plannedRunningTime+=g.getPlannedRunTime();
            actuallyRunningTime+=g.getRunningtime();


            Integer breakTime = g.getBreakTime();
            Integer lunchTime = g.getLunchTime();
            Integer preventionMaintenance = g.getPreventionMaintenance();
            Integer setupPreparation = g.getSetupPreparation();
            Integer changeOvers = g.getChangeOvers();

            Integer sum = 0;
            if(breakTime!=null){
                sum+=breakTime;
            }
            if(lunchTime!=null){
                sum+=lunchTime;
            }
            if (preventionMaintenance!=null){
                sum+=preventionMaintenance;
            }
            if(setupPreparation!=null){
                sum+=setupPreparation;
            }
            if(changeOvers!=null){
                sum+=changeOvers;
            }

            plannedDownTime+=(sum);
        }
        CastingOEETime CPCOEETime = new CastingOEETime();
        result = plannedRunningTime-(actuallyRunningTime+plannedDownTime);

        CPCOEETime.setUnplannedDowntime(result);
        CPCOEETime.setActuallyRunningTime(actuallyRunningTime);

        return CPCOEETime;

    }



    /**
     * get DownTime by Week no
     * return 21 down time information objects
     * @return
     */
    public List<CastingValue> getDownTimeWeek(Integer year, Integer weekno,String device) throws Exception{

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Integer StartRecordNO =1;
        Integer EndRecordNO =96;
        Double result ;
        String inList = "";
        String DateStringInList ="";


        //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekno);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");



        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());
            DateStringInList+="'";
            DateStringInList+=dateStringAdd;
            DateStringInList+="'";
            if(i<6){
                DateStringInList+=",";
            }

        }

        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        PageData pageData4tra = new PageData();
        pageData4tra.put("DateStringInList",DateStringInList);
        pageData4tra.put("inList",inList);
        List<CastingCPCGeneralOEEDataOutput>  list4oee = this.generallist(false,pageData4tra,device);


        Integer unplannedDownTime;

        Integer plannedRunningTime = 0;
        Integer actuallyRunningTime = 0;
        Integer plannedDownTimeByCode =0;


        Map<String,String> CE = AppConsts.CODEEXPLANATION;//for find
        Map<String,Integer>  CN = new HashMap<String,Integer>();//for calculation


            for(CastingCPCGeneralOEEData g:list4oee){

            plannedRunningTime+=g.getPlannedRunTime();
            actuallyRunningTime+=g.getRunningtime();

                String  description = g.getDescription();      //get code explanation form description column name


                if(description!=null&&!description.equals("")){

                    if(CN.containsKey(description)==false){
                        CN.put(description,900);
                    }else {
                        Integer before =  CN.get(description);
                        Integer after = before+900;
                        CN.put(description,after);
                    }
                }

        }


        List<CastingValue> listByCode = new ArrayList<>();
        for (Integer value : CN.values()) {
            plannedDownTimeByCode += value; //get total of code down time
        }
        unplannedDownTime = plannedRunningTime-(actuallyRunningTime+plannedDownTimeByCode);
        if(unplannedDownTime<=0){
            unplannedDownTime=0;
        }
        CastingValue  unplannedValue  = new CastingValue();
        unplannedValue.setName("UD:unplannedDownTime");
        unplannedValue.setValue(unplannedDownTime);
        listByCode.add(unplannedValue); //push to out list

        Iterator<Map.Entry<String, Integer>> entries = CN.entrySet().iterator();
        while (entries.hasNext()) {

            Map.Entry<String, Integer> entry = entries.next();
            CastingValue codeValue = new CastingValue(); //output for code explanation for downtime
            codeValue.setName(entry.getKey()+":"+CE.get(entry.getKey()));
            codeValue.setValue(entry.getValue());
            listByCode.add(codeValue);
        }

        return listByCode;



    }



    /**
     * getOeeA
     * (availability)
     * actually running time  / target running time
     * 2019.02.19  no shift/production plan input ,put planned running time be 900 seconds if running time >=1 second per shift
     * @return
     * @throws Exception
     */
    public Double getOeeA(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Double result ;
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";
            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);

        list4oee = this.generallist(false,pageData,device);
        Integer plannedRunningTime = 0;
        Integer actuallyRunningTime = 0;

        for(CastingCPCGeneralOEEData g:list4oee){

            if(g.getRunningtime()>=1){
                g.setPlannedRunTime(900);  //default calculation of no plan input
            }

            plannedRunningTime+=g.getPlannedRunTime();  //should be update null to 0 in db;
            actuallyRunningTime+=g.getRunningtime();
        }

        if(plannedRunningTime==0.00){
            return  0.00;
        }
        result = new BigDecimal((float)actuallyRunningTime / plannedRunningTime).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return result;

    }

    /**
     * get Running Time Sum each shift
     * Requried hour
     * @return
     * @throws Exception
     */
    public Integer getRunningTimeSum(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Double result ;
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);


        list4oee = this.generallist(false,pageData,device);

        Integer actuallyRunningTime = 0;

        for(CastingCPCGeneralOEEData g:list4oee){

            actuallyRunningTime+=g.getRunningtime();
        }

        return actuallyRunningTime;

    }






    /**
     * getOeeP
     * (performance)
     *
     * actually produced / target produced
     *
     * @return
     * @throws Exception
     */
    public Double getOeeP(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Double result ;
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }
        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);
        list4oee = this.generallist(false,pageData,device);
        Integer plannedRunningTime = 0;

        for(CastingCPCGeneralOEEData g:list4oee){

            if(g.getRunningtime()>=1){
                g.setPlannedRunTime(900);  //default calculation of no plan input
            }


            plannedRunningTime+=g.getPlannedRunTime();

        }

        Double targetpieces = new BigDecimal((float)  plannedRunningTime/20).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //per part costs time   -- default value ?
        if(targetpieces==0.00){
            return 0.00;
        }
        PageData pageData4tra = new PageData();
        pageData4tra.put("DateString",DateString);
        pageData4tra.put("inList",inList);
        List<CastingCPCGeneralPvFurnaceChamberCurveOutput>  tralist = castingCPCGeneralPvFurnaceChamberCurveService.generallist(false,pageData4tra,device);
        Integer actuallypieces = tralist.size()/2*6;    //  2 records = 1 shot of production cycle , 1 shot =  6 parts

        result = new BigDecimal((float)  actuallypieces/targetpieces).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return result;


    }


    /**
     * getOeeQ
     * (quality)
     * good parts produced / actually produced
     *
     * @return
     * @throws Exception
     */
    public Double getOeeQ(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Double result ;
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
        List<CastingCPCGeneralPvFurnaceChamberCurveOutput>  tralist = castingCPCGeneralPvFurnaceChamberCurveService.generallist(false,pageData4tra,device);
        Integer actuallypieces = tralist.size();

        Integer goodpieces = tralist.size();
        for (CastingCPCGeneralPvFurnaceChamberCurve gtra : tralist ){

//            if(gtra.getPartstatus()!=0){
//                goodpieces--; //for each to get scrap information
//            }
//
        }
        if(actuallypieces==0.00){
            return 0.00;
        }

        result = new BigDecimal((float)  goodpieces/actuallypieces).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return result;

    }


    /**
     * get Quantity
     * actually produced parts quantity
     * @return
     * @throws Exception
     */
    public Integer getQuantitySum(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));

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
        List<CastingCPCGeneralPvFurnaceChamberCurveOutput>  tralist = castingCPCGeneralPvFurnaceChamberCurveService.generallist(false,pageData4tra,device);
        Integer actuallypieces = tralist.size();

        Integer goodpieces = tralist.size();
        for (CastingCPCGeneralPvFurnaceChamberCurve gtra : tralist ){
//            if(gtra.getPartstatus()!=0){
//                goodpieces--;
//            }
        }
        if(actuallypieces==0){
            return 0;
        }
        return goodpieces;
    }

    /**
     * get ALL downtime by specific time scope
     * get different type of down time by code , and their time costs
     * ...
     * "UD" = un planned downtime
     * "PM" = maintenance
     *
     * @return downtime objects and its value
     * @throws Exception
     */
    public  List<CastingValue>  getDownTime(String DateString, Integer StartRecordNO, Integer EndRecordNO,String device) throws Exception{
        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));
        Integer unplannedDownTime;
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";

            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }

        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);
        list4oee = this.generallist(false,pageData,device);


        Integer lunchTimeSum = 0;
        Integer breakTimeSum = 0;
        Integer pmSum = 0;
        Integer spSum = 0;
        Integer coSum = 0;


        Integer plannedRunningTime = 0;
        Integer actuallyRunningTime = 0;
        Integer plannedDownTime = 0;


        for(CastingCPCGeneralOEEData g:list4oee){

            plannedRunningTime+=g.getPlannedRunTime();
            actuallyRunningTime+=g.getRunningtime();
            Integer breakTime = g.getBreakTime();
            Integer lunchTime = g.getLunchTime();
            Integer preventionMaintenance = g.getPreventionMaintenance();
            Integer setupPreparation = g.getSetupPreparation();
            Integer changeOvers = g.getChangeOvers();
            if(breakTime!=null){
                breakTimeSum+=breakTime;
            }
            if(lunchTime!=null){
                lunchTimeSum+=lunchTime;
            }
            if (preventionMaintenance!=null){
                pmSum+=preventionMaintenance;
            }
            if(setupPreparation!=null){
                spSum+=setupPreparation;
            }
            if(changeOvers!=null){
                coSum+=changeOvers;
            }
        }
        plannedDownTime= lunchTimeSum+breakTimeSum+pmSum+spSum+coSum;
        unplannedDownTime = plannedRunningTime-(actuallyRunningTime+plannedDownTime);
        List<CastingValue> list = new ArrayList<>();
        Integer[] a = {lunchTimeSum,breakTimeSum,pmSum,spSum,coSum,unplannedDownTime};
        for(int i =0;i<6;i++){
            CastingValue v1 = new CastingValue();
            if(i==0){
                v1.setName("lunchTime");
                v1.setValue(a[i]);
            }
            if(i==1){
                v1.setName("breakTimeSum");
                v1.setValue(a[i]);
            }
            if(i==2){
                v1.setName("pm");
                v1.setValue(a[i]);
            }
            if(i==3){
                v1.setName("sp");
                v1.setValue(a[i]);
            }
            if(i==4){
                v1.setName("co");
                v1.setValue(a[i]);
            }
            if(i==5){
                v1.setName("unplannedDownTime");
                v1.setValue(a[i]);
            }

            list.add(v1);
        }
        return list;
    }



    /**
     * getTarget  and produced Quantity
     * get target produced
     *
     * @return
     */
    public CastingQT getTargetQuantity(String DateString, Integer StartRecordNO, Integer EndRecordNO,String device) throws Exception{

        this.setMapperName(AppConsts.CastingCPCGeneralOEEDataName.replace("General",device));

        CastingQT qt = new CastingQT();
        String inList = "";
        for(int i =0;i<=EndRecordNO-StartRecordNO;i++ ){
            inList+="'";
            inList+=(StartRecordNO+i);
            inList+="'";
            if(i<=(EndRecordNO-StartRecordNO)-1){
                inList+=",";
            }
        }
        List<CastingCPCGeneralOEEDataOutput> list4oee = new ArrayList<>();
        PageData pageData = new PageData();
        pageData.put("DateString",DateString);
        pageData.put("inList",inList);
        list4oee = this.generallist(false,pageData,device);
        Integer plannedRunningTime = 0;
        for(CastingCPCGeneralOEEData g:list4oee){
            if(g.getRunningtime()>=1){
                g.setPlannedRunTime(900);  //default calculation of no plan input
            }
            plannedRunningTime+=g.getPlannedRunTime();
        }
        Double targetpieces ;
        if (device.contains("A4")){
            targetpieces = new BigDecimal((float)  plannedRunningTime/(100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }else if (device.contains("A6")){
            targetpieces = new BigDecimal((float) plannedRunningTime / (200)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }else {
            targetpieces = new BigDecimal((float) plannedRunningTime / (230)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        //for per part costs  expect value
        if(targetpieces==0.00){
            qt.setTarget(0.00);
        }
        PageData pageData4tra = new PageData();
        pageData4tra.put("DateString",DateString);
        pageData4tra.put("inList",inList);
        List<CastingCPCGeneralPQDataOutput>  tralist = castingCPCGeneralPQDataService.generallist(false,pageData4tra,device);
        Integer Lh = 0;
        Integer Rh = 0;
        Integer totalPer = 0;
        for(CastingCPCGeneralPQData pq : tralist){
            if(pq.getTotalParts()!=null){
                totalPer = pq.getTotalParts();
            }
            if(totalPer!=0){
                break;
            }
        }
        Integer actuallypieces = tralist.size()*totalPer;
        Lh=actuallypieces/2;
        Rh= actuallypieces-Lh;
        qt.setQuantity(actuallypieces.doubleValue());
        qt.setLh(Lh);
        qt.setRh(Rh);
        qt.setTarget(targetpieces);
        return qt;
    }
}
