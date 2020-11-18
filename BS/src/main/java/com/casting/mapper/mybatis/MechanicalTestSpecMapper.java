package com.casting.mapper.mybatis;

import com.casting.domain.entity.MechanicalTestSpec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MechanicalTestSpecMapper {

    @Select("select * from Mechanical_Test_Spec")
    List<MechanicalTestSpec> getData();

    @Select("select * from Mechanical_Test_Spec where Partname= #{Partname}")
    MechanicalTestSpec getDataByPartName(@Param("Partname") String partname);
}
