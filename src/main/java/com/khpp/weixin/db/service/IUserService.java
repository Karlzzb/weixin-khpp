package com.khpp.weixin.db.service;

import com.khpp.weixin.db.domain.User;

public interface IUserService {
	public User getUserById(int userId);
}