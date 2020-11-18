package com.quality.mapper;

import com.quality.model.LaserMarkerPrintedPN;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LaserMarkerPrintedPNMapper {

    LaserMarkerPrintedPN selectBySearch(LaserMarkerPrintedPN dmContent);

    Integer countBySearch(String dmContent);

    List<LaserMarkerPrintedPN> getAll();
}