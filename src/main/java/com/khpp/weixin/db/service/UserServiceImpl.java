package com.khpp.weixin.db.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.weixin.db.dao.IUserDao;
import com.khpp.weixin.db.domain.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}
}
