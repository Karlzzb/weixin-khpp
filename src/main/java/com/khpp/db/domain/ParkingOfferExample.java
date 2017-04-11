package com.khpp.db.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingOfferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingOfferExample() {
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

        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxNickNameIsNull() {
            addCriterion("wx_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameIsNotNull() {
            addCriterion("wx_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andWxNickNameEqualTo(String value) {
            addCriterion("wx_nick_name =", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotEqualTo(String value) {
            addCriterion("wx_nick_name <>", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameGreaterThan(String value) {
            addCriterion("wx_nick_name >", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("wx_nick_name >=", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLessThan(String value) {
            addCriterion("wx_nick_name <", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLessThanOrEqualTo(String value) {
            addCriterion("wx_nick_name <=", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameLike(String value) {
            addCriterion("wx_nick_name like", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotLike(String value) {
            addCriterion("wx_nick_name not like", value, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameIn(List<String> values) {
            addCriterion("wx_nick_name in", values, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotIn(List<String> values) {
            addCriterion("wx_nick_name not in", values, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameBetween(String value1, String value2) {
            addCriterion("wx_nick_name between", value1, value2, "wxNickName");
            return (Criteria) this;
        }

        public Criteria andWxNickNameNotBetween(String value1, String value2) {
            addCriterion("wx_nick_name not between", value1, value2, "wxNickName");
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

        public Criteria andValidStartTimeIsNull() {
            addCriterion("valid_start_time is null");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeIsNotNull() {
            addCriterion("valid_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeEqualTo(Date value) {
            addCriterion("valid_start_time =", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotEqualTo(Date value) {
            addCriterion("valid_start_time <>", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeGreaterThan(Date value) {
            addCriterion("valid_start_time >", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_start_time >=", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeLessThan(Date value) {
            addCriterion("valid_start_time <", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_start_time <=", value, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeIn(List<Date> values) {
            addCriterion("valid_start_time in", values, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotIn(List<Date> values) {
            addCriterion("valid_start_time not in", values, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeBetween(Date value1, Date value2) {
            addCriterion("valid_start_time between", value1, value2, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_start_time not between", value1, value2, "validStartTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNull() {
            addCriterion("valid_end_time is null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIsNotNull() {
            addCriterion("valid_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeEqualTo(Date value) {
            addCriterion("valid_end_time =", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotEqualTo(Date value) {
            addCriterion("valid_end_time <>", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThan(Date value) {
            addCriterion("valid_end_time >", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_end_time >=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThan(Date value) {
            addCriterion("valid_end_time <", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_end_time <=", value, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeIn(List<Date> values) {
            addCriterion("valid_end_time in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotIn(List<Date> values) {
            addCriterion("valid_end_time not in", values, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeBetween(Date value1, Date value2) {
            addCriterion("valid_end_time between", value1, value2, "validEndTime");
            return (Criteria) this;
        }

        public Criteria andValidEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_end_time not between", value1, value2, "validEndTime");
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