package com.quality.mapper;


import com.quality.model.StandardASSY2TraceabilityData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StandardASSY2TraceabilityDataMapper {

    StandardASSY2TraceabilityData selectBySearch(StandardASSY2TraceabilityData partno);

    Integer countBySearch(String partno);
}