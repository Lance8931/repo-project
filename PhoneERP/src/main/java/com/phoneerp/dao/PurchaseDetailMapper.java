package com.phoneerp.dao;

import com.phoneerp.bean.PurchaseDetail;

public interface PurchaseDetailMapper {
    int insert(PurchaseDetail record);

    int insertSelective(PurchaseDetail record);
}