package com.alarm.service;


import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.alarm.domain.Record;
import com.alarm.domain.entity.CastingChemistryUse;
import com.alarm.domain.entity.ChemistryOperators;
import com.alarm.mapper.ChemistryOperatorsMapper;
import com.alarm.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private ChemistryOperatorsMapper chemistryOperatorsMapper;

    /**
     * add data to object
     * @param record
     * @return
     */
//    public int saveRecord(Record record) {
//        CastingChemistryUse castingChemistryUse = new CastingChemistryUse();
//        castingChemistryUse.setInspector(record.getInspector());
//        castingChemistryUse.setOperator(record.getOperator());
//        String lineNumber = record.getLineRadio();
//        String line;
//        if (lineNumber.equals("1")){
//            line = "A";
//        }else if (lineNumber.equals("2")){
//            line = "B";
//        }else{
//            line = "C";
//        }
//        castingChemistryUse.setLine(line);
//        Integer station = record.getStationRadio();
//        castingChemistryUse.setStation(station);
//        Format f1 = new DecimalFormat("000");
//        String crucible = f1.format(record.getCrucible());
//        castingChemistryUse.setCrucibleId(crucible);
//        castingChemistryUse.setDensity(record.getDensity());
//        castingChemistryUse.setTemperature(record.getTemperature());
//        castingChemistryUse.setKmold(record.getMold());
//        castingChemistryUse.setSilicon(record.getSilicon());
//        castingChemistryUse.setTitanium(record.getTitanium());
//        castingChemistryUse.setCopper(record.getCopper());
//        castingChemistryUse.setIron(record.getIron());
//        castingChemistryUse.setStronium(record.getStronium());
//        castingChemistryUse.setManganese(record.getManganese());
//        castingChemistryUse.setMagnesium(record.getMagnesium());
//        castingChemistryUse.setZinc(record.getZinc());
//        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date=sDateFormat.format(new Date());
//        castingChemistryUse.setInsertTime(date);
//        SimpleDateFormat sDateFormat1=new SimpleDateFormat("yyyyMMdd");
//        String date1=sDateFormat1.format(new Date());
//        castingChemistryUse.setDateString(date1);
//        int dailyCount1 = recordMapper.getDailyCount(crucible,date1);
//        int dailyCount = dailyCount1+1;
//        Format f2 = new DecimalFormat("00");
//        String dailyCount2 = f2.format(dailyCount);
//        String batchId = date1 + line + station + crucible + dailyCount2;
//        castingChemistryUse.setBatchId(batchId);
//        castingChemistryUse.setUsed(0);
//        if (castingChemistryUse != null){
//            return recordMapper.save(castingChemistryUse);
//        }else {
//            return -1;
//        }
//    }

    public int saveRecord(Record record) {
        CastingChemistryUse castingChemistryUse = new CastingChemistryUse();
        castingChemistryUse.setInspector(record.getInspector());
        castingChemistryUse.setOperator(record.getOperator());
        String lineNumber = record.getLineRadio();
        String line;
        if (lineNumber.equals("1")){
            line = "A";
        }else if (lineNumber.equals("2")){
            line = "B";
        }else{
            line = "C";
        }
        castingChemistryUse.setLine(line);
        Integer station = record.getStationRadio();
        castingChemistryUse.setStation(station);
        Format f1 = new DecimalFormat("000");
        String crucible = f1.format(record.getCrucible());
        castingChemistryUse.setCrucibleId(crucible);
        castingChemistryUse.setDensity(record.getDensity());
        castingChemistryUse.setTemperature(record.getTemperature());
        castingChemistryUse.setKmold(record.getMold());
        castingChemistryUse.setSilicon(record.getSilicon());
        castingChemistryUse.setTitanium(record.getTitanium());
        castingChemistryUse.setCopper(record.getCopper());
        castingChemistryUse.setIron(record.getIron());
        castingChemistryUse.setStronium(record.getStronium());
        castingChemistryUse.setManganese(record.getManganese());
        castingChemistryUse.setMagnesium(record.getMagnesium());
        castingChemistryUse.setZinc(record.getZinc());
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sDateFormat.format(new Date());
        castingChemistryUse.setInsertTime(date);
        SimpleDateFormat sDateFormat1=new SimpleDateFormat("yyyyMMdd");
        String date1=sDateFormat1.format(new Date());
        castingChemistryUse.setDateString(date1);
        castingChemistryUse.setBatchId(record.getBatch());
        castingChemistryUse.setUsed(0);
        if (castingChemistryUse != null){
            return recordMapper.save(castingChemistryUse);
        }else {
            return -1;
        }
    }

    public List<ChemistryOperators> findAllInspector() {

        List<ChemistryOperators> operators = chemistryOperatorsMapper.findAllInspector();
        return operators;

    }

    public List<ChemistryOperators> findAllOperator() {
        List<ChemistryOperators> operators = chemistryOperatorsMapper.findAllOperator();
        return operators;
    }

    public int getDailyCount(Integer crucible) {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateString  = format.format(new Date());

        Format f1 = new DecimalFormat("000");
        String crucibleString = f1.format(crucible);

        int counts = recordMapper.getDailyCount(crucibleString,dateString);
        return counts;
    }

    public String getBatchId(Record record) {

        String lineNumber = record.getLineRadio();
        String line;
        if (lineNumber.equals("1")){
            line = "A";
        }else if (lineNumber.equals("2")){
            line = "B";
        }else{
            line = "C";
        }
        Integer station = record.getStationRadio();
        Format f1 = new DecimalFormat("000");
        String crucible = f1.format(record.getCrucible());
        SimpleDateFormat sDateFormat1=new SimpleDateFormat("yyyyMMdd");
        String date1=sDateFormat1.format(new Date());
        int dailyCount1 = recordMapper.getDailyCount(crucible,date1);
        int dailyCount = dailyCount1+1;
        Format f2 = new DecimalFormat("00");
        String dailyCount2 = f2.format(dailyCount);
        String batchId = date1 + line + station + crucible + dailyCount2;
        return batchId;
    }

    public int countByBatchId(String batchId) {
        int counts = recordMapper.getBatchIdCount(batchId);
        return counts;
    }

    public List<CastingChemistryUse> findByBatchId() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateString  = format.format(new Date());
        int used = 1;
        List<CastingChemistryUse> chemistryUseList = recordMapper.findByBatchId(dateString,used);
        return chemistryUseList;
    }

    public int updateState(String updateState) {

        int counts = recordMapper.updateState(updateState);
        return counts;
    }
}
