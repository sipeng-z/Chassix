package com.board.service;

import com.board.mapper.MachiningTableMapper;
import com.board.model.MachiningTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private MachiningTableMapper machiningTableMapper;

    public MachiningTable findByEquipment(String equipment) {

        MachiningTable machiningTable = machiningTableMapper.findByEquipment(equipment);

        return machiningTable;
    }
}
