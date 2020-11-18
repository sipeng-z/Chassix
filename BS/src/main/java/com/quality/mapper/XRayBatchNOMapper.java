package com.quality.mapper;

import com.quality.model.XRayBatchNO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XRayBatchNOMapper {

    XRayBatchNO selectBySearch(XRayBatchNO dmContent);

    Integer countBySearch(String dmContent);

}