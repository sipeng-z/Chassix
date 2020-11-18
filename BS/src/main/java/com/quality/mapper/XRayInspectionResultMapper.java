package com.quality.mapper;

import com.quality.model.XRayInspectionResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XRayInspectionResultMapper {

    XRayInspectionResult selectBySearch(XRayInspectionResult dmContent);

    Integer countBySearch(String dmContent);
}