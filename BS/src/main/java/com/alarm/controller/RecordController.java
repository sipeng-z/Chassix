package com.alarm.controller;

import com.alarm.domain.Record;
import com.alarm.domain.entity.CastingChemistryUse;
import com.alarm.domain.entity.ChemistryOperators;
import com.alarm.service.RecordService;
import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//2.57 2.7 density

@RestController
@RequestMapping("Record")
public class RecordController {

        @Autowired
        private RecordService recordService;

        // add record
        @RequestMapping(value = "addRecord",method = RequestMethod.POST)
        public ResponseResult addRecord(@RequestBody(required = false) Record record){

            ResponseResult result = new ResponseResult();

            int rows = recordService.saveRecord(record);

            result.setData(rows);
            result.setCode(200);
            result.setSuccess(true);
            result.setMessage("addRecord");
            return result;

        }


    @RequestMapping(value = "getInspector",method = RequestMethod.GET)
    public ResponseResult getInspector() {
        ResponseResult result = new ResponseResult();
        List<ChemistryOperators> responses = recordService.findAllInspector();
        result.setData(responses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("Get Inspector name");
        return result;
    }

    // get operator id
    @RequestMapping(value = "getOperator",method = RequestMethod.GET)
    public ResponseResult getOperator() {
        ResponseResult result = new ResponseResult();
        List<ChemistryOperators> responses = recordService.findAllOperator();
        result.setData(responses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("Get Operator name");
        return result;
    }

    // get daily count immediately
    @RequestMapping(value = "getDailyCount",method = RequestMethod.GET)
    public ResponseResult getDailyCount(@RequestParam(value = "crucible",required = false) Integer crucible){

        ResponseResult result = new ResponseResult();
        System.out.println(crucible);

        int count = recordService.getDailyCount(crucible);

        result.setData(count);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("getDailyCount");
        return result;

    }
    // get batch id immediately
    @RequestMapping(value = "getBatchId",method = RequestMethod.POST)
    public ResponseResult getBatchId(@RequestBody(required = false) Record record){

        ResponseResult result = new ResponseResult();
        System.out.println(record);

        String batchId = recordService.getBatchId(record);

        result.setData(batchId);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("getBatchId");
        return result;

    }

    // verify batchId
    @GetMapping("verifyBatchId")
    public ResponseResult verifyBatchId(@RequestParam(value = "batchId",required = false) String batchId){
        ResponseResult result = new ResponseResult();
        int rows = recordService.countByBatchId(batchId);
        result.setData(rows);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("getBatchId");
        return result;
    }


    // find data by  batchId
    @GetMapping("findDataByBatchId")
    public ResponseResult findDataByBatchId(){
        ResponseResult result = new ResponseResult();
        List<CastingChemistryUse> responses = recordService.findByBatchId();
        result.setData(responses);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("Get BatchId Data");
        return result;
    }

    // update state by batchId
    @GetMapping("updateState")
    public ResponseResult updateState(@RequestParam(value = "updateState",required = false) String updateState){
        ResponseResult result = new ResponseResult();
        int rows = recordService.updateState(updateState);
        result.setData(rows);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("update state by batchId");
        return result;
    }


}
