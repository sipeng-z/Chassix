package com.project.controller;


import com.domain.model.PageData;
import com.project.domain.entity.*;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.GeneralOEEDataService;
import com.project.service.GeneralProductionTemporaryService;
import com.project.service.GeneralTraceabilityDataService;
import com.project.service.LineDeviceService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping(value = "GeneralLine")
@RestController
public class GeneralLineController  {

    @Autowired
    private   LineDeviceService lineDeviceService;


    @Autowired
    private GeneralOEEDataService generalOEEDataService;

    @Autowired
    private GeneralProductionTemporaryService generalProductionTemporaryService;

    @Autowired
    private GeneralTraceabilityDataService generalTraceabilityDataService;


    /**
     * get line oee by week no
     * return 21  :  3 shifts * 7 days
     * @param line
     * @param year
     * @param weekNo
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "lineOee",method = RequestMethod.GET)
    public ResponseResult getLineOee(String line, Integer year,Integer weekNo) throws Exception{

        ResponseResult result = new ResponseResult();
        //week no , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        List<GeneralValue> outList = new ArrayList<>();

        for(int i=0;i<7;i++){
            Calendar calstart = Calendar.getInstance();
            calstart.setTime(date);
            calstart.add(Calendar.DAY_OF_WEEK, (i));
            String dateStringAdd =sdf.format(calstart.getTime());

            int[] shift1= new int[]{1,32};
            int[] shift2= new int[]{33,64};
            int[] shift3= new int[]{65,96};

            String shiftName = "";
            for(int j= 0; j<3;j++){
                int[] record= null;
                if(j==0){
                    record=shift1;
                    shiftName = "SHIFT1";
                }
                if(j==1){
                    record=shift2;
                    shiftName = "SHIFT2";
                }
                if (j==2){
                    record=shift3;
                    shiftName = "SHIFT3";
                }


                PageData pageData4line = new PageData();
                pageData4line.put("lineName",line);
                List<LineDeviceOutput> lineDevices = lineDeviceService.list(false,pageData4line);



                Map<String,Integer> quantityMap = new HashMap<String,Integer>();
                Map<String,Integer> runningMap = new HashMap<String,Integer>();
                Map<String,Double> runningDoubleMap = new HashMap<String,Double>();

                for(LineDevice ld : lineDevices){
                  Integer  quantitysum = 0;
                Integer    runningsum = 0;
                Double   runningSumDouble =0.0;

                    if(ld.getName().contains("ASSY")){
                         quantitysum =   generalTraceabilityDataService.getQuantitySum(dateStringAdd,record[0],record[1],line,ld.getName());

                    }else {
                         quantitysum =   generalOEEDataService.getQuantitySum(dateStringAdd,record[0],record[1],line,ld.getName());
                    }

                    runningsum =    generalOEEDataService.getPlannedRunningTimeSum(dateStringAdd,record[0],record[1],line,ld.getName());

                    runningSumDouble = new BigDecimal((float) runningsum/3600 ).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();


                    Boolean flag =   generalProductionTemporaryService.ifShiftInProduction(line,ld.getName(),dateStringAdd,shiftName);

                if(flag== false){
                    quantitysum = 0;
                    runningsum = 0;
                    runningSumDouble =0.0;
                }
                    quantityMap.put(ld.getName()+dateStringAdd+j,quantitysum);
                    runningMap.put(ld.getName()+dateStringAdd+j,runningsum);
                    runningDoubleMap.put(ld.getName()+datestring,runningSumDouble);

                }


                Integer Numerator = 0;
                Integer Denominator = 0;
                Double NumeratorDouble = 0.0;
                Double DenominatorDouble = 0.0;

                Integer[] Budget ={25,57};  // cnc assy default value of their cycle time

                Iterator<Map.Entry<String, Double>> runningEntries = runningDoubleMap.entrySet().iterator();
                while (runningEntries.hasNext()) {
                    Map.Entry<String, Double> runningEntry = runningEntries.next();

                    if(runningEntry.getKey().contains("ASSY")){

                        DenominatorDouble += runningEntry.getValue()*Budget[1];
                    }else {
                        DenominatorDouble += runningEntry.getValue()*Budget[0];
                    }

                }

                Iterator<Map.Entry<String, Integer>> quantityEntries = quantityMap.entrySet().iterator();
                while (quantityEntries.hasNext()) {
                    Map.Entry<String, Integer> quantityEntry = quantityEntries.next();
                    Numerator+=quantityEntry.getValue();
                }

                Double lineResult =0.00;
                if(DenominatorDouble!=0.00){
                    lineResult =new BigDecimal((float)  Numerator/DenominatorDouble).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                }

                if (lineResult>=1.00){
                    lineResult=1.00;
                }
                GeneralValue value = new GeneralValue();
                value.setName("line");
                value.setValue(lineResult.toString());
                outList.add(value);

            }

        }

        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("[(Mon-Sun)LineOee:{shift1,shift2,shift3}]");

        return result;



    }






    /**
     * line oee by shift
     * for  real time page
     * return 1 object
     * @param
     * @param shift
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "lineOeeByShift",method = RequestMethod.GET)

    public ResponseResult getLineOee4shift(Integer shift,String line) throws Exception{

        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        String shiftName = "";
        int[] record= null;

        int[] shift1= new int[]{1,32};
        int[] shift2= new int[]{33,64};
        int[] shift3= new int[]{65,96};

        if(shift==1){

            shiftName = "SHIFT1";
            record=shift1;
        }
        if(shift==2){

            shiftName = "SHIFT2";
            record=shift2;
        }
        if(shift==3){
            record=shift3;
            shiftName = "SHIFT3";
        }


        PageData pageData4line = new PageData();
        pageData4line.put("lineName",line);
        List<LineDeviceOutput> lineDevices = lineDeviceService.list(false,pageData4line);

        Map<String,Integer> quantityMap = new HashMap<String,Integer>();
        Map<String,Integer> runningMap = new HashMap<String,Integer>();
        Map<String,Double> runningDoubleMap = new HashMap<String,Double>();


        MachQT assyTargetQuantity = new MachQT();
        Integer runningDevices = 0;   //setup target according to quantity of cnc machines;

        for(LineDevice ld : lineDevices){

          Integer  quantitysum = 0;
          Integer  runningsum = 0;
          Double   runningSumDouble =0.0;
            if(ld.getName().contains("ASSY")){
                 quantitysum =   generalTraceabilityDataService.getQuantitySum(datestring,record[0],record[1],line,ld.getName());
                assyTargetQuantity = generalOEEDataService.getTargetQuantityAssy(datestring,record[0],record[1],line,ld.getName());

            }else {
                 quantitysum =   generalOEEDataService.getQuantitySum(datestring,record[0],record[1],line,ld.getName());
            }
            // planned running time sum
             runningsum =    generalOEEDataService.getPlannedRunningTimeSum(datestring,record[0],record[1],line,ld.getName());

            runningSumDouble = new BigDecimal((float) runningsum/3600 ).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            Boolean flag =   generalProductionTemporaryService.ifShiftInProduction(line,ld.getName(),datestring,shiftName);

            if(flag==false){
                quantitysum = 0;
                runningsum =0;
                runningSumDouble = 0.0;
            }else {
                //ALL PLANNED RUNNING MACHINES
                runningDevices++;
            }

            quantityMap.put(ld.getName()+datestring,quantitysum);
            runningMap.put(ld.getName()+datestring,runningsum);
            runningDoubleMap.put(ld.getName()+datestring,runningSumDouble);

        }


        Integer Numerator = 0;
        Integer Denominator = 0;
        Double NumeratorDouble = 0.0;
        Double DenominatorDouble = 0.0;

        Integer[] Budget ={25,57};  // cnc assy

        Iterator<Map.Entry<String, Double>> runningEntries = runningDoubleMap.entrySet().iterator();
        while (runningEntries.hasNext()) {
            Map.Entry<String, Double> runningEntry = runningEntries.next();

            if(runningEntry.getKey().contains("ASSY")){

                DenominatorDouble += runningEntry.getValue()*Budget[1];
            }else {
                DenominatorDouble += runningEntry.getValue()*Budget[0];
            }

        }

        Iterator<Map.Entry<String, Integer>> quantityEntries = quantityMap.entrySet().iterator();
        while (quantityEntries.hasNext()) {
            Map.Entry<String, Integer> quantityEntry = quantityEntries.next();
            Numerator+=quantityEntry.getValue();
        }


        Double lineResult =0.00;
        if(DenominatorDouble!=0.00){
            lineResult =new BigDecimal((float)  Numerator/DenominatorDouble).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        if (lineResult>=1.00){
            lineResult=1.00;
        }
        GeneralValue value = new GeneralValue();
        GeneralValue assyQuantity = new GeneralValue();
        GeneralValue target = new GeneralValue();


        value.setName("LineOEE");
        value.setValue(lineResult.toString());


     Integer assyqt =   assyTargetQuantity.getLh()+assyTargetQuantity.getRh();
     Integer assytarget = (assyTargetQuantity.getTarget().intValue());


        assyQuantity.setName("Quantity");
        assyQuantity.setValue(assyqt.toString());

        target.setName("Target");
        target.setValue(assytarget.toString());


        outList.add(assyQuantity);
        outList.add(target);
        outList.add(value);


        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("LineOee4shift");

        return result;


    }







}
