package com.board.controller;

import com.board.model.MachiningTable;
import com.board.model.TableDTO;
import com.board.service.BoardService;
import com.project.domain.entity.GeneralValue;
import com.project.service.GeneralOEEDataService;
import com.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private GeneralOEEDataService generalOEEDataService;


    @RequestMapping(value = "report", method = RequestMethod.GET)
    public ResponseResult getTable(Integer shift, String equipment) throws Exception {
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String datestring = sdf.format(date);

        String shiftName = "";
        int[] record = null;
        int[] shift1 = new int[]{1, 32};
        int[] shift2 = new int[]{33, 64};
        int[] shift3 = new int[]{65, 96};
        if (shift == 1) {
            shiftName = "SHIFT1";
            record = shift1;
        }
        if (shift == 2) {
            shiftName = "SHIFT2";
            record = shift2;
        }
        if (shift == 3) {
            shiftName = "SHIFT3";
            record = shift3;
        }


        Integer realProduct = generalOEEDataService.getQuantitySum(datestring, record[0], record[1], "", equipment);

        MachiningTable machiningTables = boardService.findByEquipment(equipment);

        Integer badProduct = machiningTables.getBadProduct();

        Integer planProduct = machiningTables.getPlanProduct();

        Double failureRate = new BigDecimal((float)badProduct/realProduct).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() ;

        Double finishRate = new BigDecimal((float)realProduct/planProduct).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        GeneralValue realProductValue = new GeneralValue();
        GeneralValue planProductValue = new GeneralValue();
        GeneralValue badProductValue = new GeneralValue();
        GeneralValue failureRateValue = new GeneralValue();
        GeneralValue finishRateValue = new GeneralValue();

        realProductValue.setName("realProduct");
        realProductValue.setValue(realProduct.toString());
        planProductValue.setName("planProduct");
        planProductValue.setValue(planProduct.toString());
        badProductValue.setName("badProduct");
        badProductValue.setValue(badProduct.toString());
        failureRateValue.setName("failureRate");
        failureRateValue.setValue(failureRate.toString());
        finishRateValue.setName("finishRate");
        finishRateValue.setValue(finishRate.toString());
        outList.add(realProductValue);
        outList.add(planProductValue);
        outList.add(badProductValue);
        outList.add(failureRateValue);
        outList.add(finishRateValue);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("报表数据");
        return result;

    }
}
