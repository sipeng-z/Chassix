package com.casting.service;

import com.casting.domain.entity.MechanicalTestSpec;
import com.casting.mapper.mybatis.MechanicalTestSpecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicalTestSpecService {

    @Autowired
    private MechanicalTestSpecMapper mechanicalTestSpecMapper;

    public List<MechanicalTestSpec> getData() {
        return mechanicalTestSpecMapper.getData();
    }

    public MechanicalTestSpec getDataByPartName(String partname) {
        return mechanicalTestSpecMapper.getDataByPartName(partname);
    }
}
