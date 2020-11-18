package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EMP2ASSYTraceabilityDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EMP2ASSYTraceabilityDataExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andItemnoIsNull() {
            addCriterion("ItemNO is null");
            return (Criteria) this;
        }

        public Criteria andItemnoIsNotNull() {
            addCriterion("ItemNO is not null");
            return (Criteria) this;
        }

        public Criteria andItemnoEqualTo(Integer value) {
            addCriterion("ItemNO =", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoNotEqualTo(Integer value) {
            addCriterion("ItemNO <>", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoGreaterThan(Integer value) {
            addCriterion("ItemNO >", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ItemNO >=", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoLessThan(Integer value) {
            addCriterion("ItemNO <", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoLessThanOrEqualTo(Integer value) {
            addCriterion("ItemNO <=", value, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoIn(List<Integer> values) {
            addCriterion("ItemNO in", values, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoNotIn(List<Integer> values) {
            addCriterion("ItemNO not in", values, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoBetween(Integer value1, Integer value2) {
            addCriterion("ItemNO between", value1, value2, "itemno");
            return (Criteria) this;
        }

        public Criteria andItemnoNotBetween(Integer value1, Integer value2) {
            addCriterion("ItemNO not between", value1, value2, "itemno");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoIsNull() {
            addCriterion("Part_Type_NO is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoIsNotNull() {
            addCriterion("Part_Type_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoEqualTo(Integer value) {
            addCriterion("Part_Type_NO =", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoNotEqualTo(Integer value) {
            addCriterion("Part_Type_NO <>", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoGreaterThan(Integer value) {
            addCriterion("Part_Type_NO >", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Part_Type_NO >=", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoLessThan(Integer value) {
            addCriterion("Part_Type_NO <", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoLessThanOrEqualTo(Integer value) {
            addCriterion("Part_Type_NO <=", value, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoIn(List<Integer> values) {
            addCriterion("Part_Type_NO in", values, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoNotIn(List<Integer> values) {
            addCriterion("Part_Type_NO not in", values, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoBetween(Integer value1, Integer value2) {
            addCriterion("Part_Type_NO between", value1, value2, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andPartTypeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Part_Type_NO not between", value1, value2, "partTypeNo");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNull() {
            addCriterion("MachineNO is null");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNotNull() {
            addCriterion("MachineNO is not null");
            return (Criteria) this;
        }

        public Criteria andMachinenoEqualTo(String value) {
            addCriterion("MachineNO =", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotEqualTo(String value) {
            addCriterion("MachineNO <>", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThan(String value) {
            addCriterion("MachineNO >", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThanOrEqualTo(String value) {
            addCriterion("MachineNO >=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThan(String value) {
            addCriterion("MachineNO <", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThanOrEqualTo(String value) {
            addCriterion("MachineNO <=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLike(String value) {
            addCriterion("MachineNO like", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotLike(String value) {
            addCriterion("MachineNO not like", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoIn(List<String> values) {
            addCriterion("MachineNO in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotIn(List<String> values) {
            addCriterion("MachineNO not in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoBetween(String value1, String value2) {
            addCriterion("MachineNO between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotBetween(String value1, String value2) {
            addCriterion("MachineNO not between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andSoNumberIsNull() {
            addCriterion("SO_Number is null");
            return (Criteria) this;
        }

        public Criteria andSoNumberIsNotNull() {
            addCriterion("SO_Number is not null");
            return (Criteria) this;
        }

        public Criteria andSoNumberEqualTo(String value) {
            addCriterion("SO_Number =", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberNotEqualTo(String value) {
            addCriterion("SO_Number <>", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberGreaterThan(String value) {
            addCriterion("SO_Number >", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("SO_Number >=", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberLessThan(String value) {
            addCriterion("SO_Number <", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberLessThanOrEqualTo(String value) {
            addCriterion("SO_Number <=", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberLike(String value) {
            addCriterion("SO_Number like", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberNotLike(String value) {
            addCriterion("SO_Number not like", value, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberIn(List<String> values) {
            addCriterion("SO_Number in", values, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberNotIn(List<String> values) {
            addCriterion("SO_Number not in", values, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberBetween(String value1, String value2) {
            addCriterion("SO_Number between", value1, value2, "soNumber");
            return (Criteria) this;
        }

        public Criteria andSoNumberNotBetween(String value1, String value2) {
            addCriterion("SO_Number not between", value1, value2, "soNumber");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNull() {
            addCriterion("Part_Type is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIsNotNull() {
            addCriterion("Part_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeEqualTo(String value) {
            addCriterion("Part_Type =", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotEqualTo(String value) {
            addCriterion("Part_Type <>", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThan(String value) {
            addCriterion("Part_Type >", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Part_Type >=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThan(String value) {
            addCriterion("Part_Type <", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLessThanOrEqualTo(String value) {
            addCriterion("Part_Type <=", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeLike(String value) {
            addCriterion("Part_Type like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotLike(String value) {
            addCriterion("Part_Type not like", value, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeIn(List<String> values) {
            addCriterion("Part_Type in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotIn(List<String> values) {
            addCriterion("Part_Type not in", values, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeBetween(String value1, String value2) {
            addCriterion("Part_Type between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPartTypeNotBetween(String value1, String value2) {
            addCriterion("Part_Type not between", value1, value2, "partType");
            return (Criteria) this;
        }

        public Criteria andPartnoIsNull() {
            addCriterion("PartNO is null");
            return (Criteria) this;
        }

        public Criteria andPartnoIsNotNull() {
            addCriterion("PartNO is not null");
            return (Criteria) this;
        }

        public Criteria andPartnoEqualTo(String value) {
            addCriterion("PartNO =", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoNotEqualTo(String value) {
            addCriterion("PartNO <>", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoGreaterThan(String value) {
            addCriterion("PartNO >", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoGreaterThanOrEqualTo(String value) {
            addCriterion("PartNO >=", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoLessThan(String value) {
            addCriterion("PartNO <", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoLessThanOrEqualTo(String value) {
            addCriterion("PartNO <=", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoLike(String value) {
            addCriterion("PartNO like", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoNotLike(String value) {
            addCriterion("PartNO not like", value, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoIn(List<String> values) {
            addCriterion("PartNO in", values, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoNotIn(List<String> values) {
            addCriterion("PartNO not in", values, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoBetween(String value1, String value2) {
            addCriterion("PartNO between", value1, value2, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoNotBetween(String value1, String value2) {
            addCriterion("PartNO not between", value1, value2, "partno");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrIsNull() {
            addCriterion("PartNO_Abbr is null");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrIsNotNull() {
            addCriterion("PartNO_Abbr is not null");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrEqualTo(String value) {
            addCriterion("PartNO_Abbr =", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrNotEqualTo(String value) {
            addCriterion("PartNO_Abbr <>", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrGreaterThan(String value) {
            addCriterion("PartNO_Abbr >", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("PartNO_Abbr >=", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrLessThan(String value) {
            addCriterion("PartNO_Abbr <", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrLessThanOrEqualTo(String value) {
            addCriterion("PartNO_Abbr <=", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrLike(String value) {
            addCriterion("PartNO_Abbr like", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrNotLike(String value) {
            addCriterion("PartNO_Abbr not like", value, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrIn(List<String> values) {
            addCriterion("PartNO_Abbr in", values, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrNotIn(List<String> values) {
            addCriterion("PartNO_Abbr not in", values, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrBetween(String value1, String value2) {
            addCriterion("PartNO_Abbr between", value1, value2, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartnoAbbrNotBetween(String value1, String value2) {
            addCriterion("PartNO_Abbr not between", value1, value2, "partnoAbbr");
            return (Criteria) this;
        }

        public Criteria andPartstatusIsNull() {
            addCriterion("PartStatus is null");
            return (Criteria) this;
        }

        public Criteria andPartstatusIsNotNull() {
            addCriterion("PartStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPartstatusEqualTo(Integer value) {
            addCriterion("PartStatus =", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusNotEqualTo(Integer value) {
            addCriterion("PartStatus <>", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusGreaterThan(Integer value) {
            addCriterion("PartStatus >", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PartStatus >=", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusLessThan(Integer value) {
            addCriterion("PartStatus <", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusLessThanOrEqualTo(Integer value) {
            addCriterion("PartStatus <=", value, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusIn(List<Integer> values) {
            addCriterion("PartStatus in", values, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusNotIn(List<Integer> values) {
            addCriterion("PartStatus not in", values, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusBetween(Integer value1, Integer value2) {
            addCriterion("PartStatus between", value1, value2, "partstatus");
            return (Criteria) this;
        }

        public Criteria andPartstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PartStatus not between", value1, value2, "partstatus");
            return (Criteria) this;
        }

        public Criteria andE1PressForceIsNull() {
            addCriterion("E1_Press_Force is null");
            return (Criteria) this;
        }

        public Criteria andE1PressForceIsNotNull() {
            addCriterion("E1_Press_Force is not null");
            return (Criteria) this;
        }

        public Criteria andE1PressForceEqualTo(Float value) {
            addCriterion("E1_Press_Force =", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceNotEqualTo(Float value) {
            addCriterion("E1_Press_Force <>", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceGreaterThan(Float value) {
            addCriterion("E1_Press_Force >", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceGreaterThanOrEqualTo(Float value) {
            addCriterion("E1_Press_Force >=", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceLessThan(Float value) {
            addCriterion("E1_Press_Force <", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceLessThanOrEqualTo(Float value) {
            addCriterion("E1_Press_Force <=", value, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceIn(List<Float> values) {
            addCriterion("E1_Press_Force in", values, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceNotIn(List<Float> values) {
            addCriterion("E1_Press_Force not in", values, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceBetween(Float value1, Float value2) {
            addCriterion("E1_Press_Force between", value1, value2, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1PressForceNotBetween(Float value1, Float value2) {
            addCriterion("E1_Press_Force not between", value1, value2, "e1PressForce");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionIsNull() {
            addCriterion("E1_End_Postion is null");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionIsNotNull() {
            addCriterion("E1_End_Postion is not null");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionEqualTo(Float value) {
            addCriterion("E1_End_Postion =", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionNotEqualTo(Float value) {
            addCriterion("E1_End_Postion <>", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionGreaterThan(Float value) {
            addCriterion("E1_End_Postion >", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionGreaterThanOrEqualTo(Float value) {
            addCriterion("E1_End_Postion >=", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionLessThan(Float value) {
            addCriterion("E1_End_Postion <", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionLessThanOrEqualTo(Float value) {
            addCriterion("E1_End_Postion <=", value, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionIn(List<Float> values) {
            addCriterion("E1_End_Postion in", values, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionNotIn(List<Float> values) {
            addCriterion("E1_End_Postion not in", values, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionBetween(Float value1, Float value2) {
            addCriterion("E1_End_Postion between", value1, value2, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1EndPostionNotBetween(Float value1, Float value2) {
            addCriterion("E1_End_Postion not between", value1, value2, "e1EndPostion");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceIsNull() {
            addCriterion("E1_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceIsNotNull() {
            addCriterion("E1_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceEqualTo(Float value) {
            addCriterion("E1_Final_Force =", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceNotEqualTo(Float value) {
            addCriterion("E1_Final_Force <>", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceGreaterThan(Float value) {
            addCriterion("E1_Final_Force >", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("E1_Final_Force >=", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceLessThan(Float value) {
            addCriterion("E1_Final_Force <", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("E1_Final_Force <=", value, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceIn(List<Float> values) {
            addCriterion("E1_Final_Force in", values, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceNotIn(List<Float> values) {
            addCriterion("E1_Final_Force not in", values, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceBetween(Float value1, Float value2) {
            addCriterion("E1_Final_Force between", value1, value2, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("E1_Final_Force not between", value1, value2, "e1FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceIsNull() {
            addCriterion("E2_Press_Force is null");
            return (Criteria) this;
        }

        public Criteria andE2PressForceIsNotNull() {
            addCriterion("E2_Press_Force is not null");
            return (Criteria) this;
        }

        public Criteria andE2PressForceEqualTo(Float value) {
            addCriterion("E2_Press_Force =", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceNotEqualTo(Float value) {
            addCriterion("E2_Press_Force <>", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceGreaterThan(Float value) {
            addCriterion("E2_Press_Force >", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceGreaterThanOrEqualTo(Float value) {
            addCriterion("E2_Press_Force >=", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceLessThan(Float value) {
            addCriterion("E2_Press_Force <", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceLessThanOrEqualTo(Float value) {
            addCriterion("E2_Press_Force <=", value, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceIn(List<Float> values) {
            addCriterion("E2_Press_Force in", values, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceNotIn(List<Float> values) {
            addCriterion("E2_Press_Force not in", values, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceBetween(Float value1, Float value2) {
            addCriterion("E2_Press_Force between", value1, value2, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2PressForceNotBetween(Float value1, Float value2) {
            addCriterion("E2_Press_Force not between", value1, value2, "e2PressForce");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionIsNull() {
            addCriterion("E2_End_Postion is null");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionIsNotNull() {
            addCriterion("E2_End_Postion is not null");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionEqualTo(Float value) {
            addCriterion("E2_End_Postion =", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionNotEqualTo(Float value) {
            addCriterion("E2_End_Postion <>", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionGreaterThan(Float value) {
            addCriterion("E2_End_Postion >", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionGreaterThanOrEqualTo(Float value) {
            addCriterion("E2_End_Postion >=", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionLessThan(Float value) {
            addCriterion("E2_End_Postion <", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionLessThanOrEqualTo(Float value) {
            addCriterion("E2_End_Postion <=", value, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionIn(List<Float> values) {
            addCriterion("E2_End_Postion in", values, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionNotIn(List<Float> values) {
            addCriterion("E2_End_Postion not in", values, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionBetween(Float value1, Float value2) {
            addCriterion("E2_End_Postion between", value1, value2, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2EndPostionNotBetween(Float value1, Float value2) {
            addCriterion("E2_End_Postion not between", value1, value2, "e2EndPostion");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceIsNull() {
            addCriterion("E2_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceIsNotNull() {
            addCriterion("E2_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceEqualTo(Float value) {
            addCriterion("E2_Final_Force =", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceNotEqualTo(Float value) {
            addCriterion("E2_Final_Force <>", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceGreaterThan(Float value) {
            addCriterion("E2_Final_Force >", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("E2_Final_Force >=", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceLessThan(Float value) {
            addCriterion("E2_Final_Force <", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("E2_Final_Force <=", value, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceIn(List<Float> values) {
            addCriterion("E2_Final_Force in", values, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceNotIn(List<Float> values) {
            addCriterion("E2_Final_Force not in", values, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceBetween(Float value1, Float value2) {
            addCriterion("E2_Final_Force between", value1, value2, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andE2FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("E2_Final_Force not between", value1, value2, "e2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceIsNull() {
            addCriterion("Stud1_Press_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceIsNotNull() {
            addCriterion("Stud1_Press_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceEqualTo(Float value) {
            addCriterion("Stud1_Press_Force =", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceNotEqualTo(Float value) {
            addCriterion("Stud1_Press_Force <>", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceGreaterThan(Float value) {
            addCriterion("Stud1_Press_Force >", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud1_Press_Force >=", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceLessThan(Float value) {
            addCriterion("Stud1_Press_Force <", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud1_Press_Force <=", value, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceIn(List<Float> values) {
            addCriterion("Stud1_Press_Force in", values, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceNotIn(List<Float> values) {
            addCriterion("Stud1_Press_Force not in", values, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceBetween(Float value1, Float value2) {
            addCriterion("Stud1_Press_Force between", value1, value2, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1PressForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud1_Press_Force not between", value1, value2, "stud1PressForce");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionIsNull() {
            addCriterion("Stud1_End_Postion is null");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionIsNotNull() {
            addCriterion("Stud1_End_Postion is not null");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionEqualTo(Float value) {
            addCriterion("Stud1_End_Postion =", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionNotEqualTo(Float value) {
            addCriterion("Stud1_End_Postion <>", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionGreaterThan(Float value) {
            addCriterion("Stud1_End_Postion >", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud1_End_Postion >=", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionLessThan(Float value) {
            addCriterion("Stud1_End_Postion <", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionLessThanOrEqualTo(Float value) {
            addCriterion("Stud1_End_Postion <=", value, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionIn(List<Float> values) {
            addCriterion("Stud1_End_Postion in", values, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionNotIn(List<Float> values) {
            addCriterion("Stud1_End_Postion not in", values, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionBetween(Float value1, Float value2) {
            addCriterion("Stud1_End_Postion between", value1, value2, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1EndPostionNotBetween(Float value1, Float value2) {
            addCriterion("Stud1_End_Postion not between", value1, value2, "stud1EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceIsNull() {
            addCriterion("Stud1_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceIsNotNull() {
            addCriterion("Stud1_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceEqualTo(Float value) {
            addCriterion("Stud1_Final_Force =", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceNotEqualTo(Float value) {
            addCriterion("Stud1_Final_Force <>", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceGreaterThan(Float value) {
            addCriterion("Stud1_Final_Force >", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud1_Final_Force >=", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceLessThan(Float value) {
            addCriterion("Stud1_Final_Force <", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud1_Final_Force <=", value, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceIn(List<Float> values) {
            addCriterion("Stud1_Final_Force in", values, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceNotIn(List<Float> values) {
            addCriterion("Stud1_Final_Force not in", values, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceBetween(Float value1, Float value2) {
            addCriterion("Stud1_Final_Force between", value1, value2, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud1FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud1_Final_Force not between", value1, value2, "stud1FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceIsNull() {
            addCriterion("Stud2_Press_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceIsNotNull() {
            addCriterion("Stud2_Press_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceEqualTo(Float value) {
            addCriterion("Stud2_Press_Force =", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceNotEqualTo(Float value) {
            addCriterion("Stud2_Press_Force <>", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceGreaterThan(Float value) {
            addCriterion("Stud2_Press_Force >", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud2_Press_Force >=", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceLessThan(Float value) {
            addCriterion("Stud2_Press_Force <", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud2_Press_Force <=", value, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceIn(List<Float> values) {
            addCriterion("Stud2_Press_Force in", values, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceNotIn(List<Float> values) {
            addCriterion("Stud2_Press_Force not in", values, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceBetween(Float value1, Float value2) {
            addCriterion("Stud2_Press_Force between", value1, value2, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2PressForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud2_Press_Force not between", value1, value2, "stud2PressForce");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionIsNull() {
            addCriterion("Stud2_End_Postion is null");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionIsNotNull() {
            addCriterion("Stud2_End_Postion is not null");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionEqualTo(Float value) {
            addCriterion("Stud2_End_Postion =", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionNotEqualTo(Float value) {
            addCriterion("Stud2_End_Postion <>", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionGreaterThan(Float value) {
            addCriterion("Stud2_End_Postion >", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud2_End_Postion >=", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionLessThan(Float value) {
            addCriterion("Stud2_End_Postion <", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionLessThanOrEqualTo(Float value) {
            addCriterion("Stud2_End_Postion <=", value, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionIn(List<Float> values) {
            addCriterion("Stud2_End_Postion in", values, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionNotIn(List<Float> values) {
            addCriterion("Stud2_End_Postion not in", values, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionBetween(Float value1, Float value2) {
            addCriterion("Stud2_End_Postion between", value1, value2, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2EndPostionNotBetween(Float value1, Float value2) {
            addCriterion("Stud2_End_Postion not between", value1, value2, "stud2EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceIsNull() {
            addCriterion("Stud2_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceIsNotNull() {
            addCriterion("Stud2_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceEqualTo(Float value) {
            addCriterion("Stud2_Final_Force =", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceNotEqualTo(Float value) {
            addCriterion("Stud2_Final_Force <>", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceGreaterThan(Float value) {
            addCriterion("Stud2_Final_Force >", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud2_Final_Force >=", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceLessThan(Float value) {
            addCriterion("Stud2_Final_Force <", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud2_Final_Force <=", value, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceIn(List<Float> values) {
            addCriterion("Stud2_Final_Force in", values, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceNotIn(List<Float> values) {
            addCriterion("Stud2_Final_Force not in", values, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceBetween(Float value1, Float value2) {
            addCriterion("Stud2_Final_Force between", value1, value2, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud2FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud2_Final_Force not between", value1, value2, "stud2FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceIsNull() {
            addCriterion("Stud3_Press_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceIsNotNull() {
            addCriterion("Stud3_Press_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceEqualTo(Float value) {
            addCriterion("Stud3_Press_Force =", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceNotEqualTo(Float value) {
            addCriterion("Stud3_Press_Force <>", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceGreaterThan(Float value) {
            addCriterion("Stud3_Press_Force >", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud3_Press_Force >=", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceLessThan(Float value) {
            addCriterion("Stud3_Press_Force <", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud3_Press_Force <=", value, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceIn(List<Float> values) {
            addCriterion("Stud3_Press_Force in", values, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceNotIn(List<Float> values) {
            addCriterion("Stud3_Press_Force not in", values, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceBetween(Float value1, Float value2) {
            addCriterion("Stud3_Press_Force between", value1, value2, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3PressForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud3_Press_Force not between", value1, value2, "stud3PressForce");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionIsNull() {
            addCriterion("Stud3_End_Postion is null");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionIsNotNull() {
            addCriterion("Stud3_End_Postion is not null");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionEqualTo(Float value) {
            addCriterion("Stud3_End_Postion =", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionNotEqualTo(Float value) {
            addCriterion("Stud3_End_Postion <>", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionGreaterThan(Float value) {
            addCriterion("Stud3_End_Postion >", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud3_End_Postion >=", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionLessThan(Float value) {
            addCriterion("Stud3_End_Postion <", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionLessThanOrEqualTo(Float value) {
            addCriterion("Stud3_End_Postion <=", value, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionIn(List<Float> values) {
            addCriterion("Stud3_End_Postion in", values, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionNotIn(List<Float> values) {
            addCriterion("Stud3_End_Postion not in", values, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionBetween(Float value1, Float value2) {
            addCriterion("Stud3_End_Postion between", value1, value2, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3EndPostionNotBetween(Float value1, Float value2) {
            addCriterion("Stud3_End_Postion not between", value1, value2, "stud3EndPostion");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceIsNull() {
            addCriterion("Stud3_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceIsNotNull() {
            addCriterion("Stud3_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceEqualTo(Float value) {
            addCriterion("Stud3_Final_Force =", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceNotEqualTo(Float value) {
            addCriterion("Stud3_Final_Force <>", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceGreaterThan(Float value) {
            addCriterion("Stud3_Final_Force >", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("Stud3_Final_Force >=", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceLessThan(Float value) {
            addCriterion("Stud3_Final_Force <", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("Stud3_Final_Force <=", value, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceIn(List<Float> values) {
            addCriterion("Stud3_Final_Force in", values, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceNotIn(List<Float> values) {
            addCriterion("Stud3_Final_Force not in", values, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceBetween(Float value1, Float value2) {
            addCriterion("Stud3_Final_Force between", value1, value2, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andStud3FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("Stud3_Final_Force not between", value1, value2, "stud3FinalForce");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeIsNull() {
            addCriterion("E1_E2_Completed_Time is null");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeIsNotNull() {
            addCriterion("E1_E2_Completed_Time is not null");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeEqualTo(Date value) {
            addCriterion("E1_E2_Completed_Time =", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeNotEqualTo(Date value) {
            addCriterion("E1_E2_Completed_Time <>", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeGreaterThan(Date value) {
            addCriterion("E1_E2_Completed_Time >", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("E1_E2_Completed_Time >=", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeLessThan(Date value) {
            addCriterion("E1_E2_Completed_Time <", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeLessThanOrEqualTo(Date value) {
            addCriterion("E1_E2_Completed_Time <=", value, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeIn(List<Date> values) {
            addCriterion("E1_E2_Completed_Time in", values, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeNotIn(List<Date> values) {
            addCriterion("E1_E2_Completed_Time not in", values, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeBetween(Date value1, Date value2) {
            addCriterion("E1_E2_Completed_Time between", value1, value2, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andE1E2CompletedTimeNotBetween(Date value1, Date value2) {
            addCriterion("E1_E2_Completed_Time not between", value1, value2, "e1E2CompletedTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeIsNull() {
            addCriterion("Label_Stick_Time is null");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeIsNotNull() {
            addCriterion("Label_Stick_Time is not null");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeEqualTo(Date value) {
            addCriterion("Label_Stick_Time =", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeNotEqualTo(Date value) {
            addCriterion("Label_Stick_Time <>", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeGreaterThan(Date value) {
            addCriterion("Label_Stick_Time >", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Label_Stick_Time >=", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeLessThan(Date value) {
            addCriterion("Label_Stick_Time <", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeLessThanOrEqualTo(Date value) {
            addCriterion("Label_Stick_Time <=", value, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeIn(List<Date> values) {
            addCriterion("Label_Stick_Time in", values, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeNotIn(List<Date> values) {
            addCriterion("Label_Stick_Time not in", values, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeBetween(Date value1, Date value2) {
            addCriterion("Label_Stick_Time between", value1, value2, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andLabelStickTimeNotBetween(Date value1, Date value2) {
            addCriterion("Label_Stick_Time not between", value1, value2, "labelStickTime");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusIsNull() {
            addCriterion("Stud_Assemble_Status is null");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusIsNotNull() {
            addCriterion("Stud_Assemble_Status is not null");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusEqualTo(Integer value) {
            addCriterion("Stud_Assemble_Status =", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusNotEqualTo(Integer value) {
            addCriterion("Stud_Assemble_Status <>", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusGreaterThan(Integer value) {
            addCriterion("Stud_Assemble_Status >", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Stud_Assemble_Status >=", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusLessThan(Integer value) {
            addCriterion("Stud_Assemble_Status <", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Stud_Assemble_Status <=", value, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusIn(List<Integer> values) {
            addCriterion("Stud_Assemble_Status in", values, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusNotIn(List<Integer> values) {
            addCriterion("Stud_Assemble_Status not in", values, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusBetween(Integer value1, Integer value2) {
            addCriterion("Stud_Assemble_Status between", value1, value2, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andStudAssembleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Stud_Assemble_Status not between", value1, value2, "studAssembleStatus");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeIsNull() {
            addCriterion("Part_Completed_Time is null");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeIsNotNull() {
            addCriterion("Part_Completed_Time is not null");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeEqualTo(Date value) {
            addCriterion("Part_Completed_Time =", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeNotEqualTo(Date value) {
            addCriterion("Part_Completed_Time <>", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeGreaterThan(Date value) {
            addCriterion("Part_Completed_Time >", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Part_Completed_Time >=", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeLessThan(Date value) {
            addCriterion("Part_Completed_Time <", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeLessThanOrEqualTo(Date value) {
            addCriterion("Part_Completed_Time <=", value, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeIn(List<Date> values) {
            addCriterion("Part_Completed_Time in", values, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeNotIn(List<Date> values) {
            addCriterion("Part_Completed_Time not in", values, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeBetween(Date value1, Date value2) {
            addCriterion("Part_Completed_Time between", value1, value2, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andPartCompletedTimeNotBetween(Date value1, Date value2) {
            addCriterion("Part_Completed_Time not between", value1, value2, "partCompletedTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeIsNull() {
            addCriterion("Last_Cycle_Spent_Time is null");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeIsNotNull() {
            addCriterion("Last_Cycle_Spent_Time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeEqualTo(Integer value) {
            addCriterion("Last_Cycle_Spent_Time =", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeNotEqualTo(Integer value) {
            addCriterion("Last_Cycle_Spent_Time <>", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeGreaterThan(Integer value) {
            addCriterion("Last_Cycle_Spent_Time >", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Last_Cycle_Spent_Time >=", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeLessThan(Integer value) {
            addCriterion("Last_Cycle_Spent_Time <", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeLessThanOrEqualTo(Integer value) {
            addCriterion("Last_Cycle_Spent_Time <=", value, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeIn(List<Integer> values) {
            addCriterion("Last_Cycle_Spent_Time in", values, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeNotIn(List<Integer> values) {
            addCriterion("Last_Cycle_Spent_Time not in", values, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeBetween(Integer value1, Integer value2) {
            addCriterion("Last_Cycle_Spent_Time between", value1, value2, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andLastCycleSpentTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("Last_Cycle_Spent_Time not between", value1, value2, "lastCycleSpentTime");
            return (Criteria) this;
        }

        public Criteria andRecordnoIsNull() {
            addCriterion("RecordNO is null");
            return (Criteria) this;
        }

        public Criteria andRecordnoIsNotNull() {
            addCriterion("RecordNO is not null");
            return (Criteria) this;
        }

        public Criteria andRecordnoEqualTo(Integer value) {
            addCriterion("RecordNO =", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotEqualTo(Integer value) {
            addCriterion("RecordNO <>", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoGreaterThan(Integer value) {
            addCriterion("RecordNO >", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecordNO >=", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoLessThan(Integer value) {
            addCriterion("RecordNO <", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoLessThanOrEqualTo(Integer value) {
            addCriterion("RecordNO <=", value, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoIn(List<Integer> values) {
            addCriterion("RecordNO in", values, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotIn(List<Integer> values) {
            addCriterion("RecordNO not in", values, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoBetween(Integer value1, Integer value2) {
            addCriterion("RecordNO between", value1, value2, "recordno");
            return (Criteria) this;
        }

        public Criteria andRecordnoNotBetween(Integer value1, Integer value2) {
            addCriterion("RecordNO not between", value1, value2, "recordno");
            return (Criteria) this;
        }

        public Criteria andDateStringIsNull() {
            addCriterion("Date_String is null");
            return (Criteria) this;
        }

        public Criteria andDateStringIsNotNull() {
            addCriterion("Date_String is not null");
            return (Criteria) this;
        }

        public Criteria andDateStringEqualTo(String value) {
            addCriterion("Date_String =", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringNotEqualTo(String value) {
            addCriterion("Date_String <>", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringGreaterThan(String value) {
            addCriterion("Date_String >", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringGreaterThanOrEqualTo(String value) {
            addCriterion("Date_String >=", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringLessThan(String value) {
            addCriterion("Date_String <", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringLessThanOrEqualTo(String value) {
            addCriterion("Date_String <=", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringLike(String value) {
            addCriterion("Date_String like", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringNotLike(String value) {
            addCriterion("Date_String not like", value, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringIn(List<String> values) {
            addCriterion("Date_String in", values, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringNotIn(List<String> values) {
            addCriterion("Date_String not in", values, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringBetween(String value1, String value2) {
            addCriterion("Date_String between", value1, value2, "dateString");
            return (Criteria) this;
        }

        public Criteria andDateStringNotBetween(String value1, String value2) {
            addCriterion("Date_String not between", value1, value2, "dateString");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}