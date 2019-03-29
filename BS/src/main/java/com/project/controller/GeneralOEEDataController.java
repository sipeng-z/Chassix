package com.project.controller;

import com.casting.domain.entity.*;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.entity.GeneralProductionTemporary;
import com.project.domain.entity.MachQT;
import com.project.domain.model.input.GeneralOEEDataInput;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.service.ConversionToolService;
import com.project.service.GeneralOEEDataService;
import com.project.service.GeneralPQDataService;
import com.project.service.GeneralProductionTemporaryService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping(value = "GeneralOEEData")
public class GeneralOEEDataController extends GenericController<GeneralOEEDataInput,GeneralOEEDataOutput> {




    private final Logger logger = LoggerFactory.getLogger(GeneralOEEDataController.class);

    @Autowired
    private GeneralOEEDataService generalOEEDataService;

    @Autowired
    private ConversionToolService conversionToolService;

    @Autowired
    private GeneralProductionTemporaryService generalProductionTemporaryService;

    @Autowired
    private GeneralPQDataService generalPQDataService;


    @Override
    protected void OnActionExecuting() {
        generalOEEDataService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<GeneralOEEDataInput,GeneralOEEDataOutput> getService() {
        return generalOEEDataService;
    }





    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */
    @RequestMapping(value = "generalformpost",method = RequestMethod.POST)
    public ResponseResult generalformPost(String id, @RequestBody GeneralOEEDataInput input,String line,String device) {
        ResponseResult result = new ResponseResult();
        try{
            if(input==null){
                result.setMessage("@RequestBody M");
                result.setSuccess(false);
                return result;
            }
            if(device==null||device.equals("")){
                result.setMessage("Device is null");
                result.setSuccess(false);
                return result;
            }

            Boolean flag = null;
            if(id==null||id.equals("")){
                flag =  generalOEEDataService.generaladd (input,line,device);

            }else {
                flag =  generalOEEDataService.generalupdate(input,line,device);
            }
            if(flag==true){
                result.setMessage("Success!");
                result.setSuccess(true);
                return result;
            }else {
                result.setMessage("Error!");
                result.setSuccess(false);
                return result;
            }
        }catch (Exception e){
            logger.error("---------------------add异常-------"+e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * PAGELIST
     * @param request
     * @return
     */
    @RequestMapping(value = "generalpagerlist",method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request,String line,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(generalOEEDataService.generallist(true,new PageData(request),line,device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }




    /**
     * DEL
     * @param idList
     * @return
     */
    @RequestMapping(value = "generaldelete",method = RequestMethod.POST)
    public ResponseResult generaldelete(String idList,String line,String device) {
        try{
            return super.delete(idList);
        }catch (Exception e){
            logger.error("-----------------------delete异常-------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * GET
     */
    @RequestMapping(value = "generalget",method = RequestMethod.GET)
    public ResponseResult generalget(Integer ItemNO,String line,String device) {
        try{

            return ResponseResult.success(generalOEEDataService.getByItemNO(ItemNO,line,device));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * get Oee result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getOee",method = RequestMethod.GET)
    public ResponseResult getOeeAll(String DateString,Integer StartRecordNO,Integer EndRecordNO,String line,String device) throws Exception {

        ResponseResult result = new ResponseResult();

         Double a =  generalOEEDataService.getOeeA(DateString,StartRecordNO,EndRecordNO,line,device);

        Double p = 0.0;

        if(device.contains("ASSY")){
            p  =generalOEEDataService.getOeePAssy(DateString,StartRecordNO,EndRecordNO,line,device);
        }else {
            p  =generalOEEDataService.getOeeP(DateString,StartRecordNO,EndRecordNO,line,device);
        }

        Double q = generalOEEDataService.getOeeQ(DateString,StartRecordNO,EndRecordNO,line,device);

        Double oee = a*p*q*100;

        String oeeString = ""+oee+"";

        List list = new ArrayList();


        list.add(a);
        list.add(p);
        list.add(q);
        list.add(oeeString);


        return ResponseResult.success(list);

    }

    /**
     * get oee week FOR device
     * @param weekNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getWeekOee",method = RequestMethod.GET)
    public ResponseResult getWeekOee(Integer year,Integer weekNo,String line,String device) throws Exception {

        ResponseResult result = new ResponseResult();
        //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        List<CastingOEE> outList = new ArrayList<>();

        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());

            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};


            for(int j= 0; j<3;j++){
                int[] record= null;
                if(j==0){
                    record=shift1;
                }
                if(j==1){
                    record=shift2;
                }
                if (j==2){
                    record=shift3;
                }
                CastingOEE oeeobj = new CastingOEE();

                Double a  = generalOEEDataService.getOeeA(dateStringAdd,record[0],record[1],line,device);


                Double p  = 0.00;

                if(device.contains("ASSY")){
                    p =  generalOEEDataService.getOeePAssy(dateStringAdd,record[0],record[1],line,device);

                }else {
                    p =  generalOEEDataService.getOeeP(dateStringAdd,record[0],record[1],line,device);

                }

                Double q = 0.00;

                if(device.contains("ASSY")){
                    q = generalOEEDataService.getOeeQAssy(dateStringAdd,record[0],record[1],line,device);
                }else {
                    q = generalOEEDataService.getOeeQ(dateStringAdd,record[0],record[1],line,device);
                }


                Double oee = a*p*q*100;

                if (oee>=100.00){
                    oee=100.00;
                }

                oeeobj.setA(a);
                oeeobj.setP(p);
                oeeobj.setQ(q);
                oeeobj.setOEE(oee);

                outList.add(oeeobj);
            }


        }

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("[day(1-7):{shift1,shift2,shift3}]");

        return result;
    }




    /**
     * get oee week target
     * @param weekNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getWeekTargetByProduction",method = RequestMethod.GET)
    public ResponseResult getWeekOeeTarget(Integer year,Integer weekNo,String line,String device) throws Exception {

        ResponseResult result = new ResponseResult();
        PageData pageData = new PageData();


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR,weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);
        String DateStringInList = "";          //in list

        List<String> DateStringList =  new ArrayList<>();
        for(int i =1;i<=7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i-1));
            String dateStringAdd =sdf.format(calstart.getTime());
            DateStringInList+=dateStringAdd;
            DateStringList.add(dateStringAdd);
            if(i<7){
                DateStringInList+=",";
            }

        }
        pageData.put("DateStringInList",DateStringInList);

        List<GeneralProductionTemporary> productionList = (List<GeneralProductionTemporary>) generalProductionTemporaryService.generallist(false,pageData,line,device);


        Map<Integer,String> map = new HashMap<Integer,String>();
        List<Integer> ordersFull = new ArrayList<>();
        List<Integer> orders = new ArrayList<>();
        List<Integer> resultOrders = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        for(int i =0;i<productionList.size();i++){


            for(int j= 0;j<7;j++){

                String a = productionList.get(i).getDateString();
                String b = DateStringList.get(j);
                if(a.equals(b)){

                Integer recordNo =   productionList.get(i).getRecordno();

                Integer shiftAdd = 0;

                    if(recordNo<=32){
                        shiftAdd= 0;
                    }else if(recordNo<=64){
                        shiftAdd= 1;
                    }else if(recordNo<=96){
                        shiftAdd= 2;
                    }

                    Integer order = j*3+shiftAdd;
                    orders.add(order);

                }

            }

        }

        for(int i =0;i<21;i++){
            ordersFull.add(i);
            outList.add(85); // oee target line;  if plan was inputed  give value ,otherwise be 0;
        }

        for(Integer o:ordersFull){
           if(!orders.contains(o)){
               resultOrders.add(o);
           }
        }

        for(Integer ro :resultOrders){
           Integer index =  ro;
            outList.set(index,0);
        }




        result.setMessage("get oee target success");
        result.setData(outList);
        result.setSuccess(true);
        result.setCode(200);

        return result;

    }










    @RequestMapping(value = "getDownTime",method = RequestMethod.GET)
    public ResponseResult getDownTime(String DateString, Integer StartRecord , Integer EndRecord,String line,String device)  {


        try{

            return ResponseResult.success(generalOEEDataService.getDownTime(DateString,StartRecord,EndRecord,line,device));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    @RequestMapping(value = "getDownTimeWeek",method = RequestMethod.GET)
    public ResponseResult getDownTimeWeek(Integer year,Integer weekNo,String line,String device)  {


        try{


            return ResponseResult.success(generalOEEDataService.getDownTimeWeek(year,weekNo,line,device));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * getqt
     * @param year
     * @param weekNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getqt",method = RequestMethod.GET)
    public ResponseResult getQuantityTarget(Integer year,Integer weekNo,String line,String device) throws Exception {

        ResponseResult result = new ResponseResult();            //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        List<MachQT> outList = new ArrayList<>();
                                                                 // get 7 dates  and use that to loop ,get data
        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());
                                                                //put shift be full and 96 records per day to get data
            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};

            MachQT oeeobj = new MachQT();
            for(int j= 0; j<3;j++){
                int[] record= null;
                if(j==0){
                    record=shift1;
                }
                if(j==1){
                    record=shift2;
                }
                if (j==2){
                    record=shift3;
                }

                if(device.contains("ASSY")){
                    //ASSY calculation is different with cnc machines , need to rebuild the logic inside
                    oeeobj = generalOEEDataService.getTargetQuantityAssy(dateStringAdd,record[0],record[1],line,device);


                }else {
                    oeeobj = generalOEEDataService.getTargetQuantity(dateStringAdd,record[0],record[1],line,device);
                }

                outList.add(oeeobj);
            }

        }

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("[day(1-7):{shift1,shift2,shift3}]");

        return result;
    }



    @RequestMapping(value = "getqtByShift",method = RequestMethod.GET)
    public ResponseResult getQuantityTarget4Shift(String DateString ,Integer shift,String line ,String device) throws Exception {

        ResponseResult result = new ResponseResult();


        List<MachQT> outList = new ArrayList<>();



            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};

            MachQT oeeobj = new MachQT();

                int[] record= null;
                if(shift==1){
                    record=shift1;
                }
                if(shift==2){
                    record=shift2;
                }
                if (shift==3){
                    record=shift3;
                }

                oeeobj = generalOEEDataService.getTargetQuantity(DateString,record[0],record[1],line,device);


        Double a  =  generalOEEDataService.getOeeA(DateString,record[0],record[1],line,device);

        Double p  = generalOEEDataService.getOeeP(DateString,record[0],record[1],line,device);

        Double q = generalOEEDataService.getOeeQ(DateString,record[0],record[1],line,device);

        Double oee = a*p*q*100;

        String oeeString = ""+oee+"";

        outList.add(oeeobj);

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(oeeString);

        return result;
    }

    /**
     * get latest cycle time average value
     * @return
     */
    @RequestMapping(value = "cycleTimeAverage",method = RequestMethod.GET)
    public ResponseResult getCurrentCycleTimeAverage (String line,String device)throws Exception{

        ResponseResult result = new ResponseResult();


        Date today = new Date();
        String dateString = conversionToolService.dateToString(today);
        List<Integer> cycleTimeList = generalPQDataService.cycleTimeAverage(dateString,line,device);

        Integer AverageSum = 0; //sum of latest 6 value;

        for(int i= 0;i<6;i++){
            AverageSum += cycleTimeList.get(i);  //for the normal latest 6 cycle time sum , divided by  / 6

        }

        Integer resultAverage = AverageSum/6;
        List<Integer> outList = new ArrayList<>();
        outList.add(resultAverage);

        if(outList.size()==0){
            outList.add(0);     //if no production ,set 0
        }

        result.setSuccess(true);
        result.setMessage("Get current cycle time average success");
        result.setData(outList);
        return result;

    }


}
