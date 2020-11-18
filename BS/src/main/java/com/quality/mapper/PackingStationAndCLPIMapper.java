package com.quality.mapper;

import com.quality.model.PackingStationAndCLPI;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PackingStationAndCLPIMapper {

    PackingStationAndCLPI selectBySearch(PackingStationAndCLPI dmContent);

    Integer countBySearch(String dmContent);
}