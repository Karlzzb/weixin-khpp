package com.khpp.weixin.db.domain;

import java.util.Date;

public class DictParking {
    private Integer parkingId;

    private String parkingName;

    private Date createTime;

    private Date dmlTime;

    private byte[] location;

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