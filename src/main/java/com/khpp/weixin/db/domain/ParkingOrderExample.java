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

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andUserIdSellorIsNull() {
            addCriterion("user_id_sellor is null");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorIsNotNull() {
            addCriterion("user_id_sellor is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorEqualTo(Integer value) {
            addCriterion("user_id_sellor =", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorNotEqualTo(Integer value) {
            addCriterion("user_id_sellor <>", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorGreaterThan(Integer value) {
            addCriterion("user_id_sellor >", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_sellor >=", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorLessThan(Integer value) {
            addCriterion("user_id_sellor <", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_sellor <=", value, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorIn(List<Integer> values) {
            addCriterion("user_id_sellor in", values, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorNotIn(List<Integer> values) {
            addCriterion("user_id_sellor not in", values, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorBetween(Integer value1, Integer value2) {
            addCriterion("user_id_sellor between", value1, value2, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdSellorNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_sellor not between", value1, value2, "userIdSellor");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierIsNull() {
            addCriterion("user_id_buier is null");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierIsNotNull() {
            addCriterion("user_id_buier is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierEqualTo(Integer value) {
            addCriterion("user_id_buier =", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierNotEqualTo(Integer value) {
            addCriterion("user_id_buier <>", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierGreaterThan(Integer value) {
            addCriterion("user_id_buier >", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id_buier >=", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierLessThan(Integer value) {
            addCriterion("user_id_buier <", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierLessThanOrEqualTo(Integer value) {
            addCriterion("user_id_buier <=", value, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierIn(List<Integer> values) {
            addCriterion("user_id_buier in", values, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierNotIn(List<Integer> values) {
            addCriterion("user_id_buier not in", values, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierBetween(Integer value1, Integer value2) {
            addCriterion("user_id_buier between", value1, value2, "userIdBuier");
            return (Criteria) this;
        }

        public Criteria andUserIdBuierNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id_buier not between", value1, value2, "userIdBuier");
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

        public Criteria andOrderStatusEqualTo(Byte value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Byte value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Byte> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Byte value1, Byte value2) {
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