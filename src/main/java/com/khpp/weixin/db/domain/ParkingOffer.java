package com.khpp.weixin.db.domain;

import java.util.Date;

public class ParkingOffer {
	public static final int OFFERSTATUS_PUBLIC = 1;
	public static final int OFFERSTATUS_SELL = 2;
	public static final int OFFERSTATUS_NONE = 3;

	private Integer offerId;

	private Integer parkingId;

	private String parkingName;

	private Integer userIdSellor;

	private Integer offerStatus;

	private Double price;

	private String detail;

	private Float latitude;

	private Float longitude;

	private Date createTime;

	private Date dmlTime;

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

	public Integer getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(Integer offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
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