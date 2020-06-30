package com.project.controller.Monitoring;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.project.domain.entity.MachQT;
import com.project.domain.entity.StockAndWIP;
import com.project.domain.model.input.RawMaterialMonitoringInput;
import com.project.domain.model.output.RawMaterialMonitoringOutput;
import com.project.service.RawMaterialMonitoringService;
import com.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Monitor")
public class RawMaterialMonitoringController extends GenericController<RawMaterialMonitoringInput, RawMaterialMonitoringOutput> {

    private final Logger logger = LoggerFactory.getLogger(RawMaterialMonitoringController.class);

    @Autowired
    private RawMaterialMonitoringService rawMaterialMonitoringService;

    @Override
    protected void OnActionExecuting() {
        rawMaterialMonitoringService.SetWorkContext(this.WorkContext);
    }

    @Override
    protected AbstractService<RawMaterialMonitoringInput, RawMaterialMonitoringOutput> getService() {
        return rawMaterialMonitoringService;
    }

    @RequestMapping(value = "getQuantity",method = RequestMethod.GET)
    public ResponseResult getQuantity(Integer year, Integer weekNo) throws Exception {

        ResponseResult result = new ResponseResult();            //weekno , year get monday date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datestring = sdf.format(date);

        List<StockAndWIP> stockAndWIP = new ArrayList<>();
        stockAndWIP = rawMaterialMonitoringService.getQuantity(datestring);



        result.setData(stockAndWIP);
        result.setCode(200);
        result.setSuccess(true);
        return result;
    }
}
