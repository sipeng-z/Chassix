package com.quality.service;

import com.quality.mapper.*;
import com.quality.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualityService {


    @Autowired
    private LaserMarkerPrintedPNMapper laserMarkerPrintedPNMapper;

    @Autowired
    private XRayInspectionResultMapper xRayInspectionResultMapper;

    @Autowired
    private XRayBatchNOMapper xRayBatchNOMapper;

    @Autowired
    private PackingStationAndCLPIMapper packingStationAndCLPIMapper;

    @Autowired
    private A10A2ASSYTraceabilityDataMapper a10A2ASSYTraceabilityDataMapper;

    @Autowired
    private EMP2ASSYTraceabilityDataMapper emp2ASSYTraceabilityDataMapper;

    @Autowired
    private StandardASSY1TraceabilityDataMapper standardASSY1TraceabilityDataMapper;

    @Autowired
    private StandardASSY2TraceabilityDataMapper standardASSY2TraceabilityDataMapper;

    public LaserMarkerPrintedPN getStep(String searchBar) {
        LaserMarkerPrintedPN laserMarkerPrintedPN = new LaserMarkerPrintedPN();
        laserMarkerPrintedPN.setDmContent(searchBar);
        LaserMarkerPrintedPN outList = laserMarkerPrintedPNMapper.selectBySearch(laserMarkerPrintedPN);
        if (outList == null){
            outList.setMachineNo("-");
            outList.setPartType("-");
            outList.setHandSign("-");
        }
        return outList;
    }

    public Integer getStatus(String searchBar) {
        Integer status = laserMarkerPrintedPNMapper.countBySearch(searchBar);
        return status;
    }

    public XRayInspectionResult getXRay(String searchBar) {
        XRayInspectionResult xRayInspectionResult = new XRayInspectionResult();
        xRayInspectionResult.setDmContent(searchBar);
        XRayInspectionResult outList = xRayInspectionResultMapper.selectBySearch(xRayInspectionResult);
        return outList;
    }

    public Integer getXRayStatus(String searchBar) {
        Integer status = xRayInspectionResultMapper.countBySearch(searchBar);
        return status;
    }

    public XRayBatchNO getHeatTreat(String searchBar) {
        XRayBatchNO xRayBatchNO = new XRayBatchNO();
        xRayBatchNO.setDmContent(searchBar);
        XRayBatchNO outlist = xRayBatchNOMapper.selectBySearch(xRayBatchNO);
        return outlist;
    }

    public Integer getHeatTreatStatus(String searchBar) {
        Integer status = xRayBatchNOMapper.countBySearch(searchBar);
        return status;
    }

    public PackingStationAndCLPI getLPI(String searchBar) {
        PackingStationAndCLPI packingStationAndCLPI = new PackingStationAndCLPI();
        packingStationAndCLPI.setDmContent(searchBar);
        PackingStationAndCLPI outlist = packingStationAndCLPIMapper.selectBySearch(packingStationAndCLPI);
        return outlist;
    }
    public Integer getLPIStatus(String searchBar) {
        Integer status = packingStationAndCLPIMapper.countBySearch(searchBar);
        return status;
    }

    public A10A2ASSYTraceabilityData getA2xxAssy (String searchBar) {
        A10A2ASSYTraceabilityData a10A2ASSYTraceabilityData = new A10A2ASSYTraceabilityData();
        a10A2ASSYTraceabilityData.setPartno(searchBar);
        A10A2ASSYTraceabilityData outlist = a10A2ASSYTraceabilityDataMapper.selectBySearch(a10A2ASSYTraceabilityData);
        return outlist;
    }
    public Integer getA2xxAssyStatus(String searchBar) {
        Integer status = a10A2ASSYTraceabilityDataMapper.countBySearch(searchBar);
        return status;
    }

    public EMP2ASSYTraceabilityData getEMP2Assy (String searchBar){
        EMP2ASSYTraceabilityData emp2ASSYTraceabilityData = new EMP2ASSYTraceabilityData();
        emp2ASSYTraceabilityData.setPartno(searchBar);
        EMP2ASSYTraceabilityData outList = emp2ASSYTraceabilityDataMapper.selectBySearch(emp2ASSYTraceabilityData);
        return outList;
    }

    public Integer getEMP2AssyStatus (String searchBar){
        Integer status = emp2ASSYTraceabilityDataMapper.countBySearch(searchBar);
        return status;
    }

    public StandardASSY1TraceabilityData getBAICAssy (String searchBar){
        StandardASSY1TraceabilityData standardASSY1TraceabilityData = new StandardASSY1TraceabilityData();
        standardASSY1TraceabilityData.setPartNo(searchBar);
        StandardASSY1TraceabilityData outList = standardASSY1TraceabilityDataMapper.selectBySearch(standardASSY1TraceabilityData);
        return outList;
    }

    public Integer getBAICAssyStatus(String searchBar){
        Integer status = standardASSY1TraceabilityDataMapper.countBySearch(searchBar);
        return status;
    }

    public StandardASSY2TraceabilityData getE2xxAssy (String searchBar){
        StandardASSY2TraceabilityData standardASSY2TraceabilityData = new StandardASSY2TraceabilityData();
        standardASSY2TraceabilityData.setPartNo(searchBar);
        StandardASSY2TraceabilityData outList = standardASSY2TraceabilityDataMapper.selectBySearch(standardASSY2TraceabilityData);
        return outList;
    }

    public Integer getE2xxAssyStatus(String searchBar){
        Integer status = standardASSY2TraceabilityDataMapper.countBySearch(searchBar);
        return status;
    }

//    public List<LaserMarkerPrintedPN> getLazerMarkerAll() {
//
//        List<LaserMarkerPrintedPN> laserMarkerPrintedList = laserMarkerPrintedPNMapper.getAll();
//        return laserMarkerPrintedList;
//    }
}
