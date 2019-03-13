package com.project.controller;

import com.core.controller.GenericController;
import com.core.service.AbstractService;
import com.domain.model.PageData;
import com.project.domain.entity.Shipment;
import com.project.domain.entity.ShipmentItem;
import com.project.service.ShipmentItemService;
import com.project.service.ShipmentService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Shipment")
public class ShipmentController extends GenericController <Shipment,Shipment> {


    private final Logger logger = LoggerFactory.getLogger(ShipmentController.class);



    @Autowired
    private ShipmentService shipmentService;

    @Override
    protected void OnActionExecuting() {
        shipmentService.SetWorkContext(this.WorkContext);
    }

    protected AbstractService<Shipment,Shipment> getService() {
        return shipmentService;
    }


    /**
     * get shipment after today
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getShipment",method = RequestMethod.GET)
    public ResponseResult getShipment(String partName) throws Exception{

        try{

            return ResponseResult.success(shipmentService.getAllShipment(partName));

        }catch (Exception e){
            logger.error("-----------------------pagelist异常------"+e);
        }
        return ResponseResult.error(CommonConstants.EX.EXCEPTION);


    }


}
