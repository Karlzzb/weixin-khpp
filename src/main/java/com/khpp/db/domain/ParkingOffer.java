package com.khpp.db.domain;

import java.util.Date;

import com.khpp.common.utils.DateUtil;

public class ParkingOffer {

	/**
	 * <pre>
	 * 停车券状态
	 * {@link com.khpp.common.constants.CommonConstans#OFFERSTATUS_PUBLIC}
	 * {@link com.khpp.common.constants.CommonConstans#OFFERSTATUS_SOLD}
	 * {@link com.khpp.common.constants.CommonConstans#OFFERSTATUS_UNAVILABLE}
	 * {@link com.khpp.common.constants.CommonConstans#OFFERVALIDHOURS}
	 * </pre>
	 * 
	 * @param offerStatus
	 */
	public ParkingOffer(Integer offerId, Integer offerStatus) {
		super();
		this.offerId = offerId;
		this.offerStatus = offerStatus;
	}

	public ParkingOffer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Integer offerId;

	private Integer parkingId;

	private String parkingName;

	private String wxOpenid;

	private String wxNickName;

	private Integer offerStatus;

	private Double price;

	private Date validStartTime;

	private Date validEndTime;

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

	public String getWxOpenid() {
		return wxOpenid;
	}

	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
	}

	public String getWxNickName() {
		return wxNickName;
	}

	public void setWxNickName(String wxNickName) {
		this.wxNickName = wxNickName == null ? null : wxNickName.trim();
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

	public Date getValidStartTime() {
		return validStartTime;
	}

	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}

	public Date getValidEndTime() {
		return validEndTime;
	}

	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
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

	public String getStartTime() {
		return validStartTime == null ? "" : DateUtil
				.dateToTimeString(this.validStartTime);
	}

	public String getEndTime() {
		return validEndTime == null ? "" : DateUtil
				.dateToTimeString(this.validEndTime);
	}
}