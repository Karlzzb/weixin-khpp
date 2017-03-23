package com.khpp.weixin.db.domain;

import java.util.Date;

public class User {
	public User(String username, String wxOpenId) {
		super();
		this.username = username;
		this.wxOpenId = wxOpenId;
	}

	private Integer userId;

	private String username;

	private String wxOpenId;

	private String password;

	private String paidPw;

	private Byte userState;

	private Date subscribeTime;

	private Date unsubscribeTime;

	private Date createTime;

	private Date dmlTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getPaidPw() {
		return paidPw;
	}

	public void setPaidPw(String paidPw) {
		this.paidPw = paidPw == null ? null : paidPw.trim();
	}

	public Byte getUserState() {
		return userState;
	}

	public void setUserState(Byte userState) {
		this.userState = userState;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUnsubscribeTime() {
		return unsubscribeTime;
	}

	public void setUnsubscribeTime(Date unsubscribeTime) {
		this.unsubscribeTime = unsubscribeTime;
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