package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.entity.MachStock;
import com.project.service.StockService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping(value = "Stock")
public class StockController extends GenericController<MachStock,MachStock> {

    private final Logger logger = LoggerFactory.getLogger(StockController.class);



    @Autowired
    private StockService stockService;



    @Override
    protected void OnActionExecuting() {
        stockService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<MachStock,MachStock> getService() {
        return stockService;
    }

    @RequestMapping(value = "getStock",method = RequestMethod.GET)
    public ResponseResult getStock(String partName){


        try{
            MachStock machStock = new MachStock();
            PageData pageData = new PageData();
            machStock = stockService.getStockG38();

            return ResponseResult.success(machStock);

        }catch (Exception e){
            logger.error("-------------get Stock Error--------"+e);
        }


        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
    }









}
