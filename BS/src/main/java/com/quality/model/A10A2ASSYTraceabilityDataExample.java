package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class A10A2ASSYTraceabilityDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public A10A2ASSYTraceabilityDataExample() {
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

        public Criteria andBsh1InsertForceIsNull() {
            addCriterion("BSH1_Insert_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceIsNotNull() {
            addCriterion("BSH1_Insert_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force =", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force <>", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Force >", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force >=", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceLessThan(Float value) {
            addCriterion("BSH1_Insert_Force <", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force <=", value, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force in", values, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force not in", values, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force between", value1, value2, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force not between", value1, value2, "bsh1InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinIsNull() {
            addCriterion("BSH1_Insert_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinIsNotNull() {
            addCriterion("BSH1_Insert_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Min =", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Min <>", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Force_Min >", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Min >=", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinLessThan(Float value) {
            addCriterion("BSH1_Insert_Force_Min <", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Min <=", value, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force_Min in", values, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force_Min not in", values, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force_Min between", value1, value2, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force_Min not between", value1, value2, "bsh1InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxIsNull() {
            addCriterion("BSH1_Insert_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxIsNotNull() {
            addCriterion("BSH1_Insert_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Max =", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Max <>", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Force_Max >", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Max >=", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxLessThan(Float value) {
            addCriterion("BSH1_Insert_Force_Max <", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Force_Max <=", value, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force_Max in", values, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Force_Max not in", values, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force_Max between", value1, value2, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Force_Max not between", value1, value2, "bsh1InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionIsNull() {
            addCriterion("BSH1_Insert_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionIsNotNull() {
            addCriterion("BSH1_Insert_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position =", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position <>", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Position >", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position >=", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionLessThan(Float value) {
            addCriterion("BSH1_Insert_Position <", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position <=", value, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position in", values, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position not in", values, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position between", value1, value2, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position not between", value1, value2, "bsh1InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinIsNull() {
            addCriterion("BSH1_Insert_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinIsNotNull() {
            addCriterion("BSH1_Insert_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Min =", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Min <>", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Position_Min >", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Min >=", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinLessThan(Float value) {
            addCriterion("BSH1_Insert_Position_Min <", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Min <=", value, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position_Min in", values, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position_Min not in", values, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position_Min between", value1, value2, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position_Min not between", value1, value2, "bsh1InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxIsNull() {
            addCriterion("BSH1_Insert_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxIsNotNull() {
            addCriterion("BSH1_Insert_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Max =", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Max <>", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxGreaterThan(Float value) {
            addCriterion("BSH1_Insert_Position_Max >", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Max >=", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxLessThan(Float value) {
            addCriterion("BSH1_Insert_Position_Max <", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Insert_Position_Max <=", value, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position_Max in", values, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Insert_Position_Max not in", values, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position_Max between", value1, value2, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1InsertPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Insert_Position_Max not between", value1, value2, "bsh1InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceIsNull() {
            addCriterion("BSH1_Press_in_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceIsNotNull() {
            addCriterion("BSH1_Press_in_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force =", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force <>", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Force >", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force >=", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceLessThan(Float value) {
            addCriterion("BSH1_Press_in_Force <", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force <=", value, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force in", values, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force not in", values, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force between", value1, value2, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force not between", value1, value2, "bsh1PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinIsNull() {
            addCriterion("BSH1_Press_in_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinIsNotNull() {
            addCriterion("BSH1_Press_in_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Min =", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Min <>", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Force_Min >", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Min >=", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinLessThan(Float value) {
            addCriterion("BSH1_Press_in_Force_Min <", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Min <=", value, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force_Min in", values, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force_Min not in", values, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force_Min between", value1, value2, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force_Min not between", value1, value2, "bsh1PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxIsNull() {
            addCriterion("BSH1_Press_in_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxIsNotNull() {
            addCriterion("BSH1_Press_in_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Max =", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Max <>", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Force_Max >", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Max >=", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxLessThan(Float value) {
            addCriterion("BSH1_Press_in_Force_Max <", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Force_Max <=", value, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force_Max in", values, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Force_Max not in", values, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force_Max between", value1, value2, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Force_Max not between", value1, value2, "bsh1PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionIsNull() {
            addCriterion("BSH1_Press_in_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionIsNotNull() {
            addCriterion("BSH1_Press_in_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position =", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position <>", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Position >", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position >=", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionLessThan(Float value) {
            addCriterion("BSH1_Press_in_Position <", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position <=", value, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position in", values, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position not in", values, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position between", value1, value2, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position not between", value1, value2, "bsh1PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinIsNull() {
            addCriterion("BSH1_Press_in_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinIsNotNull() {
            addCriterion("BSH1_Press_in_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Min =", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Min <>", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Position_Min >", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Min >=", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinLessThan(Float value) {
            addCriterion("BSH1_Press_in_Position_Min <", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Min <=", value, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position_Min in", values, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position_Min not in", values, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position_Min between", value1, value2, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position_Min not between", value1, value2, "bsh1PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxIsNull() {
            addCriterion("BSH1_Press_in_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxIsNotNull() {
            addCriterion("BSH1_Press_in_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Max =", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Max <>", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Position_Max >", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Max >=", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxLessThan(Float value) {
            addCriterion("BSH1_Press_in_Position_Max <", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Position_Max <=", value, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position_Max in", values, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Position_Max not in", values, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position_Max between", value1, value2, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Position_Max not between", value1, value2, "bsh1PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceIsNull() {
            addCriterion("BSH1_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceIsNotNull() {
            addCriterion("BSH1_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceEqualTo(Float value) {
            addCriterion("BSH1_Final_Force =", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Force <>", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceGreaterThan(Float value) {
            addCriterion("BSH1_Final_Force >", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force >=", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceLessThan(Float value) {
            addCriterion("BSH1_Final_Force <", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force <=", value, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceIn(List<Float> values) {
            addCriterion("BSH1_Final_Force in", values, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Force not in", values, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force between", value1, value2, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force not between", value1, value2, "bsh1FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinIsNull() {
            addCriterion("BSH1_Final_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinIsNotNull() {
            addCriterion("BSH1_Final_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Min =", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Min <>", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinGreaterThan(Float value) {
            addCriterion("BSH1_Final_Force_Min >", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Min >=", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinLessThan(Float value) {
            addCriterion("BSH1_Final_Force_Min <", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Min <=", value, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinIn(List<Float> values) {
            addCriterion("BSH1_Final_Force_Min in", values, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Force_Min not in", values, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force_Min between", value1, value2, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force_Min not between", value1, value2, "bsh1FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxIsNull() {
            addCriterion("BSH1_Final_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxIsNotNull() {
            addCriterion("BSH1_Final_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Max =", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Max <>", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxGreaterThan(Float value) {
            addCriterion("BSH1_Final_Force_Max >", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Max >=", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxLessThan(Float value) {
            addCriterion("BSH1_Final_Force_Max <", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Force_Max <=", value, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxIn(List<Float> values) {
            addCriterion("BSH1_Final_Force_Max in", values, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Force_Max not in", values, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force_Max between", value1, value2, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Force_Max not between", value1, value2, "bsh1FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionIsNull() {
            addCriterion("BSH1_Final_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionIsNotNull() {
            addCriterion("BSH1_Final_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionEqualTo(Float value) {
            addCriterion("BSH1_Final_Position =", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Position <>", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionGreaterThan(Float value) {
            addCriterion("BSH1_Final_Position >", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position >=", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionLessThan(Float value) {
            addCriterion("BSH1_Final_Position <", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position <=", value, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionIn(List<Float> values) {
            addCriterion("BSH1_Final_Position in", values, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Position not in", values, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position between", value1, value2, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position not between", value1, value2, "bsh1FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinIsNull() {
            addCriterion("BSH1_Final_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinIsNotNull() {
            addCriterion("BSH1_Final_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Min =", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Min <>", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinGreaterThan(Float value) {
            addCriterion("BSH1_Final_Position_Min >", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Min >=", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinLessThan(Float value) {
            addCriterion("BSH1_Final_Position_Min <", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Min <=", value, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinIn(List<Float> values) {
            addCriterion("BSH1_Final_Position_Min in", values, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Position_Min not in", values, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position_Min between", value1, value2, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position_Min not between", value1, value2, "bsh1FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxIsNull() {
            addCriterion("BSH1_Final_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxIsNotNull() {
            addCriterion("BSH1_Final_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Max =", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Max <>", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxGreaterThan(Float value) {
            addCriterion("BSH1_Final_Position_Max >", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Max >=", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxLessThan(Float value) {
            addCriterion("BSH1_Final_Position_Max <", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Final_Position_Max <=", value, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxIn(List<Float> values) {
            addCriterion("BSH1_Final_Position_Max in", values, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Final_Position_Max not in", values, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position_Max between", value1, value2, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1FinalPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Final_Position_Max not between", value1, value2, "bsh1FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedIsNull() {
            addCriterion("BSH1_Press_in_Speed is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedIsNotNull() {
            addCriterion("BSH1_Press_in_Speed is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed =", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed <>", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Speed >", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed >=", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedLessThan(Float value) {
            addCriterion("BSH1_Press_in_Speed <", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed <=", value, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed in", values, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed not in", values, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed between", value1, value2, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed not between", value1, value2, "bsh1PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinIsNull() {
            addCriterion("BSH1_Press_in_Speed_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinIsNotNull() {
            addCriterion("BSH1_Press_in_Speed_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min =", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min <>", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min >", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min >=", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinLessThan(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min <", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Min <=", value, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed_Min in", values, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed_Min not in", values, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed_Min between", value1, value2, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed_Min not between", value1, value2, "bsh1PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxIsNull() {
            addCriterion("BSH1_Press_in_Speed_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxIsNotNull() {
            addCriterion("BSH1_Press_in_Speed_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max =", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max <>", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxGreaterThan(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max >", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max >=", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxLessThan(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max <", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Press_in_Speed_Max <=", value, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed_Max in", values, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Press_in_Speed_Max not in", values, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed_Max between", value1, value2, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1PressInSpeedMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Press_in_Speed_Max not between", value1, value2, "bsh1PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeIsNull() {
            addCriterion("BSH1_Slope is null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeIsNotNull() {
            addCriterion("BSH1_Slope is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeEqualTo(Float value) {
            addCriterion("BSH1_Slope =", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeNotEqualTo(Float value) {
            addCriterion("BSH1_Slope <>", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeGreaterThan(Float value) {
            addCriterion("BSH1_Slope >", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope >=", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeLessThan(Float value) {
            addCriterion("BSH1_Slope <", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope <=", value, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeIn(List<Float> values) {
            addCriterion("BSH1_Slope in", values, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeNotIn(List<Float> values) {
            addCriterion("BSH1_Slope not in", values, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope between", value1, value2, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope not between", value1, value2, "bsh1Slope");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinIsNull() {
            addCriterion("BSH1_Slope_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinIsNotNull() {
            addCriterion("BSH1_Slope_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinEqualTo(Float value) {
            addCriterion("BSH1_Slope_Min =", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinNotEqualTo(Float value) {
            addCriterion("BSH1_Slope_Min <>", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinGreaterThan(Float value) {
            addCriterion("BSH1_Slope_Min >", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope_Min >=", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinLessThan(Float value) {
            addCriterion("BSH1_Slope_Min <", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope_Min <=", value, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinIn(List<Float> values) {
            addCriterion("BSH1_Slope_Min in", values, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinNotIn(List<Float> values) {
            addCriterion("BSH1_Slope_Min not in", values, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope_Min between", value1, value2, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope_Min not between", value1, value2, "bsh1SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxIsNull() {
            addCriterion("BSH1_Slope_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxIsNotNull() {
            addCriterion("BSH1_Slope_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxEqualTo(Float value) {
            addCriterion("BSH1_Slope_Max =", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxNotEqualTo(Float value) {
            addCriterion("BSH1_Slope_Max <>", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxGreaterThan(Float value) {
            addCriterion("BSH1_Slope_Max >", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope_Max >=", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxLessThan(Float value) {
            addCriterion("BSH1_Slope_Max <", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH1_Slope_Max <=", value, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxIn(List<Float> values) {
            addCriterion("BSH1_Slope_Max in", values, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxNotIn(List<Float> values) {
            addCriterion("BSH1_Slope_Max not in", values, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope_Max between", value1, value2, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh1SlopeMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH1_Slope_Max not between", value1, value2, "bsh1SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceIsNull() {
            addCriterion("BSH2_Insert_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceIsNotNull() {
            addCriterion("BSH2_Insert_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force =", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force <>", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Force >", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force >=", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceLessThan(Float value) {
            addCriterion("BSH2_Insert_Force <", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force <=", value, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force in", values, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force not in", values, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force between", value1, value2, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force not between", value1, value2, "bsh2InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinIsNull() {
            addCriterion("BSH2_Insert_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinIsNotNull() {
            addCriterion("BSH2_Insert_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Min =", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Min <>", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Force_Min >", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Min >=", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinLessThan(Float value) {
            addCriterion("BSH2_Insert_Force_Min <", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Min <=", value, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force_Min in", values, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force_Min not in", values, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force_Min between", value1, value2, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force_Min not between", value1, value2, "bsh2InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxIsNull() {
            addCriterion("BSH2_Insert_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxIsNotNull() {
            addCriterion("BSH2_Insert_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Max =", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Max <>", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Force_Max >", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Max >=", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxLessThan(Float value) {
            addCriterion("BSH2_Insert_Force_Max <", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Force_Max <=", value, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force_Max in", values, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Force_Max not in", values, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force_Max between", value1, value2, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Force_Max not between", value1, value2, "bsh2InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionIsNull() {
            addCriterion("BSH2_Insert_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionIsNotNull() {
            addCriterion("BSH2_Insert_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position =", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position <>", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Position >", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position >=", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionLessThan(Float value) {
            addCriterion("BSH2_Insert_Position <", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position <=", value, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position in", values, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position not in", values, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position between", value1, value2, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position not between", value1, value2, "bsh2InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinIsNull() {
            addCriterion("BSH2_Insert_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinIsNotNull() {
            addCriterion("BSH2_Insert_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Min =", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Min <>", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Position_Min >", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Min >=", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinLessThan(Float value) {
            addCriterion("BSH2_Insert_Position_Min <", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Min <=", value, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position_Min in", values, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position_Min not in", values, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position_Min between", value1, value2, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position_Min not between", value1, value2, "bsh2InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxIsNull() {
            addCriterion("BSH2_Insert_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxIsNotNull() {
            addCriterion("BSH2_Insert_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Max =", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Max <>", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxGreaterThan(Float value) {
            addCriterion("BSH2_Insert_Position_Max >", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Max >=", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxLessThan(Float value) {
            addCriterion("BSH2_Insert_Position_Max <", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Insert_Position_Max <=", value, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position_Max in", values, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Insert_Position_Max not in", values, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position_Max between", value1, value2, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2InsertPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Insert_Position_Max not between", value1, value2, "bsh2InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceIsNull() {
            addCriterion("BSH2_Press_in_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceIsNotNull() {
            addCriterion("BSH2_Press_in_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force =", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force <>", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Force >", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force >=", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceLessThan(Float value) {
            addCriterion("BSH2_Press_in_Force <", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force <=", value, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force in", values, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force not in", values, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force between", value1, value2, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force not between", value1, value2, "bsh2PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinIsNull() {
            addCriterion("BSH2_Press_in_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinIsNotNull() {
            addCriterion("BSH2_Press_in_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Min =", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Min <>", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Force_Min >", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Min >=", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinLessThan(Float value) {
            addCriterion("BSH2_Press_in_Force_Min <", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Min <=", value, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force_Min in", values, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force_Min not in", values, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force_Min between", value1, value2, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force_Min not between", value1, value2, "bsh2PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxIsNull() {
            addCriterion("BSH2_Press_in_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxIsNotNull() {
            addCriterion("BSH2_Press_in_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Max =", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Max <>", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Force_Max >", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Max >=", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxLessThan(Float value) {
            addCriterion("BSH2_Press_in_Force_Max <", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Force_Max <=", value, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force_Max in", values, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Force_Max not in", values, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force_Max between", value1, value2, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Force_Max not between", value1, value2, "bsh2PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionIsNull() {
            addCriterion("BSH2_Press_in_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionIsNotNull() {
            addCriterion("BSH2_Press_in_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position =", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position <>", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Position >", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position >=", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionLessThan(Float value) {
            addCriterion("BSH2_Press_in_Position <", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position <=", value, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position in", values, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position not in", values, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position between", value1, value2, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position not between", value1, value2, "bsh2PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinIsNull() {
            addCriterion("BSH2_Press_in_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinIsNotNull() {
            addCriterion("BSH2_Press_in_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Min =", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Min <>", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Position_Min >", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Min >=", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinLessThan(Float value) {
            addCriterion("BSH2_Press_in_Position_Min <", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Min <=", value, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position_Min in", values, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position_Min not in", values, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position_Min between", value1, value2, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position_Min not between", value1, value2, "bsh2PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxIsNull() {
            addCriterion("BSH2_Press_in_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxIsNotNull() {
            addCriterion("BSH2_Press_in_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Max =", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Max <>", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Position_Max >", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Max >=", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxLessThan(Float value) {
            addCriterion("BSH2_Press_in_Position_Max <", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Position_Max <=", value, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position_Max in", values, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Position_Max not in", values, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position_Max between", value1, value2, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Position_Max not between", value1, value2, "bsh2PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceIsNull() {
            addCriterion("BSH2_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceIsNotNull() {
            addCriterion("BSH2_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceEqualTo(Float value) {
            addCriterion("BSH2_Final_Force =", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Force <>", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceGreaterThan(Float value) {
            addCriterion("BSH2_Final_Force >", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force >=", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceLessThan(Float value) {
            addCriterion("BSH2_Final_Force <", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force <=", value, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceIn(List<Float> values) {
            addCriterion("BSH2_Final_Force in", values, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Force not in", values, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force between", value1, value2, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force not between", value1, value2, "bsh2FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinIsNull() {
            addCriterion("BSH2_Final_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinIsNotNull() {
            addCriterion("BSH2_Final_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Min =", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Min <>", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinGreaterThan(Float value) {
            addCriterion("BSH2_Final_Force_Min >", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Min >=", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinLessThan(Float value) {
            addCriterion("BSH2_Final_Force_Min <", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Min <=", value, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinIn(List<Float> values) {
            addCriterion("BSH2_Final_Force_Min in", values, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Force_Min not in", values, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force_Min between", value1, value2, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force_Min not between", value1, value2, "bsh2FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxIsNull() {
            addCriterion("BSH2_Final_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxIsNotNull() {
            addCriterion("BSH2_Final_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Max =", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Max <>", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxGreaterThan(Float value) {
            addCriterion("BSH2_Final_Force_Max >", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Max >=", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxLessThan(Float value) {
            addCriterion("BSH2_Final_Force_Max <", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Force_Max <=", value, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxIn(List<Float> values) {
            addCriterion("BSH2_Final_Force_Max in", values, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Force_Max not in", values, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force_Max between", value1, value2, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Force_Max not between", value1, value2, "bsh2FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionIsNull() {
            addCriterion("BSH2_Final_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionIsNotNull() {
            addCriterion("BSH2_Final_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionEqualTo(Float value) {
            addCriterion("BSH2_Final_Position =", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Position <>", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionGreaterThan(Float value) {
            addCriterion("BSH2_Final_Position >", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position >=", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionLessThan(Float value) {
            addCriterion("BSH2_Final_Position <", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position <=", value, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionIn(List<Float> values) {
            addCriterion("BSH2_Final_Position in", values, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Position not in", values, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position between", value1, value2, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position not between", value1, value2, "bsh2FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinIsNull() {
            addCriterion("BSH2_Final_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinIsNotNull() {
            addCriterion("BSH2_Final_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Min =", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Min <>", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinGreaterThan(Float value) {
            addCriterion("BSH2_Final_Position_Min >", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Min >=", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinLessThan(Float value) {
            addCriterion("BSH2_Final_Position_Min <", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Min <=", value, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinIn(List<Float> values) {
            addCriterion("BSH2_Final_Position_Min in", values, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Position_Min not in", values, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position_Min between", value1, value2, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position_Min not between", value1, value2, "bsh2FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxIsNull() {
            addCriterion("BSH2_Final_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxIsNotNull() {
            addCriterion("BSH2_Final_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Max =", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Max <>", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxGreaterThan(Float value) {
            addCriterion("BSH2_Final_Position_Max >", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Max >=", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxLessThan(Float value) {
            addCriterion("BSH2_Final_Position_Max <", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Final_Position_Max <=", value, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxIn(List<Float> values) {
            addCriterion("BSH2_Final_Position_Max in", values, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Final_Position_Max not in", values, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position_Max between", value1, value2, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2FinalPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Final_Position_Max not between", value1, value2, "bsh2FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedIsNull() {
            addCriterion("BSH2_Press_in_Speed is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedIsNotNull() {
            addCriterion("BSH2_Press_in_Speed is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed =", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed <>", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Speed >", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed >=", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedLessThan(Float value) {
            addCriterion("BSH2_Press_in_Speed <", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed <=", value, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed in", values, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed not in", values, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed between", value1, value2, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed not between", value1, value2, "bsh2PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinIsNull() {
            addCriterion("BSH2_Press_in_Speed_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinIsNotNull() {
            addCriterion("BSH2_Press_in_Speed_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min =", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min <>", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min >", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min >=", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinLessThan(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min <", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Min <=", value, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed_Min in", values, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed_Min not in", values, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed_Min between", value1, value2, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed_Min not between", value1, value2, "bsh2PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxIsNull() {
            addCriterion("BSH2_Press_in_Speed_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxIsNotNull() {
            addCriterion("BSH2_Press_in_Speed_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max =", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max <>", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxGreaterThan(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max >", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max >=", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxLessThan(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max <", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Press_in_Speed_Max <=", value, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed_Max in", values, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Press_in_Speed_Max not in", values, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed_Max between", value1, value2, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2PressInSpeedMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Press_in_Speed_Max not between", value1, value2, "bsh2PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeIsNull() {
            addCriterion("BSH2_Slope is null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeIsNotNull() {
            addCriterion("BSH2_Slope is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeEqualTo(Float value) {
            addCriterion("BSH2_Slope =", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeNotEqualTo(Float value) {
            addCriterion("BSH2_Slope <>", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeGreaterThan(Float value) {
            addCriterion("BSH2_Slope >", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope >=", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeLessThan(Float value) {
            addCriterion("BSH2_Slope <", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope <=", value, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeIn(List<Float> values) {
            addCriterion("BSH2_Slope in", values, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeNotIn(List<Float> values) {
            addCriterion("BSH2_Slope not in", values, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope between", value1, value2, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope not between", value1, value2, "bsh2Slope");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinIsNull() {
            addCriterion("BSH2_Slope_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinIsNotNull() {
            addCriterion("BSH2_Slope_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinEqualTo(Float value) {
            addCriterion("BSH2_Slope_Min =", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinNotEqualTo(Float value) {
            addCriterion("BSH2_Slope_Min <>", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinGreaterThan(Float value) {
            addCriterion("BSH2_Slope_Min >", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope_Min >=", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinLessThan(Float value) {
            addCriterion("BSH2_Slope_Min <", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope_Min <=", value, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinIn(List<Float> values) {
            addCriterion("BSH2_Slope_Min in", values, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinNotIn(List<Float> values) {
            addCriterion("BSH2_Slope_Min not in", values, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope_Min between", value1, value2, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope_Min not between", value1, value2, "bsh2SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxIsNull() {
            addCriterion("BSH2_Slope_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxIsNotNull() {
            addCriterion("BSH2_Slope_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxEqualTo(Float value) {
            addCriterion("BSH2_Slope_Max =", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxNotEqualTo(Float value) {
            addCriterion("BSH2_Slope_Max <>", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxGreaterThan(Float value) {
            addCriterion("BSH2_Slope_Max >", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope_Max >=", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxLessThan(Float value) {
            addCriterion("BSH2_Slope_Max <", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH2_Slope_Max <=", value, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxIn(List<Float> values) {
            addCriterion("BSH2_Slope_Max in", values, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxNotIn(List<Float> values) {
            addCriterion("BSH2_Slope_Max not in", values, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope_Max between", value1, value2, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh2SlopeMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH2_Slope_Max not between", value1, value2, "bsh2SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceIsNull() {
            addCriterion("BSH3_Insert_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceIsNotNull() {
            addCriterion("BSH3_Insert_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force =", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force <>", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Force >", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force >=", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceLessThan(Float value) {
            addCriterion("BSH3_Insert_Force <", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force <=", value, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force in", values, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force not in", values, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force between", value1, value2, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force not between", value1, value2, "bsh3InsertForce");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinIsNull() {
            addCriterion("BSH3_Insert_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinIsNotNull() {
            addCriterion("BSH3_Insert_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Min =", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Min <>", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Force_Min >", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Min >=", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinLessThan(Float value) {
            addCriterion("BSH3_Insert_Force_Min <", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Min <=", value, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force_Min in", values, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force_Min not in", values, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force_Min between", value1, value2, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force_Min not between", value1, value2, "bsh3InsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxIsNull() {
            addCriterion("BSH3_Insert_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxIsNotNull() {
            addCriterion("BSH3_Insert_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Max =", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Max <>", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Force_Max >", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Max >=", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxLessThan(Float value) {
            addCriterion("BSH3_Insert_Force_Max <", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Force_Max <=", value, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force_Max in", values, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Force_Max not in", values, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force_Max between", value1, value2, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Force_Max not between", value1, value2, "bsh3InsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionIsNull() {
            addCriterion("BSH3_Insert_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionIsNotNull() {
            addCriterion("BSH3_Insert_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position =", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position <>", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Position >", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position >=", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionLessThan(Float value) {
            addCriterion("BSH3_Insert_Position <", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position <=", value, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position in", values, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position not in", values, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position between", value1, value2, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position not between", value1, value2, "bsh3InsertPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinIsNull() {
            addCriterion("BSH3_Insert_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinIsNotNull() {
            addCriterion("BSH3_Insert_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Min =", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Min <>", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Position_Min >", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Min >=", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinLessThan(Float value) {
            addCriterion("BSH3_Insert_Position_Min <", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Min <=", value, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position_Min in", values, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position_Min not in", values, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position_Min between", value1, value2, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position_Min not between", value1, value2, "bsh3InsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxIsNull() {
            addCriterion("BSH3_Insert_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxIsNotNull() {
            addCriterion("BSH3_Insert_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Max =", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Max <>", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxGreaterThan(Float value) {
            addCriterion("BSH3_Insert_Position_Max >", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Max >=", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxLessThan(Float value) {
            addCriterion("BSH3_Insert_Position_Max <", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Insert_Position_Max <=", value, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position_Max in", values, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Insert_Position_Max not in", values, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position_Max between", value1, value2, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3InsertPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Insert_Position_Max not between", value1, value2, "bsh3InsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceIsNull() {
            addCriterion("BSH3_Press_in_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceIsNotNull() {
            addCriterion("BSH3_Press_in_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force =", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force <>", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Force >", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force >=", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceLessThan(Float value) {
            addCriterion("BSH3_Press_in_Force <", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force <=", value, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force in", values, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force not in", values, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force between", value1, value2, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force not between", value1, value2, "bsh3PressInForce");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinIsNull() {
            addCriterion("BSH3_Press_in_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinIsNotNull() {
            addCriterion("BSH3_Press_in_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Min =", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Min <>", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Force_Min >", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Min >=", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinLessThan(Float value) {
            addCriterion("BSH3_Press_in_Force_Min <", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Min <=", value, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force_Min in", values, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force_Min not in", values, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force_Min between", value1, value2, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force_Min not between", value1, value2, "bsh3PressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxIsNull() {
            addCriterion("BSH3_Press_in_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxIsNotNull() {
            addCriterion("BSH3_Press_in_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Max =", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Max <>", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Force_Max >", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Max >=", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxLessThan(Float value) {
            addCriterion("BSH3_Press_in_Force_Max <", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Force_Max <=", value, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force_Max in", values, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Force_Max not in", values, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force_Max between", value1, value2, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Force_Max not between", value1, value2, "bsh3PressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionIsNull() {
            addCriterion("BSH3_Press_in_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionIsNotNull() {
            addCriterion("BSH3_Press_in_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position =", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position <>", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Position >", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position >=", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionLessThan(Float value) {
            addCriterion("BSH3_Press_in_Position <", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position <=", value, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position in", values, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position not in", values, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position between", value1, value2, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position not between", value1, value2, "bsh3PressInPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinIsNull() {
            addCriterion("BSH3_Press_in_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinIsNotNull() {
            addCriterion("BSH3_Press_in_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Min =", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Min <>", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Position_Min >", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Min >=", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinLessThan(Float value) {
            addCriterion("BSH3_Press_in_Position_Min <", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Min <=", value, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position_Min in", values, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position_Min not in", values, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position_Min between", value1, value2, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position_Min not between", value1, value2, "bsh3PressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxIsNull() {
            addCriterion("BSH3_Press_in_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxIsNotNull() {
            addCriterion("BSH3_Press_in_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Max =", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Max <>", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Position_Max >", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Max >=", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxLessThan(Float value) {
            addCriterion("BSH3_Press_in_Position_Max <", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Position_Max <=", value, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position_Max in", values, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Position_Max not in", values, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position_Max between", value1, value2, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Position_Max not between", value1, value2, "bsh3PressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceIsNull() {
            addCriterion("BSH3_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceIsNotNull() {
            addCriterion("BSH3_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceEqualTo(Float value) {
            addCriterion("BSH3_Final_Force =", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Force <>", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceGreaterThan(Float value) {
            addCriterion("BSH3_Final_Force >", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force >=", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceLessThan(Float value) {
            addCriterion("BSH3_Final_Force <", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force <=", value, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceIn(List<Float> values) {
            addCriterion("BSH3_Final_Force in", values, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Force not in", values, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force between", value1, value2, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force not between", value1, value2, "bsh3FinalForce");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinIsNull() {
            addCriterion("BSH3_Final_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinIsNotNull() {
            addCriterion("BSH3_Final_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Min =", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Min <>", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinGreaterThan(Float value) {
            addCriterion("BSH3_Final_Force_Min >", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Min >=", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinLessThan(Float value) {
            addCriterion("BSH3_Final_Force_Min <", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Min <=", value, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinIn(List<Float> values) {
            addCriterion("BSH3_Final_Force_Min in", values, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Force_Min not in", values, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force_Min between", value1, value2, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force_Min not between", value1, value2, "bsh3FinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxIsNull() {
            addCriterion("BSH3_Final_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxIsNotNull() {
            addCriterion("BSH3_Final_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Max =", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Max <>", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxGreaterThan(Float value) {
            addCriterion("BSH3_Final_Force_Max >", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Max >=", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxLessThan(Float value) {
            addCriterion("BSH3_Final_Force_Max <", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Force_Max <=", value, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxIn(List<Float> values) {
            addCriterion("BSH3_Final_Force_Max in", values, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Force_Max not in", values, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force_Max between", value1, value2, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Force_Max not between", value1, value2, "bsh3FinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionIsNull() {
            addCriterion("BSH3_Final_Position is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionIsNotNull() {
            addCriterion("BSH3_Final_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionEqualTo(Float value) {
            addCriterion("BSH3_Final_Position =", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Position <>", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionGreaterThan(Float value) {
            addCriterion("BSH3_Final_Position >", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position >=", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionLessThan(Float value) {
            addCriterion("BSH3_Final_Position <", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position <=", value, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionIn(List<Float> values) {
            addCriterion("BSH3_Final_Position in", values, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Position not in", values, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position between", value1, value2, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position not between", value1, value2, "bsh3FinalPosition");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinIsNull() {
            addCriterion("BSH3_Final_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinIsNotNull() {
            addCriterion("BSH3_Final_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Min =", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Min <>", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinGreaterThan(Float value) {
            addCriterion("BSH3_Final_Position_Min >", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Min >=", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinLessThan(Float value) {
            addCriterion("BSH3_Final_Position_Min <", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Min <=", value, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinIn(List<Float> values) {
            addCriterion("BSH3_Final_Position_Min in", values, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Position_Min not in", values, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position_Min between", value1, value2, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position_Min not between", value1, value2, "bsh3FinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxIsNull() {
            addCriterion("BSH3_Final_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxIsNotNull() {
            addCriterion("BSH3_Final_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Max =", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Max <>", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxGreaterThan(Float value) {
            addCriterion("BSH3_Final_Position_Max >", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Max >=", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxLessThan(Float value) {
            addCriterion("BSH3_Final_Position_Max <", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Final_Position_Max <=", value, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxIn(List<Float> values) {
            addCriterion("BSH3_Final_Position_Max in", values, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Final_Position_Max not in", values, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position_Max between", value1, value2, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3FinalPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Final_Position_Max not between", value1, value2, "bsh3FinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedIsNull() {
            addCriterion("BSH3_Press_in_Speed is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedIsNotNull() {
            addCriterion("BSH3_Press_in_Speed is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed =", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed <>", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Speed >", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed >=", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedLessThan(Float value) {
            addCriterion("BSH3_Press_in_Speed <", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed <=", value, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed in", values, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed not in", values, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed between", value1, value2, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed not between", value1, value2, "bsh3PressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinIsNull() {
            addCriterion("BSH3_Press_in_Speed_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinIsNotNull() {
            addCriterion("BSH3_Press_in_Speed_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min =", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min <>", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min >", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min >=", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinLessThan(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min <", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Min <=", value, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed_Min in", values, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed_Min not in", values, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed_Min between", value1, value2, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed_Min not between", value1, value2, "bsh3PressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxIsNull() {
            addCriterion("BSH3_Press_in_Speed_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxIsNotNull() {
            addCriterion("BSH3_Press_in_Speed_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max =", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max <>", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxGreaterThan(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max >", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max >=", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxLessThan(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max <", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Press_in_Speed_Max <=", value, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed_Max in", values, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Press_in_Speed_Max not in", values, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed_Max between", value1, value2, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3PressInSpeedMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Press_in_Speed_Max not between", value1, value2, "bsh3PressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeIsNull() {
            addCriterion("BSH3_Slope is null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeIsNotNull() {
            addCriterion("BSH3_Slope is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeEqualTo(Float value) {
            addCriterion("BSH3_Slope =", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeNotEqualTo(Float value) {
            addCriterion("BSH3_Slope <>", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeGreaterThan(Float value) {
            addCriterion("BSH3_Slope >", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope >=", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeLessThan(Float value) {
            addCriterion("BSH3_Slope <", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope <=", value, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeIn(List<Float> values) {
            addCriterion("BSH3_Slope in", values, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeNotIn(List<Float> values) {
            addCriterion("BSH3_Slope not in", values, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope between", value1, value2, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope not between", value1, value2, "bsh3Slope");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinIsNull() {
            addCriterion("BSH3_Slope_Min is null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinIsNotNull() {
            addCriterion("BSH3_Slope_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinEqualTo(Float value) {
            addCriterion("BSH3_Slope_Min =", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinNotEqualTo(Float value) {
            addCriterion("BSH3_Slope_Min <>", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinGreaterThan(Float value) {
            addCriterion("BSH3_Slope_Min >", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope_Min >=", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinLessThan(Float value) {
            addCriterion("BSH3_Slope_Min <", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope_Min <=", value, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinIn(List<Float> values) {
            addCriterion("BSH3_Slope_Min in", values, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinNotIn(List<Float> values) {
            addCriterion("BSH3_Slope_Min not in", values, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope_Min between", value1, value2, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMinNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope_Min not between", value1, value2, "bsh3SlopeMin");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxIsNull() {
            addCriterion("BSH3_Slope_Max is null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxIsNotNull() {
            addCriterion("BSH3_Slope_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxEqualTo(Float value) {
            addCriterion("BSH3_Slope_Max =", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxNotEqualTo(Float value) {
            addCriterion("BSH3_Slope_Max <>", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxGreaterThan(Float value) {
            addCriterion("BSH3_Slope_Max >", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope_Max >=", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxLessThan(Float value) {
            addCriterion("BSH3_Slope_Max <", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxLessThanOrEqualTo(Float value) {
            addCriterion("BSH3_Slope_Max <=", value, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxIn(List<Float> values) {
            addCriterion("BSH3_Slope_Max in", values, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxNotIn(List<Float> values) {
            addCriterion("BSH3_Slope_Max not in", values, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope_Max between", value1, value2, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBsh3SlopeMaxNotBetween(Float value1, Float value2) {
            addCriterion("BSH3_Slope_Max not between", value1, value2, "bsh3SlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceIsNull() {
            addCriterion("BJ_Insert_Force is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceIsNotNull() {
            addCriterion("BJ_Insert_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceEqualTo(Float value) {
            addCriterion("BJ_Insert_Force =", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Force <>", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceGreaterThan(Float value) {
            addCriterion("BJ_Insert_Force >", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force >=", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceLessThan(Float value) {
            addCriterion("BJ_Insert_Force <", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force <=", value, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceIn(List<Float> values) {
            addCriterion("BJ_Insert_Force in", values, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Force not in", values, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force between", value1, value2, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force not between", value1, value2, "bjInsertForce");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinIsNull() {
            addCriterion("BJ_Insert_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinIsNotNull() {
            addCriterion("BJ_Insert_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Min =", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Min <>", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinGreaterThan(Float value) {
            addCriterion("BJ_Insert_Force_Min >", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Min >=", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinLessThan(Float value) {
            addCriterion("BJ_Insert_Force_Min <", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Min <=", value, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinIn(List<Float> values) {
            addCriterion("BJ_Insert_Force_Min in", values, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Force_Min not in", values, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force_Min between", value1, value2, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force_Min not between", value1, value2, "bjInsertForceMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxIsNull() {
            addCriterion("BJ_Insert_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxIsNotNull() {
            addCriterion("BJ_Insert_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Max =", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Max <>", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxGreaterThan(Float value) {
            addCriterion("BJ_Insert_Force_Max >", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Max >=", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxLessThan(Float value) {
            addCriterion("BJ_Insert_Force_Max <", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Force_Max <=", value, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxIn(List<Float> values) {
            addCriterion("BJ_Insert_Force_Max in", values, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Force_Max not in", values, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force_Max between", value1, value2, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Force_Max not between", value1, value2, "bjInsertForceMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionIsNull() {
            addCriterion("BJ_Insert_Position is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionIsNotNull() {
            addCriterion("BJ_Insert_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionEqualTo(Float value) {
            addCriterion("BJ_Insert_Position =", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Position <>", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionGreaterThan(Float value) {
            addCriterion("BJ_Insert_Position >", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position >=", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionLessThan(Float value) {
            addCriterion("BJ_Insert_Position <", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position <=", value, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionIn(List<Float> values) {
            addCriterion("BJ_Insert_Position in", values, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Position not in", values, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position between", value1, value2, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position not between", value1, value2, "bjInsertPosition");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinIsNull() {
            addCriterion("BJ_Insert_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinIsNotNull() {
            addCriterion("BJ_Insert_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Min =", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Min <>", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinGreaterThan(Float value) {
            addCriterion("BJ_Insert_Position_Min >", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Min >=", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinLessThan(Float value) {
            addCriterion("BJ_Insert_Position_Min <", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Min <=", value, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinIn(List<Float> values) {
            addCriterion("BJ_Insert_Position_Min in", values, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Position_Min not in", values, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position_Min between", value1, value2, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position_Min not between", value1, value2, "bjInsertPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxIsNull() {
            addCriterion("BJ_Insert_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxIsNotNull() {
            addCriterion("BJ_Insert_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Max =", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxNotEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Max <>", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxGreaterThan(Float value) {
            addCriterion("BJ_Insert_Position_Max >", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Max >=", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxLessThan(Float value) {
            addCriterion("BJ_Insert_Position_Max <", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Insert_Position_Max <=", value, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxIn(List<Float> values) {
            addCriterion("BJ_Insert_Position_Max in", values, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxNotIn(List<Float> values) {
            addCriterion("BJ_Insert_Position_Max not in", values, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position_Max between", value1, value2, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjInsertPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Insert_Position_Max not between", value1, value2, "bjInsertPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceIsNull() {
            addCriterion("BJ_Press_in_Force is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceIsNotNull() {
            addCriterion("BJ_Press_in_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force =", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force <>", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Force >", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force >=", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceLessThan(Float value) {
            addCriterion("BJ_Press_in_Force <", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force <=", value, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force in", values, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force not in", values, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force between", value1, value2, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force not between", value1, value2, "bjPressInForce");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinIsNull() {
            addCriterion("BJ_Press_in_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinIsNotNull() {
            addCriterion("BJ_Press_in_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Min =", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Min <>", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Force_Min >", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Min >=", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinLessThan(Float value) {
            addCriterion("BJ_Press_in_Force_Min <", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Min <=", value, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force_Min in", values, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force_Min not in", values, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force_Min between", value1, value2, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force_Min not between", value1, value2, "bjPressInForceMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxIsNull() {
            addCriterion("BJ_Press_in_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxIsNotNull() {
            addCriterion("BJ_Press_in_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Max =", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Max <>", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Force_Max >", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Max >=", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxLessThan(Float value) {
            addCriterion("BJ_Press_in_Force_Max <", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Force_Max <=", value, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force_Max in", values, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Force_Max not in", values, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force_Max between", value1, value2, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Force_Max not between", value1, value2, "bjPressInForceMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionIsNull() {
            addCriterion("BJ_Press_in_Position is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionIsNotNull() {
            addCriterion("BJ_Press_in_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position =", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position <>", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Position >", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position >=", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionLessThan(Float value) {
            addCriterion("BJ_Press_in_Position <", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position <=", value, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position in", values, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position not in", values, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position between", value1, value2, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position not between", value1, value2, "bjPressInPosition");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinIsNull() {
            addCriterion("BJ_Press_in_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinIsNotNull() {
            addCriterion("BJ_Press_in_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Min =", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Min <>", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Position_Min >", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Min >=", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinLessThan(Float value) {
            addCriterion("BJ_Press_in_Position_Min <", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Min <=", value, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position_Min in", values, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position_Min not in", values, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position_Min between", value1, value2, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position_Min not between", value1, value2, "bjPressInPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxIsNull() {
            addCriterion("BJ_Press_in_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxIsNotNull() {
            addCriterion("BJ_Press_in_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Max =", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Max <>", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Position_Max >", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Max >=", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxLessThan(Float value) {
            addCriterion("BJ_Press_in_Position_Max <", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Position_Max <=", value, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position_Max in", values, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Position_Max not in", values, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position_Max between", value1, value2, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Position_Max not between", value1, value2, "bjPressInPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceIsNull() {
            addCriterion("BJ_Final_Force is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceIsNotNull() {
            addCriterion("BJ_Final_Force is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceEqualTo(Float value) {
            addCriterion("BJ_Final_Force =", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceNotEqualTo(Float value) {
            addCriterion("BJ_Final_Force <>", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceGreaterThan(Float value) {
            addCriterion("BJ_Final_Force >", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force >=", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceLessThan(Float value) {
            addCriterion("BJ_Final_Force <", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force <=", value, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceIn(List<Float> values) {
            addCriterion("BJ_Final_Force in", values, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceNotIn(List<Float> values) {
            addCriterion("BJ_Final_Force not in", values, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force between", value1, value2, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force not between", value1, value2, "bjFinalForce");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinIsNull() {
            addCriterion("BJ_Final_Force_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinIsNotNull() {
            addCriterion("BJ_Final_Force_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Min =", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinNotEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Min <>", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinGreaterThan(Float value) {
            addCriterion("BJ_Final_Force_Min >", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Min >=", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinLessThan(Float value) {
            addCriterion("BJ_Final_Force_Min <", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Min <=", value, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinIn(List<Float> values) {
            addCriterion("BJ_Final_Force_Min in", values, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinNotIn(List<Float> values) {
            addCriterion("BJ_Final_Force_Min not in", values, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force_Min between", value1, value2, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force_Min not between", value1, value2, "bjFinalForceMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxIsNull() {
            addCriterion("BJ_Final_Force_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxIsNotNull() {
            addCriterion("BJ_Final_Force_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Max =", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxNotEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Max <>", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxGreaterThan(Float value) {
            addCriterion("BJ_Final_Force_Max >", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Max >=", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxLessThan(Float value) {
            addCriterion("BJ_Final_Force_Max <", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Force_Max <=", value, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxIn(List<Float> values) {
            addCriterion("BJ_Final_Force_Max in", values, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxNotIn(List<Float> values) {
            addCriterion("BJ_Final_Force_Max not in", values, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force_Max between", value1, value2, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalForceMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Force_Max not between", value1, value2, "bjFinalForceMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionIsNull() {
            addCriterion("BJ_Final_Position is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionIsNotNull() {
            addCriterion("BJ_Final_Position is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionEqualTo(Float value) {
            addCriterion("BJ_Final_Position =", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionNotEqualTo(Float value) {
            addCriterion("BJ_Final_Position <>", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionGreaterThan(Float value) {
            addCriterion("BJ_Final_Position >", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position >=", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionLessThan(Float value) {
            addCriterion("BJ_Final_Position <", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position <=", value, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionIn(List<Float> values) {
            addCriterion("BJ_Final_Position in", values, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionNotIn(List<Float> values) {
            addCriterion("BJ_Final_Position not in", values, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position between", value1, value2, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position not between", value1, value2, "bjFinalPosition");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinIsNull() {
            addCriterion("BJ_Final_Position_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinIsNotNull() {
            addCriterion("BJ_Final_Position_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Min =", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinNotEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Min <>", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinGreaterThan(Float value) {
            addCriterion("BJ_Final_Position_Min >", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Min >=", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinLessThan(Float value) {
            addCriterion("BJ_Final_Position_Min <", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Min <=", value, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinIn(List<Float> values) {
            addCriterion("BJ_Final_Position_Min in", values, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinNotIn(List<Float> values) {
            addCriterion("BJ_Final_Position_Min not in", values, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position_Min between", value1, value2, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position_Min not between", value1, value2, "bjFinalPositionMin");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxIsNull() {
            addCriterion("BJ_Final_Position_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxIsNotNull() {
            addCriterion("BJ_Final_Position_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Max =", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxNotEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Max <>", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxGreaterThan(Float value) {
            addCriterion("BJ_Final_Position_Max >", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Max >=", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxLessThan(Float value) {
            addCriterion("BJ_Final_Position_Max <", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Final_Position_Max <=", value, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxIn(List<Float> values) {
            addCriterion("BJ_Final_Position_Max in", values, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxNotIn(List<Float> values) {
            addCriterion("BJ_Final_Position_Max not in", values, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position_Max between", value1, value2, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjFinalPositionMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Final_Position_Max not between", value1, value2, "bjFinalPositionMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedIsNull() {
            addCriterion("BJ_Press_in_Speed is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedIsNotNull() {
            addCriterion("BJ_Press_in_Speed is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed =", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed <>", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Speed >", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed >=", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedLessThan(Float value) {
            addCriterion("BJ_Press_in_Speed <", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed <=", value, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed in", values, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed not in", values, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed between", value1, value2, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed not between", value1, value2, "bjPressInSpeed");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinIsNull() {
            addCriterion("BJ_Press_in_Speed_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinIsNotNull() {
            addCriterion("BJ_Press_in_Speed_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Min =", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Min <>", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Speed_Min >", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Min >=", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinLessThan(Float value) {
            addCriterion("BJ_Press_in_Speed_Min <", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Min <=", value, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed_Min in", values, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed_Min not in", values, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed_Min between", value1, value2, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed_Min not between", value1, value2, "bjPressInSpeedMin");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxIsNull() {
            addCriterion("BJ_Press_in_Speed_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxIsNotNull() {
            addCriterion("BJ_Press_in_Speed_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Max =", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxNotEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Max <>", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxGreaterThan(Float value) {
            addCriterion("BJ_Press_in_Speed_Max >", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Max >=", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxLessThan(Float value) {
            addCriterion("BJ_Press_in_Speed_Max <", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Press_in_Speed_Max <=", value, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed_Max in", values, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxNotIn(List<Float> values) {
            addCriterion("BJ_Press_in_Speed_Max not in", values, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed_Max between", value1, value2, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjPressInSpeedMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Press_in_Speed_Max not between", value1, value2, "bjPressInSpeedMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeIsNull() {
            addCriterion("BJ_Slope is null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeIsNotNull() {
            addCriterion("BJ_Slope is not null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeEqualTo(Float value) {
            addCriterion("BJ_Slope =", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeNotEqualTo(Float value) {
            addCriterion("BJ_Slope <>", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeGreaterThan(Float value) {
            addCriterion("BJ_Slope >", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope >=", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeLessThan(Float value) {
            addCriterion("BJ_Slope <", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope <=", value, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeIn(List<Float> values) {
            addCriterion("BJ_Slope in", values, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeNotIn(List<Float> values) {
            addCriterion("BJ_Slope not in", values, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope between", value1, value2, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope not between", value1, value2, "bjSlope");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinIsNull() {
            addCriterion("BJ_Slope_Min is null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinIsNotNull() {
            addCriterion("BJ_Slope_Min is not null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinEqualTo(Float value) {
            addCriterion("BJ_Slope_Min =", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinNotEqualTo(Float value) {
            addCriterion("BJ_Slope_Min <>", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinGreaterThan(Float value) {
            addCriterion("BJ_Slope_Min >", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope_Min >=", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinLessThan(Float value) {
            addCriterion("BJ_Slope_Min <", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope_Min <=", value, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinIn(List<Float> values) {
            addCriterion("BJ_Slope_Min in", values, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinNotIn(List<Float> values) {
            addCriterion("BJ_Slope_Min not in", values, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope_Min between", value1, value2, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMinNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope_Min not between", value1, value2, "bjSlopeMin");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxIsNull() {
            addCriterion("BJ_Slope_Max is null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxIsNotNull() {
            addCriterion("BJ_Slope_Max is not null");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxEqualTo(Float value) {
            addCriterion("BJ_Slope_Max =", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxNotEqualTo(Float value) {
            addCriterion("BJ_Slope_Max <>", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxGreaterThan(Float value) {
            addCriterion("BJ_Slope_Max >", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope_Max >=", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxLessThan(Float value) {
            addCriterion("BJ_Slope_Max <", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxLessThanOrEqualTo(Float value) {
            addCriterion("BJ_Slope_Max <=", value, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxIn(List<Float> values) {
            addCriterion("BJ_Slope_Max in", values, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxNotIn(List<Float> values) {
            addCriterion("BJ_Slope_Max not in", values, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope_Max between", value1, value2, "bjSlopeMax");
            return (Criteria) this;
        }

        public Criteria andBjSlopeMaxNotBetween(Float value1, Float value2) {
            addCriterion("BJ_Slope_Max not between", value1, value2, "bjSlopeMax");
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

        public Criteria andVmTimeIsNull() {
            addCriterion("VM_Time is null");
            return (Criteria) this;
        }

        public Criteria andVmTimeIsNotNull() {
            addCriterion("VM_Time is not null");
            return (Criteria) this;
        }

        public Criteria andVmTimeEqualTo(Date value) {
            addCriterion("VM_Time =", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeNotEqualTo(Date value) {
            addCriterion("VM_Time <>", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeGreaterThan(Date value) {
            addCriterion("VM_Time >", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VM_Time >=", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeLessThan(Date value) {
            addCriterion("VM_Time <", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeLessThanOrEqualTo(Date value) {
            addCriterion("VM_Time <=", value, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeIn(List<Date> values) {
            addCriterion("VM_Time in", values, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeNotIn(List<Date> values) {
            addCriterion("VM_Time not in", values, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeBetween(Date value1, Date value2) {
            addCriterion("VM_Time between", value1, value2, "vmTime");
            return (Criteria) this;
        }

        public Criteria andVmTimeNotBetween(Date value1, Date value2) {
            addCriterion("VM_Time not between", value1, value2, "vmTime");
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