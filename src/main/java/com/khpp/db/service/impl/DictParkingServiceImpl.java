package com.khpp.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.db.dao.DictParkingMapper;
import com.khpp.db.domain.DictParking;
import com.khpp.db.domain.DictParkingExample;
import com.khpp.db.genric.GenericDao;
import com.khpp.db.genric.GenericServiceImpl;
import com.khpp.db.service.DictParkingService;

/**
 * 用户Service实现类
 *
 */
@Service
public class DictParkingServiceImpl extends
		GenericServiceImpl<DictParking, Integer> implements DictParkingService {

	@Resource
	private DictParkingMapper dictParkingMapper;

	@Override
	public GenericDao<DictParking, Integer> getDao() {
		return dictParkingMapper;
	}

	@Override
	public List<DictParking> selectList() {
		DictParkingExample example = new DictParkingExample();
		return dictParkingMapper.selectByExample(example);
	}
}
