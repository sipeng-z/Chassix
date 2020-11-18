package com.alarm.mapper;

import com.alarm.domain.entity.ChemistryOperators;

import java.util.List;

public interface ChemistryOperatorsMapper {
    List<ChemistryOperators> findAllInspector();

    List<ChemistryOperators> findAllOperator();
}
