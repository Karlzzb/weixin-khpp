package com.khpp.weixin.db.domain;

import java.util.Date;

import com.khpp.weixin.utils.MD5Util;

public class ParkingOrder {
	public ParkingOrder(Integer offerId, Integer parkingId, String parkingName,
			String wxOpenidSellor, String wxNickNameSellor,
			String wxOpenidBuier, String wxNickNameBuier, Integer orderStatus,
			Double paidAmount, Double serviceFee) {
		super();
		this.offerId = offerId;
		this.parkingId = parkingId;
		this.parkingName = parkingName;
		this.wxOpenidSellor = wxOpenidSellor;
		this.wxNickNameSellor = wxNickNameSellor;
		this.wxOpenidBuier = wxOpenidBuier;
		this.wxNickNameBuier = wxNickNameBuier;
		this.orderStatus = orderStatus;
		this.paidAmount = paidAmount;
		this.serviceFee = serviceFee;
		this.orderId = MD5Util.md5EncodeUTF8(wxOpenidBuier + offerId
				+ wxOpenidSellor);
	}

	public ParkingOrder() {
		super();
	}

	private String orderId;

	private Integer offerId;

	private Integer parkingId;

	private String parkingName;

	private String wxOpenidSellor;

	private String wxNickNameSellor;

	private String wxOpenidBuier;

	private String wxNickNameBuier;

	private Integer orderStatus;

	private String wxFromOrderId;

	private String wxToOrderId;

	private Double paidAmount;

	private Double serviceFee;

	private Float latitude;

	private Float longitude;

	private Date createTime;

	private Date dmlTime;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
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

	public String getWxOpenidSellor() {
		return wxOpenidSellor;
	}

	public void setWxOpenidSellor(String wxOpenidSellor) {
		this.wxOpenidSellor = wxOpenidSellor == null ? null : wxOpenidSellor
				.trim();
	}

	public String getWxNickNameSellor() {
		return wxNickNameSellor;
	}

	public void setWxNickNameSellor(String wxNickNameSellor) {
		this.wxNickNameSellor = wxNickNameSellor == null ? null
				: wxNickNameSellor.trim();
	}

	public String getWxOpenidBuier() {
		return wxOpenidBuier;
	}

	public void setWxOpenidBuier(String wxOpenidBuier) {
		this.wxOpenidBuier = wxOpenidBuier == null ? null : wxOpenidBuier
				.trim();
	}

	public String getWxNickNameBuier() {
		return wxNickNameBuier;
	}

	public void setWxNickNameBuier(String wxNickNameBuier) {
		this.wxNickNameBuier = wxNickNameBuier == null ? null : wxNickNameBuier
				.trim();
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
		this.wxFromOrderId = wxFromOrderId == null ? null : wxFromOrderId
				.trim();
	}

	public String getWxToOrderId() {
		return wxToOrderId;
	}

	public void setWxToOrderId(String wxToOrderId) {
		this.wxToOrderId = wxToOrderId == null ? null : wxToOrderId.trim();
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Double serviceFee) {
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