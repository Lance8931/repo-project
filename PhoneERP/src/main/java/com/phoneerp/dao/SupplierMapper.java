package com.phoneerp.dao;

import com.phoneerp.bean.Supplier;

public interface SupplierMapper {
    int insert(Supplier record);

    int insertSelective(Supplier record);
}