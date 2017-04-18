package com.khpp.db.domain;

import java.util.Date;

public class CouponOffer {
	private Integer couponId;

	private String couponBrand;

	private Integer couponType;

	private Integer offerStatus;

	private Double price;

	private String couponQrcode;

	private String detail;

	private Date createTime;

	private Date dmlTime;

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

	public String getCouponQrcode() {
		return couponQrcode;
	}

	public void setCouponQrcode(String couponQrcode) {
		this.couponQrcode = couponQrcode == null ? null : couponQrcode.trim();
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
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