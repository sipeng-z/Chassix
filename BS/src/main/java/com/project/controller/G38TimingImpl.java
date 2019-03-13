package com.project.controller;


import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.model.AppConsts;
import com.project.domain.entity.*;
import com.project.domain.model.input.G38ASSYOEEDataInput;
import com.project.domain.model.output.*;
import com.project.service.*;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "G38OTimingTest")
public class G38TimingImpl extends GenericController<G38ASSYOEEDataInput,G38ASSYOEEDataOutput>{

    private final Logger logger = LoggerFactory.getLogger(G38Timing.class);

    @Override
    protected void OnActionExecuting() {
        g38ASSYOEEDataService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<G38ASSYOEEDataInput,G38ASSYOEEDataOutput> getService() {
        return g38ASSYOEEDataService;
    }


    @Autowired
    private G38ASSYShiftService g38ASSYShiftService;
    @Autowired
    private G38V21ShiftService g38V21ShiftService;

    @Autowired
    private G38V22ShiftService g38V22ShiftService;
    @Autowired
    private G38V23ShiftService g38V23ShiftService;



    @Autowired
    private G38ASSYOEEDataService g38ASSYOEEDataService;

    @Autowired
    private G38V21OEEDataService g38V21OEEDataService;
    @Autowired
    private G38V22OEEDataService g38V22OEEDataService;

    @Autowired
    private G38V23OEEDataService g38V23OEEDataService;



    @Autowired
    private G38ASSYOEEDataTemporaryService g38ASSYOEEDataTemporaryService;

   @Autowired
   private G38V21OEEDataTemporaryService  g38V21OEEDataTemporaryService;

    @Autowired
    private G38V22OEEDataTemporaryService  g38V22OEEDataTemporaryService;
    @Autowired
    private G38V23OEEDataTemporaryService  g38V23OEEDataTemporaryService;



    public final static long ONE_Minute =  60 * 1000;
    public final static long FIFTEEN_Minute =  900 * 1000;





    /**
     * test
     * @param
     * @return
     */
    @RequestMapping(value = "testAssyShift",method = RequestMethod.POST)
    public ResponseResult assyShiftTiming() {
        ResponseResult result = new ResponseResult();
        try{

            Integer mark = 0;
            List<G38ASSYShift> list =  g38ASSYShiftService.listbymark(mark);
            if (list.size()==0){
                result.setMessage("NO SHIFT ASSY DATA");
                logger.info("NO SHIFT ASSY DATA");
                return result;
            }

            for(G38ASSYShift g : list){

                Calendar c = Calendar.getInstance();
                c.setTime(g.getCreatedDateTime());
                Integer year =  c.get(Calendar.YEAR); ;
                Integer weekno = g.getWeekNo();
                String  shiftName = g.getShiftName();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.WEEK_OF_YEAR,weekno);
                cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datestring = sdf.format(date);
                String inList = "";          //in list

                Integer[] shift = null;
                if(shiftName.equals("SHIFT1")) {
                    shift = AppConsts.shift1;
                }else if(shiftName.equals("SHIFT2")){
                    shift = AppConsts.shift2;
                }else if(shiftName.equals("SHIFT3")){
                    shift = AppConsts.shift3;
                }else {
                    logger.error("SHIFT ERROR");
                    result.setMessage("shift error");
                    return result ;
                }
                for(int i =0;i<=shift[1]-shift[0];i++ ){
                    inList+="'";

                    inList+=(shift[0]+i);
                    inList+="'";
                    if(i<=(shift[1]-shift[0])-1){
                        inList+=",";
                    }
                }

                Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                if(g.getMon()!=null&&!g.getMon().equals("")){
                map.put(1,1);
                }
                if(g.getTue()!=null&&!g.getTue().equals("")){
                    map.put(2,1);
                }
                if(g.getWed()!=null&&!g.getWed().equals("")){
                    map.put(3,1);
                }
                if(g.getThu()!=null&&!g.getWed().equals("")){
                    map.put(4,1);
                }
                if(g.getFri()!=null&&!g.getFri().equals("")){
                    map.put(5,1);
                }
                if(g.getSat()!=null&&!g.getSat().equals("")){
                    map.put(6,1);
                }
                if(g.getSun()!=null&&!g.getSun().equals("")){
                    map.put(7,1);
                }
                for(int i =1;i<=7;i++) {
                    if(!map.containsKey(i)){
                        continue;
                    }

                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(date);
                    calstart.add(Calendar.DAY_OF_WEEK, (i-1));
                    String dateStringAdd =sdf.format(calstart.getTime());


                    //MON - SUN
                    PageData pageData = new PageData();
                    pageData.put("inList", inList);
                    pageData.put("DateString", dateStringAdd);
                    pageData.put("nomark", "1");

                    List<G38ASSYOEEDataOutput> oeelist = (List<G38ASSYOEEDataOutput>) g38ASSYOEEDataService.list(false, pageData);

                    Date nowDate = new Date();

                    String nowparsebefore = sdf.format(nowDate); //parse date to String

                    Date loopparse = sdf.parse(dateStringAdd);   // String to Date
                    Date nowparse = sdf.parse(nowparsebefore);

                    for (G38ASSYOEEData goee : oeelist) {
                        Integer pkId = goee.getItemno();
                        boolean flag = g38ASSYOEEDataService.updatePlannedTimeByItemno(pkId);

                        boolean flag1 = (map.containsKey(6)==false)&&(map.containsKey(7)==false);
                        boolean flag2 = (oeelist.size()>=32);

                        if((i>=7||(i>=5&&flag1))&&oeelist.size()>=32){
                            Integer updateM = 1;
                            g38ASSYShiftService.updateMark(updateM,g.getShiftId());
                        }
                    }



                }

                Calendar calstart = Calendar.getInstance();
                calstart.setTime(date);
                calstart.add(Calendar.DAY_OF_WEEK, 6);
                String weekMaxDateString =sdf.format(calstart.getTime());

                Date maxparse = sdf.parse(weekMaxDateString);   // String to Date

                Date nowDate = new Date();
                String nowDateString = sdf.format(nowDate); //parse date to String

                Date nowparse = sdf.parse(nowDateString);
                boolean flag3 = maxparse.before(nowparse);

                if(flag3==true){
                    Integer updateM = 1;
                    g38ASSYShiftService.updateMark(updateM,g.getShiftId());
                }


            }
            result.setSuccess(true);
            result.setMessage("success!");
            return result;



        }catch (Exception e) {
            logger.error("-----------ASSY SHIFT LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }


    @RequestMapping(value = "testAssyTem",method = RequestMethod.POST)
    public ResponseResult assyTemTiming() {
        try{
            ResponseResult result = new ResponseResult();
            PageData pageData = new PageData();
            pageData.put("NoMark","1");
           List<G38ASSYOEEDataTemporaryOutput> list = g38ASSYOEEDataTemporaryService.list(false,pageData);
            Integer listsize =list.size();
            if (list.size()==0){
                result.setMessage("NO TEM ASSY DATA");
                logger.info("NO TEM ASSY DATA");
                return result;
            }

            for(G38ASSYOEEDataTemporary g :list){
              PageData pageData1 = new PageData();
               pageData1.put("RecordNO",g.getRecordno().toString());
               pageData1.put("DateString",g.getDateString());
             List<G38ASSYOEEDataOutput> list1 = g38ASSYOEEDataService.list(false,pageData1);

             for(G38ASSYOEEData g38ASSYOEEData : list1){

                 if(g.getPreventiveMaintenance()!=null){
                     g38ASSYOEEData.setPreventiveMaintenance(g.getPreventiveMaintenance());
                 }
                 if(g.getSetupPreoaration()!=null){
                     g38ASSYOEEData.setSetupPreparation(g.getSetupPreoaration());
                 }
                 if(g.getChangeOvers()!=null){
                     g38ASSYOEEData.setChangeOvers(g.getChangeOvers());
                 }
                 if(g.getBreakTime()!=null){
                     g38ASSYOEEData.setBreakTime(g.getBreakTime());
                 }
                 if(g.getLunchTime()!=null){
                     g38ASSYOEEData.setLunchTime(g.getLunchTime());
                 }
                 if(g.getDescription()!=null&&!g.getDescription().equals("")){
                     g38ASSYOEEData.setDescription(g.getDescription());
                 }


                 g38ASSYOEEData.setPlannedRunTime(0);
               Boolean flag =  g38ASSYOEEDataService.updatePlannedTime(g38ASSYOEEData);

                    if(flag==true){
                      //mark the tem single one
                       PageData pageData2 = new PageData();
                      pageData2.put("RecordNO",g38ASSYOEEData.getRecordno().toString());
                       pageData1.put("DateString",g38ASSYOEEData.getDateString());
                        G38ASSYOEEDataTemporary  g38ASSYOEEDataTemporary = g38ASSYOEEDataTemporaryService.findByDateRecord(g38ASSYOEEData.getDateString(),g38ASSYOEEData.getRecordno());
                      String temporaryId =  g38ASSYOEEDataTemporary.getTemporaryId();
                       g38ASSYOEEDataTemporaryService.updateMark(1,temporaryId);
                    }


             }

           }
            result.setSuccess(true);
            result.setMessage("ASSY TEM SUCCESS!");
            return result;

        }catch (Exception e){
            logger.error("-----------ASSY TEM LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);

    }



    @RequestMapping(value = "testV21Shift",method = RequestMethod.POST)
    public ResponseResult v21ShiftTiming() {
        ResponseResult result = new ResponseResult();
        try{

            Integer mark = 0;
            List<G38V21ShiftOutput> list =  g38V21ShiftService.listbymark(mark);
            if (list.size()==0){
                result.setMessage("NO SHIFT V21 DATA");
                logger.info("NO SHIFT V21 DATA");
                return result;
            }

            for(G38V21Shift g : list){

                Calendar c = Calendar.getInstance();
                c.setTime(g.getCreatedDateTime());
                Integer year =  c.get(Calendar.YEAR); ;
                Integer weekno = g.getWeekNo();
                String  shiftName = g.getShiftName();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.WEEK_OF_YEAR, weekno);
                cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datestring = sdf.format(date);
                String inList = "";          //in list

                Integer[] shift = null;
                if(shiftName.equals("SHIFT1")) {
                    shift = AppConsts.shift1;
                }else if(shiftName.equals("SHIFT2")){
                    shift = AppConsts.shift2;
                }else if(shiftName.equals("SHIFT3")){
                    shift = AppConsts.shift3;
                }else {
                    logger.error("SHIFT ERROR");
                    result.setMessage("shift error");
                    return result ;
                }
                for(int i =0;i<=shift[1]-shift[0];i++ ){
                    inList+="'";

                    inList+=(shift[0]+i);
                    inList+="'";
                    if(i<=(shift[1]-shift[0])-1){
                        inList+=",";
                    }
                }

                Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                if(g.getMon()!=null&&!g.getMon().equals("")){
                    map.put(1,1);
                }
                if(g.getTue()!=null&&!g.getTue().equals("")){
                    map.put(2,1);
                }
                if(g.getWed()!=null&&!g.getWed().equals("")){
                    map.put(3,1);
                }
                if(g.getThu()!=null&&!g.getWed().equals("")){
                    map.put(4,1);
                }
                if(g.getFri()!=null&&!g.getFri().equals("")){
                    map.put(5,1);
                }
                if(g.getSat()!=null&&!g.getSat().equals("")){
                    map.put(6,1);
                }
                if(g.getSun()!=null&&!g.getSun().equals("")){
                    map.put(7,1);
                }
                for(int i =1;i<=7;i++) {
                    if(!map.containsKey(i)){
                        continue;
                    }

                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(date);
                    calstart.add(Calendar.DAY_OF_WEEK, (i-1));
                    String dateStringAdd =sdf.format(calstart.getTime());


                    //MON - SUN
                    PageData pageData = new PageData();
                    pageData.put("inList", inList);
                    pageData.put("DateString", dateStringAdd);
                    pageData.put("nomark", "1");
                    List<G38V21OEEDataOutput> oeelist = (List<G38V21OEEDataOutput>) g38V21OEEDataService.list(false, pageData);

                    Date nowDate = new Date();
                    String nowparsebefore = sdf.format(nowDate); //parse date to String

                    Date loopparse = sdf.parse(dateStringAdd);   // String to Date
                    Date nowparse = sdf.parse(nowparsebefore);




                    for (G38V21OEEData goee : oeelist) {
                        Integer pkId = goee.getItemno();
                        boolean flag = g38V21OEEDataService.updatePlannedTimeByItemno(pkId);

                        boolean flag1 = (map.containsKey(6)==false)&&(map.containsKey(7)==false);
                        boolean flag2 = (oeelist.size()>=32);
                        boolean flag3 = (loopparse.before(nowparse));

                        if((i>=7||(i>=5&&flag1))&&flag3){
                            Integer updateM = 1;
                            g38V21ShiftService.updateMark(updateM,g.getShiftId());
                        }

                    }


                }
                Calendar calstart = Calendar.getInstance();
                calstart.setTime(date);
                calstart.add(Calendar.DAY_OF_WEEK, 6);
                String weekMaxDateString =sdf.format(calstart.getTime());

                Date maxparse = sdf.parse(weekMaxDateString);   // String to Date

                Date nowDate = new Date();
                String nowDateString = sdf.format(nowDate); //parse date to String

                Date nowparse = sdf.parse(nowDateString);
                boolean flag3 = maxparse.before(nowparse);

                if(flag3==true){
                    Integer updateM = 1;
                    g38V21ShiftService.updateMark(updateM,g.getShiftId());
                }


            }
            result.setSuccess(true);
            result.setMessage("V21 SHIFT SUCCESS!");
            return result;



        }catch (Exception e) {
            logger.error("-----------V21 SHIFT LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    @RequestMapping(value = "testV21Tem",method = RequestMethod.POST)
    public ResponseResult v21TemTiming() {
        try{
            ResponseResult result = new ResponseResult();
            PageData pageData = new PageData();
            pageData.put("NoMark","1");
            List<G38V21OEEDataTemporaryOutput> list = g38V21OEEDataTemporaryService.list(false,pageData);
            if (list.size()==0){
                result.setMessage("NO TEM V21 DATA");
                logger.info("NO TEM V21 DATA");
                return result;
            }


            for(G38V21OEEDataTemporary g :list){
                PageData pageData1 = new PageData();
                pageData1.put("RecordNO",g.getRecordno().toString());
                pageData1.put("DateString",g.getDateString());
                List<G38V21OEEDataOutput> list1 = g38V21OEEDataService.list(false,pageData1);


                for(G38V21OEEData g38V21OEEData : list1){

                    if(g.getPreventiveMaintenance()!=null){
                        g38V21OEEData.setPreventionMaintenance(g.getPreventiveMaintenance());
                    }
                    if(g.getSetupPreoaration()!=null){
                        g38V21OEEData.setSetupPreparation(g.getSetupPreoaration());
                    }
                    if(g.getChangeOvers()!=null){
                        g38V21OEEData.setChangeOvers(g.getChangeOvers());
                    }
                    if(g.getBreakTime()!=null){
                        g38V21OEEData.setBreakTime(g.getBreakTime());
                    }
                    if(g.getLunchTime()!=null){
                        g38V21OEEData.setLunchTime(g.getLunchTime());
                    }

                    if(g.getDescription()!=null&&!g.getDescription().equals("")){
                        g38V21OEEData.setDescription(g.getDescription());
                    }


                    g38V21OEEData.setPlannedRunTime(0);
               Boolean flag =     g38V21OEEDataService.updatePlannedTime(g38V21OEEData);
               if(flag==true){

                   PageData pageData2 =  new PageData();
                   pageData2.put("RecordNO",g38V21OEEData.getRecordno().toString());
                   pageData2.put("DateString",g38V21OEEData.getDateString());
                G38V21OEEDataTemporary g38V21OEEDataTemporary =   g38V21OEEDataTemporaryService.findByDateRecord(g38V21OEEData.getDateString(),g38V21OEEData.getRecordno());
                    String temporaryId = g38V21OEEDataTemporary.getTemporaryId();
                   g38V21OEEDataTemporaryService.updateMark(1,temporaryId);
               }

                }

            }
            result.setSuccess(true);
            result.setMessage("V21 TEM SUCCESS!");
            return result;

        }catch (Exception e){
            logger.error("-----------V21 TEM LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);

    }




    @RequestMapping(value = "testV22Shift",method = RequestMethod.POST)
    public ResponseResult v22ShiftTiming() {
        ResponseResult result = new ResponseResult();
        try{

            Integer mark = 0;
            List<G38V22ShiftOutput> list =  g38V22ShiftService.listbymark(mark);
            if (list.size()==0){
                result.setMessage("NO SHIFT V22 DATA");
                logger.info("NO SHIFT V22 DATA");
                return result;
            }

            for(G38V22Shift g : list){

                Calendar c = Calendar.getInstance();
                c.setTime(g.getCreatedDateTime());
                Integer year =  c.get(Calendar.YEAR); ;
                Integer weekno = g.getWeekNo();
                String  shiftName = g.getShiftName();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.WEEK_OF_YEAR, weekno);
                cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datestring = sdf.format(date);
                String inList = "";          //in list



                Integer[] shift = null;
                if(shiftName.equals("SHIFT1")) {
                    shift = AppConsts.shift1;
                }else if(shiftName.equals("SHIFT2")){
                    shift = AppConsts.shift2;
                }else if(shiftName.equals("SHIFT3")){
                    shift = AppConsts.shift3;
                }else {
                    logger.error("SHIFT ERROR");
                    result.setMessage("shift error");
                    return result ;
                }
                for(int i =0;i<=shift[1]-shift[0];i++ ){
                    inList+="'";

                    inList+=(shift[0]+i);
                    inList+="'";
                    if(i<=(shift[1]-shift[0])-1){
                        inList+=",";
                    }
                }

                Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                if(g.getMon()!=null&&!g.getMon().equals("")){
                    map.put(1,1);
                }
                if(g.getTue()!=null&&!g.getTue().equals("")){
                    map.put(2,1);
                }
                if(g.getWed()!=null&&!g.getWed().equals("")){
                    map.put(3,1);
                }
                if(g.getThu()!=null&&!g.getWed().equals("")){
                    map.put(4,1);
                }
                if(g.getFri()!=null&&!g.getFri().equals("")){
                    map.put(5,1);
                }
                if(g.getSat()!=null&&!g.getSat().equals("")){
                    map.put(6,1);
                }
                if(g.getSun()!=null&&!g.getSun().equals("")){
                    map.put(7,1);
                }
                for(int i =1;i<=7;i++) {
                    if(!map.containsKey(i)){
                        continue;
                    }

                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(date);
                    calstart.add(Calendar.DAY_OF_WEEK, (i-1));
                    String dateStringAdd =sdf.format(calstart.getTime());


                    //MON - SUN
                    PageData pageData = new PageData();
                    pageData.put("inList", inList);
                    pageData.put("DateString", dateStringAdd);
                    pageData.put("nomark", "1");
                    List<G38V22OEEDataOutput> oeelist = (List<G38V22OEEDataOutput>) g38V22OEEDataService.list(false, pageData);



                    Date nowDate = new Date();
                    String nowparsebefore = sdf.format(nowDate); //parse date to String

                    Date loopparse = sdf.parse(dateStringAdd);   // String to Date
                    Date nowparse = sdf.parse(nowparsebefore);





                    for (G38V22OEEData goee : oeelist) {
                        Integer pkId = goee.getItemno();
                        boolean flag = g38V22OEEDataService.updatePlannedTimeByItemno(pkId);
                        boolean flag1 = (map.containsKey(6)==false)&&(map.containsKey(7)==false);
                        boolean flag2 = (oeelist.size()>=32);
                        boolean flag3 = (loopparse.before(nowparse));
                        if((i>=7||(i>=5&&flag1))&&flag3){
                            Integer updateM = 1;
                            g38V22ShiftService.updateMark(updateM,g.getShiftId());
                        }

                    }

                }

                Calendar calstart = Calendar.getInstance();
                calstart.setTime(date);
                calstart.add(Calendar.DAY_OF_WEEK, 6);
                String weekMaxDateString =sdf.format(calstart.getTime());

                Date maxparse = sdf.parse(weekMaxDateString);   // String to Date

                Date nowDate = new Date();
                String nowDateString = sdf.format(nowDate); //parse date to String

                Date nowparse = sdf.parse(nowDateString);
                boolean flag3 = maxparse.before(nowparse);

                if(flag3==true){
                    Integer updateM = 1;
                    g38V22ShiftService.updateMark(updateM,g.getShiftId());
                }


            }
            result.setSuccess(true);
            result.setMessage("V22 SHIFT SUCCESS!");
            return result;



        }catch (Exception e) {
            logger.error("-----------V22 SHIFT LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }




    @RequestMapping(value = "testV22Tem",method = RequestMethod.POST)
    public ResponseResult v22TemTiming() {
        try{
            ResponseResult result = new ResponseResult();
            PageData pageData = new PageData();
            pageData.put("NoMark","1");
            List<G38V22OEEDataTemporaryOutput> list = g38V22OEEDataTemporaryService.list(false,pageData); //get tem data mark!=1


            if(list.size()==0){

                result.setMessage("NO TEM V22 DATA");
                logger.info("NO TEM V22 DATA");
                return result;
            }
            Integer listsize =list.size();

            for(G38V22OEEDataTemporary g :list){
                PageData pageData1 = new PageData();
                pageData1.put("RecordNO",g.getRecordno().toString());
                pageData1.put("DateString",g.getDateString());
                List<G38V22OEEDataOutput> list1 = g38V22OEEDataService.list(false,pageData1);//using recordno,dateString from tem to get oeedata list(should be single one once)


                for(G38V22OEEData g38V22OEEData : list1){

                    if(g.getPreventiveMaintenance()!=null){
                        g38V22OEEData.setPreventionMaintenance(g.getPreventiveMaintenance());
                    }
                    if(g.getSetupPreoaration()!=null){
                        g38V22OEEData.setSetupPreparation(g.getSetupPreoaration());
                    }
                    if(g.getChangeOvers()!=null){
                        g38V22OEEData.setChangeOvers(g.getChangeOvers());
                    }
                    if(g.getBreakTime()!=null){
                        g38V22OEEData.setBreakTime(g.getBreakTime());
                    }
                    if(g.getLunchTime()!=null){
                        g38V22OEEData.setLunchTime(g.getLunchTime());
                    }

                    if(g.getDescription()!=null&&!g.getDescription().equals("")){
                        g38V22OEEData.setDescription(g.getDescription());
                    }

                    g38V22OEEData.setPlannedRunTime(0);
                    Boolean flag =     g38V22OEEDataService.updatePlannedTime(g38V22OEEData);
                    if(flag==true){

                        PageData pageData2 =  new PageData();
                        pageData2.put("RecordNO",g38V22OEEData.getRecordno().toString());
                        pageData2.put("DateString",g38V22OEEData.getDateString());
                        G38V22OEEDataTemporary g38V22OEEDataTemporary =   g38V22OEEDataTemporaryService.findByDateRecord(g38V22OEEData.getDateString(),g38V22OEEData.getRecordno());
                        String temporaryId = g38V22OEEDataTemporary.getTemporaryId();
                        g38V22OEEDataTemporaryService.updateMark(1,temporaryId);
                    }

                }

            }
            result.setSuccess(true);
            result.setMessage("V22 TEM SUCCESS!");
            return result;

        }catch (Exception e){
            logger.error("-----------V22 TEM LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);

    }



    @RequestMapping(value = "testV23Shift",method = RequestMethod.POST)
    public ResponseResult v23ShiftTiming() {
        ResponseResult result = new ResponseResult();
        try{

            Integer mark = 0;
            List<G38V23ShiftOutput> list =  g38V23ShiftService.listbymark(mark);
            if (list.size()==0){
                result.setMessage("NO SHIFT V23 DATA");
                logger.info("NO SHIFT V23 DATA");
                return result;
            }

            for(G38V23Shift g : list){

                Calendar c = Calendar.getInstance();
                c.setTime(g.getCreatedDateTime());
                Integer year =  c.get(Calendar.YEAR); ;
                Integer weekno = g.getWeekNo();
                String  shiftName = g.getShiftName();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR,year);
                cal.set(Calendar.WEEK_OF_YEAR, weekno);
                cal.set(Calendar.DAY_OF_WEEK, 2);//monday 2
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String datestring = sdf.format(date);
                String inList = "";          //in list



                Integer[] shift = null;
                if(shiftName.equals("SHIFT1")) {
                    shift = AppConsts.shift1;
                }else if(shiftName.equals("SHIFT2")){
                    shift = AppConsts.shift2;
                }else if(shiftName.equals("SHIFT3")){
                    shift = AppConsts.shift3;
                }else {
                    logger.error("SHIFT ERROR");
                    result.setMessage("SHIFT ERROR");
                    return result ;
                }
                for(int i =0;i<=shift[1]-shift[0];i++ ){
                    inList+="'";

                    inList+=(shift[0]+i);
                    inList+="'";
                    if(i<=(shift[1]-shift[0])-1){
                        inList+=",";
                    }
                }

                Map<Integer,Integer> map = new HashMap<Integer, Integer>();
                if(g.getMon()!=null&&!g.getMon().equals("")){
                    map.put(1,1);
                }
                if(g.getTue()!=null&&!g.getTue().equals("")){
                    map.put(2,1);
                }
                if(g.getWed()!=null&&!g.getWed().equals("")){
                    map.put(3,1);
                }
                if(g.getThu()!=null&&!g.getWed().equals("")){
                    map.put(4,1);
                }
                if(g.getFri()!=null&&!g.getFri().equals("")){
                    map.put(5,1);
                }
                if(g.getSat()!=null&&!g.getSat().equals("")){
                    map.put(6,1);
                }
                if(g.getSun()!=null&&!g.getSun().equals("")){
                    map.put(7,1);
                }
                for(int i =1;i<=7;i++) {
                    if(!map.containsKey(i)){
                        continue;
                    }

                    Calendar calstart = Calendar.getInstance();
                    calstart.setTime(date);
                    calstart.add(Calendar.DAY_OF_WEEK, (i-1));
                    String dateStringAdd =sdf.format(calstart.getTime());


                    //MON - SUN
                    PageData pageData = new PageData();
                    pageData.put("inList", inList);
                    pageData.put("DateString", dateStringAdd);
                    pageData.put("nomark", "1");
                    List<G38V23OEEDataOutput> oeelist = (List<G38V23OEEDataOutput>) g38V23OEEDataService.list(false, pageData);

                    Date nowDate = new Date();
                    String nowparsebefore = sdf.format(nowDate); //parse date to String

                    Date loopparse = sdf.parse(dateStringAdd);   // String to Date
                    Date nowparse = sdf.parse(nowparsebefore);



                    for (G38V23OEEData goee : oeelist) {
                        Integer pkId = goee.getItemno();
                        boolean flag = g38V23OEEDataService.updatePlannedTimeByItemno(pkId);


                        boolean flag1 = (map.containsKey(6)==false)&&(map.containsKey(7)==false);
                        boolean flag2 = (oeelist.size()>=32);
                        boolean flag3 = (loopparse.before(nowparse));

                        if((i>=7||(i>=5&&flag1))&&flag3){
                            Integer updateM = 1;
                            g38V23ShiftService.updateMark(updateM,g.getShiftId());
                        }

                    }

                }

                Calendar calstart = Calendar.getInstance();
                calstart.setTime(date);
                calstart.add(Calendar.DAY_OF_WEEK, 6);
                String weekMaxDateString =sdf.format(calstart.getTime());

                Date maxparse = sdf.parse(weekMaxDateString);   // String to Date

                Date nowDate = new Date();
                String nowDateString = sdf.format(nowDate); //parse date to String

                Date nowparse = sdf.parse(nowDateString);
                boolean flag3 = maxparse.before(nowparse);

                if(flag3==true){
                    Integer updateM = 1;
                    g38V23ShiftService.updateMark(updateM,g.getShiftId());
                }

            }
            result.setSuccess(true);
            result.setMessage(" V23 SHIFT SUCCESS!");
            return result;



        }catch (Exception e) {
            logger.error("----------- V23 SHIFT LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }




    @RequestMapping(value = "testV23Tem",method = RequestMethod.POST)
    public ResponseResult v23TemTiming() {
        try{
            ResponseResult result = new ResponseResult();
            PageData pageData = new PageData();
            pageData.put("NoMark","1");
            List<G38V23OEEDataTemporaryOutput> list = g38V23OEEDataTemporaryService.list(false,pageData);
            Integer listsize =list.size();
            if (list.size()==0){
                result.setMessage("NO TEM V23 DATA");
                logger.info("NO TEM V23 DATA");
                return result;
            }


            for(G38V23OEEDataTemporary g :list){
                PageData pageData1 = new PageData();
                pageData1.put("RecordNO",g.getRecordno().toString());
                pageData1.put("DateString",g.getDateString());
                List<G38V23OEEDataOutput> list1 = g38V23OEEDataService.list(false,pageData1);


                for(G38V23OEEData g38V23OEEData : list1){

                    if(g.getPreventiveMaintenance()!=null){
                        g38V23OEEData.setPreventionMaintenance(g.getPreventiveMaintenance());
                    }
                    if(g.getSetupPreoaration()!=null){
                        g38V23OEEData.setSetupPreparation(g.getSetupPreoaration());
                    }
                    if(g.getChangeOvers()!=null){
                        g38V23OEEData.setChangeOvers(g.getChangeOvers());
                    }
                    if(g.getBreakTime()!=null){
                        g38V23OEEData.setBreakTime(g.getBreakTime());
                    }
                    if(g.getLunchTime()!=null){
                        g38V23OEEData.setLunchTime(g.getLunchTime());
                    }

                    if(g.getDescription()!=null&&!g.getDescription().equals("")){
                        g38V23OEEData.setDescription(g.getDescription());
                    }
                    g38V23OEEData.setPlannedRunTime(0);
                    Boolean flag =     g38V23OEEDataService.updatePlannedTime(g38V23OEEData);
                    if(flag==true){

                        PageData pageData2 =  new PageData();
                        pageData2.put("RecordNO",g38V23OEEData.getRecordno().toString());
                        pageData2.put("DateString",g38V23OEEData.getDateString());
                        G38V23OEEDataTemporary g38V23OEEDataTemporary =   g38V23OEEDataTemporaryService.findByDateRecord(g38V23OEEData.getDateString(),g38V23OEEData.getRecordno());
                        String temporaryId = g38V23OEEDataTemporary.getTemporaryId();
                        g38V23OEEDataTemporaryService.updateMark(1,temporaryId);
                    }

                }

            }
            result.setSuccess(true);
            result.setMessage("V23 TEM SUCCESS!");
            return result;

        }catch (Exception e){
            logger.error("-----------V23 TEM LOGGER ERROR-------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);

    }



}
