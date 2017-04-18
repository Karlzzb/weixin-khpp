package com.khpp.db.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponOrderExample() {
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

        public Criteria andCouponOrderIdIsNull() {
            addCriterion("coupon_order_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdIsNotNull() {
            addCriterion("coupon_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdEqualTo(String value) {
            addCriterion("coupon_order_id =", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdNotEqualTo(String value) {
            addCriterion("coupon_order_id <>", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdGreaterThan(String value) {
            addCriterion("coupon_order_id >", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_order_id >=", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdLessThan(String value) {
            addCriterion("coupon_order_id <", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_order_id <=", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdLike(String value) {
            addCriterion("coupon_order_id like", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdNotLike(String value) {
            addCriterion("coupon_order_id not like", value, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdIn(List<String> values) {
            addCriterion("coupon_order_id in", values, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdNotIn(List<String> values) {
            addCriterion("coupon_order_id not in", values, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdBetween(String value1, String value2) {
            addCriterion("coupon_order_id between", value1, value2, "couponOrderId");
            return (Criteria) this;
        }

        public Criteria andCouponOrderIdNotBetween(String value1, String value2) {
            addCriterion("coupon_order_id not between", value1, value2, "couponOrderId");
            return (Criteria) this;
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

        public Criteria andWxOpenidBuierIsNull() {
            addCriterion("wx_openid_buier is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierIsNotNull() {
            addCriterion("wx_openid_buier is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierEqualTo(String value) {
            addCriterion("wx_openid_buier =", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierNotEqualTo(String value) {
            addCriterion("wx_openid_buier <>", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierGreaterThan(String value) {
            addCriterion("wx_openid_buier >", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid_buier >=", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierLessThan(String value) {
            addCriterion("wx_openid_buier <", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierLessThanOrEqualTo(String value) {
            addCriterion("wx_openid_buier <=", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierLike(String value) {
            addCriterion("wx_openid_buier like", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierNotLike(String value) {
            addCriterion("wx_openid_buier not like", value, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierIn(List<String> values) {
            addCriterion("wx_openid_buier in", values, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierNotIn(List<String> values) {
            addCriterion("wx_openid_buier not in", values, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierBetween(String value1, String value2) {
            addCriterion("wx_openid_buier between", value1, value2, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBuierNotBetween(String value1, String value2) {
            addCriterion("wx_openid_buier not between", value1, value2, "wxOpenidBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierIsNull() {
            addCriterion("wx_nick_name_buier is null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierIsNotNull() {
            addCriterion("wx_nick_name_buier is not null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierEqualTo(String value) {
            addCriterion("wx_nick_name_buier =", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierNotEqualTo(String value) {
            addCriterion("wx_nick_name_buier <>", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierGreaterThan(String value) {
            addCriterion("wx_nick_name_buier >", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierGreaterThanOrEqualTo(String value) {
            addCriterion("wx_nick_name_buier >=", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierLessThan(String value) {
            addCriterion("wx_nick_name_buier <", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierLessThanOrEqualTo(String value) {
            addCriterion("wx_nick_name_buier <=", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierLike(String value) {
            addCriterion("wx_nick_name_buier like", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierNotLike(String value) {
            addCriterion("wx_nick_name_buier not like", value, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierIn(List<String> values) {
            addCriterion("wx_nick_name_buier in", values, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierNotIn(List<String> values) {
            addCriterion("wx_nick_name_buier not in", values, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierBetween(String value1, String value2) {
            addCriterion("wx_nick_name_buier between", value1, value2, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBuierNotBetween(String value1, String value2) {
            addCriterion("wx_nick_name_buier not between", value1, value2, "wxNickNameBuier");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Integer> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdIsNull() {
            addCriterion("wx_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdIsNotNull() {
            addCriterion("wx_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdEqualTo(String value) {
            addCriterion("wx_order_id =", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdNotEqualTo(String value) {
            addCriterion("wx_order_id <>", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdGreaterThan(String value) {
            addCriterion("wx_order_id >", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_order_id >=", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdLessThan(String value) {
            addCriterion("wx_order_id <", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdLessThanOrEqualTo(String value) {
            addCriterion("wx_order_id <=", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdLike(String value) {
            addCriterion("wx_order_id like", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdNotLike(String value) {
            addCriterion("wx_order_id not like", value, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdIn(List<String> values) {
            addCriterion("wx_order_id in", values, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdNotIn(List<String> values) {
            addCriterion("wx_order_id not in", values, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdBetween(String value1, String value2) {
            addCriterion("wx_order_id between", value1, value2, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andWxOrderIdNotBetween(String value1, String value2) {
            addCriterion("wx_order_id not between", value1, value2, "wxOrderId");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIsNull() {
            addCriterion("paid_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIsNotNull() {
            addCriterion("paid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaidAmountEqualTo(BigDecimal value) {
            addCriterion("paid_amount =", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotEqualTo(BigDecimal value) {
            addCriterion("paid_amount <>", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountGreaterThan(BigDecimal value) {
            addCriterion("paid_amount >", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amount >=", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountLessThan(BigDecimal value) {
            addCriterion("paid_amount <", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amount <=", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIn(List<BigDecimal> values) {
            addCriterion("paid_amount in", values, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotIn(List<BigDecimal> values) {
            addCriterion("paid_amount not in", values, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amount between", value1, value2, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amount not between", value1, value2, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Float value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Float value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Float value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Float value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Float value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Float> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Float> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Float value1, Float value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Float value1, Float value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Float value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Float value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Float value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Float value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Float value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Float> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Float> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Float value1, Float value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Float value1, Float value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
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