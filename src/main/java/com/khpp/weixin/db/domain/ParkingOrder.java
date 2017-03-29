package com.khpp.weixin.db.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingOrder {
    private Integer orderId;

    private Integer offerId;

    private Integer parkingId;

    private String parkingName;

    private Integer userIdSellor;

    private Integer userIdBuier;

    private Integer orderStatus;

    private String wxFromOrderId;

    private String wxToOrderId;

    private BigDecimal paidAmount;

    private BigDecimal serviceFee;

    private Float latitude;

    private Float longitude;

    private Date createTime;

    private Date dmlTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName == null ? null : parkingName.trim();
    }

    public Integer getUserIdSellor() {
        return userIdSellor;
    }

    public void setUserIdSellor(Integer userIdSellor) {
        this.userIdSellor = userIdSellor;
    }

    public Integer getUserIdBuier() {
        return userIdBuier;
    }

    public void setUserIdBuier(Integer userIdBuier) {
        this.userIdBuier = userIdBuier;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getWxFromOrderId() {
        return wxFromOrderId;
    }

    public void setWxFromOrderId(String wxFromOrderId) {
        this.wxFromOrderId = wxFromOrderId == null ? null : wxFromOrderId.trim();
    }

    public String getWxToOrderId() {
        return wxToOrderId;
    }

    public void setWxToOrderId(String wxToOrderId) {
        this.wxToOrderId = wxToOrderId == null ? null : wxToOrderId.trim();
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDmlTime() {
        return dmlTime;
    }

    public void setDmlTime(Date dmlTime) {
        this.dmlTime = dmlTime;
    }
}