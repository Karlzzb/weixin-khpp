package com.khpp.weixin.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.db.domain.User;
import com.khpp.weixin.db.domain.UserExample;

public interface UserMapper extends GenericDao<User, Integer> {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer userId);

	int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example);

	int updateByExample(@Param("record") User record,
			@Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}