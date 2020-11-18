package com.casting.controller;

import com.casting.domain.entity.*;
import com.casting.domain.model.input.CastingCPCGeneralOEEDataInput;
import com.casting.domain.model.output.CastingCPCGeneralOEEDataOutput;
import com.casting.domain.model.output.CastingCPCGeneralShiftOutput;
import com.casting.service.CastingCPCGeneralOEEDataService;
import com.casting.service.CastingCPCGeneralShiftService;
import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.service.ConversionToolService;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "CPCGeneralOEEData")
public class CastingCPCGeneralOEEDataController extends GenericController<CastingCPCGeneralOEEDataInput,CastingCPCGeneralOEEDataOutput> {

    private final Logger logger = LoggerFactory.getLogger(CastingCPCGeneralOEEDataController.class);

    @Autowired
    private CastingCPCGeneralOEEDataService castingCPCGeneralOEEDataService;

    @Autowired
    private CastingCPCGeneralShiftService castingCPCGeneralShiftService;

    @Override
    protected void OnActionExecuting() {
        castingCPCGeneralOEEDataService.SetWorkContext(this.WorkContext);
    }

    @Autowired
    private ConversionToolService conversionToolService;

    // declare sub services,
    protected AbstractService<CastingCPCGeneralOEEDataInput,CastingCPCGeneralOEEDataOutput> getService() {
        return castingCPCGeneralOEEDataService;
    }

    /**
     * ADD/UPDATE
     * @param id
     * @param input
     * @return
     */
    @RequestMapping(value = "generalformpost",method = RequestMethod.POST)
    public ResponseResult generalformPost(String id, @RequestBody CastingCPCGeneralOEEDataInput input,String device) {
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
            // if id not null, then considered as update
            if(id==null||id.equals("")){
                flag =  castingCPCGeneralOEEDataService.generaladd (input,device);   //add the domain

            }else {
                flag =  castingCPCGeneralOEEDataService.generalupdate(input,device);   //have pk id , update
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
     * PAGE LIST
     * @param request
     * @return
     */
    @RequestMapping(value = "generalpagerlist",method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request,String device) {
        try{
            return ResponseResult.success(new PageInfo<>(castingCPCGeneralOEEDataService.generallist(true,new PageData(request),device)));
        }catch (Exception e){
            logger.error("-----------------------pagelist  error ------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * DELETE
     * @param idList
     * @return
     */
    @RequestMapping(value = "generaldelete",method = RequestMethod.POST)
    public ResponseResult generaldelete(String idList,String device) {
        try{
            return super.delete(idList);
        }catch (Exception e){
            logger.error("-----------------------delete error-------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * GET SINGLE RECORD
     */
    @RequestMapping(value = "generalget",method = RequestMethod.GET)
    public ResponseResult generalget(Integer ItemNO,String device) {
        try{

            return ResponseResult.success(castingCPCGeneralOEEDataService.getByItemNO(ItemNO,device));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * get Oee
     * by
     * DateString
     * RecordNO scope
     * Device Name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getoee",method = RequestMethod.GET)
    public ResponseResult getOeeAll(String DateString,Integer StartRecordNO,Integer EndRecordNO,String device) throws Exception {

        ResponseResult result = new ResponseResult();

        Double a  =  castingCPCGeneralOEEDataService.getOeeA(DateString,StartRecordNO,EndRecordNO,device);

        Double p  = castingCPCGeneralOEEDataService.getOeeP(DateString,StartRecordNO,EndRecordNO,device);

        Double q = castingCPCGeneralOEEDataService.getOeeQ(DateString,StartRecordNO,EndRecordNO,device);

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
     *
     * get  week  oee
     * by weekno, device
     * @param weekno
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getweekoee",method = RequestMethod.GET)
    public ResponseResult getWeekOee(Integer year,Integer weekno,String device) throws Exception {

        ResponseResult result = new ResponseResult();
        //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekno);
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
                Double a  =  castingCPCGeneralOEEDataService.getOeeA(dateStringAdd,record[0],record[1],device);

                Double p  = castingCPCGeneralOEEDataService.getOeeP(dateStringAdd,record[0],record[1],device);

                Double q = castingCPCGeneralOEEDataService.getOeeQ(dateStringAdd,record[0],record[1],device);

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
     * get real time shift oee data
     * @param device
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getOeeByShift")
    public ResponseResult getOeeByShift(String device) throws Exception {

        ResponseResult result = new ResponseResult();

        Date today = new Date();

        Integer realTimeRecord = conversionToolService.timeToRecord(today);


        List<CastingOEE> outList = new ArrayList<>();

            String dateString = conversionToolService.dateToString(today);

            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};


                int[] record= null;
                if(realTimeRecord<=32){
                    record=shift1;
                }
                if(realTimeRecord>=33&&realTimeRecord<=64){
                    record=shift2;
                }
                if (realTimeRecord>=65){
                    record=shift3;
                }


                CastingOEE castingOEE = new CastingOEE();

                Double a = castingCPCGeneralOEEDataService.getOeeA(dateString,record[0],record[1],device);

                Double p = castingCPCGeneralOEEDataService.getOeeP(dateString,record[0],record[1],device);

                Double q = castingCPCGeneralOEEDataService.getOeeQ(dateString,record[0],record[1],device);



            Double oee = a*p*q*100;
            Double oeeLimit2 = new BigDecimal(a*p*q*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                if (oee>=100.00){
                    oee=100.00; // if running out of plan ,exist this situation
                }

        castingOEE.setA(a);
        castingOEE.setP(p);
        castingOEE.setQ(q);
//        castingOEE.setOEE(oeeLimit2);

                // param to get quantity and  target , getTargetQuantity();
        CastingQT qt = castingCPCGeneralOEEDataService.getTargetQuantity(dateString,record[0],record[1],device);

        castingOEE.setTarget(qt.getTarget().intValue());
        castingOEE.setProduced(qt.getLh()+qt.getRh()); //the sum of (left hand and right hand )
        outList.add(castingOEE);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("Real time oee data for casting shift ");

        return result;



    }

    /**
     * get oee week target
     * using shift plan  or production plan
     * @param weekNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getweekoeetarget",method = RequestMethod.GET)
    public ResponseResult getWeekOeeTarget(Integer year,Integer weekNo,String device) throws Exception {

        ResponseResult result = new ResponseResult();
        PageData pageData = new PageData();
        pageData.put("weekNo",weekNo.toString());
        pageData.put("year",year.toString());

        List<CastingCPCGeneralShiftOutput> shiftlist = castingCPCGeneralShiftService.generallist(false,pageData,device);
        List<CastingValue> outlist = new ArrayList<>();
        for(CastingCPCGeneralShift a :shiftlist){
            //order of shift_name done in the sql' order by '

            if(a.getMon()!=null&&!a.getMon().equals("")){
                CastingValue val = new CastingValue();
                val.setName("MON");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("MON");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getTue()!=null&&!a.getTue().equals("")){
                CastingValue val = new CastingValue();
                val.setName("TUE");
                val.setValue(75);
                outlist.add(val);
            } else {
                CastingValue val = new CastingValue();
                val.setName("TUE");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getWed()!=null&&!a.getWed().equals("")){
                CastingValue val = new CastingValue();
                val.setName("WED");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("WED");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getThu()!=null&&!a.getThu().equals("")){
                CastingValue val = new CastingValue();
                val.setName("THU");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("THU");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getFri()!=null&&!a.getFri().equals("")){
                CastingValue val = new CastingValue();
                val.setName("FRI");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("FRI");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getSat()!=null&&!a.getSat().equals("")){
                CastingValue val = new CastingValue();
                val.setName("SAT");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("SAT");
                val.setValue(0);
                outlist.add(val);
            }

            if(a.getSun()!=null&&!a.getSun().equals("")){
                CastingValue val = new CastingValue();
                val.setName("SUN");
                val.setValue(75);
                outlist.add(val);
            }else {
                CastingValue val = new CastingValue();
                val.setName("SUN");
                val.setValue(0);
                outlist.add(val);
            }
        }


        List<Integer> orderlist = new ArrayList<>();
        Integer limit = outlist.size()/3;

        for(int i=0;i<limit;i+=1){
            orderlist.add(outlist.get(i).getValue());
            orderlist.add(outlist.get(i+7).getValue());
            orderlist.add(outlist.get(i+14).getValue());

        }

        result.setMessage("get oee target success");
        result.setData(orderlist);
        result.setSuccess(true);
        result.setCode(200);
        return result;

    }






    @RequestMapping(value = "getdowntime",method = RequestMethod.GET)
    public ResponseResult getDownTime(String DateString, Integer StartRecord , Integer EndRecord,String device)  {


        try{

            return ResponseResult.success(castingCPCGeneralOEEDataService.getDownTime(DateString,StartRecord,EndRecord,device));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }





    @RequestMapping(value = "getdowntimeweek",method = RequestMethod.GET)
    public ResponseResult getDownTimeWeek(Integer year,Integer weekno,String device)  {


        try{


            return ResponseResult.success(castingCPCGeneralOEEDataService.getDownTimeWeek(year,weekno,device));

        }catch (Exception e){
            logger.error("-------------getDownTime Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * get quantity of week units == quantity/per shift
     * @param year
     * @param weekno
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "getqt",method = RequestMethod.GET)
    public ResponseResult getQuantityTarget(Integer year,Integer weekno,String device) throws Exception {

        ResponseResult result = new ResponseResult();
        //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekno);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        List<CastingQT> outList = new ArrayList<>();

        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());

            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};

            CastingQT oeeobj = new CastingQT();
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
                oeeobj = castingCPCGeneralOEEDataService.getTargetQuantity(dateStringAdd,record[0],record[1],device);
                outList.add(oeeobj);
            }
        }
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("[day(1-7):{shift1,shift2,shift3}]");

        return result;
    }



    @RequestMapping(value = "getqt4shift",method = RequestMethod.GET)
    public ResponseResult getQuantityTarget4Shift(String DateString ,Integer shift,String device) throws Exception {

        ResponseResult result = new ResponseResult();


        List<CastingQT> outList = new ArrayList<>();



            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};

            CastingQT oeeobj = new CastingQT();

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

                oeeobj = castingCPCGeneralOEEDataService.getTargetQuantity(DateString,record[0],record[1],device);


        Double a = castingCPCGeneralOEEDataService.getOeeA(DateString,record[0],record[1],device);
        System.out.println(a);

        Double p = castingCPCGeneralOEEDataService.getOeeP(DateString,record[0],record[1],device);
        System.out.println(p);

        Double q = castingCPCGeneralOEEDataService.getOeeQ(DateString,record[0],record[1],device);
        System.out.println(q);

        Double oee = a*p*q*100;

        String oeeString = ""+oee+"";

        outList.add(oeeobj);

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(oeeString);
        return result;
    }






}
