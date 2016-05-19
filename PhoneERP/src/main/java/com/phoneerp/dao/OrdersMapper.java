package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Orders;

public interface OrdersMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Orders record);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	List<Orders> getList(Map<?, ?> map);

	Integer getCount(Map<?, ?> map);
}