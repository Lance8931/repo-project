package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Supplier;

public interface SupplierMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Supplier record);

	int insertSelective(Supplier record);

	Supplier selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Supplier record);

	int updateByPrimaryKey(Supplier record);

	List<Supplier> getList(Map<?, ?> map);
}