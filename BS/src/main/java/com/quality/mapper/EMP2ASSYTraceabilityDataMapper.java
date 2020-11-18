package com.quality.mapper;


import com.quality.model.EMP2ASSYTraceabilityData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EMP2ASSYTraceabilityDataMapper {
    EMP2ASSYTraceabilityData selectBySearch(EMP2ASSYTraceabilityData partno);

    Integer countBySearch(String partno);
}