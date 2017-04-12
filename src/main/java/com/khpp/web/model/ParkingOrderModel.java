package com.khpp.web.model;

import javax.validation.constraints.NotNull;

public class ParkingOrderModel {

	@NotNull
	private Integer selectOfferId;

	private String detail;

	public Integer getSelectOfferId() {
		return selectOfferId;
	}

	public void setSelectOfferId(Integer selectOfferId) {
		this.selectOfferId = selectOfferId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
