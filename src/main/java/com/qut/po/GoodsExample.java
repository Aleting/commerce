package com.qut.po;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGopriceIsNull() {
            addCriterion("goprice is null");
            return (Criteria) this;
        }

        public Criteria andGopriceIsNotNull() {
            addCriterion("goprice is not null");
            return (Criteria) this;
        }

        public Criteria andGopriceEqualTo(Double value) {
            addCriterion("goprice =", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotEqualTo(Double value) {
            addCriterion("goprice <>", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceGreaterThan(Double value) {
            addCriterion("goprice >", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceGreaterThanOrEqualTo(Double value) {
            addCriterion("goprice >=", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceLessThan(Double value) {
            addCriterion("goprice <", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceLessThanOrEqualTo(Double value) {
            addCriterion("goprice <=", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceIn(List<Double> values) {
            addCriterion("goprice in", values, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotIn(List<Double> values) {
            addCriterion("goprice not in", values, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceBetween(Double value1, Double value2) {
            addCriterion("goprice between", value1, value2, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotBetween(Double value1, Double value2) {
            addCriterion("goprice not between", value1, value2, "goprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceIsNull() {
            addCriterion("grprice is null");
            return (Criteria) this;
        }

        public Criteria andGrpriceIsNotNull() {
            addCriterion("grprice is not null");
            return (Criteria) this;
        }

        public Criteria andGrpriceEqualTo(Double value) {
            addCriterion("grprice =", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceNotEqualTo(Double value) {
            addCriterion("grprice <>", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceGreaterThan(Double value) {
            addCriterion("grprice >", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("grprice >=", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceLessThan(Double value) {
            addCriterion("grprice <", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceLessThanOrEqualTo(Double value) {
            addCriterion("grprice <=", value, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceIn(List<Double> values) {
            addCriterion("grprice in", values, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceNotIn(List<Double> values) {
            addCriterion("grprice not in", values, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceBetween(Double value1, Double value2) {
            addCriterion("grprice between", value1, value2, "grprice");
            return (Criteria) this;
        }

        public Criteria andGrpriceNotBetween(Double value1, Double value2) {
            addCriterion("grprice not between", value1, value2, "grprice");
            return (Criteria) this;
        }

        public Criteria andGstoreIsNull() {
            addCriterion("gstore is null");
            return (Criteria) this;
        }

        public Criteria andGstoreIsNotNull() {
            addCriterion("gstore is not null");
            return (Criteria) this;
        }

        public Criteria andGstoreEqualTo(Integer value) {
            addCriterion("gstore =", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreNotEqualTo(Integer value) {
            addCriterion("gstore <>", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreGreaterThan(Integer value) {
            addCriterion("gstore >", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("gstore >=", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreLessThan(Integer value) {
            addCriterion("gstore <", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreLessThanOrEqualTo(Integer value) {
            addCriterion("gstore <=", value, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreIn(List<Integer> values) {
            addCriterion("gstore in", values, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreNotIn(List<Integer> values) {
            addCriterion("gstore not in", values, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreBetween(Integer value1, Integer value2) {
            addCriterion("gstore between", value1, value2, "gstore");
            return (Criteria) this;
        }

        public Criteria andGstoreNotBetween(Integer value1, Integer value2) {
            addCriterion("gstore not between", value1, value2, "gstore");
            return (Criteria) this;
        }

        public Criteria andGpictureIsNull() {
            addCriterion("gpicture is null");
            return (Criteria) this;
        }

        public Criteria andGpictureIsNotNull() {
            addCriterion("gpicture is not null");
            return (Criteria) this;
        }

        public Criteria andGpictureEqualTo(String value) {
            addCriterion("gpicture =", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureNotEqualTo(String value) {
            addCriterion("gpicture <>", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureGreaterThan(String value) {
            addCriterion("gpicture >", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureGreaterThanOrEqualTo(String value) {
            addCriterion("gpicture >=", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureLessThan(String value) {
            addCriterion("gpicture <", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureLessThanOrEqualTo(String value) {
            addCriterion("gpicture <=", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureLike(String value) {
            addCriterion("gpicture like", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureNotLike(String value) {
            addCriterion("gpicture not like", value, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureIn(List<String> values) {
            addCriterion("gpicture in", values, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureNotIn(List<String> values) {
            addCriterion("gpicture not in", values, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureBetween(String value1, String value2) {
            addCriterion("gpicture between", value1, value2, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGpictureNotBetween(String value1, String value2) {
            addCriterion("gpicture not between", value1, value2, "gpicture");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIsNull() {
            addCriterion("goodstype_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIsNotNull() {
            addCriterion("goodstype_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdEqualTo(Integer value) {
            addCriterion("goodstype_id =", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotEqualTo(Integer value) {
            addCriterion("goodstype_id <>", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdGreaterThan(Integer value) {
            addCriterion("goodstype_id >", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodstype_id >=", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdLessThan(Integer value) {
            addCriterion("goodstype_id <", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("goodstype_id <=", value, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdIn(List<Integer> values) {
            addCriterion("goodstype_id in", values, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotIn(List<Integer> values) {
            addCriterion("goodstype_id not in", values, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdBetween(Integer value1, Integer value2) {
            addCriterion("goodstype_id between", value1, value2, "goodstypeId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goodstype_id not between", value1, value2, "goodstypeId");
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