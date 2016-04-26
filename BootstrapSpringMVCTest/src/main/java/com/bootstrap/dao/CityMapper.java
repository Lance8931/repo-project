package com.bootstrap.dao;

import java.util.List;
import java.util.Map;

import com.bootstrap.bean.City;
import com.bootstrap.bean.ResultBean;

public interface CityMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(City record);

	int insertSelective(City record);

	City selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(City record);

	int updateByPrimaryKey(City record);

	List<ResultBean> getListByPage(Map<?, ?> map);

	Integer getCount();
}