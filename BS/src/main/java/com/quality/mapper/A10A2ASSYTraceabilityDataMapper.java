package com.quality.mapper;

import com.quality.model.A10A2ASSYTraceabilityData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface A10A2ASSYTraceabilityDataMapper {

    A10A2ASSYTraceabilityData selectBySearch(A10A2ASSYTraceabilityData partno);

    Integer countBySearch(String partno);

}