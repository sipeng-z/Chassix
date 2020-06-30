package com.project.controller;


import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.model.AppConsts;
import com.project.domain.entity.GeneralOEEData;
import com.project.domain.entity.LineDevice;
import com.project.domain.model.output.GeneralOEEDataOutput;
import com.project.domain.model.output.LineDeviceOutput;
import com.project.service.ConversionToolService;
import com.project.service.GeneralOEEDataService;
import com.project.service.LineDeviceService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "GeneralOEEDataExplanation")
@RestController
public class GeneralOEEDataExplanationController {

    private final Logger logger = LoggerFactory.getLogger(GeneralOEEDataExplanationController.class);


    @Autowired
    private   GeneralOEEDataService generalOEEDataService;

    @Autowired
    private LineDeviceService lineDeviceService;

    @Autowired
    private ConversionToolService conversionToolService;



    /**
     * Line and device  OEE Data record
     * @param request
     * @param lineId
     * @param lineName
     * @return
     */

    @RequestMapping(value = "lineDeviceOeeList",method = RequestMethod.GET)
    public ResponseResult generalPageList(HttpServletRequest request, String lineId,String lineName) {

            ResponseResult result = new ResponseResult();
            List<GeneralOEEData> outList = new ArrayList<>();

        try{

            Date today = new Date();
            String todayString = conversionToolService.dateToString(today);

            PageData linePageData = new PageData();
            linePageData.put("parentId", lineId);
            //get device quantity
            List<LineDeviceOutput> LineDeviceList = lineDeviceService.list(false, linePageData);   //all devices in the line object
            List<String> devicesAll = new ArrayList<>();

            for (LineDevice l : LineDeviceList) {
                devicesAll.add(l.getName());                                //push name into the list for next step
            }


            for(String deviceName : devicesAll){

                PageData devicePageData = new PageData();
                Integer mark = AppConsts.afterDownTimeCalculation;
                devicePageData.put("mark",mark.toString());             // 0 or null default , 3 after unplanned downtime sync , 5 after explain
                devicePageData.put("DateString",todayString);            // downtime filter : today
                List<GeneralOEEDataOutput>  outputList = ( List<GeneralOEEDataOutput> ) generalOEEDataService.generalList(false,devicePageData,lineName,deviceName);

                //loop for push into outList , give  line and device information
                for(GeneralOEEData generalOEEData : outputList){
                    Integer recordNo = generalOEEData.getRecordno();
                    List<String> times = conversionToolService.parseRecord(recordNo-1,recordNo);
                    generalOEEData.setTime(times.get(0)+"--"+times.get(1));
                    generalOEEData.setUnplannedDowntimeMin(generalOEEData.getUnplannedDowntime()/60);   // downtime seconds to mins
                    generalOEEData.setLine(lineName);
                    generalOEEData.setDevice(deviceName);


                    outList.add(generalOEEData);
                }

            }

            result.setData(outList);
            result.setMessage("Success!");
            result.setSuccess(true);
            return result;

            }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }

    /**
     * get single row PkId
     */
    @RequestMapping(value = "updateExplanation",method = RequestMethod.GET)
    public ResponseResult updateExplanation(Integer ItemNo,String code,String line,String device) {
        try{

            return ResponseResult.success(generalOEEDataService.updateExplanationByItem(ItemNo,code,line,device));
        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }
}
