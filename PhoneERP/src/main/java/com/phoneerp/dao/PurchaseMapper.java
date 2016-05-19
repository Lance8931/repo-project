package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Purchase;

public interface PurchaseMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Purchase record);

	int insertSelective(Purchase record);

	Purchase selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Purchase record);

	int updateByPrimaryKey(Purchase record);

	List<Purchase> getList(Map<?, ?> map);

	Integer getCount(Map<?, ?> map);
}