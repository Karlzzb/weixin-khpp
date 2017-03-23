package com.khpp.weixin.db.service;

import com.khpp.weixin.core.GenericService;
import com.khpp.weixin.db.domain.User;

public interface UserService extends GenericService<User, Integer> {

	/**
	 * 用户验证
	 * 
	 * @param user
	 * @return
	 */
	User authentication(User user);
}
