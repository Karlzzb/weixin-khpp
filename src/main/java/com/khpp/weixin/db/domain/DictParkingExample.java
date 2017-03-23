package com.khpp.weixin.db.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictParkingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictParkingExample() {
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

        public Criteria andParkingIdIsNull() {
            addCriterion("parking_id is null");
            return (Criteria) this;
        }

        public Criteria andParkingIdIsNotNull() {
            addCriterion("parking_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkingIdEqualTo(Integer value) {
            addCriterion("parking_id =", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotEqualTo(Integer value) {
            addCriterion("parking_id <>", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThan(Integer value) {
            addCriterion("parking_id >", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_id >=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThan(Integer value) {
            addCriterion("parking_id <", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThanOrEqualTo(Integer value) {
            addCriterion("parking_id <=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdIn(List<Integer> values) {
            addCriterion("parking_id in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotIn(List<Integer> values) {
            addCriterion("parking_id not in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdBetween(Integer value1, Integer value2) {
            addCriterion("parking_id between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_id not between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingNameIsNull() {
            addCriterion("parking_name is null");
            return (Criteria) this;
        }

        public Criteria andParkingNameIsNotNull() {
            addCriterion("parking_name is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNameEqualTo(String value) {
            addCriterion("parking_name =", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotEqualTo(String value) {
            addCriterion("parking_name <>", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameGreaterThan(String value) {
            addCriterion("parking_name >", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameGreaterThanOrEqualTo(String value) {
            addCriterion("parking_name >=", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLessThan(String value) {
            addCriterion("parking_name <", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLessThanOrEqualTo(String value) {
            addCriterion("parking_name <=", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLike(String value) {
            addCriterion("parking_name like", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotLike(String value) {
            addCriterion("parking_name not like", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameIn(List<String> values) {
            addCriterion("parking_name in", values, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotIn(List<String> values) {
            addCriterion("parking_name not in", values, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameBetween(String value1, String value2) {
            addCriterion("parking_name between", value1, value2, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotBetween(String value1, String value2) {
            addCriterion("parking_name not between", value1, value2, "parkingName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeIsNull() {
            addCriterion("dml_time is null");
            return (Criteria) this;
        }

        public Criteria andDmlTimeIsNotNull() {
            addCriterion("dml_time is not null");
            return (Criteria) this;
        }

        public Criteria andDmlTimeEqualTo(Date value) {
            addCriterion("dml_time =", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeNotEqualTo(Date value) {
            addCriterion("dml_time <>", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeGreaterThan(Date value) {
            addCriterion("dml_time >", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dml_time >=", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeLessThan(Date value) {
            addCriterion("dml_time <", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeLessThanOrEqualTo(Date value) {
            addCriterion("dml_time <=", value, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeIn(List<Date> values) {
            addCriterion("dml_time in", values, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeNotIn(List<Date> values) {
            addCriterion("dml_time not in", values, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeBetween(Date value1, Date value2) {
            addCriterion("dml_time between", value1, value2, "dmlTime");
            return (Criteria) this;
        }

        public Criteria andDmlTimeNotBetween(Date value1, Date value2) {
            addCriterion("dml_time not between", value1, value2, "dmlTime");
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