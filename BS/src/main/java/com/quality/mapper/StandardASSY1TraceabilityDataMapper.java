package com.quality.mapper;

import com.quality.model.StandardASSY1TraceabilityData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StandardASSY1TraceabilityDataMapper {

    StandardASSY1TraceabilityData selectBySearch(StandardASSY1TraceabilityData partno);

    Integer countBySearch(String partno);
}