package com.khpp.weixin.web.model;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.hibernate.validator.constraints.Range;

import com.khpp.weixin.db.domain.DictParking;
import com.khpp.weixin.db.domain.ParkingOffer;

public class ParkingOfferModel {
	private Integer parkingId;

	@Range(min = 0, max = 150, message = "{价格不能为空}")
	private Double price;

	private String detail;

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
		domain.setUserIdSellor(0);
		// TODO 添加用户信息
		domain.setOfferStatus(ParkingOffer.OFFERSTATUS_PUBLIC);
		return domain;
	}
}
