package com.qut.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FocusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FocusExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdIsNull() {
            addCriterion("goodstable_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdIsNotNull() {
            addCriterion("goodstable_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdEqualTo(Integer value) {
            addCriterion("goodstable_id =", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdNotEqualTo(Integer value) {
            addCriterion("goodstable_id <>", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdGreaterThan(Integer value) {
            addCriterion("goodstable_id >", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodstable_id >=", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdLessThan(Integer value) {
            addCriterion("goodstable_id <", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdLessThanOrEqualTo(Integer value) {
            addCriterion("goodstable_id <=", value, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdIn(List<Integer> values) {
            addCriterion("goodstable_id in", values, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdNotIn(List<Integer> values) {
            addCriterion("goodstable_id not in", values, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdBetween(Integer value1, Integer value2) {
            addCriterion("goodstable_id between", value1, value2, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andGoodstableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goodstable_id not between", value1, value2, "goodstableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdIsNull() {
            addCriterion("busertable_id is null");
            return (Criteria) this;
        }

        public Criteria andBusertableIdIsNotNull() {
            addCriterion("busertable_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusertableIdEqualTo(Integer value) {
            addCriterion("busertable_id =", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdNotEqualTo(Integer value) {
            addCriterion("busertable_id <>", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdGreaterThan(Integer value) {
            addCriterion("busertable_id >", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("busertable_id >=", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdLessThan(Integer value) {
            addCriterion("busertable_id <", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdLessThanOrEqualTo(Integer value) {
            addCriterion("busertable_id <=", value, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdIn(List<Integer> values) {
            addCriterion("busertable_id in", values, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdNotIn(List<Integer> values) {
            addCriterion("busertable_id not in", values, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdBetween(Integer value1, Integer value2) {
            addCriterion("busertable_id between", value1, value2, "busertableId");
            return (Criteria) this;
        }

        public Criteria andBusertableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("busertable_id not between", value1, value2, "busertableId");
            return (Criteria) this;
        }

        public Criteria andFocustimeIsNull() {
            addCriterion("focustime is null");
            return (Criteria) this;
        }

        public Criteria andFocustimeIsNotNull() {
            addCriterion("focustime is not null");
            return (Criteria) this;
        }

        public Criteria andFocustimeEqualTo(Date value) {
            addCriterion("focustime =", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotEqualTo(Date value) {
            addCriterion("focustime <>", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeGreaterThan(Date value) {
            addCriterion("focustime >", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeGreaterThanOrEqualTo(Date value) {
            addCriterion("focustime >=", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeLessThan(Date value) {
            addCriterion("focustime <", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeLessThanOrEqualTo(Date value) {
            addCriterion("focustime <=", value, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeIn(List<Date> values) {
            addCriterion("focustime in", values, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotIn(List<Date> values) {
            addCriterion("focustime not in", values, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeBetween(Date value1, Date value2) {
            addCriterion("focustime between", value1, value2, "focustime");
            return (Criteria) this;
        }

        public Criteria andFocustimeNotBetween(Date value1, Date value2) {
            addCriterion("focustime not between", value1, value2, "focustime");
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