package com.quality.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackingStationAndCLPIExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackingStationAndCLPIExample() {
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

        public Criteria andLotNoIsNull() {
            addCriterion("LOT_NO is null");
            return (Criteria) this;
        }

        public Criteria andLotNoIsNotNull() {
            addCriterion("LOT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLotNoEqualTo(String value) {
            addCriterion("LOT_NO =", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotEqualTo(String value) {
            addCriterion("LOT_NO <>", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThan(String value) {
            addCriterion("LOT_NO >", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoGreaterThanOrEqualTo(String value) {
            addCriterion("LOT_NO >=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThan(String value) {
            addCriterion("LOT_NO <", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLessThanOrEqualTo(String value) {
            addCriterion("LOT_NO <=", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoLike(String value) {
            addCriterion("LOT_NO like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotLike(String value) {
            addCriterion("LOT_NO not like", value, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoIn(List<String> values) {
            addCriterion("LOT_NO in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotIn(List<String> values) {
            addCriterion("LOT_NO not in", values, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoBetween(String value1, String value2) {
            addCriterion("LOT_NO between", value1, value2, "lotNo");
            return (Criteria) this;
        }

        public Criteria andLotNoNotBetween(String value1, String value2) {
            addCriterion("LOT_NO not between", value1, value2, "lotNo");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxIsNull() {
            addCriterion("Count_Base_on_Box is null");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxIsNotNull() {
            addCriterion("Count_Base_on_Box is not null");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxEqualTo(Integer value) {
            addCriterion("Count_Base_on_Box =", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxNotEqualTo(Integer value) {
            addCriterion("Count_Base_on_Box <>", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxGreaterThan(Integer value) {
            addCriterion("Count_Base_on_Box >", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxGreaterThanOrEqualTo(Integer value) {
            addCriterion("Count_Base_on_Box >=", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxLessThan(Integer value) {
            addCriterion("Count_Base_on_Box <", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxLessThanOrEqualTo(Integer value) {
            addCriterion("Count_Base_on_Box <=", value, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxIn(List<Integer> values) {
            addCriterion("Count_Base_on_Box in", values, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxNotIn(List<Integer> values) {
            addCriterion("Count_Base_on_Box not in", values, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxBetween(Integer value1, Integer value2) {
            addCriterion("Count_Base_on_Box between", value1, value2, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andCountBaseOnBoxNotBetween(Integer value1, Integer value2) {
            addCriterion("Count_Base_on_Box not between", value1, value2, "countBaseOnBox");
            return (Criteria) this;
        }

        public Criteria andLayerNoIsNull() {
            addCriterion("Layer_NO is null");
            return (Criteria) this;
        }

        public Criteria andLayerNoIsNotNull() {
            addCriterion("Layer_NO is not null");
            return (Criteria) this;
        }

        public Criteria andLayerNoEqualTo(Integer value) {
            addCriterion("Layer_NO =", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoNotEqualTo(Integer value) {
            addCriterion("Layer_NO <>", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoGreaterThan(Integer value) {
            addCriterion("Layer_NO >", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Layer_NO >=", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoLessThan(Integer value) {
            addCriterion("Layer_NO <", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoLessThanOrEqualTo(Integer value) {
            addCriterion("Layer_NO <=", value, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoIn(List<Integer> values) {
            addCriterion("Layer_NO in", values, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoNotIn(List<Integer> values) {
            addCriterion("Layer_NO not in", values, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoBetween(Integer value1, Integer value2) {
            addCriterion("Layer_NO between", value1, value2, "layerNo");
            return (Criteria) this;
        }

        public Criteria andLayerNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Layer_NO not between", value1, value2, "layerNo");
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

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("Updated_Time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("Updated_Time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("Updated_Time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("Updated_Time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("Updated_Time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Updated_Time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("Updated_Time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("Updated_Time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("Updated_Time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("Updated_Time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("Updated_Time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("Updated_Time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("Data_Source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("Data_Source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("Data_Source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("Data_Source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("Data_Source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("Data_Source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("Data_Source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("Data_Source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("Data_Source like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("Data_Source not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("Data_Source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("Data_Source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("Data_Source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("Data_Source not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andReaderNoIsNull() {
            addCriterion("Reader_NO is null");
            return (Criteria) this;
        }

        public Criteria andReaderNoIsNotNull() {
            addCriterion("Reader_NO is not null");
            return (Criteria) this;
        }

        public Criteria andReaderNoEqualTo(Integer value) {
            addCriterion("Reader_NO =", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoNotEqualTo(Integer value) {
            addCriterion("Reader_NO <>", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoGreaterThan(Integer value) {
            addCriterion("Reader_NO >", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Reader_NO >=", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoLessThan(Integer value) {
            addCriterion("Reader_NO <", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoLessThanOrEqualTo(Integer value) {
            addCriterion("Reader_NO <=", value, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoIn(List<Integer> values) {
            addCriterion("Reader_NO in", values, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoNotIn(List<Integer> values) {
            addCriterion("Reader_NO not in", values, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoBetween(Integer value1, Integer value2) {
            addCriterion("Reader_NO between", value1, value2, "readerNo");
            return (Criteria) this;
        }

        public Criteria andReaderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("Reader_NO not between", value1, value2, "readerNo");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateIsNull() {
            addCriterion("Last_Process_State is null");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateIsNotNull() {
            addCriterion("Last_Process_State is not null");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateEqualTo(Integer value) {
            addCriterion("Last_Process_State =", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateNotEqualTo(Integer value) {
            addCriterion("Last_Process_State <>", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateGreaterThan(Integer value) {
            addCriterion("Last_Process_State >", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("Last_Process_State >=", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateLessThan(Integer value) {
            addCriterion("Last_Process_State <", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateLessThanOrEqualTo(Integer value) {
            addCriterion("Last_Process_State <=", value, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateIn(List<Integer> values) {
            addCriterion("Last_Process_State in", values, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateNotIn(List<Integer> values) {
            addCriterion("Last_Process_State not in", values, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateBetween(Integer value1, Integer value2) {
            addCriterion("Last_Process_State between", value1, value2, "lastProcessState");
            return (Criteria) this;
        }

        public Criteria andLastProcessStateNotBetween(Integer value1, Integer value2) {
            addCriterion("Last_Process_State not between", value1, value2, "lastProcessState");
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