package com.alarm.mapper;

import com.alarm.domain.AlarmUseName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmUseNameMapper {

    List<AlarmUseName> findByParentId(@Param("parentId") Integer parentId);
}
