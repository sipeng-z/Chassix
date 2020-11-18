package com.board.mapper;

import com.board.model.MachiningTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MachiningTableMapper {

    public MachiningTable findByEquipment(String equipment);
}
