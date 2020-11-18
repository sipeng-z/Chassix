package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XRayBatchNOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XRayBatchNOExample() {
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

        public Criteria andParttypeQuantityIsNull() {
            addCriterion("PartType_Quantity is null");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityIsNotNull() {
            addCriterion("PartType_Quantity is not null");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityEqualTo(Integer value) {
            addCriterion("PartType_Quantity =", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityNotEqualTo(Integer value) {
            addCriterion("PartType_Quantity <>", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityGreaterThan(Integer value) {
            addCriterion("PartType_Quantity >", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("PartType_Quantity >=", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityLessThan(Integer value) {
            addCriterion("PartType_Quantity <", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("PartType_Quantity <=", value, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityIn(List<Integer> values) {
            addCriterion("PartType_Quantity in", values, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityNotIn(List<Integer> values) {
            addCriterion("PartType_Quantity not in", values, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityBetween(Integer value1, Integer value2) {
            addCriterion("PartType_Quantity between", value1, value2, "parttypeQuantity");
            return (Criteria) this;
        }

        public Criteria andParttypeQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("PartType_Quantity not between", value1, value2, "parttypeQuantity");
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

        public Criteria andRackNoIsNull() {
            addCriterion("Rack_NO is null");
            return (Criteria) this;
        }

        public Criteria andRackNoIsNotNull() {
            addCriterion("Rack_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRackNoEqualTo(String value) {
            addCriterion("Rack_NO =", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoNotEqualTo(String value) {
            addCriterion("Rack_NO <>", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoGreaterThan(String value) {
            addCriterion("Rack_NO >", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoGreaterThanOrEqualTo(String value) {
            addCriterion("Rack_NO >=", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoLessThan(String value) {
            addCriterion("Rack_NO <", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoLessThanOrEqualTo(String value) {
            addCriterion("Rack_NO <=", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoLike(String value) {
            addCriterion("Rack_NO like", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoNotLike(String value) {
            addCriterion("Rack_NO not like", value, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoIn(List<String> values) {
            addCriterion("Rack_NO in", values, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoNotIn(List<String> values) {
            addCriterion("Rack_NO not in", values, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoBetween(String value1, String value2) {
            addCriterion("Rack_NO between", value1, value2, "rackNo");
            return (Criteria) this;
        }

        public Criteria andRackNoNotBetween(String value1, String value2) {
            addCriterion("Rack_NO not between", value1, value2, "rackNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("Batch_NO is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("Batch_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("Batch_NO =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("Batch_NO <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("Batch_NO >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("Batch_NO >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("Batch_NO <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("Batch_NO <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("Batch_NO like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("Batch_NO not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("Batch_NO in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("Batch_NO not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("Batch_NO between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("Batch_NO not between", value1, value2, "batchNo");
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

        public Criteria andHtStatusIsNull() {
            addCriterion("HT_Status is null");
            return (Criteria) this;
        }

        public Criteria andHtStatusIsNotNull() {
            addCriterion("HT_Status is not null");
            return (Criteria) this;
        }

        public Criteria andHtStatusEqualTo(Integer value) {
            addCriterion("HT_Status =", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusNotEqualTo(Integer value) {
            addCriterion("HT_Status <>", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusGreaterThan(Integer value) {
            addCriterion("HT_Status >", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("HT_Status >=", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusLessThan(Integer value) {
            addCriterion("HT_Status <", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusLessThanOrEqualTo(Integer value) {
            addCriterion("HT_Status <=", value, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusIn(List<Integer> values) {
            addCriterion("HT_Status in", values, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusNotIn(List<Integer> values) {
            addCriterion("HT_Status not in", values, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusBetween(Integer value1, Integer value2) {
            addCriterion("HT_Status between", value1, value2, "htStatus");
            return (Criteria) this;
        }

        public Criteria andHtStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("HT_Status not between", value1, value2, "htStatus");
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