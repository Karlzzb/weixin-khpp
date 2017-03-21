package com.khpp.weixin.db.dao;

import org.apache.ibatis.annotations.Param;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.db.domain.User;

/**
 * 用户Dao接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:49:57
 **/
public interface UserMapper extends GenericDao<User, Long> {

	int deleteByPrimaryKey(Long id);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 用户登录验证查询
	 * 
	 * @param record
	 * @return
	 */
	User authentication(@Param("record") User record);

}