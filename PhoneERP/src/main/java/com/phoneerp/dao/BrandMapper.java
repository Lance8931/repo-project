package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Brand;

public interface BrandMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Brand record);

	int insertSelective(Brand record);

	Brand selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Brand record);

	int updateByPrimaryKey(Brand record);

	List<Brand> getList(Map<?, ?> map);

	Integer getCountByBrandName(String brandName);
}