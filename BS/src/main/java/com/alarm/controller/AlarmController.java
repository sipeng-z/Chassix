package com.alarm.controller;

import com.alarm.domain.*;
import com.alarm.domain.entity.MaintenanceAlarms;
import com.alarm.service.AlarmService;
import com.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "getAlarm",method = RequestMethod.POST)
    public ResponseResult getAlarm(@RequestBody AlarmRequest alarmRequest){

        ResponseResult result = new ResponseResult();

        List<AlarmResponse> alarmResponses = alarmService.findByTypeAndDevice(alarmRequest.getType(),alarmRequest.getDevice(),alarmRequest.getEquipment());

        result.setData(alarmResponses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetAlarm");
        return result;

    }

    @RequestMapping(value = "getDeviceName",method = RequestMethod.GET)
    public ResponseResult findByParentId(@RequestParam(value = "parentId",required = true) Integer parentId) {
        ResponseResult result = new ResponseResult();

        List<AlarmUseName> alarmResponses = alarmService.findByParentId(parentId);

        result.setData(alarmResponses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetDeviceName");
        return result;
    }

    @RequestMapping(value = "getMTTR",method = RequestMethod.POST)
    public ResponseResult getMTTR(@RequestBody AlarmRequest alarmRequest){

        ResponseResult result = new ResponseResult();

        MTTRAndMTBF mttrAndMTBFS = alarmService.findMTTR(alarmRequest.getType(),alarmRequest.getDevice(),alarmRequest.getEquipment());

        result.setData(mttrAndMTBFS);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetAlarm");
        return result;

    }

    @RequestMapping(value = "getTop",method = RequestMethod.POST)
    public ResponseResult getTop(){

        ResponseResult result = new ResponseResult();

        List<MaintenanceAlarms> maintenanceAlarms = alarmService.findTop5();

        result.setData(maintenanceAlarms);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetAlarm");
        return result;

    }

    /**
     * category interface
     * @param alarmRequest
     * @return
     */
    @RequestMapping(value = "getCategory",method = RequestMethod.POST)
    public ResponseResult getCategory(@RequestBody AlarmRequest alarmRequest){

        ResponseResult result = new ResponseResult();

        List<CategoryResponse> responses = alarmService.findByCategory(alarmRequest.getType(),alarmRequest.getDevice(),alarmRequest.getEquipment());

        result.setData(responses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetCategory");
        return result;

    }
}
