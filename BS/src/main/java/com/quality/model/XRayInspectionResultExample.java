package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XRayInspectionResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XRayInspectionResultExample() {
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

        public Criteria andMachineNoEqualTo(Integer value) {
            addCriterion("Machine_NO =", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotEqualTo(Integer value) {
            addCriterion("Machine_NO <>", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThan(Integer value) {
            addCriterion("Machine_NO >", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Machine_NO >=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThan(Integer value) {
            addCriterion("Machine_NO <", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThanOrEqualTo(Integer value) {
            addCriterion("Machine_NO <=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoIn(List<Integer> values) {
            addCriterion("Machine_NO in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotIn(List<Integer> values) {
            addCriterion("Machine_NO not in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoBetween(Integer value1, Integer value2) {
            addCriterion("Machine_NO between", value1, value2, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Machine_NO not between", value1, value2, "machineNo");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIsNull() {
            addCriterion("Program_Code is null");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIsNotNull() {
            addCriterion("Program_Code is not null");
            return (Criteria) this;
        }

        public Criteria andProgramCodeEqualTo(Integer value) {
            addCriterion("Program_Code =", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotEqualTo(Integer value) {
            addCriterion("Program_Code <>", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeGreaterThan(Integer value) {
            addCriterion("Program_Code >", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Program_Code >=", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeLessThan(Integer value) {
            addCriterion("Program_Code <", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeLessThanOrEqualTo(Integer value) {
            addCriterion("Program_Code <=", value, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeIn(List<Integer> values) {
            addCriterion("Program_Code in", values, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotIn(List<Integer> values) {
            addCriterion("Program_Code not in", values, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeBetween(Integer value1, Integer value2) {
            addCriterion("Program_Code between", value1, value2, "programCode");
            return (Criteria) this;
        }

        public Criteria andProgramCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Program_Code not between", value1, value2, "programCode");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationIsNull() {
            addCriterion("DM_Content_Abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationIsNotNull() {
            addCriterion("DM_Content_Abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationEqualTo(String value) {
            addCriterion("DM_Content_Abbreviation =", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationNotEqualTo(String value) {
            addCriterion("DM_Content_Abbreviation <>", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationGreaterThan(String value) {
            addCriterion("DM_Content_Abbreviation >", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("DM_Content_Abbreviation >=", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationLessThan(String value) {
            addCriterion("DM_Content_Abbreviation <", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("DM_Content_Abbreviation <=", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationLike(String value) {
            addCriterion("DM_Content_Abbreviation like", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationNotLike(String value) {
            addCriterion("DM_Content_Abbreviation not like", value, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationIn(List<String> values) {
            addCriterion("DM_Content_Abbreviation in", values, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationNotIn(List<String> values) {
            addCriterion("DM_Content_Abbreviation not in", values, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationBetween(String value1, String value2) {
            addCriterion("DM_Content_Abbreviation between", value1, value2, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentAbbreviationNotBetween(String value1, String value2) {
            addCriterion("DM_Content_Abbreviation not between", value1, value2, "dmContentAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDmContentIsNull() {
            addCriterion("DM_Content is null");
            return (Criteria) this;
        }

        public Criteria andDmContentIsNotNull() {
            addCriterion("DM_Content is not null");
            return (Criteria) this;
        }

        public Criteria andDmContentEqualTo(String value) {
            addCriterion("DM_Content =", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentNotEqualTo(String value) {
            addCriterion("DM_Content <>", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentGreaterThan(String value) {
            addCriterion("DM_Content >", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentGreaterThanOrEqualTo(String value) {
            addCriterion("DM_Content >=", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentLessThan(String value) {
            addCriterion("DM_Content <", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentLessThanOrEqualTo(String value) {
            addCriterion("DM_Content <=", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentLike(String value) {
            addCriterion("DM_Content like", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentNotLike(String value) {
            addCriterion("DM_Content not like", value, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentIn(List<String> values) {
            addCriterion("DM_Content in", values, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentNotIn(List<String> values) {
            addCriterion("DM_Content not in", values, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentBetween(String value1, String value2) {
            addCriterion("DM_Content between", value1, value2, "dmContent");
            return (Criteria) this;
        }

        public Criteria andDmContentNotBetween(String value1, String value2) {
            addCriterion("DM_Content not between", value1, value2, "dmContent");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusIsNull() {
            addCriterion("Part_Inspection_Status is null");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusIsNotNull() {
            addCriterion("Part_Inspection_Status is not null");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusEqualTo(Integer value) {
            addCriterion("Part_Inspection_Status =", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusNotEqualTo(Integer value) {
            addCriterion("Part_Inspection_Status <>", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusGreaterThan(Integer value) {
            addCriterion("Part_Inspection_Status >", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Part_Inspection_Status >=", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusLessThan(Integer value) {
            addCriterion("Part_Inspection_Status <", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Part_Inspection_Status <=", value, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusIn(List<Integer> values) {
            addCriterion("Part_Inspection_Status in", values, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusNotIn(List<Integer> values) {
            addCriterion("Part_Inspection_Status not in", values, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusBetween(Integer value1, Integer value2) {
            addCriterion("Part_Inspection_Status between", value1, value2, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andPartInspectionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Part_Inspection_Status not between", value1, value2, "partInspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("Insert_Time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("Insert_Time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("Insert_Time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("Insert_Time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("Insert_Time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Insert_Time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("Insert_Time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("Insert_Time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("Insert_Time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("Insert_Time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("Insert_Time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("Insert_Time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeIsNull() {
            addCriterion("Part_Validation_Type is null");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeIsNotNull() {
            addCriterion("Part_Validation_Type is not null");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeEqualTo(Integer value) {
            addCriterion("Part_Validation_Type =", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeNotEqualTo(Integer value) {
            addCriterion("Part_Validation_Type <>", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeGreaterThan(Integer value) {
            addCriterion("Part_Validation_Type >", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Part_Validation_Type >=", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeLessThan(Integer value) {
            addCriterion("Part_Validation_Type <", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("Part_Validation_Type <=", value, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeIn(List<Integer> values) {
            addCriterion("Part_Validation_Type in", values, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeNotIn(List<Integer> values) {
            addCriterion("Part_Validation_Type not in", values, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeBetween(Integer value1, Integer value2) {
            addCriterion("Part_Validation_Type between", value1, value2, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andPartValidationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("Part_Validation_Type not between", value1, value2, "partValidationType");
            return (Criteria) this;
        }

        public Criteria andVcContentIsNull() {
            addCriterion("VC_Content is null");
            return (Criteria) this;
        }

        public Criteria andVcContentIsNotNull() {
            addCriterion("VC_Content is not null");
            return (Criteria) this;
        }

        public Criteria andVcContentEqualTo(String value) {
            addCriterion("VC_Content =", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentNotEqualTo(String value) {
            addCriterion("VC_Content <>", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentGreaterThan(String value) {
            addCriterion("VC_Content >", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentGreaterThanOrEqualTo(String value) {
            addCriterion("VC_Content >=", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentLessThan(String value) {
            addCriterion("VC_Content <", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentLessThanOrEqualTo(String value) {
            addCriterion("VC_Content <=", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentLike(String value) {
            addCriterion("VC_Content like", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentNotLike(String value) {
            addCriterion("VC_Content not like", value, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentIn(List<String> values) {
            addCriterion("VC_Content in", values, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentNotIn(List<String> values) {
            addCriterion("VC_Content not in", values, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentBetween(String value1, String value2) {
            addCriterion("VC_Content between", value1, value2, "vcContent");
            return (Criteria) this;
        }

        public Criteria andVcContentNotBetween(String value1, String value2) {
            addCriterion("VC_Content not between", value1, value2, "vcContent");
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