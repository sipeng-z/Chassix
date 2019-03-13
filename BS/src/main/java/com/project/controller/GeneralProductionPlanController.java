package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.entity.*;
import com.project.domain.model.input.GeneralProductionTemporaryInput;
import com.project.domain.model.output.GeneralProductionTemporaryOutput;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.GeneralProductionTemporaryService;
import com.project.service.LineDeviceService;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "GeneralProduction")
public class GeneralProductionPlanController extends GenericController<GeneralProductionTemporaryInput,GeneralProductionTemporaryOutput> {


    private final Logger logger = LoggerFactory.getLogger(GeneralProductionPlanController.class);


    @Autowired
    private GeneralProductionTemporaryService generalProductionTemporaryService;

    @Autowired
    private LineDeviceService lineDeviceService;

    @Override
    protected void OnActionExecuting() {
        generalProductionTemporaryService.SetWorkContext(this.WorkContext);
    }


    protected AbstractService<GeneralProductionTemporaryInput, GeneralProductionTemporaryOutput> getService() {
        return generalProductionTemporaryService;
    }


    /**
     * Add production
     *
     * @param
     * @param input
     * @return
     */
    @RequestMapping(value = "generalformpost", method = RequestMethod.POST)
    public ResponseResult generalFormPost(@RequestBody GeneralProductionTemporaryInput input, String line) {
        ResponseResult result = new ResponseResult();
        try {
            if (input == null) {
                result.setSuccess(false);
                result.setMessage("@RequestBody M");
                return result;
            }
            if (input.getTemporaryId() == null || input.getTemporaryId().equals("")) {

                // fill production logic

                PageData pageData = new PageData();
                pageData.put("parentId", input.getLineId());

                //get device quantity
                List<LineDeviceOutput> LineDeviceList = lineDeviceService.list(false, pageData);
                Integer deviceQuantity = LineDeviceList.size();


                String lineName = input.getLineName();
                String lineId = input.getLineId();
                Date inputDate = new Date();

                List<String> devicesAll = new ArrayList<>();
                List<String> devices = new ArrayList<>();

                List<Integer> durations = new ArrayList<>();
                List<Integer> startRecords = new ArrayList<>();
                List<Integer> endRecords = new ArrayList<>();
                List<Date> startDates = new ArrayList<>();
                List<Date> endDates = new ArrayList<>();
                List<GeneralProductionTemporaryInput> inputs = new ArrayList<>();

                //get  devices name for query
                for (LineDevice l : LineDeviceList) {
                    devicesAll.add(l.getName());
                }
                //get durations in order
                if (input.getDuration1() != null) {
                    durations.add(input.getDuration1());
                }
                if (input.getDuration2() != null) {
                    durations.add(input.getDuration2());
                }
                if (input.getDuration3() != null) {
                    durations.add(input.getDuration3());
                }
                if (input.getDuration4() != null) {
                    durations.add(input.getDuration4());
                }

                //parse Start End Op to Date and Record
                if (input.getStart1() != null && input.getEnd1() != null
                        && !input.getStart1().equals("") && !input.getEnd1().equals("")) {
                    List<Integer> Records = parseString(input.getStart1(), input.getEnd1());
                    startRecords.add(Records.get(0));
                    endRecords.add(Records.get(1));
                    devices.add(devicesAll.get(0));


                }

                if (input.getStart2() != null && input.getEnd2() != null
                        && !input.getStart2().equals("") && !input.getEnd2().equals("")) {
                    List<Integer> Records = parseString(input.getStart2(), input.getEnd2());
                    startRecords.add(Records.get(0));
                    endRecords.add(Records.get(1));
                    devices.add(devicesAll.get(1));
                }

                if (input.getStart3() != null && input.getEnd3() != null
                        && !input.getStart3().equals("") && !input.getEnd3().equals("")) {
                    List<Integer> Records = parseString(input.getStart3(), input.getEnd3());
                    startRecords.add(Records.get(0));
                    endRecords.add(Records.get(1));
                    devices.add(devicesAll.get(2));
                }

                if (input.getStart4() != null && input.getEnd4() != null
                        && !input.getStart4().equals("") && !input.getEnd4().equals("")) {
                    List<Integer> Records = parseString(input.getStart4(), input.getEnd4());
                    startRecords.add(Records.get(0));
                    endRecords.add(Records.get(1));
                    devices.add(devicesAll.get(3));
                }

                // get duration of adds and make Date list
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                for (int i = 0; i < startRecords.size(); i++) {
                    startDates.add(inputDate);
                    endDates.add(inputDate);
                }
                for (int i = 0; i < startRecords.size(); i++) {

                    if (durations.get(i) >= 1) {
                        Calendar calstart = Calendar.getInstance();
                        calstart.setTime(startDates.get(i));
                        calstart.add(Calendar.DATE, durations.get(i));
                        String dateStr = sdf.format(calstart.getTime());
                        Date StartDate = sdf.parse(dateStr);
                        endDates.set(i, StartDate);
                    }
                }


                //prepare inputs
                for (int i = 0; i < startRecords.size(); i++) {
                    GeneralProductionTemporaryInput generalProductionTemporaryInput = new GeneralProductionTemporaryInput();
                    generalProductionTemporaryInput.setStartDateTime(startDates.get(i));
                    generalProductionTemporaryInput.setEndDateTime(endDates.get(i));
                    generalProductionTemporaryInput.setStartRecord(startRecords.get(i));
                    generalProductionTemporaryInput.setEndRecord(endRecords.get(i));
                    inputs.add(generalProductionTemporaryInput);
                }


                //result inputs
                List<Boolean> flags = new ArrayList<>();
                for (int i = 0; i < inputs.size(); i++) {
                    Boolean flag = generalProductionTemporaryService.addnewhalt(inputs.get(i), line, devices.get(i));
                    flags.add(flag);
                }

                for (Boolean b : flags) {
                    if (b == false) {
                        result.setMessage("Input already!");
                        result.setSuccess(true);
                        return result;
                    }
                }
                result.setMessage("Success!");
                result.setSuccess(true);
                return result;
            } else {
                boolean flag = generalProductionTemporaryService.update(input);
                if (flag == true) {
                    result.setMessage("Update Success!");
                    result.setSuccess(true);
                    return result;
                }
            }
        } catch (Exception e) {
            logger.error("---------------------add异常-------" + e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }


    /**
     * parseStart1,End1 to Integer
     *
     * time to recordNO
     * exam,8:00-->33
     * @return
     */
    public List<Integer> parseString(String Start, String End) {

        List<Integer> list = new ArrayList<>();
        String[] startAfter = Start.split(":");
        String[] endAfter = End.split(":");


        Integer sRecordBase = (Integer.valueOf(startAfter[0]) * 4) + 1;
        Integer sRecordAdd = Integer.valueOf(startAfter[1]) / 15;
        Integer sRecordStart = sRecordBase + sRecordAdd;
        list.add(sRecordStart);


        Integer eRecordBase = (Integer.valueOf(endAfter[0]) * 4) + 1;
        Integer eRecordAdd = Integer.valueOf(endAfter[1]) / 15;
        Integer eRecordStart = eRecordBase + eRecordAdd;
        list.add(eRecordStart);

        return list;

    }

    /**
     *
     *parse Integer  to time
     *  recordNO to time
     * exam,33-->>08:00
     * @return
     */
    public List<String> parseRecord(Integer startRecord, Integer endRecord) {
        List<String> list = new ArrayList<>();
        String startTime = "";
        String endTime = "";

        String startBase = Integer.valueOf(startRecord/4).toString();           //hours start time
        String startAdd = String.valueOf(Integer.valueOf(startRecord%4)*15);  //minutes  start time

        String endBase = Integer.valueOf(endRecord/4).toString();            //hours end time
        String endAdd = String.valueOf(Integer.valueOf(endRecord%4)*15);    //minutes  end time



        if(startBase.length()<2){
            startBase= "0"+startBase;                                       // 8:00 ->> 08:00
        }
        if(endBase.length()<2){
            endBase= "0"+endBase;
        }

        if(startAdd.equals("0")){
            startAdd="00";                                                  //08:0->>08:00
        }
        if(endAdd.equals("0")){
            endAdd="00";
        }
        startTime+=startBase+":"+startAdd;
        endTime+=endBase+":"+endAdd;
        list.add(startTime);
        list.add(endTime);


        return list;
    }





    /**
     * PAGELIST
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "generalpagerlist", method = RequestMethod.GET)
    public ResponseResult generalpagerList(HttpServletRequest request, String line, String device) {
        try {
            return ResponseResult.success(new PageInfo<>(generalProductionTemporaryService.generallist(true, new PageData(request), line, device)));
        } catch (Exception e) {
            logger.error("-----------------------pagelist异常------" + e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }



    /**
     * stop production
     * @param
     * @param lineId
     * @param order
     * @return
     */

    @RequestMapping(value = "stopproduction", method = RequestMethod.GET)
    public ResponseResult stopProduction(String lineName, String lineId,Integer order) {

        ResponseResult result = new ResponseResult();
        try {

                // stop production logic
                PageData pageData = new PageData();
                pageData.put("parentId", lineId);
                //get device quantity
                List<LineDeviceOutput> LineDeviceList = lineDeviceService.list(false, pageData);


                List<String> devicesAll = new ArrayList<>();
                List<String> devices = new ArrayList<>();

                List<Integer> durations = new ArrayList<>();
                List<Date> startDates = new ArrayList<>();
                List<Date> endDates = new ArrayList<>();
                List<GeneralProductionTemporaryInput> inputs = new ArrayList<>();

                //get  devicesAll name for query
                for (LineDevice l : LineDeviceList) {
                    devicesAll.add(l.getName());
                }
                //parse Start End Op to Date and Record
                if (order!=null) {
                   //time to recordNO
                    devices.add(devicesAll.get(order));
                }

                Date inputDate = new Date();
                 Integer hour =  inputDate.getHours();
                Integer min =  inputDate.getMinutes();

            Integer base = hour*4 ;
            Integer minadd = (min/15);
            Integer record = base + minadd ;

                //result inputs
            // PARAM  : String line, String device, Date stopDate, Integer stopRecord

            Boolean flag = generalProductionTemporaryService.stopProduction(lineName, devices.get(0),inputDate,record);

                result.setMessage("Stop production success!");
                result.setSuccess(true);
                return result;

        } catch (Exception e) {
            logger.error("---------------------Stop production error-------" + e);
            result.setMessage("处理过程中发生异常");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);


    }




    /**
     * Add production
     *
     * @param
     * @param
     * @return
     */

    @RequestMapping(value = "generalimpressive", method = RequestMethod.GET)
    public ResponseResult generalimpressive(String lineName , String lineId) {
        ResponseResult result = new ResponseResult();
        try {

            PageData pageData = new PageData();
            pageData.put("parentId", lineId);

            //get device quantity
            List<LineDeviceOutput> LineDeviceList = lineDeviceService.list(false, pageData);
            List<String> devicesAll = new ArrayList<>();

            for(LineDevice ld : LineDeviceList){
                devicesAll.add(ld.getName());
            }

            List<ProductionFeedBack> productionFeedBacks = new ArrayList<>();
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String DateString = sdf.format(today);

            PageData pageData4query = new PageData();
            pageData4query.put("DateString",DateString);


            for(String deviceName : devicesAll){

         List<GeneralImpressive>  productionList =   generalProductionTemporaryService.impressiveList(false,pageData4query,lineName,deviceName);


                for(GeneralImpressive gl : productionList){

                    List<String> timeList = this.parseRecord(Integer.valueOf(gl.getMin()),Integer.valueOf(gl.getMax()));
                    ProductionFeedBack pfb = new ProductionFeedBack();
                    pfb.setLine(lineName);
                    pfb.setDevice(deviceName);
                    pfb.setStartTime(timeList.get(0));
                    pfb.setEndTime(timeList.get(1));
                    productionFeedBacks.add(pfb);
                }

            }

            result.setSuccess(true);
            result.setData(productionFeedBacks);
            result.setMessage("getimpressive success");
            result.setCode(200);
            return result;


        } catch (Exception e) {
            logger.error("get error" + e);
            result.setMessage("error in process");
            result.setMessage_detail(e.toString());
        }
        return result.error(CommonConstants.EX.EXCEPTION);
    }







}