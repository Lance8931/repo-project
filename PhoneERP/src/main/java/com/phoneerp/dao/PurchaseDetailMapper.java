package com.phoneerp.dao;

import com.phoneerp.bean.PurchaseDetail;

public interface PurchaseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseDetail record);

    int insertSelective(PurchaseDetail record);

    PurchaseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseDetail record);

    int updateByPrimaryKey(PurchaseDetail record);
}