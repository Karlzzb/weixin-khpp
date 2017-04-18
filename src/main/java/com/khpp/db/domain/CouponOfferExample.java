package com.khpp.db.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponOfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponOfferExample() {
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

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponBrandIsNull() {
            addCriterion("coupon_brand is null");
            return (Criteria) this;
        }

        public Criteria andCouponBrandIsNotNull() {
            addCriterion("coupon_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCouponBrandEqualTo(String value) {
            addCriterion("coupon_brand =", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandNotEqualTo(String value) {
            addCriterion("coupon_brand <>", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandGreaterThan(String value) {
            addCriterion("coupon_brand >", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_brand >=", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandLessThan(String value) {
            addCriterion("coupon_brand <", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandLessThanOrEqualTo(String value) {
            addCriterion("coupon_brand <=", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandLike(String value) {
            addCriterion("coupon_brand like", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandNotLike(String value) {
            addCriterion("coupon_brand not like", value, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandIn(List<String> values) {
            addCriterion("coupon_brand in", values, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandNotIn(List<String> values) {
            addCriterion("coupon_brand not in", values, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandBetween(String value1, String value2) {
            addCriterion("coupon_brand between", value1, value2, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponBrandNotBetween(String value1, String value2) {
            addCriterion("coupon_brand not between", value1, value2, "couponBrand");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Integer value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Integer value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Integer value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Integer value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Integer> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Integer> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andOfferStatusIsNull() {
            addCriterion("offer_status is null");
            return (Criteria) this;
        }

        public Criteria andOfferStatusIsNotNull() {
            addCriterion("offer_status is not null");
            return (Criteria) this;
        }

        public Criteria andOfferStatusEqualTo(Integer value) {
            addCriterion("offer_status =", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusNotEqualTo(Integer value) {
            addCriterion("offer_status <>", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusGreaterThan(Integer value) {
            addCriterion("offer_status >", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer_status >=", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusLessThan(Integer value) {
            addCriterion("offer_status <", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusLessThanOrEqualTo(Integer value) {
            addCriterion("offer_status <=", value, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusIn(List<Integer> values) {
            addCriterion("offer_status in", values, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusNotIn(List<Integer> values) {
            addCriterion("offer_status not in", values, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusBetween(Integer value1, Integer value2) {
            addCriterion("offer_status between", value1, value2, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andOfferStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("offer_status not between", value1, value2, "offerStatus");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeIsNull() {
            addCriterion("coupon_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeIsNotNull() {
            addCriterion("coupon_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeEqualTo(String value) {
            addCriterion("coupon_qrcode =", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeNotEqualTo(String value) {
            addCriterion("coupon_qrcode <>", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeGreaterThan(String value) {
            addCriterion("coupon_qrcode >", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_qrcode >=", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeLessThan(String value) {
            addCriterion("coupon_qrcode <", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_qrcode <=", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeLike(String value) {
            addCriterion("coupon_qrcode like", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeNotLike(String value) {
            addCriterion("coupon_qrcode not like", value, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeIn(List<String> values) {
            addCriterion("coupon_qrcode in", values, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeNotIn(List<String> values) {
            addCriterion("coupon_qrcode not in", values, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeBetween(String value1, String value2) {
            addCriterion("coupon_qrcode between", value1, value2, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andCouponQrcodeNotBetween(String value1, String value2) {
            addCriterion("coupon_qrcode not between", value1, value2, "couponQrcode");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
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