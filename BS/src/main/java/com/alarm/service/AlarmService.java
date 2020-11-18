package com.alarm.service;

import com.alarm.domain.entity.MaintenanceAlarms;
import com.alarm.mapper.AlarmUseNameMapper;
import com.alarm.mapper.MTTRMapper;
import com.alarm.mapper.MaintenanceAlarmsMapper;
import com.alarm.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    @Autowired
    private MaintenanceAlarmsMapper maintenanceAlarmsMapper;

    @Autowired
    private AlarmUseNameMapper alarmUseNameMapper;

    @Autowired
    private MTTRMapper mttrMapper;

    public List<AlarmResponse> findByTypeAndDevice(Integer type, String device, String equipment) {

        if (device.equals("none")  && type == 2 && equipment.equals("none")){
            List<AlarmResponse> responses =maintenanceAlarmsMapper.findAll();
            return responses;
        }else if (device.equals("none")  && type != 2 && !equipment.equals("none")){
            List<AlarmResponse> responses =maintenanceAlarmsMapper.findByTimeAndEquipment(type,equipment);
            return responses;
        }else if (!device.equals("none")  && type == 2 && !equipment.equals("none")){
            List<AlarmResponse> responses =maintenanceAlarmsMapper.findByDeviceAndEquipment(device,equipment);
            return responses;
        }else if (device.equals("none")  && type == 2 && !equipment.equals("none")) {
            List<AlarmResponse> responses = maintenanceAlarmsMapper.findByEquipment(equipment);
            return responses;
        }else if (device.equals("none")  && type != 2 && equipment.equals("none")) {
            List<AlarmResponse> responses = maintenanceAlarmsMapper.findByType(type);
            return responses;
        }else{
            List<AlarmResponse> responses =maintenanceAlarmsMapper.findByAll(type,device,equipment);
            return responses;
        }
    }

    public List<AlarmUseName> findByParentId(Integer parentId){
        List<AlarmUseName> alarmUseNames = alarmUseNameMapper.findByParentId(parentId);
        return alarmUseNames;
    }

    public MTTRAndMTBF findMTTR(Integer type, String device, String equipment) {

        if (device.equals("none")  && type == 2 && equipment.equals("none")){
            MTTRResponse responses =mttrMapper.findAll();
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =2592000/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }else if (device.equals("none")  && type != 2 && !equipment.equals("none")){
            MTTRResponse responses =mttrMapper.findByTimeAndEquipment(type,equipment);
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =type*3600*24*7/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }else if (!device.equals("none")  && type == 2 && !equipment.equals("none")){
            MTTRResponse responses =mttrMapper.findByDeviceAndEquipment(device,equipment);
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =2592000/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }else if (device.equals("none")  && type == 2 && !equipment.equals("none")) {
            MTTRResponse responses = mttrMapper.findByEquipment(equipment);
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =2592000/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }else if (device.equals("none")  && type != 2 && equipment.equals("none")) {
            MTTRResponse responses = mttrMapper.findByType(type);
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =type*3600*24*7/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }else{
            MTTRResponse responses =mttrMapper.findByAll(type,device,equipment);
            MTTRAndMTBF mttrAndMTBF = new MTTRAndMTBF();
            mttrAndMTBF.setMTTR(responses.getMTTR());
            Integer MTBF =type*3600*24*7/(responses.getAlarmTimes());
            mttrAndMTBF.setMTBF(MTBF);
            return mttrAndMTBF;
        }
    }

    public List<MaintenanceAlarms> findTop5() {

        List<MaintenanceAlarms> maintenanceAlarms = maintenanceAlarmsMapper.findTop5();

        return maintenanceAlarms;
    }

    public List<CategoryResponse> findByCategory(Integer type, String device, String equipment) {

        if (device.equals("none")  && type == 2 && equipment.equals("none")){
            List<CategoryResponse> responses =maintenanceAlarmsMapper.findCategoryAll();
            return responses;
        }else if (device.equals("none")  && type != 2 && !equipment.equals("none")){
            List<CategoryResponse> responses =maintenanceAlarmsMapper.findCategoryByTimeAndEquipment(type,equipment);
            return responses;
        }else if (!device.equals("none")  && type == 2 && !equipment.equals("none")){
            List<CategoryResponse> responses =maintenanceAlarmsMapper.findCategoryByDeviceAndEquipment(device,equipment);
            return responses;
        }else if (device.equals("none")  && type == 2 && !equipment.equals("none")) {
            List<CategoryResponse> responses = maintenanceAlarmsMapper.findCategoryByEquipment(equipment);
            return responses;
        }else if (device.equals("none")  && type != 2 && equipment.equals("none")) {
            List<CategoryResponse> responses = maintenanceAlarmsMapper.findCategoryByType(type);
            return responses;
        }else{
            List<CategoryResponse> responses =maintenanceAlarmsMapper.findCategoryByAll(type,device,equipment);
            return responses;
        }

    }
}
