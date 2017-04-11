package com.khpp.db.service;

import com.khpp.db.domain.User;
import com.khpp.db.genric.GenericService;

public interface UserService extends GenericService<User, Integer> {

	/**
	 * 用户验证
	 * 
	 * @param user
	 * @return
	 */
	User authentication(User user);
}
