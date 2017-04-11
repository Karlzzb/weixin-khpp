package com.khpp.web.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.DateUtil;
import com.khpp.db.domain.DictParking;
import com.khpp.db.domain.ParkingOffer;

public class ParkingOfferModel {
	public ParkingOfferModel() {
		super();
	}

	public ParkingOfferModel(Date validStartTime, Date validEndTime) {
		super();
		this.validStartTime = validStartTime;
		this.validEndTime = validEndTime;
	}

	private Integer parkingId;

	@Range(min = 0, max = 150, message = "{价格不能为空}")
	private Double price;

	private String detail;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validStartTime;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date validEndTime;

	public Integer getParkingId() {
		return parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
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
		this.detail = detail;
	}

	public ParkingOffer toDomain(DictParking dictParking, WxMpUser wxMapuser) {
		ParkingOffer domain = new ParkingOffer();
		domain.setParkingId(dictParking.getParkingId());
		domain.setPrice(this.price);
		domain.setParkingName(dictParking.getParkingName());
		domain.setDetail(this.detail);
		domain.setWxOpenid(wxMapuser.getOpenId());
		domain.setWxNickName(wxMapuser.getNickname());
		domain.setValidStartTime(validStartTime == null ? new Date()
				: validStartTime);
		domain.setValidEndTime(validEndTime == null ? DateUtil.hourSwing(
				domain.getValidStartTime(), 4) : validEndTime);
		domain.setOfferStatus(CommonConstans.OFFERSTATUS_PUBLIC);
		return domain;
	}

	public Date getValidStartTime() {
		return validStartTime;
	}

	public String getValidStartTimeFormat() {
		return DateUtil.dateToFullString(validStartTime);
	}

	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}

	public Date getValidEndTime() {
		return validEndTime;
	}

	public String getValidEndTimeFormat() {
		return DateUtil.dateToFullString(validEndTime);
	}

	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
	}
}
