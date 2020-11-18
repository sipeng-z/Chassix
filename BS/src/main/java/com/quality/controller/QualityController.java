package com.quality.controller;

import com.domain.model.PageData;
import com.github.pagehelper.PageInfo;
import com.project.domain.entity.GeneralValue;
import com.quality.dto.QualityDTO;
import com.quality.dto.StatusDTO;
import com.quality.dto.TimeAndKeyDTO;
import com.quality.model.*;
import com.quality.service.QualityService;
import com.response.ResponseResult;
import com.utils.CommonConstants;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "Quality")
public class QualityController {

    @Autowired
    private QualityService qualityService;

    private final Logger logger = LoggerFactory.getLogger(QualityController.class);


    @RequestMapping(value = "getStep",method = RequestMethod.GET)
    public ResponseResult getStep(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        LaserMarkerPrintedPN timeAndKeyDTO = qualityService.getStep(searchBar);
        Integer statusDTO =qualityService.getStatus(searchBar);
        String key = timeAndKeyDTO.getMachineNo();
        String partType = timeAndKeyDTO.getPartType();
        String handSign = timeAndKeyDTO.getHandSign();
        GeneralValue laserTime = new GeneralValue();
        GeneralValue laserKey = new GeneralValue();
        GeneralValue laserStatus = new GeneralValue();
        GeneralValue productPartType = new GeneralValue();
        GeneralValue productHandSign = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKeyDTO.getInsertTime());
        String status = statusDTO.toString();
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        laserTime.setName("laserTime");
        laserTime.setValue(time);
        laserKey.setName("laserKey");
        laserKey.setValue(key);
        laserStatus.setName("laserStatus");
        laserStatus.setValue(status);
        productPartType.setName("partType");
        productPartType.setValue(partType);
        productHandSign.setName("handSign");
        productHandSign.setValue(handSign);
        outList.add(laserTime);
        outList.add(laserKey);
        outList.add(laserStatus);
        outList.add(productPartType);
        outList.add(productHandSign);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetStatus");
        return result;
    }

    @RequestMapping(value = "getXRay",method = RequestMethod.GET)
    public ResponseResult getXRay(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        XRayInspectionResult timeAndKey = qualityService.getXRay(searchBar);
        Integer statusDTO =qualityService.getXRayStatus(searchBar);
        String key = timeAndKey.getMachineNo().toString();
        GeneralValue XRayTime = new GeneralValue();
        GeneralValue XRayKey = new GeneralValue();
        GeneralValue XRayStatus = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKey.getInsertTime());
        String status = statusDTO.toString();
        if (key == null){
            key = "-";
        }
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        XRayTime.setName("XRayTime");
        XRayTime.setValue(time);
        XRayKey.setName("XRayKey");
        XRayKey.setValue(key);
        XRayStatus.setName("XRayStatus");
        XRayStatus.setValue(status);
        outList.add(XRayTime);
        outList.add(XRayKey);
        outList.add(XRayStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetXRayStatus");
        return result;
    }

    @RequestMapping(value = "getHeatTreat",method = RequestMethod.GET)
    public ResponseResult getHeatTreat(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        XRayBatchNO timeAndKey = qualityService.getHeatTreat(searchBar);
        Integer statusDTO =qualityService.getHeatTreatStatus(searchBar);
        String key = timeAndKey.getBatchNo();
        GeneralValue heatTreatTime = new GeneralValue();
        GeneralValue heatTreatKey = new GeneralValue();
        GeneralValue heatTreatStatus = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKey.getInsertTime());
        String status = statusDTO.toString();
        if (key == null){
            key = "-";
        }
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        heatTreatTime.setName("heatTreatTime");
        heatTreatTime.setValue(time);
        heatTreatKey.setName("heatTreatKey");
        heatTreatKey.setValue(key);
        heatTreatStatus.setName("heatTreatStatus");
        heatTreatStatus.setValue(status);
        outList.add(heatTreatTime);
        outList.add(heatTreatKey);
        outList.add(heatTreatStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetHeatTreatStatus");
        return result;
    }

    @RequestMapping(value = "getLPI",method = RequestMethod.GET)
    public ResponseResult getLPI(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        PackingStationAndCLPI timeAndKey = qualityService.getLPI(searchBar);
        Integer statusDTO =qualityService.getLPIStatus(searchBar);
        String key = timeAndKey.getLotNo();
        GeneralValue LPITime = new GeneralValue();
        GeneralValue LPIKey = new GeneralValue();
        GeneralValue LPIStatus = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKey.getInsertTime());
        String status = statusDTO.toString();
        if (key == null){
            key = "-";
        }
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        LPITime.setName("LPITime");
        LPITime.setValue(time);
        LPIKey.setName("LPIKey");
        LPIKey.setValue(key);
        LPIStatus.setName("LPIStatus");
        LPIStatus.setValue(status);
        outList.add(LPITime);
        outList.add(LPIKey);
        outList.add(LPIStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetLPIStatus");
        return result;
    }

    @RequestMapping(value = "getCastingPacking",method = RequestMethod.GET)
    public ResponseResult getCastingPacking(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        PackingStationAndCLPI timeAndKey = qualityService.getLPI(searchBar);
        String dataSource = timeAndKey.getDataSource();
        Integer statusDTO =qualityService.getLPIStatus(searchBar);
        String key = timeAndKey.getLotNo();
        GeneralValue LPITime = new GeneralValue();
        GeneralValue LPIKey = new GeneralValue();
        GeneralValue LPIStatus = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKey.getInsertTime());
        String status = statusDTO.toString();
        if (key == null){
            key = "-";
        }
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        if (dataSource.equals("PS_GP12")){
            LPITime.setName("CastingPackingTime");
            LPITime.setValue("-");
            LPIKey.setName("CastingPackingKey");
            LPIKey.setValue("-");
            LPIStatus.setName("CastingPackingStatus");
            LPIStatus.setValue("-");
        }else {
            LPITime.setName("CastingPackingTime");
            LPITime.setValue(time);
            LPIKey.setName("CastingPackingKey");
            LPIKey.setValue(key);
            LPIStatus.setName("CastingPackingStatus");
            LPIStatus.setValue(status);
        }
        outList.add(LPITime);
        outList.add(LPIKey);
        outList.add(LPIStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetCastingPackingStatus");
        return result;
    }

    @RequestMapping(value = "getAssy",method = RequestMethod.GET)
    public ResponseResult getAssy(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        LaserMarkerPrintedPN timeAndKeyDTO = qualityService.getStep(searchBar);
        String partType = timeAndKeyDTO.getPartType();
        GeneralValue assyTime = new GeneralValue();
        GeneralValue assyKey = new GeneralValue();
        GeneralValue assyStatus = new GeneralValue();
        String status = null;
        String key = null;
        String time = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (partType.equals("E2XX RK")){
            StandardASSY2TraceabilityData e2xx = qualityService.getE2xxAssy(searchBar);
            status = qualityService.getE2xxAssyStatus(searchBar).toString();
            key= e2xx.getMachineNo();
            time = format.format(e2xx.getPartCompletedTime());
        }else if (partType.equals("BAIC RLCA")){
            StandardASSY1TraceabilityData baic = qualityService.getBAICAssy(searchBar);
            status = qualityService.getBAICAssyStatus(searchBar).toString();
            key= baic.getMachineNo();
            time = format.format(baic.getPartCompletedTime());
        }else if (partType.equals("A2LL RK")){
            A10A2ASSYTraceabilityData A2LL = qualityService.getA2xxAssy(searchBar);
            status = qualityService.getA2xxAssyStatus(searchBar).toString();
            key= A2LL.getSoNumber();
            time = format.format(A2LL.getPartCompletedTime());
        }else if (partType.equals("EMP2 FLCA")){
            EMP2ASSYTraceabilityData EMP2 = qualityService.getEMP2Assy(searchBar);
            status = qualityService.getEMP2AssyStatus(searchBar).toString();
            key = EMP2.getMachineno();
            time = format.format(EMP2.getE1E2CompletedTime());
        }else{
            status = "-";
            key = "-";
            time = "-";
        }
        assyTime.setName("assyTime");
        assyTime.setValue(time);
        assyKey.setName("assyKey");
        assyKey.setValue(key);
        assyStatus.setName("assyStatus");
        assyStatus.setValue(status);
        outList.add(assyTime);
        outList.add(assyKey);
        outList.add(assyStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetStatus");
        return result;
    }

    @RequestMapping(value = "getFinalPacking",method = RequestMethod.GET)
    public ResponseResult getFinalPacking(HttpServletRequest request){
        String searchBar = request.getParameter("searchBar");
        ResponseResult result = new ResponseResult();
        List<GeneralValue> outList = new ArrayList<>();
        PackingStationAndCLPI timeAndKey = qualityService.getLPI(searchBar);
        String dataSource = timeAndKey.getDataSource();
        Integer statusDTO =qualityService.getLPIStatus(searchBar);
        String key = timeAndKey.getLotNo();
        GeneralValue FinalPackingTime = new GeneralValue();
        GeneralValue FinalPackingKey = new GeneralValue();
        GeneralValue FinalPackingStatus = new GeneralValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(timeAndKey.getInsertTime());
        String status = statusDTO.toString();
        if (key == null){
            key = "-";
        }
        if (status == null){
            status = "-";
        }
        if (time == null){
            time = "-";
        }
        if (dataSource.equals("PS_GP12")){
            FinalPackingTime.setName("CastingPackingTime");
            FinalPackingTime.setValue(time);
            FinalPackingKey.setName("CastingPackingKey");
            FinalPackingKey.setValue(key);
            FinalPackingStatus.setName("CastingPackingStatus");
            FinalPackingStatus.setValue(status);
        }else {
            FinalPackingTime.setName("CastingPackingTime");
            FinalPackingTime.setValue("-");
            FinalPackingKey.setName("CastingPackingKey");
            FinalPackingKey.setValue("-");
            FinalPackingStatus.setName("CastingPackingStatus");
            FinalPackingStatus.setValue("-");
        }
        outList.add(FinalPackingTime);
        outList.add(FinalPackingKey);
        outList.add(FinalPackingStatus);
        result.setData(outList);
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("GetFinalPackingStatus");
        return result;
    }

//    @RequestMapping(value = "pagerlist",method = RequestMethod.GET)
//    public ResponseResult pagerList(HttpServletRequest request) {
//        try{
//            return ResponseResult.success(new PageInfo<>(qualityService.getLazerMarkerAll()));
//        }catch (Exception e){
//            logger.error("-----------------------pagelist异常------"+e);
//        }
//        return ResponseResult.error(CommonConstants.EX.EXCEPTION);
//    }
}
