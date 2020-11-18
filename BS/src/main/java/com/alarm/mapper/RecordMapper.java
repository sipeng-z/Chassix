package com.alarm.mapper;

import com.alarm.domain.entity.CastingChemistryUse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordMapper {
    int save(CastingChemistryUse castingChemistryUse);

    int getDailyCount(@Param("crucible") String crucible, @Param("dateString") String dateString);

    int getBatchIdCount(@Param("batchId") String batchId);

    List<CastingChemistryUse> findByBatchId(@Param("dateString")String dateString, @Param("used")int used);

    int updateState(@Param("batchId") String updateState);
}
