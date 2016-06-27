package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Shop;

public interface ShopMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Shop record);

	int insertSelective(Shop record);

	Shop selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Shop record);

	int updateByPrimaryKey(Shop record);

	List<Shop> getList(Map<?, ?> map);

	Integer getCountByShopName(String shopName);
}