package com.khpp.db.domain;

import java.util.Date;

public class CouponOrder {

	private String couponOrderId;

	private Integer couponId;

	private String couponBrand;

	private Integer couponType;

	private String couponQrcode;

	private String wxOpenidBuier;

	private String wxNickNameBuier;

	private Integer orderStatus;

	private String wxOrderId;

	private Double paidAmount;

	private Float latitude;

	private Float longitude;

	private Date createTime;

	private Date dmlTime;

	public String getCouponOrderId() {
		return couponOrderId;
	}

	public void setCouponOrderId(String couponOrderId) {
		this.couponOrderId = couponOrderId == null ? null : couponOrderId
				.trim();
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponBrand() {
		return couponBrand;
	}

	public void setCouponBrand(String couponBrand) {
		this.couponBrand = couponBrand == null ? null : couponBrand.trim();
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public String getCouponQrcode() {
		return couponQrcode;
	}

	public void setCouponQrcode(String couponQrcode) {
		this.couponQrcode = couponQrcode == null ? null : couponQrcode.trim();
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

	public String getWxOrderId() {
		return wxOrderId;
	}

	public void setWxOrderId(String wxOrderId) {
		this.wxOrderId = wxOrderId == null ? null : wxOrderId.trim();
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
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