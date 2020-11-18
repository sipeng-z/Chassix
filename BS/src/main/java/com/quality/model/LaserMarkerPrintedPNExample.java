package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LaserMarkerPrintedPNExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LaserMarkerPrintedPNExample() {
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

        public Criteria andHandSignIsNull() {
            addCriterion("Hand_Sign is null");
            return (Criteria) this;
        }

        public Criteria andHandSignIsNotNull() {
            addCriterion("Hand_Sign is not null");
            return (Criteria) this;
        }

        public Criteria andHandSignEqualTo(String value) {
            addCriterion("Hand_Sign =", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignNotEqualTo(String value) {
            addCriterion("Hand_Sign <>", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignGreaterThan(String value) {
            addCriterion("Hand_Sign >", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignGreaterThanOrEqualTo(String value) {
            addCriterion("Hand_Sign >=", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignLessThan(String value) {
            addCriterion("Hand_Sign <", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignLessThanOrEqualTo(String value) {
            addCriterion("Hand_Sign <=", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignLike(String value) {
            addCriterion("Hand_Sign like", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignNotLike(String value) {
            addCriterion("Hand_Sign not like", value, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignIn(List<String> values) {
            addCriterion("Hand_Sign in", values, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignNotIn(List<String> values) {
            addCriterion("Hand_Sign not in", values, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignBetween(String value1, String value2) {
            addCriterion("Hand_Sign between", value1, value2, "handSign");
            return (Criteria) this;
        }

        public Criteria andHandSignNotBetween(String value1, String value2) {
            addCriterion("Hand_Sign not between", value1, value2, "handSign");
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

        public Criteria andDailyCountIsNull() {
            addCriterion("Daily_Count is null");
            return (Criteria) this;
        }

        public Criteria andDailyCountIsNotNull() {
            addCriterion("Daily_Count is not null");
            return (Criteria) this;
        }

        public Criteria andDailyCountEqualTo(Integer value) {
            addCriterion("Daily_Count =", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountNotEqualTo(Integer value) {
            addCriterion("Daily_Count <>", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountGreaterThan(Integer value) {
            addCriterion("Daily_Count >", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Daily_Count >=", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountLessThan(Integer value) {
            addCriterion("Daily_Count <", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountLessThanOrEqualTo(Integer value) {
            addCriterion("Daily_Count <=", value, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountIn(List<Integer> values) {
            addCriterion("Daily_Count in", values, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountNotIn(List<Integer> values) {
            addCriterion("Daily_Count not in", values, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountBetween(Integer value1, Integer value2) {
            addCriterion("Daily_Count between", value1, value2, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andDailyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("Daily_Count not between", value1, value2, "dailyCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountIsNull() {
            addCriterion("FLC_Count is null");
            return (Criteria) this;
        }

        public Criteria andFlcCountIsNotNull() {
            addCriterion("FLC_Count is not null");
            return (Criteria) this;
        }

        public Criteria andFlcCountEqualTo(Integer value) {
            addCriterion("FLC_Count =", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountNotEqualTo(Integer value) {
            addCriterion("FLC_Count <>", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountGreaterThan(Integer value) {
            addCriterion("FLC_Count >", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLC_Count >=", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountLessThan(Integer value) {
            addCriterion("FLC_Count <", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountLessThanOrEqualTo(Integer value) {
            addCriterion("FLC_Count <=", value, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountIn(List<Integer> values) {
            addCriterion("FLC_Count in", values, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountNotIn(List<Integer> values) {
            addCriterion("FLC_Count not in", values, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountBetween(Integer value1, Integer value2) {
            addCriterion("FLC_Count between", value1, value2, "flcCount");
            return (Criteria) this;
        }

        public Criteria andFlcCountNotBetween(Integer value1, Integer value2) {
            addCriterion("FLC_Count not between", value1, value2, "flcCount");
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

        public Criteria andAskedTimeIsNull() {
            addCriterion("Asked_Time is null");
            return (Criteria) this;
        }

        public Criteria andAskedTimeIsNotNull() {
            addCriterion("Asked_Time is not null");
            return (Criteria) this;
        }

        public Criteria andAskedTimeEqualTo(Date value) {
            addCriterion("Asked_Time =", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeNotEqualTo(Date value) {
            addCriterion("Asked_Time <>", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeGreaterThan(Date value) {
            addCriterion("Asked_Time >", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Asked_Time >=", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeLessThan(Date value) {
            addCriterion("Asked_Time <", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeLessThanOrEqualTo(Date value) {
            addCriterion("Asked_Time <=", value, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeIn(List<Date> values) {
            addCriterion("Asked_Time in", values, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeNotIn(List<Date> values) {
            addCriterion("Asked_Time not in", values, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeBetween(Date value1, Date value2) {
            addCriterion("Asked_Time between", value1, value2, "askedTime");
            return (Criteria) this;
        }

        public Criteria andAskedTimeNotBetween(Date value1, Date value2) {
            addCriterion("Asked_Time not between", value1, value2, "askedTime");
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