package com.casting.controller;


import com.casting.domain.entity.CPCValue;
import com.casting.service.CreateTableService;
import com.project.domain.workbench.auth;
import com.project.domain.workbench.forapi;
import com.project.domain.workbench.params;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "castingCreateTable")
public class CreateTableController {

    @Autowired
    private CreateTableService createTableService;

    private final Logger logger = LoggerFactory.getLogger(CreateTableController.class);


    /**
     * for  more series CPC
     * @param deviceName
     * @return
     */
    @RequestMapping(value = "byName",method = RequestMethod.GET)
    public ResponseResult getCPCDeviceDataWithCycle(String deviceName) {


        //for creating tables
        ResponseResult result = new ResponseResult();
        try {

            Boolean flag = createTableService.createTables(deviceName);


            if (flag == true) {
                result.setSuccess(true);
                result.setMessage("Create tables Success!");
                return result;
            }else {

                result.setSuccess(false);
                result.setMessage("Create tables Failure!");
                return result;
            }

        } catch (Exception e) {
            logger.error("Exception___" + e);
            result.setMessage("error");
            result.setSuccess(false);
            return result;
        }

    }








}
