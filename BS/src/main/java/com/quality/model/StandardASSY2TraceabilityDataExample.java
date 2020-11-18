package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StandardASSY2TraceabilityDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StandardASSY2TraceabilityDataExample() {
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

        public Criteria andMachineNoIsNull() {
            addCriterion("Machine_NO is null");
            return (Criteria) this;
        }

        public Criteria andMachineNoIsNotNull() {
            addCriterion("Machine_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNoEqualTo(String value) {
            addCriterion("Machine_NO =", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotEqualTo(String value) {
            addCriterion("Machine_NO <>", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThan(String value) {
            addCriterion("Machine_NO >", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThanOrEqualTo(String value) {
            addCriterion("Machine_NO >=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThan(String value) {
            addCriterion("Machine_NO <", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThanOrEqualTo(String value) {
            addCriterion("Machine_NO <=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLike(String value) {
            addCriterion("Machine_NO like", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotLike(String value) {
            addCriterion("Machine_NO not like", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoIn(List<String> values) {
            addCriterion("Machine_NO in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotIn(List<String> values) {
            addCriterion("Machine_NO not in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoBetween(String value1, String value2) {
            addCriterion("Machine_NO between", value1, value2, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotBetween(String value1, String value2) {
            addCriterion("Machine_NO not between", value1, value2, "machineNo");
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

        public Criteria andPartNoIsNull() {
            addCriterion("Part_NO is null");
            return (Criteria) this;
        }

        public Criteria andPartNoIsNotNull() {
            addCriterion("Part_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPartNoEqualTo(String value) {
            addCriterion("Part_NO =", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoNotEqualTo(String value) {
            addCriterion("Part_NO <>", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoGreaterThan(String value) {
            addCriterion("Part_NO >", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoGreaterThanOrEqualTo(String value) {
            addCriterion("Part_NO >=", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoLessThan(String value) {
            addCriterion("Part_NO <", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoLessThanOrEqualTo(String value) {
            addCriterion("Part_NO <=", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoLike(String value) {
            addCriterion("Part_NO like", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoNotLike(String value) {
            addCriterion("Part_NO not like", value, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoIn(List<String> values) {
            addCriterion("Part_NO in", values, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoNotIn(List<String> values) {
            addCriterion("Part_NO not in", values, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoBetween(String value1, String value2) {
            addCriterion("Part_NO between", value1, value2, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoNotBetween(String value1, String value2) {
            addCriterion("Part_NO not between", value1, value2, "partNo");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationIsNull() {
            addCriterion("Part_NO_Abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationIsNotNull() {
            addCriterion("Part_NO_Abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationEqualTo(String value) {
            addCriterion("Part_NO_Abbreviation =", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationNotEqualTo(String value) {
            addCriterion("Part_NO_Abbreviation <>", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationGreaterThan(String value) {
            addCriterion("Part_NO_Abbreviation >", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("Part_NO_Abbreviation >=", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationLessThan(String value) {
            addCriterion("Part_NO_Abbreviation <", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("Part_NO_Abbreviation <=", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationLike(String value) {
            addCriterion("Part_NO_Abbreviation like", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationNotLike(String value) {
            addCriterion("Part_NO_Abbreviation not like", value, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationIn(List<String> values) {
            addCriterion("Part_NO_Abbreviation in", values, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationNotIn(List<String> values) {
            addCriterion("Part_NO_Abbreviation not in", values, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationBetween(String value1, String value2) {
            addCriterion("Part_NO_Abbreviation between", value1, value2, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andPartNoAbbreviationNotBetween(String value1, String value2) {
            addCriterion("Part_NO_Abbreviation not between", value1, value2, "partNoAbbreviation");
            return (Criteria) this;
        }

        public Criteria andCodeLevelIsNull() {
            addCriterion("Code_Level is null");
            return (Criteria) this;
        }

        public Criteria andCodeLevelIsNotNull() {
            addCriterion("Code_Level is not null");
            return (Criteria) this;
        }

        public Criteria andCodeLevelEqualTo(Integer value) {
            addCriterion("Code_Level =", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelNotEqualTo(Integer value) {
            addCriterion("Code_Level <>", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelGreaterThan(Integer value) {
            addCriterion("Code_Level >", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("Code_Level >=", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelLessThan(Integer value) {
            addCriterion("Code_Level <", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("Code_Level <=", value, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelIn(List<Integer> values) {
            addCriterion("Code_Level in", values, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelNotIn(List<Integer> values) {
            addCriterion("Code_Level not in", values, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelBetween(Integer value1, Integer value2) {
            addCriterion("Code_Level between", value1, value2, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andCodeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("Code_Level not between", value1, value2, "codeLevel");
            return (Criteria) this;
        }

        public Criteria andPartStatusIsNull() {
            addCriterion("Part_Status is null");
            return (Criteria) this;
        }

        public Criteria andPartStatusIsNotNull() {
            addCriterion("Part_Status is not null");
            return (Criteria) this;
        }

        public Criteria andPartStatusEqualTo(Integer value) {
            addCriterion("Part_Status =", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusNotEqualTo(Integer value) {
            addCriterion("Part_Status <>", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusGreaterThan(Integer value) {
            addCriterion("Part_Status >", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Part_Status >=", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusLessThan(Integer value) {
            addCriterion("Part_Status <", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Part_Status <=", value, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusIn(List<Integer> values) {
            addCriterion("Part_Status in", values, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusNotIn(List<Integer> values) {
            addCriterion("Part_Status not in", values, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusBetween(Integer value1, Integer value2) {
            addCriterion("Part_Status between", value1, value2, "partStatus");
            return (Criteria) this;
        }

        public Criteria andPartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Part_Status not between", value1, value2, "partStatus");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1IsNull() {
            addCriterion("Complete_Distance_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1IsNotNull() {
            addCriterion("Complete_Distance_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1EqualTo(Float value) {
            addCriterion("Complete_Distance_Press1 =", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1NotEqualTo(Float value) {
            addCriterion("Complete_Distance_Press1 <>", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1GreaterThan(Float value) {
            addCriterion("Complete_Distance_Press1 >", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press1 >=", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1LessThan(Float value) {
            addCriterion("Complete_Distance_Press1 <", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1LessThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press1 <=", value, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1In(List<Float> values) {
            addCriterion("Complete_Distance_Press1 in", values, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1NotIn(List<Float> values) {
            addCriterion("Complete_Distance_Press1 not in", values, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1Between(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press1 between", value1, value2, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress1NotBetween(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press1 not between", value1, value2, "completeDistancePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1IsNull() {
            addCriterion("Insert_Force_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1IsNotNull() {
            addCriterion("Insert_Force_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1EqualTo(Float value) {
            addCriterion("Insert_Force_Press1 =", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1NotEqualTo(Float value) {
            addCriterion("Insert_Force_Press1 <>", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1GreaterThan(Float value) {
            addCriterion("Insert_Force_Press1 >", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press1 >=", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1LessThan(Float value) {
            addCriterion("Insert_Force_Press1 <", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press1 <=", value, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1In(List<Float> values) {
            addCriterion("Insert_Force_Press1 in", values, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1NotIn(List<Float> values) {
            addCriterion("Insert_Force_Press1 not in", values, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Press1 between", value1, value2, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Press1 not between", value1, value2, "insertForcePress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1IsNull() {
            addCriterion("Insert_Force_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1IsNotNull() {
            addCriterion("Insert_Force_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1EqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press1 =", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1NotEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press1 <>", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1GreaterThan(Float value) {
            addCriterion("Insert_Force_Min_Press1 >", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press1 >=", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1LessThan(Float value) {
            addCriterion("Insert_Force_Min_Press1 <", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press1 <=", value, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1In(List<Float> values) {
            addCriterion("Insert_Force_Min_Press1 in", values, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1NotIn(List<Float> values) {
            addCriterion("Insert_Force_Min_Press1 not in", values, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press1 between", value1, value2, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press1 not between", value1, value2, "insertForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1IsNull() {
            addCriterion("Insert_Force_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1IsNotNull() {
            addCriterion("Insert_Force_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1EqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press1 =", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1NotEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press1 <>", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1GreaterThan(Float value) {
            addCriterion("Insert_Force_Max_Press1 >", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press1 >=", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1LessThan(Float value) {
            addCriterion("Insert_Force_Max_Press1 <", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press1 <=", value, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1In(List<Float> values) {
            addCriterion("Insert_Force_Max_Press1 in", values, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1NotIn(List<Float> values) {
            addCriterion("Insert_Force_Max_Press1 not in", values, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press1 between", value1, value2, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press1 not between", value1, value2, "insertForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1IsNull() {
            addCriterion("Insert_Position_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1IsNotNull() {
            addCriterion("Insert_Position_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1EqualTo(Float value) {
            addCriterion("Insert_Position_Press1 =", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1NotEqualTo(Float value) {
            addCriterion("Insert_Position_Press1 <>", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1GreaterThan(Float value) {
            addCriterion("Insert_Position_Press1 >", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press1 >=", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1LessThan(Float value) {
            addCriterion("Insert_Position_Press1 <", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press1 <=", value, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1In(List<Float> values) {
            addCriterion("Insert_Position_Press1 in", values, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1NotIn(List<Float> values) {
            addCriterion("Insert_Position_Press1 not in", values, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Press1 between", value1, value2, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Press1 not between", value1, value2, "insertPositionPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1IsNull() {
            addCriterion("Insert_Position_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1IsNotNull() {
            addCriterion("Insert_Position_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1EqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press1 =", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1NotEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press1 <>", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1GreaterThan(Float value) {
            addCriterion("Insert_Position_Min_Press1 >", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press1 >=", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1LessThan(Float value) {
            addCriterion("Insert_Position_Min_Press1 <", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press1 <=", value, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1In(List<Float> values) {
            addCriterion("Insert_Position_Min_Press1 in", values, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1NotIn(List<Float> values) {
            addCriterion("Insert_Position_Min_Press1 not in", values, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press1 between", value1, value2, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press1 not between", value1, value2, "insertPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1IsNull() {
            addCriterion("Insert_Position_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1IsNotNull() {
            addCriterion("Insert_Position_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1EqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press1 =", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1NotEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press1 <>", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1GreaterThan(Float value) {
            addCriterion("Insert_Position_Max_Press1 >", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press1 >=", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1LessThan(Float value) {
            addCriterion("Insert_Position_Max_Press1 <", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press1 <=", value, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1In(List<Float> values) {
            addCriterion("Insert_Position_Max_Press1 in", values, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1NotIn(List<Float> values) {
            addCriterion("Insert_Position_Max_Press1 not in", values, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press1 between", value1, value2, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press1 not between", value1, value2, "insertPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1IsNull() {
            addCriterion("Press_in_Force_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1IsNotNull() {
            addCriterion("Press_in_Force_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1EqualTo(Float value) {
            addCriterion("Press_in_Force_Press1 =", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Press1 <>", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1GreaterThan(Float value) {
            addCriterion("Press_in_Force_Press1 >", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press1 >=", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1LessThan(Float value) {
            addCriterion("Press_in_Force_Press1 <", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press1 <=", value, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1In(List<Float> values) {
            addCriterion("Press_in_Force_Press1 in", values, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Press1 not in", values, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press1 between", value1, value2, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press1 not between", value1, value2, "pressInForcePress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1IsNull() {
            addCriterion("Press_in_Force_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1IsNotNull() {
            addCriterion("Press_in_Force_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1EqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press1 =", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press1 <>", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1GreaterThan(Float value) {
            addCriterion("Press_in_Force_Min_Press1 >", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press1 >=", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1LessThan(Float value) {
            addCriterion("Press_in_Force_Min_Press1 <", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press1 <=", value, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1In(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press1 in", values, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press1 not in", values, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press1 between", value1, value2, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press1 not between", value1, value2, "pressInForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1IsNull() {
            addCriterion("Press_in_Force_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1IsNotNull() {
            addCriterion("Press_in_Force_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1EqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press1 =", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press1 <>", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1GreaterThan(Float value) {
            addCriterion("Press_in_Force_Max_Press1 >", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press1 >=", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1LessThan(Float value) {
            addCriterion("Press_in_Force_Max_Press1 <", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press1 <=", value, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1In(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press1 in", values, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press1 not in", values, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press1 between", value1, value2, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press1 not between", value1, value2, "pressInForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1IsNull() {
            addCriterion("Press_in_Position_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1IsNotNull() {
            addCriterion("Press_in_Position_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1EqualTo(Float value) {
            addCriterion("Press_in_Position_Press1 =", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Press1 <>", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1GreaterThan(Float value) {
            addCriterion("Press_in_Position_Press1 >", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press1 >=", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1LessThan(Float value) {
            addCriterion("Press_in_Position_Press1 <", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press1 <=", value, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1In(List<Float> values) {
            addCriterion("Press_in_Position_Press1 in", values, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Press1 not in", values, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press1 between", value1, value2, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press1 not between", value1, value2, "pressInPositionPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1IsNull() {
            addCriterion("Press_in_Position_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1IsNotNull() {
            addCriterion("Press_in_Position_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1EqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press1 =", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press1 <>", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1GreaterThan(Float value) {
            addCriterion("Press_in_Position_Min_Press1 >", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press1 >=", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1LessThan(Float value) {
            addCriterion("Press_in_Position_Min_Press1 <", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press1 <=", value, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1In(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press1 in", values, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press1 not in", values, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press1 between", value1, value2, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press1 not between", value1, value2, "pressInPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1IsNull() {
            addCriterion("Press_in_Position_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1IsNotNull() {
            addCriterion("Press_in_Position_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1EqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press1 =", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press1 <>", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1GreaterThan(Float value) {
            addCriterion("Press_in_Position_Max_Press1 >", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press1 >=", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1LessThan(Float value) {
            addCriterion("Press_in_Position_Max_Press1 <", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press1 <=", value, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1In(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press1 in", values, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press1 not in", values, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press1 between", value1, value2, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press1 not between", value1, value2, "pressInPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1IsNull() {
            addCriterion("Final_Force_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1IsNotNull() {
            addCriterion("Final_Force_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1EqualTo(Float value) {
            addCriterion("Final_Force_Press1 =", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1NotEqualTo(Float value) {
            addCriterion("Final_Force_Press1 <>", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1GreaterThan(Float value) {
            addCriterion("Final_Force_Press1 >", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press1 >=", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1LessThan(Float value) {
            addCriterion("Final_Force_Press1 <", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press1 <=", value, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1In(List<Float> values) {
            addCriterion("Final_Force_Press1 in", values, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1NotIn(List<Float> values) {
            addCriterion("Final_Force_Press1 not in", values, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1Between(Float value1, Float value2) {
            addCriterion("Final_Force_Press1 between", value1, value2, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Press1 not between", value1, value2, "finalForcePress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1IsNull() {
            addCriterion("Final_Force_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1IsNotNull() {
            addCriterion("Final_Force_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1EqualTo(Float value) {
            addCriterion("Final_Force_Min_Press1 =", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1NotEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press1 <>", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1GreaterThan(Float value) {
            addCriterion("Final_Force_Min_Press1 >", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press1 >=", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1LessThan(Float value) {
            addCriterion("Final_Force_Min_Press1 <", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press1 <=", value, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1In(List<Float> values) {
            addCriterion("Final_Force_Min_Press1 in", values, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1NotIn(List<Float> values) {
            addCriterion("Final_Force_Min_Press1 not in", values, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1Between(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press1 between", value1, value2, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press1 not between", value1, value2, "finalForceMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1IsNull() {
            addCriterion("Final_Force_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1IsNotNull() {
            addCriterion("Final_Force_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1EqualTo(Float value) {
            addCriterion("Final_Force_Max_Press1 =", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1NotEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press1 <>", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1GreaterThan(Float value) {
            addCriterion("Final_Force_Max_Press1 >", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press1 >=", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1LessThan(Float value) {
            addCriterion("Final_Force_Max_Press1 <", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press1 <=", value, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1In(List<Float> values) {
            addCriterion("Final_Force_Max_Press1 in", values, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1NotIn(List<Float> values) {
            addCriterion("Final_Force_Max_Press1 not in", values, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1Between(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press1 between", value1, value2, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press1 not between", value1, value2, "finalForceMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1IsNull() {
            addCriterion("Final_Position_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1IsNotNull() {
            addCriterion("Final_Position_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1EqualTo(Float value) {
            addCriterion("Final_Position_Press1 =", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1NotEqualTo(Float value) {
            addCriterion("Final_Position_Press1 <>", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1GreaterThan(Float value) {
            addCriterion("Final_Position_Press1 >", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press1 >=", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1LessThan(Float value) {
            addCriterion("Final_Position_Press1 <", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press1 <=", value, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1In(List<Float> values) {
            addCriterion("Final_Position_Press1 in", values, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1NotIn(List<Float> values) {
            addCriterion("Final_Position_Press1 not in", values, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1Between(Float value1, Float value2) {
            addCriterion("Final_Position_Press1 between", value1, value2, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Press1 not between", value1, value2, "finalPositionPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1IsNull() {
            addCriterion("Final_Position_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1IsNotNull() {
            addCriterion("Final_Position_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1EqualTo(Float value) {
            addCriterion("Final_Position_Min_Press1 =", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1NotEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press1 <>", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1GreaterThan(Float value) {
            addCriterion("Final_Position_Min_Press1 >", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press1 >=", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1LessThan(Float value) {
            addCriterion("Final_Position_Min_Press1 <", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press1 <=", value, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1In(List<Float> values) {
            addCriterion("Final_Position_Min_Press1 in", values, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1NotIn(List<Float> values) {
            addCriterion("Final_Position_Min_Press1 not in", values, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1Between(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press1 between", value1, value2, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press1 not between", value1, value2, "finalPositionMinPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1IsNull() {
            addCriterion("Final_Position_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1IsNotNull() {
            addCriterion("Final_Position_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1EqualTo(Float value) {
            addCriterion("Final_Position_Max_Press1 =", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1NotEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press1 <>", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1GreaterThan(Float value) {
            addCriterion("Final_Position_Max_Press1 >", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press1 >=", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1LessThan(Float value) {
            addCriterion("Final_Position_Max_Press1 <", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press1 <=", value, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1In(List<Float> values) {
            addCriterion("Final_Position_Max_Press1 in", values, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1NotIn(List<Float> values) {
            addCriterion("Final_Position_Max_Press1 not in", values, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1Between(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press1 between", value1, value2, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press1 not between", value1, value2, "finalPositionMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1IsNull() {
            addCriterion("Press_in_Speed_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1IsNotNull() {
            addCriterion("Press_in_Speed_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1EqualTo(Float value) {
            addCriterion("Press_in_Speed_Press1 =", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press1 <>", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Press1 >", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press1 >=", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1LessThan(Float value) {
            addCriterion("Press_in_Speed_Press1 <", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press1 <=", value, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1In(List<Float> values) {
            addCriterion("Press_in_Speed_Press1 in", values, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Press1 not in", values, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press1 between", value1, value2, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press1 not between", value1, value2, "pressInSpeedPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1IsNull() {
            addCriterion("Press_in_Speed_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1IsNotNull() {
            addCriterion("Press_in_Speed_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1EqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 =", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 <>", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 >", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 >=", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1LessThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 <", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press1 <=", value, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1In(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press1 in", values, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press1 not in", values, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press1 between", value1, value2, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press1 not between", value1, value2, "pressInSpeedMinPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1IsNull() {
            addCriterion("Press_in_Spedd_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1IsNotNull() {
            addCriterion("Press_in_Spedd_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1EqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 =", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1NotEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 <>", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1GreaterThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 >", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 >=", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1LessThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 <", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press1 <=", value, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1In(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press1 in", values, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1NotIn(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press1 not in", values, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1Between(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press1 between", value1, value2, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press1 not between", value1, value2, "pressInSpeddMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1IsNull() {
            addCriterion("Slope_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andSlopePress1IsNotNull() {
            addCriterion("Slope_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopePress1EqualTo(Float value) {
            addCriterion("Slope_Press1 =", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1NotEqualTo(Float value) {
            addCriterion("Slope_Press1 <>", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1GreaterThan(Float value) {
            addCriterion("Slope_Press1 >", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Press1 >=", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1LessThan(Float value) {
            addCriterion("Slope_Press1 <", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Press1 <=", value, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1In(List<Float> values) {
            addCriterion("Slope_Press1 in", values, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1NotIn(List<Float> values) {
            addCriterion("Slope_Press1 not in", values, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1Between(Float value1, Float value2) {
            addCriterion("Slope_Press1 between", value1, value2, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopePress1NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Press1 not between", value1, value2, "slopePress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1IsNull() {
            addCriterion("Slope_Min_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1IsNotNull() {
            addCriterion("Slope_Min_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1EqualTo(Float value) {
            addCriterion("Slope_Min_Press1 =", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1NotEqualTo(Float value) {
            addCriterion("Slope_Min_Press1 <>", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1GreaterThan(Float value) {
            addCriterion("Slope_Min_Press1 >", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press1 >=", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1LessThan(Float value) {
            addCriterion("Slope_Min_Press1 <", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press1 <=", value, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1In(List<Float> values) {
            addCriterion("Slope_Min_Press1 in", values, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1NotIn(List<Float> values) {
            addCriterion("Slope_Min_Press1 not in", values, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1Between(Float value1, Float value2) {
            addCriterion("Slope_Min_Press1 between", value1, value2, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress1NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Min_Press1 not between", value1, value2, "slopeMinPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1IsNull() {
            addCriterion("Slope_Max_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1IsNotNull() {
            addCriterion("Slope_Max_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1EqualTo(Float value) {
            addCriterion("Slope_Max_Press1 =", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1NotEqualTo(Float value) {
            addCriterion("Slope_Max_Press1 <>", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1GreaterThan(Float value) {
            addCriterion("Slope_Max_Press1 >", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press1 >=", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1LessThan(Float value) {
            addCriterion("Slope_Max_Press1 <", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press1 <=", value, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1In(List<Float> values) {
            addCriterion("Slope_Max_Press1 in", values, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1NotIn(List<Float> values) {
            addCriterion("Slope_Max_Press1 not in", values, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1Between(Float value1, Float value2) {
            addCriterion("Slope_Max_Press1 between", value1, value2, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress1NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Max_Press1 not between", value1, value2, "slopeMaxPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1IsNull() {
            addCriterion("Component_BatchNO_Press1 is null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1IsNotNull() {
            addCriterion("Component_BatchNO_Press1 is not null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1EqualTo(String value) {
            addCriterion("Component_BatchNO_Press1 =", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1NotEqualTo(String value) {
            addCriterion("Component_BatchNO_Press1 <>", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1GreaterThan(String value) {
            addCriterion("Component_BatchNO_Press1 >", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1GreaterThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press1 >=", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1LessThan(String value) {
            addCriterion("Component_BatchNO_Press1 <", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1LessThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press1 <=", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1Like(String value) {
            addCriterion("Component_BatchNO_Press1 like", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1NotLike(String value) {
            addCriterion("Component_BatchNO_Press1 not like", value, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1In(List<String> values) {
            addCriterion("Component_BatchNO_Press1 in", values, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1NotIn(List<String> values) {
            addCriterion("Component_BatchNO_Press1 not in", values, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1Between(String value1, String value2) {
            addCriterion("Component_BatchNO_Press1 between", value1, value2, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress1NotBetween(String value1, String value2) {
            addCriterion("Component_BatchNO_Press1 not between", value1, value2, "componentBatchnoPress1");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2IsNull() {
            addCriterion("Complete_Distance_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2IsNotNull() {
            addCriterion("Complete_Distance_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2EqualTo(Float value) {
            addCriterion("Complete_Distance_Press2 =", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2NotEqualTo(Float value) {
            addCriterion("Complete_Distance_Press2 <>", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2GreaterThan(Float value) {
            addCriterion("Complete_Distance_Press2 >", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press2 >=", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2LessThan(Float value) {
            addCriterion("Complete_Distance_Press2 <", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2LessThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press2 <=", value, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2In(List<Float> values) {
            addCriterion("Complete_Distance_Press2 in", values, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2NotIn(List<Float> values) {
            addCriterion("Complete_Distance_Press2 not in", values, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2Between(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press2 between", value1, value2, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress2NotBetween(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press2 not between", value1, value2, "completeDistancePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2IsNull() {
            addCriterion("Insert_Force_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2IsNotNull() {
            addCriterion("Insert_Force_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2EqualTo(Float value) {
            addCriterion("Insert_Force_Press2 =", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2NotEqualTo(Float value) {
            addCriterion("Insert_Force_Press2 <>", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2GreaterThan(Float value) {
            addCriterion("Insert_Force_Press2 >", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press2 >=", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2LessThan(Float value) {
            addCriterion("Insert_Force_Press2 <", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press2 <=", value, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2In(List<Float> values) {
            addCriterion("Insert_Force_Press2 in", values, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2NotIn(List<Float> values) {
            addCriterion("Insert_Force_Press2 not in", values, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Press2 between", value1, value2, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Press2 not between", value1, value2, "insertForcePress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2IsNull() {
            addCriterion("Insert_Force_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2IsNotNull() {
            addCriterion("Insert_Force_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2EqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press2 =", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2NotEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press2 <>", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2GreaterThan(Float value) {
            addCriterion("Insert_Force_Min_Press2 >", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press2 >=", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2LessThan(Float value) {
            addCriterion("Insert_Force_Min_Press2 <", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press2 <=", value, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2In(List<Float> values) {
            addCriterion("Insert_Force_Min_Press2 in", values, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2NotIn(List<Float> values) {
            addCriterion("Insert_Force_Min_Press2 not in", values, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press2 between", value1, value2, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press2 not between", value1, value2, "insertForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2IsNull() {
            addCriterion("Insert_Force_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2IsNotNull() {
            addCriterion("Insert_Force_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2EqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press2 =", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2NotEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press2 <>", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2GreaterThan(Float value) {
            addCriterion("Insert_Force_Max_Press2 >", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press2 >=", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2LessThan(Float value) {
            addCriterion("Insert_Force_Max_Press2 <", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press2 <=", value, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2In(List<Float> values) {
            addCriterion("Insert_Force_Max_Press2 in", values, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2NotIn(List<Float> values) {
            addCriterion("Insert_Force_Max_Press2 not in", values, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press2 between", value1, value2, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press2 not between", value1, value2, "insertForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2IsNull() {
            addCriterion("Insert_Position_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2IsNotNull() {
            addCriterion("Insert_Position_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2EqualTo(Float value) {
            addCriterion("Insert_Position_Press2 =", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2NotEqualTo(Float value) {
            addCriterion("Insert_Position_Press2 <>", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2GreaterThan(Float value) {
            addCriterion("Insert_Position_Press2 >", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press2 >=", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2LessThan(Float value) {
            addCriterion("Insert_Position_Press2 <", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press2 <=", value, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2In(List<Float> values) {
            addCriterion("Insert_Position_Press2 in", values, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2NotIn(List<Float> values) {
            addCriterion("Insert_Position_Press2 not in", values, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Press2 between", value1, value2, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Press2 not between", value1, value2, "insertPositionPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2IsNull() {
            addCriterion("Insert_Position_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2IsNotNull() {
            addCriterion("Insert_Position_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2EqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press2 =", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2NotEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press2 <>", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2GreaterThan(Float value) {
            addCriterion("Insert_Position_Min_Press2 >", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press2 >=", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2LessThan(Float value) {
            addCriterion("Insert_Position_Min_Press2 <", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press2 <=", value, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2In(List<Float> values) {
            addCriterion("Insert_Position_Min_Press2 in", values, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2NotIn(List<Float> values) {
            addCriterion("Insert_Position_Min_Press2 not in", values, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press2 between", value1, value2, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press2 not between", value1, value2, "insertPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2IsNull() {
            addCriterion("Insert_Position_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2IsNotNull() {
            addCriterion("Insert_Position_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2EqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press2 =", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2NotEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press2 <>", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2GreaterThan(Float value) {
            addCriterion("Insert_Position_Max_Press2 >", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press2 >=", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2LessThan(Float value) {
            addCriterion("Insert_Position_Max_Press2 <", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press2 <=", value, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2In(List<Float> values) {
            addCriterion("Insert_Position_Max_Press2 in", values, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2NotIn(List<Float> values) {
            addCriterion("Insert_Position_Max_Press2 not in", values, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press2 between", value1, value2, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press2 not between", value1, value2, "insertPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2IsNull() {
            addCriterion("Press_in_Force_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2IsNotNull() {
            addCriterion("Press_in_Force_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2EqualTo(Float value) {
            addCriterion("Press_in_Force_Press2 =", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Press2 <>", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2GreaterThan(Float value) {
            addCriterion("Press_in_Force_Press2 >", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press2 >=", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2LessThan(Float value) {
            addCriterion("Press_in_Force_Press2 <", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press2 <=", value, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2In(List<Float> values) {
            addCriterion("Press_in_Force_Press2 in", values, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Press2 not in", values, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press2 between", value1, value2, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press2 not between", value1, value2, "pressInForcePress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2IsNull() {
            addCriterion("Press_in_Force_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2IsNotNull() {
            addCriterion("Press_in_Force_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2EqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press2 =", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press2 <>", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2GreaterThan(Float value) {
            addCriterion("Press_in_Force_Min_Press2 >", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press2 >=", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2LessThan(Float value) {
            addCriterion("Press_in_Force_Min_Press2 <", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press2 <=", value, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2In(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press2 in", values, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press2 not in", values, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press2 between", value1, value2, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press2 not between", value1, value2, "pressInForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2IsNull() {
            addCriterion("Press_in_Force_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2IsNotNull() {
            addCriterion("Press_in_Force_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2EqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press2 =", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press2 <>", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2GreaterThan(Float value) {
            addCriterion("Press_in_Force_Max_Press2 >", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press2 >=", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2LessThan(Float value) {
            addCriterion("Press_in_Force_Max_Press2 <", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press2 <=", value, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2In(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press2 in", values, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press2 not in", values, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press2 between", value1, value2, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press2 not between", value1, value2, "pressInForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2IsNull() {
            addCriterion("Press_in_Position_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2IsNotNull() {
            addCriterion("Press_in_Position_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2EqualTo(Float value) {
            addCriterion("Press_in_Position_Press2 =", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Press2 <>", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2GreaterThan(Float value) {
            addCriterion("Press_in_Position_Press2 >", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press2 >=", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2LessThan(Float value) {
            addCriterion("Press_in_Position_Press2 <", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press2 <=", value, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2In(List<Float> values) {
            addCriterion("Press_in_Position_Press2 in", values, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Press2 not in", values, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press2 between", value1, value2, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press2 not between", value1, value2, "pressInPositionPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2IsNull() {
            addCriterion("Press_in_Position_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2IsNotNull() {
            addCriterion("Press_in_Position_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2EqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press2 =", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press2 <>", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2GreaterThan(Float value) {
            addCriterion("Press_in_Position_Min_Press2 >", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press2 >=", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2LessThan(Float value) {
            addCriterion("Press_in_Position_Min_Press2 <", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press2 <=", value, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2In(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press2 in", values, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press2 not in", values, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press2 between", value1, value2, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press2 not between", value1, value2, "pressInPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2IsNull() {
            addCriterion("Press_in_Position_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2IsNotNull() {
            addCriterion("Press_in_Position_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2EqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press2 =", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press2 <>", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2GreaterThan(Float value) {
            addCriterion("Press_in_Position_Max_Press2 >", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press2 >=", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2LessThan(Float value) {
            addCriterion("Press_in_Position_Max_Press2 <", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press2 <=", value, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2In(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press2 in", values, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press2 not in", values, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press2 between", value1, value2, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press2 not between", value1, value2, "pressInPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2IsNull() {
            addCriterion("Final_Force_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2IsNotNull() {
            addCriterion("Final_Force_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2EqualTo(Float value) {
            addCriterion("Final_Force_Press2 =", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2NotEqualTo(Float value) {
            addCriterion("Final_Force_Press2 <>", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2GreaterThan(Float value) {
            addCriterion("Final_Force_Press2 >", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press2 >=", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2LessThan(Float value) {
            addCriterion("Final_Force_Press2 <", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press2 <=", value, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2In(List<Float> values) {
            addCriterion("Final_Force_Press2 in", values, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2NotIn(List<Float> values) {
            addCriterion("Final_Force_Press2 not in", values, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2Between(Float value1, Float value2) {
            addCriterion("Final_Force_Press2 between", value1, value2, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Press2 not between", value1, value2, "finalForcePress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2IsNull() {
            addCriterion("Final_Force_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2IsNotNull() {
            addCriterion("Final_Force_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2EqualTo(Float value) {
            addCriterion("Final_Force_Min_Press2 =", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2NotEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press2 <>", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2GreaterThan(Float value) {
            addCriterion("Final_Force_Min_Press2 >", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press2 >=", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2LessThan(Float value) {
            addCriterion("Final_Force_Min_Press2 <", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press2 <=", value, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2In(List<Float> values) {
            addCriterion("Final_Force_Min_Press2 in", values, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2NotIn(List<Float> values) {
            addCriterion("Final_Force_Min_Press2 not in", values, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2Between(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press2 between", value1, value2, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press2 not between", value1, value2, "finalForceMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2IsNull() {
            addCriterion("Final_Force_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2IsNotNull() {
            addCriterion("Final_Force_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2EqualTo(Float value) {
            addCriterion("Final_Force_Max_Press2 =", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2NotEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press2 <>", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2GreaterThan(Float value) {
            addCriterion("Final_Force_Max_Press2 >", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press2 >=", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2LessThan(Float value) {
            addCriterion("Final_Force_Max_Press2 <", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press2 <=", value, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2In(List<Float> values) {
            addCriterion("Final_Force_Max_Press2 in", values, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2NotIn(List<Float> values) {
            addCriterion("Final_Force_Max_Press2 not in", values, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2Between(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press2 between", value1, value2, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press2 not between", value1, value2, "finalForceMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2IsNull() {
            addCriterion("Final_Position_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2IsNotNull() {
            addCriterion("Final_Position_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2EqualTo(Float value) {
            addCriterion("Final_Position_Press2 =", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2NotEqualTo(Float value) {
            addCriterion("Final_Position_Press2 <>", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2GreaterThan(Float value) {
            addCriterion("Final_Position_Press2 >", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press2 >=", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2LessThan(Float value) {
            addCriterion("Final_Position_Press2 <", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press2 <=", value, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2In(List<Float> values) {
            addCriterion("Final_Position_Press2 in", values, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2NotIn(List<Float> values) {
            addCriterion("Final_Position_Press2 not in", values, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2Between(Float value1, Float value2) {
            addCriterion("Final_Position_Press2 between", value1, value2, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Press2 not between", value1, value2, "finalPositionPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2IsNull() {
            addCriterion("Final_Position_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2IsNotNull() {
            addCriterion("Final_Position_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2EqualTo(Float value) {
            addCriterion("Final_Position_Min_Press2 =", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2NotEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press2 <>", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2GreaterThan(Float value) {
            addCriterion("Final_Position_Min_Press2 >", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press2 >=", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2LessThan(Float value) {
            addCriterion("Final_Position_Min_Press2 <", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press2 <=", value, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2In(List<Float> values) {
            addCriterion("Final_Position_Min_Press2 in", values, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2NotIn(List<Float> values) {
            addCriterion("Final_Position_Min_Press2 not in", values, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2Between(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press2 between", value1, value2, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press2 not between", value1, value2, "finalPositionMinPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2IsNull() {
            addCriterion("Final_Position_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2IsNotNull() {
            addCriterion("Final_Position_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2EqualTo(Float value) {
            addCriterion("Final_Position_Max_Press2 =", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2NotEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press2 <>", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2GreaterThan(Float value) {
            addCriterion("Final_Position_Max_Press2 >", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press2 >=", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2LessThan(Float value) {
            addCriterion("Final_Position_Max_Press2 <", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press2 <=", value, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2In(List<Float> values) {
            addCriterion("Final_Position_Max_Press2 in", values, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2NotIn(List<Float> values) {
            addCriterion("Final_Position_Max_Press2 not in", values, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2Between(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press2 between", value1, value2, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press2 not between", value1, value2, "finalPositionMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2IsNull() {
            addCriterion("Press_in_Speed_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2IsNotNull() {
            addCriterion("Press_in_Speed_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2EqualTo(Float value) {
            addCriterion("Press_in_Speed_Press2 =", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press2 <>", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Press2 >", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press2 >=", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2LessThan(Float value) {
            addCriterion("Press_in_Speed_Press2 <", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press2 <=", value, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2In(List<Float> values) {
            addCriterion("Press_in_Speed_Press2 in", values, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Press2 not in", values, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press2 between", value1, value2, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press2 not between", value1, value2, "pressInSpeedPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2IsNull() {
            addCriterion("Press_in_Speed_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2IsNotNull() {
            addCriterion("Press_in_Speed_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2EqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 =", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 <>", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 >", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 >=", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2LessThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 <", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press2 <=", value, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2In(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press2 in", values, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press2 not in", values, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press2 between", value1, value2, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press2 not between", value1, value2, "pressInSpeedMinPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2IsNull() {
            addCriterion("Press_in_Spedd_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2IsNotNull() {
            addCriterion("Press_in_Spedd_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2EqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 =", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2NotEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 <>", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2GreaterThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 >", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 >=", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2LessThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 <", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press2 <=", value, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2In(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press2 in", values, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2NotIn(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press2 not in", values, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2Between(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press2 between", value1, value2, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press2 not between", value1, value2, "pressInSpeddMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2IsNull() {
            addCriterion("Slope_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andSlopePress2IsNotNull() {
            addCriterion("Slope_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopePress2EqualTo(Float value) {
            addCriterion("Slope_Press2 =", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2NotEqualTo(Float value) {
            addCriterion("Slope_Press2 <>", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2GreaterThan(Float value) {
            addCriterion("Slope_Press2 >", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Press2 >=", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2LessThan(Float value) {
            addCriterion("Slope_Press2 <", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Press2 <=", value, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2In(List<Float> values) {
            addCriterion("Slope_Press2 in", values, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2NotIn(List<Float> values) {
            addCriterion("Slope_Press2 not in", values, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2Between(Float value1, Float value2) {
            addCriterion("Slope_Press2 between", value1, value2, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopePress2NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Press2 not between", value1, value2, "slopePress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2IsNull() {
            addCriterion("Slope_Min_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2IsNotNull() {
            addCriterion("Slope_Min_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2EqualTo(Float value) {
            addCriterion("Slope_Min_Press2 =", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2NotEqualTo(Float value) {
            addCriterion("Slope_Min_Press2 <>", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2GreaterThan(Float value) {
            addCriterion("Slope_Min_Press2 >", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press2 >=", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2LessThan(Float value) {
            addCriterion("Slope_Min_Press2 <", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press2 <=", value, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2In(List<Float> values) {
            addCriterion("Slope_Min_Press2 in", values, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2NotIn(List<Float> values) {
            addCriterion("Slope_Min_Press2 not in", values, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2Between(Float value1, Float value2) {
            addCriterion("Slope_Min_Press2 between", value1, value2, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress2NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Min_Press2 not between", value1, value2, "slopeMinPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2IsNull() {
            addCriterion("Slope_Max_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2IsNotNull() {
            addCriterion("Slope_Max_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2EqualTo(Float value) {
            addCriterion("Slope_Max_Press2 =", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2NotEqualTo(Float value) {
            addCriterion("Slope_Max_Press2 <>", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2GreaterThan(Float value) {
            addCriterion("Slope_Max_Press2 >", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press2 >=", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2LessThan(Float value) {
            addCriterion("Slope_Max_Press2 <", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press2 <=", value, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2In(List<Float> values) {
            addCriterion("Slope_Max_Press2 in", values, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2NotIn(List<Float> values) {
            addCriterion("Slope_Max_Press2 not in", values, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2Between(Float value1, Float value2) {
            addCriterion("Slope_Max_Press2 between", value1, value2, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress2NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Max_Press2 not between", value1, value2, "slopeMaxPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2IsNull() {
            addCriterion("Component_BatchNO_Press2 is null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2IsNotNull() {
            addCriterion("Component_BatchNO_Press2 is not null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2EqualTo(String value) {
            addCriterion("Component_BatchNO_Press2 =", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2NotEqualTo(String value) {
            addCriterion("Component_BatchNO_Press2 <>", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2GreaterThan(String value) {
            addCriterion("Component_BatchNO_Press2 >", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2GreaterThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press2 >=", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2LessThan(String value) {
            addCriterion("Component_BatchNO_Press2 <", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2LessThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press2 <=", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2Like(String value) {
            addCriterion("Component_BatchNO_Press2 like", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2NotLike(String value) {
            addCriterion("Component_BatchNO_Press2 not like", value, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2In(List<String> values) {
            addCriterion("Component_BatchNO_Press2 in", values, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2NotIn(List<String> values) {
            addCriterion("Component_BatchNO_Press2 not in", values, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2Between(String value1, String value2) {
            addCriterion("Component_BatchNO_Press2 between", value1, value2, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress2NotBetween(String value1, String value2) {
            addCriterion("Component_BatchNO_Press2 not between", value1, value2, "componentBatchnoPress2");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3IsNull() {
            addCriterion("Complete_Distance_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3IsNotNull() {
            addCriterion("Complete_Distance_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3EqualTo(Float value) {
            addCriterion("Complete_Distance_Press3 =", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3NotEqualTo(Float value) {
            addCriterion("Complete_Distance_Press3 <>", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3GreaterThan(Float value) {
            addCriterion("Complete_Distance_Press3 >", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press3 >=", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3LessThan(Float value) {
            addCriterion("Complete_Distance_Press3 <", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3LessThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press3 <=", value, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3In(List<Float> values) {
            addCriterion("Complete_Distance_Press3 in", values, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3NotIn(List<Float> values) {
            addCriterion("Complete_Distance_Press3 not in", values, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3Between(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press3 between", value1, value2, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress3NotBetween(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press3 not between", value1, value2, "completeDistancePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3IsNull() {
            addCriterion("Insert_Force_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3IsNotNull() {
            addCriterion("Insert_Force_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3EqualTo(Float value) {
            addCriterion("Insert_Force_Press3 =", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3NotEqualTo(Float value) {
            addCriterion("Insert_Force_Press3 <>", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3GreaterThan(Float value) {
            addCriterion("Insert_Force_Press3 >", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press3 >=", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3LessThan(Float value) {
            addCriterion("Insert_Force_Press3 <", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press3 <=", value, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3In(List<Float> values) {
            addCriterion("Insert_Force_Press3 in", values, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3NotIn(List<Float> values) {
            addCriterion("Insert_Force_Press3 not in", values, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Press3 between", value1, value2, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Press3 not between", value1, value2, "insertForcePress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3IsNull() {
            addCriterion("Insert_Force_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3IsNotNull() {
            addCriterion("Insert_Force_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3EqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press3 =", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3NotEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press3 <>", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3GreaterThan(Float value) {
            addCriterion("Insert_Force_Min_Press3 >", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press3 >=", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3LessThan(Float value) {
            addCriterion("Insert_Force_Min_Press3 <", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press3 <=", value, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3In(List<Float> values) {
            addCriterion("Insert_Force_Min_Press3 in", values, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3NotIn(List<Float> values) {
            addCriterion("Insert_Force_Min_Press3 not in", values, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press3 between", value1, value2, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press3 not between", value1, value2, "insertForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3IsNull() {
            addCriterion("Insert_Force_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3IsNotNull() {
            addCriterion("Insert_Force_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3EqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press3 =", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3NotEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press3 <>", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3GreaterThan(Float value) {
            addCriterion("Insert_Force_Max_Press3 >", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press3 >=", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3LessThan(Float value) {
            addCriterion("Insert_Force_Max_Press3 <", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press3 <=", value, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3In(List<Float> values) {
            addCriterion("Insert_Force_Max_Press3 in", values, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3NotIn(List<Float> values) {
            addCriterion("Insert_Force_Max_Press3 not in", values, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press3 between", value1, value2, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press3 not between", value1, value2, "insertForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3IsNull() {
            addCriterion("Insert_Position_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3IsNotNull() {
            addCriterion("Insert_Position_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3EqualTo(Float value) {
            addCriterion("Insert_Position_Press3 =", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3NotEqualTo(Float value) {
            addCriterion("Insert_Position_Press3 <>", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3GreaterThan(Float value) {
            addCriterion("Insert_Position_Press3 >", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press3 >=", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3LessThan(Float value) {
            addCriterion("Insert_Position_Press3 <", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press3 <=", value, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3In(List<Float> values) {
            addCriterion("Insert_Position_Press3 in", values, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3NotIn(List<Float> values) {
            addCriterion("Insert_Position_Press3 not in", values, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Press3 between", value1, value2, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Press3 not between", value1, value2, "insertPositionPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3IsNull() {
            addCriterion("Insert_Position_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3IsNotNull() {
            addCriterion("Insert_Position_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3EqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press3 =", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3NotEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press3 <>", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3GreaterThan(Float value) {
            addCriterion("Insert_Position_Min_Press3 >", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press3 >=", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3LessThan(Float value) {
            addCriterion("Insert_Position_Min_Press3 <", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press3 <=", value, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3In(List<Float> values) {
            addCriterion("Insert_Position_Min_Press3 in", values, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3NotIn(List<Float> values) {
            addCriterion("Insert_Position_Min_Press3 not in", values, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press3 between", value1, value2, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press3 not between", value1, value2, "insertPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3IsNull() {
            addCriterion("Insert_Position_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3IsNotNull() {
            addCriterion("Insert_Position_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3EqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press3 =", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3NotEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press3 <>", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3GreaterThan(Float value) {
            addCriterion("Insert_Position_Max_Press3 >", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press3 >=", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3LessThan(Float value) {
            addCriterion("Insert_Position_Max_Press3 <", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press3 <=", value, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3In(List<Float> values) {
            addCriterion("Insert_Position_Max_Press3 in", values, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3NotIn(List<Float> values) {
            addCriterion("Insert_Position_Max_Press3 not in", values, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press3 between", value1, value2, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press3 not between", value1, value2, "insertPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3IsNull() {
            addCriterion("Press_in_Force_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3IsNotNull() {
            addCriterion("Press_in_Force_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3EqualTo(Float value) {
            addCriterion("Press_in_Force_Press3 =", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Press3 <>", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3GreaterThan(Float value) {
            addCriterion("Press_in_Force_Press3 >", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press3 >=", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3LessThan(Float value) {
            addCriterion("Press_in_Force_Press3 <", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press3 <=", value, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3In(List<Float> values) {
            addCriterion("Press_in_Force_Press3 in", values, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Press3 not in", values, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press3 between", value1, value2, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press3 not between", value1, value2, "pressInForcePress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3IsNull() {
            addCriterion("Press_in_Force_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3IsNotNull() {
            addCriterion("Press_in_Force_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3EqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press3 =", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press3 <>", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3GreaterThan(Float value) {
            addCriterion("Press_in_Force_Min_Press3 >", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press3 >=", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3LessThan(Float value) {
            addCriterion("Press_in_Force_Min_Press3 <", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press3 <=", value, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3In(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press3 in", values, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press3 not in", values, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press3 between", value1, value2, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press3 not between", value1, value2, "pressInForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3IsNull() {
            addCriterion("Press_in_Force_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3IsNotNull() {
            addCriterion("Press_in_Force_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3EqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press3 =", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press3 <>", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3GreaterThan(Float value) {
            addCriterion("Press_in_Force_Max_Press3 >", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press3 >=", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3LessThan(Float value) {
            addCriterion("Press_in_Force_Max_Press3 <", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press3 <=", value, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3In(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press3 in", values, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press3 not in", values, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press3 between", value1, value2, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press3 not between", value1, value2, "pressInForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3IsNull() {
            addCriterion("Press_in_Position_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3IsNotNull() {
            addCriterion("Press_in_Position_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3EqualTo(Float value) {
            addCriterion("Press_in_Position_Press3 =", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Press3 <>", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3GreaterThan(Float value) {
            addCriterion("Press_in_Position_Press3 >", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press3 >=", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3LessThan(Float value) {
            addCriterion("Press_in_Position_Press3 <", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press3 <=", value, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3In(List<Float> values) {
            addCriterion("Press_in_Position_Press3 in", values, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Press3 not in", values, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press3 between", value1, value2, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press3 not between", value1, value2, "pressInPositionPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3IsNull() {
            addCriterion("Press_in_Position_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3IsNotNull() {
            addCriterion("Press_in_Position_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3EqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press3 =", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press3 <>", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3GreaterThan(Float value) {
            addCriterion("Press_in_Position_Min_Press3 >", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press3 >=", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3LessThan(Float value) {
            addCriterion("Press_in_Position_Min_Press3 <", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press3 <=", value, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3In(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press3 in", values, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press3 not in", values, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press3 between", value1, value2, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press3 not between", value1, value2, "pressInPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3IsNull() {
            addCriterion("Press_in_Position_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3IsNotNull() {
            addCriterion("Press_in_Position_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3EqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press3 =", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press3 <>", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3GreaterThan(Float value) {
            addCriterion("Press_in_Position_Max_Press3 >", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press3 >=", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3LessThan(Float value) {
            addCriterion("Press_in_Position_Max_Press3 <", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press3 <=", value, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3In(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press3 in", values, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press3 not in", values, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press3 between", value1, value2, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press3 not between", value1, value2, "pressInPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3IsNull() {
            addCriterion("Final_Force_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3IsNotNull() {
            addCriterion("Final_Force_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3EqualTo(Float value) {
            addCriterion("Final_Force_Press3 =", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3NotEqualTo(Float value) {
            addCriterion("Final_Force_Press3 <>", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3GreaterThan(Float value) {
            addCriterion("Final_Force_Press3 >", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press3 >=", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3LessThan(Float value) {
            addCriterion("Final_Force_Press3 <", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press3 <=", value, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3In(List<Float> values) {
            addCriterion("Final_Force_Press3 in", values, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3NotIn(List<Float> values) {
            addCriterion("Final_Force_Press3 not in", values, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3Between(Float value1, Float value2) {
            addCriterion("Final_Force_Press3 between", value1, value2, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Press3 not between", value1, value2, "finalForcePress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3IsNull() {
            addCriterion("Final_Force_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3IsNotNull() {
            addCriterion("Final_Force_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3EqualTo(Float value) {
            addCriterion("Final_Force_Min_Press3 =", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3NotEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press3 <>", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3GreaterThan(Float value) {
            addCriterion("Final_Force_Min_Press3 >", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press3 >=", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3LessThan(Float value) {
            addCriterion("Final_Force_Min_Press3 <", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press3 <=", value, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3In(List<Float> values) {
            addCriterion("Final_Force_Min_Press3 in", values, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3NotIn(List<Float> values) {
            addCriterion("Final_Force_Min_Press3 not in", values, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3Between(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press3 between", value1, value2, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press3 not between", value1, value2, "finalForceMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3IsNull() {
            addCriterion("Final_Force_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3IsNotNull() {
            addCriterion("Final_Force_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3EqualTo(Float value) {
            addCriterion("Final_Force_Max_Press3 =", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3NotEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press3 <>", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3GreaterThan(Float value) {
            addCriterion("Final_Force_Max_Press3 >", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press3 >=", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3LessThan(Float value) {
            addCriterion("Final_Force_Max_Press3 <", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press3 <=", value, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3In(List<Float> values) {
            addCriterion("Final_Force_Max_Press3 in", values, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3NotIn(List<Float> values) {
            addCriterion("Final_Force_Max_Press3 not in", values, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3Between(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press3 between", value1, value2, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press3 not between", value1, value2, "finalForceMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3IsNull() {
            addCriterion("Final_Position_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3IsNotNull() {
            addCriterion("Final_Position_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3EqualTo(Float value) {
            addCriterion("Final_Position_Press3 =", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3NotEqualTo(Float value) {
            addCriterion("Final_Position_Press3 <>", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3GreaterThan(Float value) {
            addCriterion("Final_Position_Press3 >", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press3 >=", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3LessThan(Float value) {
            addCriterion("Final_Position_Press3 <", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press3 <=", value, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3In(List<Float> values) {
            addCriterion("Final_Position_Press3 in", values, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3NotIn(List<Float> values) {
            addCriterion("Final_Position_Press3 not in", values, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3Between(Float value1, Float value2) {
            addCriterion("Final_Position_Press3 between", value1, value2, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Press3 not between", value1, value2, "finalPositionPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3IsNull() {
            addCriterion("Final_Position_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3IsNotNull() {
            addCriterion("Final_Position_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3EqualTo(Float value) {
            addCriterion("Final_Position_Min_Press3 =", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3NotEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press3 <>", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3GreaterThan(Float value) {
            addCriterion("Final_Position_Min_Press3 >", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press3 >=", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3LessThan(Float value) {
            addCriterion("Final_Position_Min_Press3 <", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press3 <=", value, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3In(List<Float> values) {
            addCriterion("Final_Position_Min_Press3 in", values, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3NotIn(List<Float> values) {
            addCriterion("Final_Position_Min_Press3 not in", values, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3Between(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press3 between", value1, value2, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press3 not between", value1, value2, "finalPositionMinPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3IsNull() {
            addCriterion("Final_Position_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3IsNotNull() {
            addCriterion("Final_Position_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3EqualTo(Float value) {
            addCriterion("Final_Position_Max_Press3 =", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3NotEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press3 <>", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3GreaterThan(Float value) {
            addCriterion("Final_Position_Max_Press3 >", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press3 >=", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3LessThan(Float value) {
            addCriterion("Final_Position_Max_Press3 <", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press3 <=", value, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3In(List<Float> values) {
            addCriterion("Final_Position_Max_Press3 in", values, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3NotIn(List<Float> values) {
            addCriterion("Final_Position_Max_Press3 not in", values, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3Between(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press3 between", value1, value2, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press3 not between", value1, value2, "finalPositionMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3IsNull() {
            addCriterion("Press_in_Speed_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3IsNotNull() {
            addCriterion("Press_in_Speed_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3EqualTo(Float value) {
            addCriterion("Press_in_Speed_Press3 =", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press3 <>", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Press3 >", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press3 >=", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3LessThan(Float value) {
            addCriterion("Press_in_Speed_Press3 <", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press3 <=", value, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3In(List<Float> values) {
            addCriterion("Press_in_Speed_Press3 in", values, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Press3 not in", values, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press3 between", value1, value2, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press3 not between", value1, value2, "pressInSpeedPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3IsNull() {
            addCriterion("Press_in_Speed_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3IsNotNull() {
            addCriterion("Press_in_Speed_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3EqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 =", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 <>", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 >", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 >=", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3LessThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 <", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press3 <=", value, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3In(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press3 in", values, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press3 not in", values, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press3 between", value1, value2, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press3 not between", value1, value2, "pressInSpeedMinPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3IsNull() {
            addCriterion("Press_in_Spedd_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3IsNotNull() {
            addCriterion("Press_in_Spedd_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3EqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 =", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3NotEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 <>", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3GreaterThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 >", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 >=", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3LessThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 <", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press3 <=", value, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3In(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press3 in", values, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3NotIn(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press3 not in", values, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3Between(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press3 between", value1, value2, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press3 not between", value1, value2, "pressInSpeddMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3IsNull() {
            addCriterion("Slope_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andSlopePress3IsNotNull() {
            addCriterion("Slope_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopePress3EqualTo(Float value) {
            addCriterion("Slope_Press3 =", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3NotEqualTo(Float value) {
            addCriterion("Slope_Press3 <>", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3GreaterThan(Float value) {
            addCriterion("Slope_Press3 >", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Press3 >=", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3LessThan(Float value) {
            addCriterion("Slope_Press3 <", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Press3 <=", value, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3In(List<Float> values) {
            addCriterion("Slope_Press3 in", values, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3NotIn(List<Float> values) {
            addCriterion("Slope_Press3 not in", values, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3Between(Float value1, Float value2) {
            addCriterion("Slope_Press3 between", value1, value2, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopePress3NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Press3 not between", value1, value2, "slopePress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3IsNull() {
            addCriterion("Slope_Min_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3IsNotNull() {
            addCriterion("Slope_Min_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3EqualTo(Float value) {
            addCriterion("Slope_Min_Press3 =", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3NotEqualTo(Float value) {
            addCriterion("Slope_Min_Press3 <>", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3GreaterThan(Float value) {
            addCriterion("Slope_Min_Press3 >", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press3 >=", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3LessThan(Float value) {
            addCriterion("Slope_Min_Press3 <", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press3 <=", value, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3In(List<Float> values) {
            addCriterion("Slope_Min_Press3 in", values, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3NotIn(List<Float> values) {
            addCriterion("Slope_Min_Press3 not in", values, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3Between(Float value1, Float value2) {
            addCriterion("Slope_Min_Press3 between", value1, value2, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress3NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Min_Press3 not between", value1, value2, "slopeMinPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3IsNull() {
            addCriterion("Slope_Max_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3IsNotNull() {
            addCriterion("Slope_Max_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3EqualTo(Float value) {
            addCriterion("Slope_Max_Press3 =", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3NotEqualTo(Float value) {
            addCriterion("Slope_Max_Press3 <>", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3GreaterThan(Float value) {
            addCriterion("Slope_Max_Press3 >", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press3 >=", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3LessThan(Float value) {
            addCriterion("Slope_Max_Press3 <", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press3 <=", value, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3In(List<Float> values) {
            addCriterion("Slope_Max_Press3 in", values, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3NotIn(List<Float> values) {
            addCriterion("Slope_Max_Press3 not in", values, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3Between(Float value1, Float value2) {
            addCriterion("Slope_Max_Press3 between", value1, value2, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress3NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Max_Press3 not between", value1, value2, "slopeMaxPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3IsNull() {
            addCriterion("Component_BatchNO_Press3 is null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3IsNotNull() {
            addCriterion("Component_BatchNO_Press3 is not null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3EqualTo(String value) {
            addCriterion("Component_BatchNO_Press3 =", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3NotEqualTo(String value) {
            addCriterion("Component_BatchNO_Press3 <>", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3GreaterThan(String value) {
            addCriterion("Component_BatchNO_Press3 >", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3GreaterThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press3 >=", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3LessThan(String value) {
            addCriterion("Component_BatchNO_Press3 <", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3LessThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press3 <=", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3Like(String value) {
            addCriterion("Component_BatchNO_Press3 like", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3NotLike(String value) {
            addCriterion("Component_BatchNO_Press3 not like", value, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3In(List<String> values) {
            addCriterion("Component_BatchNO_Press3 in", values, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3NotIn(List<String> values) {
            addCriterion("Component_BatchNO_Press3 not in", values, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3Between(String value1, String value2) {
            addCriterion("Component_BatchNO_Press3 between", value1, value2, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress3NotBetween(String value1, String value2) {
            addCriterion("Component_BatchNO_Press3 not between", value1, value2, "componentBatchnoPress3");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4IsNull() {
            addCriterion("Complete_Distance_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4IsNotNull() {
            addCriterion("Complete_Distance_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4EqualTo(Float value) {
            addCriterion("Complete_Distance_Press4 =", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4NotEqualTo(Float value) {
            addCriterion("Complete_Distance_Press4 <>", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4GreaterThan(Float value) {
            addCriterion("Complete_Distance_Press4 >", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press4 >=", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4LessThan(Float value) {
            addCriterion("Complete_Distance_Press4 <", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4LessThanOrEqualTo(Float value) {
            addCriterion("Complete_Distance_Press4 <=", value, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4In(List<Float> values) {
            addCriterion("Complete_Distance_Press4 in", values, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4NotIn(List<Float> values) {
            addCriterion("Complete_Distance_Press4 not in", values, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4Between(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press4 between", value1, value2, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andCompleteDistancePress4NotBetween(Float value1, Float value2) {
            addCriterion("Complete_Distance_Press4 not between", value1, value2, "completeDistancePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4IsNull() {
            addCriterion("Insert_Force_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4IsNotNull() {
            addCriterion("Insert_Force_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4EqualTo(Float value) {
            addCriterion("Insert_Force_Press4 =", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4NotEqualTo(Float value) {
            addCriterion("Insert_Force_Press4 <>", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4GreaterThan(Float value) {
            addCriterion("Insert_Force_Press4 >", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press4 >=", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4LessThan(Float value) {
            addCriterion("Insert_Force_Press4 <", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Press4 <=", value, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4In(List<Float> values) {
            addCriterion("Insert_Force_Press4 in", values, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4NotIn(List<Float> values) {
            addCriterion("Insert_Force_Press4 not in", values, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Press4 between", value1, value2, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForcePress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Press4 not between", value1, value2, "insertForcePress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4IsNull() {
            addCriterion("Insert_Force_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4IsNotNull() {
            addCriterion("Insert_Force_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4EqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press4 =", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4NotEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press4 <>", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4GreaterThan(Float value) {
            addCriterion("Insert_Force_Min_Press4 >", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press4 >=", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4LessThan(Float value) {
            addCriterion("Insert_Force_Min_Press4 <", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Min_Press4 <=", value, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4In(List<Float> values) {
            addCriterion("Insert_Force_Min_Press4 in", values, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4NotIn(List<Float> values) {
            addCriterion("Insert_Force_Min_Press4 not in", values, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press4 between", value1, value2, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Min_Press4 not between", value1, value2, "insertForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4IsNull() {
            addCriterion("Insert_Force_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4IsNotNull() {
            addCriterion("Insert_Force_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4EqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press4 =", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4NotEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press4 <>", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4GreaterThan(Float value) {
            addCriterion("Insert_Force_Max_Press4 >", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press4 >=", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4LessThan(Float value) {
            addCriterion("Insert_Force_Max_Press4 <", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Force_Max_Press4 <=", value, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4In(List<Float> values) {
            addCriterion("Insert_Force_Max_Press4 in", values, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4NotIn(List<Float> values) {
            addCriterion("Insert_Force_Max_Press4 not in", values, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4Between(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press4 between", value1, value2, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertForceMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Force_Max_Press4 not between", value1, value2, "insertForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4IsNull() {
            addCriterion("Insert_Position_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4IsNotNull() {
            addCriterion("Insert_Position_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4EqualTo(Float value) {
            addCriterion("Insert_Position_Press4 =", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4NotEqualTo(Float value) {
            addCriterion("Insert_Position_Press4 <>", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4GreaterThan(Float value) {
            addCriterion("Insert_Position_Press4 >", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press4 >=", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4LessThan(Float value) {
            addCriterion("Insert_Position_Press4 <", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Press4 <=", value, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4In(List<Float> values) {
            addCriterion("Insert_Position_Press4 in", values, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4NotIn(List<Float> values) {
            addCriterion("Insert_Position_Press4 not in", values, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Press4 between", value1, value2, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionPress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Press4 not between", value1, value2, "insertPositionPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4IsNull() {
            addCriterion("Insert_Position_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4IsNotNull() {
            addCriterion("Insert_Position_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4EqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press4 =", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4NotEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press4 <>", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4GreaterThan(Float value) {
            addCriterion("Insert_Position_Min_Press4 >", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press4 >=", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4LessThan(Float value) {
            addCriterion("Insert_Position_Min_Press4 <", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Min_Press4 <=", value, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4In(List<Float> values) {
            addCriterion("Insert_Position_Min_Press4 in", values, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4NotIn(List<Float> values) {
            addCriterion("Insert_Position_Min_Press4 not in", values, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press4 between", value1, value2, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Min_Press4 not between", value1, value2, "insertPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4IsNull() {
            addCriterion("Insert_Position_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4IsNotNull() {
            addCriterion("Insert_Position_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4EqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press4 =", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4NotEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press4 <>", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4GreaterThan(Float value) {
            addCriterion("Insert_Position_Max_Press4 >", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press4 >=", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4LessThan(Float value) {
            addCriterion("Insert_Position_Max_Press4 <", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Insert_Position_Max_Press4 <=", value, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4In(List<Float> values) {
            addCriterion("Insert_Position_Max_Press4 in", values, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4NotIn(List<Float> values) {
            addCriterion("Insert_Position_Max_Press4 not in", values, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4Between(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press4 between", value1, value2, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andInsertPositionMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Insert_Position_Max_Press4 not between", value1, value2, "insertPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4IsNull() {
            addCriterion("Press_in_Force_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4IsNotNull() {
            addCriterion("Press_in_Force_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4EqualTo(Float value) {
            addCriterion("Press_in_Force_Press4 =", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Press4 <>", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4GreaterThan(Float value) {
            addCriterion("Press_in_Force_Press4 >", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press4 >=", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4LessThan(Float value) {
            addCriterion("Press_in_Force_Press4 <", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Press4 <=", value, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4In(List<Float> values) {
            addCriterion("Press_in_Force_Press4 in", values, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Press4 not in", values, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press4 between", value1, value2, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForcePress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Press4 not between", value1, value2, "pressInForcePress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4IsNull() {
            addCriterion("Press_in_Force_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4IsNotNull() {
            addCriterion("Press_in_Force_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4EqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press4 =", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press4 <>", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4GreaterThan(Float value) {
            addCriterion("Press_in_Force_Min_Press4 >", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press4 >=", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4LessThan(Float value) {
            addCriterion("Press_in_Force_Min_Press4 <", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Min_Press4 <=", value, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4In(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press4 in", values, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Min_Press4 not in", values, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press4 between", value1, value2, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Min_Press4 not between", value1, value2, "pressInForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4IsNull() {
            addCriterion("Press_in_Force_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4IsNotNull() {
            addCriterion("Press_in_Force_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4EqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press4 =", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press4 <>", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4GreaterThan(Float value) {
            addCriterion("Press_in_Force_Max_Press4 >", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press4 >=", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4LessThan(Float value) {
            addCriterion("Press_in_Force_Max_Press4 <", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Force_Max_Press4 <=", value, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4In(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press4 in", values, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Force_Max_Press4 not in", values, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press4 between", value1, value2, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInForceMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Force_Max_Press4 not between", value1, value2, "pressInForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4IsNull() {
            addCriterion("Press_in_Position_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4IsNotNull() {
            addCriterion("Press_in_Position_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4EqualTo(Float value) {
            addCriterion("Press_in_Position_Press4 =", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Press4 <>", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4GreaterThan(Float value) {
            addCriterion("Press_in_Position_Press4 >", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press4 >=", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4LessThan(Float value) {
            addCriterion("Press_in_Position_Press4 <", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Press4 <=", value, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4In(List<Float> values) {
            addCriterion("Press_in_Position_Press4 in", values, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Press4 not in", values, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press4 between", value1, value2, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Press4 not between", value1, value2, "pressInPositionPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4IsNull() {
            addCriterion("Press_in_Position_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4IsNotNull() {
            addCriterion("Press_in_Position_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4EqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press4 =", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press4 <>", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4GreaterThan(Float value) {
            addCriterion("Press_in_Position_Min_Press4 >", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press4 >=", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4LessThan(Float value) {
            addCriterion("Press_in_Position_Min_Press4 <", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Min_Press4 <=", value, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4In(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press4 in", values, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Min_Press4 not in", values, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press4 between", value1, value2, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Min_Press4 not between", value1, value2, "pressInPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4IsNull() {
            addCriterion("Press_in_Position_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4IsNotNull() {
            addCriterion("Press_in_Position_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4EqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press4 =", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press4 <>", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4GreaterThan(Float value) {
            addCriterion("Press_in_Position_Max_Press4 >", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press4 >=", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4LessThan(Float value) {
            addCriterion("Press_in_Position_Max_Press4 <", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Position_Max_Press4 <=", value, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4In(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press4 in", values, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Position_Max_Press4 not in", values, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press4 between", value1, value2, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInPositionMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Position_Max_Press4 not between", value1, value2, "pressInPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4IsNull() {
            addCriterion("Final_Force_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4IsNotNull() {
            addCriterion("Final_Force_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4EqualTo(Float value) {
            addCriterion("Final_Force_Press4 =", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4NotEqualTo(Float value) {
            addCriterion("Final_Force_Press4 <>", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4GreaterThan(Float value) {
            addCriterion("Final_Force_Press4 >", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press4 >=", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4LessThan(Float value) {
            addCriterion("Final_Force_Press4 <", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Press4 <=", value, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4In(List<Float> values) {
            addCriterion("Final_Force_Press4 in", values, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4NotIn(List<Float> values) {
            addCriterion("Final_Force_Press4 not in", values, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4Between(Float value1, Float value2) {
            addCriterion("Final_Force_Press4 between", value1, value2, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForcePress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Press4 not between", value1, value2, "finalForcePress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4IsNull() {
            addCriterion("Final_Force_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4IsNotNull() {
            addCriterion("Final_Force_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4EqualTo(Float value) {
            addCriterion("Final_Force_Min_Press4 =", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4NotEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press4 <>", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4GreaterThan(Float value) {
            addCriterion("Final_Force_Min_Press4 >", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press4 >=", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4LessThan(Float value) {
            addCriterion("Final_Force_Min_Press4 <", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Min_Press4 <=", value, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4In(List<Float> values) {
            addCriterion("Final_Force_Min_Press4 in", values, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4NotIn(List<Float> values) {
            addCriterion("Final_Force_Min_Press4 not in", values, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4Between(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press4 between", value1, value2, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Min_Press4 not between", value1, value2, "finalForceMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4IsNull() {
            addCriterion("Final_Force_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4IsNotNull() {
            addCriterion("Final_Force_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4EqualTo(Float value) {
            addCriterion("Final_Force_Max_Press4 =", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4NotEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press4 <>", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4GreaterThan(Float value) {
            addCriterion("Final_Force_Max_Press4 >", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press4 >=", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4LessThan(Float value) {
            addCriterion("Final_Force_Max_Press4 <", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Force_Max_Press4 <=", value, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4In(List<Float> values) {
            addCriterion("Final_Force_Max_Press4 in", values, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4NotIn(List<Float> values) {
            addCriterion("Final_Force_Max_Press4 not in", values, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4Between(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press4 between", value1, value2, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalForceMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Force_Max_Press4 not between", value1, value2, "finalForceMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4IsNull() {
            addCriterion("Final_Position_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4IsNotNull() {
            addCriterion("Final_Position_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4EqualTo(Float value) {
            addCriterion("Final_Position_Press4 =", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4NotEqualTo(Float value) {
            addCriterion("Final_Position_Press4 <>", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4GreaterThan(Float value) {
            addCriterion("Final_Position_Press4 >", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press4 >=", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4LessThan(Float value) {
            addCriterion("Final_Position_Press4 <", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Press4 <=", value, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4In(List<Float> values) {
            addCriterion("Final_Position_Press4 in", values, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4NotIn(List<Float> values) {
            addCriterion("Final_Position_Press4 not in", values, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4Between(Float value1, Float value2) {
            addCriterion("Final_Position_Press4 between", value1, value2, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionPress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Press4 not between", value1, value2, "finalPositionPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4IsNull() {
            addCriterion("Final_Position_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4IsNotNull() {
            addCriterion("Final_Position_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4EqualTo(Float value) {
            addCriterion("Final_Position_Min_Press4 =", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4NotEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press4 <>", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4GreaterThan(Float value) {
            addCriterion("Final_Position_Min_Press4 >", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press4 >=", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4LessThan(Float value) {
            addCriterion("Final_Position_Min_Press4 <", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Min_Press4 <=", value, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4In(List<Float> values) {
            addCriterion("Final_Position_Min_Press4 in", values, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4NotIn(List<Float> values) {
            addCriterion("Final_Position_Min_Press4 not in", values, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4Between(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press4 between", value1, value2, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Min_Press4 not between", value1, value2, "finalPositionMinPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4IsNull() {
            addCriterion("Final_Position_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4IsNotNull() {
            addCriterion("Final_Position_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4EqualTo(Float value) {
            addCriterion("Final_Position_Max_Press4 =", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4NotEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press4 <>", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4GreaterThan(Float value) {
            addCriterion("Final_Position_Max_Press4 >", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press4 >=", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4LessThan(Float value) {
            addCriterion("Final_Position_Max_Press4 <", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Final_Position_Max_Press4 <=", value, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4In(List<Float> values) {
            addCriterion("Final_Position_Max_Press4 in", values, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4NotIn(List<Float> values) {
            addCriterion("Final_Position_Max_Press4 not in", values, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4Between(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press4 between", value1, value2, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andFinalPositionMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Final_Position_Max_Press4 not between", value1, value2, "finalPositionMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4IsNull() {
            addCriterion("Press_in_Speed_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4IsNotNull() {
            addCriterion("Press_in_Speed_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4EqualTo(Float value) {
            addCriterion("Press_in_Speed_Press4 =", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press4 <>", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Press4 >", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press4 >=", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4LessThan(Float value) {
            addCriterion("Press_in_Speed_Press4 <", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Press4 <=", value, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4In(List<Float> values) {
            addCriterion("Press_in_Speed_Press4 in", values, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Press4 not in", values, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press4 between", value1, value2, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Press4 not between", value1, value2, "pressInSpeedPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4IsNull() {
            addCriterion("Press_in_Speed_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4IsNotNull() {
            addCriterion("Press_in_Speed_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4EqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 =", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 <>", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4GreaterThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 >", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 >=", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4LessThan(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 <", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Speed_Min_Press4 <=", value, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4In(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press4 in", values, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Speed_Min_Press4 not in", values, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press4 between", value1, value2, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeedMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Speed_Min_Press4 not between", value1, value2, "pressInSpeedMinPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4IsNull() {
            addCriterion("Press_in_Spedd_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4IsNotNull() {
            addCriterion("Press_in_Spedd_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4EqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 =", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4NotEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 <>", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4GreaterThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 >", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 >=", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4LessThan(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 <", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Press_in_Spedd_Max_Press4 <=", value, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4In(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press4 in", values, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4NotIn(List<Float> values) {
            addCriterion("Press_in_Spedd_Max_Press4 not in", values, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4Between(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press4 between", value1, value2, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andPressInSpeddMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Press_in_Spedd_Max_Press4 not between", value1, value2, "pressInSpeddMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4IsNull() {
            addCriterion("Slope_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andSlopePress4IsNotNull() {
            addCriterion("Slope_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopePress4EqualTo(Float value) {
            addCriterion("Slope_Press4 =", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4NotEqualTo(Float value) {
            addCriterion("Slope_Press4 <>", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4GreaterThan(Float value) {
            addCriterion("Slope_Press4 >", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Press4 >=", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4LessThan(Float value) {
            addCriterion("Slope_Press4 <", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Press4 <=", value, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4In(List<Float> values) {
            addCriterion("Slope_Press4 in", values, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4NotIn(List<Float> values) {
            addCriterion("Slope_Press4 not in", values, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4Between(Float value1, Float value2) {
            addCriterion("Slope_Press4 between", value1, value2, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopePress4NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Press4 not between", value1, value2, "slopePress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4IsNull() {
            addCriterion("Slope_Min_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4IsNotNull() {
            addCriterion("Slope_Min_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4EqualTo(Float value) {
            addCriterion("Slope_Min_Press4 =", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4NotEqualTo(Float value) {
            addCriterion("Slope_Min_Press4 <>", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4GreaterThan(Float value) {
            addCriterion("Slope_Min_Press4 >", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press4 >=", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4LessThan(Float value) {
            addCriterion("Slope_Min_Press4 <", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Min_Press4 <=", value, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4In(List<Float> values) {
            addCriterion("Slope_Min_Press4 in", values, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4NotIn(List<Float> values) {
            addCriterion("Slope_Min_Press4 not in", values, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4Between(Float value1, Float value2) {
            addCriterion("Slope_Min_Press4 between", value1, value2, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMinPress4NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Min_Press4 not between", value1, value2, "slopeMinPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4IsNull() {
            addCriterion("Slope_Max_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4IsNotNull() {
            addCriterion("Slope_Max_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4EqualTo(Float value) {
            addCriterion("Slope_Max_Press4 =", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4NotEqualTo(Float value) {
            addCriterion("Slope_Max_Press4 <>", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4GreaterThan(Float value) {
            addCriterion("Slope_Max_Press4 >", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4GreaterThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press4 >=", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4LessThan(Float value) {
            addCriterion("Slope_Max_Press4 <", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4LessThanOrEqualTo(Float value) {
            addCriterion("Slope_Max_Press4 <=", value, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4In(List<Float> values) {
            addCriterion("Slope_Max_Press4 in", values, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4NotIn(List<Float> values) {
            addCriterion("Slope_Max_Press4 not in", values, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4Between(Float value1, Float value2) {
            addCriterion("Slope_Max_Press4 between", value1, value2, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andSlopeMaxPress4NotBetween(Float value1, Float value2) {
            addCriterion("Slope_Max_Press4 not between", value1, value2, "slopeMaxPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4IsNull() {
            addCriterion("Component_BatchNO_Press4 is null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4IsNotNull() {
            addCriterion("Component_BatchNO_Press4 is not null");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4EqualTo(String value) {
            addCriterion("Component_BatchNO_Press4 =", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4NotEqualTo(String value) {
            addCriterion("Component_BatchNO_Press4 <>", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4GreaterThan(String value) {
            addCriterion("Component_BatchNO_Press4 >", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4GreaterThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press4 >=", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4LessThan(String value) {
            addCriterion("Component_BatchNO_Press4 <", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4LessThanOrEqualTo(String value) {
            addCriterion("Component_BatchNO_Press4 <=", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4Like(String value) {
            addCriterion("Component_BatchNO_Press4 like", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4NotLike(String value) {
            addCriterion("Component_BatchNO_Press4 not like", value, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4In(List<String> values) {
            addCriterion("Component_BatchNO_Press4 in", values, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4NotIn(List<String> values) {
            addCriterion("Component_BatchNO_Press4 not in", values, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4Between(String value1, String value2) {
            addCriterion("Component_BatchNO_Press4 between", value1, value2, "componentBatchnoPress4");
            return (Criteria) this;
        }

        public Criteria andComponentBatchnoPress4NotBetween(String value1, String value2) {
            addCriterion("Component_BatchNO_Press4 not between", value1, value2, "componentBatchnoPress4");
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

        public Criteria andRecordNoIsNull() {
            addCriterion("Record_NO is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("Record_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(Integer value) {
            addCriterion("Record_NO =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(Integer value) {
            addCriterion("Record_NO <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(Integer value) {
            addCriterion("Record_NO >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Record_NO >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(Integer value) {
            addCriterion("Record_NO <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(Integer value) {
            addCriterion("Record_NO <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<Integer> values) {
            addCriterion("Record_NO in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<Integer> values) {
            addCriterion("Record_NO not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(Integer value1, Integer value2) {
            addCriterion("Record_NO between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Record_NO not between", value1, value2, "recordNo");
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