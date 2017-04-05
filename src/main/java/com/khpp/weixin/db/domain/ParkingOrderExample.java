package com.khpp.weixin.db.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNull() {
            addCriterion("offer_id is null");
            return (Criteria) this;
        }

        public Criteria andOfferIdIsNotNull() {
            addCriterion("offer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfferIdEqualTo(Integer value) {
            addCriterion("offer_id =", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotEqualTo(Integer value) {
            addCriterion("offer_id <>", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThan(Integer value) {
            addCriterion("offer_id >", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("offer_id >=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThan(Integer value) {
            addCriterion("offer_id <", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdLessThanOrEqualTo(Integer value) {
            addCriterion("offer_id <=", value, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdIn(List<Integer> values) {
            addCriterion("offer_id in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotIn(List<Integer> values) {
            addCriterion("offer_id not in", values, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdBetween(Integer value1, Integer value2) {
            addCriterion("offer_id between", value1, value2, "offerId");
            return (Criteria) this;
        }

        public Criteria andOfferIdNotBetween(Integer value1, Integer value2) {
            addCriterion("offer_id not between", value1, value2, "offerId");
            return (Criteria) this;
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

        public Criteria andWxOpenidSellorIsNull() {
            addCriterion("wx_openid_sellor is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorIsNotNull() {
            addCriterion("wx_openid_sellor is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorEqualTo(String value) {
            addCriterion("wx_openid_sellor =", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorNotEqualTo(String value) {
            addCriterion("wx_openid_sellor <>", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorGreaterThan(String value) {
            addCriterion("wx_openid_sellor >", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid_sellor >=", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorLessThan(String value) {
            addCriterion("wx_openid_sellor <", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorLessThanOrEqualTo(String value) {
            addCriterion("wx_openid_sellor <=", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorLike(String value) {
            addCriterion("wx_openid_sellor like", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorNotLike(String value) {
            addCriterion("wx_openid_sellor not like", value, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorIn(List<String> values) {
            addCriterion("wx_openid_sellor in", values, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorNotIn(List<String> values) {
            addCriterion("wx_openid_sellor not in", values, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorBetween(String value1, String value2) {
            addCriterion("wx_openid_sellor between", value1, value2, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxOpenidSellorNotBetween(String value1, String value2) {
            addCriterion("wx_openid_sellor not between", value1, value2, "wxOpenidSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorIsNull() {
            addCriterion("wx_nick_name_sellor is null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorIsNotNull() {
            addCriterion("wx_nick_name_sellor is not null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorEqualTo(String value) {
            addCriterion("wx_nick_name_sellor =", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorNotEqualTo(String value) {
            addCriterion("wx_nick_name_sellor <>", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorGreaterThan(String value) {
            addCriterion("wx_nick_name_sellor >", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorGreaterThanOrEqualTo(String value) {
            addCriterion("wx_nick_name_sellor >=", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorLessThan(String value) {
            addCriterion("wx_nick_name_sellor <", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorLessThanOrEqualTo(String value) {
            addCriterion("wx_nick_name_sellor <=", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorLike(String value) {
            addCriterion("wx_nick_name_sellor like", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorNotLike(String value) {
            addCriterion("wx_nick_name_sellor not like", value, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorIn(List<String> values) {
            addCriterion("wx_nick_name_sellor in", values, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorNotIn(List<String> values) {
            addCriterion("wx_nick_name_sellor not in", values, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorBetween(String value1, String value2) {
            addCriterion("wx_nick_name_sellor between", value1, value2, "wxNickNameSellor");
            return (Criteria) this;
        }

        public Criteria andWxNickNameSellorNotBetween(String value1, String value2) {
            addCriterion("wx_nick_name_sellor not between", value1, value2, "wxNickNameSellor");
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

        public Criteria andWxFromOrderIdIsNull() {
            addCriterion("wx_from_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdIsNotNull() {
            addCriterion("wx_from_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdEqualTo(String value) {
            addCriterion("wx_from_order_id =", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdNotEqualTo(String value) {
            addCriterion("wx_from_order_id <>", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdGreaterThan(String value) {
            addCriterion("wx_from_order_id >", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_from_order_id >=", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdLessThan(String value) {
            addCriterion("wx_from_order_id <", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdLessThanOrEqualTo(String value) {
            addCriterion("wx_from_order_id <=", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdLike(String value) {
            addCriterion("wx_from_order_id like", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdNotLike(String value) {
            addCriterion("wx_from_order_id not like", value, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdIn(List<String> values) {
            addCriterion("wx_from_order_id in", values, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdNotIn(List<String> values) {
            addCriterion("wx_from_order_id not in", values, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdBetween(String value1, String value2) {
            addCriterion("wx_from_order_id between", value1, value2, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxFromOrderIdNotBetween(String value1, String value2) {
            addCriterion("wx_from_order_id not between", value1, value2, "wxFromOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdIsNull() {
            addCriterion("wx_to_order_id is null");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdIsNotNull() {
            addCriterion("wx_to_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdEqualTo(String value) {
            addCriterion("wx_to_order_id =", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdNotEqualTo(String value) {
            addCriterion("wx_to_order_id <>", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdGreaterThan(String value) {
            addCriterion("wx_to_order_id >", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_to_order_id >=", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdLessThan(String value) {
            addCriterion("wx_to_order_id <", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdLessThanOrEqualTo(String value) {
            addCriterion("wx_to_order_id <=", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdLike(String value) {
            addCriterion("wx_to_order_id like", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdNotLike(String value) {
            addCriterion("wx_to_order_id not like", value, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdIn(List<String> values) {
            addCriterion("wx_to_order_id in", values, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdNotIn(List<String> values) {
            addCriterion("wx_to_order_id not in", values, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdBetween(String value1, String value2) {
            addCriterion("wx_to_order_id between", value1, value2, "wxToOrderId");
            return (Criteria) this;
        }

        public Criteria andWxToOrderIdNotBetween(String value1, String value2) {
            addCriterion("wx_to_order_id not between", value1, value2, "wxToOrderId");
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

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
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