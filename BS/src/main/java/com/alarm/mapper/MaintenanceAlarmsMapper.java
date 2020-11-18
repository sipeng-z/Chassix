package com.alarm.mapper;


import com.alarm.domain.AlarmResponse;
import com.alarm.domain.CategoryResponse;
import com.alarm.domain.entity.MaintenanceAlarms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenanceAlarmsMapper {


    List<AlarmResponse> findAll();

    List<AlarmResponse> findByType(@Param("type") Integer type);

    List<AlarmResponse> findByAll(@Param("type")Integer type,@Param("device") String device, @Param("equipment") String equipment);

    List<AlarmResponse> findByTimeAndEquipment(@Param("type")Integer type, @Param("equipment") String equipment);

    List<AlarmResponse> findByDeviceAndEquipment(@Param("device")String device, @Param("equipment") String equipment);

    List<AlarmResponse> findByEquipment(@Param("equipment") String equipment);

    List<MaintenanceAlarms> findTop5();

    List<CategoryResponse> findCategoryAll();

    List<CategoryResponse> findCategoryByTimeAndEquipment(@Param("type")Integer type, @Param("equipment") String equipment);

    List<CategoryResponse> findCategoryByDeviceAndEquipment(@Param("device")String device, @Param("equipment") String equipment);

    List<CategoryResponse> findCategoryByEquipment(@Param("equipment") String equipment);

    List<CategoryResponse> findCategoryByType(@Param("type") Integer type);

    List<CategoryResponse> findCategoryByAll(@Param("type")Integer type,@Param("device") String device, @Param("equipment") String equipment);
}