package com.khpp.weixin.db.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingOffer {
    private Integer offerId;

    private Integer parkingId;

    private String parkingName;

    private Integer userIdSellor;

    private Byte offerStatus;

    private BigDecimal price;

    private Date createTime;

    private Date dmlTime;

    private byte[] location;

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

    public Byte getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(Byte offerStatus) {
        this.offerStatus = offerStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }
}