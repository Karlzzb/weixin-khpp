package com.khpp.weixin.db.domain;

import java.util.Date;

public class DictParking {
	private Integer parkingId;

	private String parkingName;

	private Double definedPrice;

	private Float latitude;

	private Float longitude;

	private Date createTime;

	private Date dmlTime;

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

	public Double getDefinedPrice() {
		return definedPrice;
	}

	public void setDefinedPrice(Double definedPrice) {
		this.definedPrice = definedPrice;
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