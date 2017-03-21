package com.khpp.weixin.db.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.core.GenericServiceImpl;
import com.khpp.weixin.db.dao.UserMapper;
import com.khpp.weixin.db.domain.User;
import com.khpp.weixin.db.service.UserService;

/**
 * 用户Service实现类
 *
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements
		UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public int insert(User model) {
		return userMapper.insertSelective(model);
	}

	@Override
	public int update(User model) {
		return userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User authentication(User user) {
		return userMapper.authentication(user);
	}

	@Override
	public User selectById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<User, Long> getDao() {
		return userMapper;
	}

}
