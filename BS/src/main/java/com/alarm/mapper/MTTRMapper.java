package com.alarm.mapper;

import com.alarm.domain.MTTRResponse;
import org.apache.ibatis.annotations.Param;


public interface MTTRMapper {
    MTTRResponse findAll();

    MTTRResponse findByType(@Param("type") Integer type);

    MTTRResponse findByAll(@Param("type")Integer type,@Param("device") String device, @Param("equipment") String equipment);

    MTTRResponse findByTimeAndEquipment(@Param("type")Integer type, @Param("equipment") String equipment);

    MTTRResponse findByDeviceAndEquipment(@Param("device")String device, @Param("equipment") String equipment);

    MTTRResponse findByEquipment(@Param("equipment") String equipment);
}
