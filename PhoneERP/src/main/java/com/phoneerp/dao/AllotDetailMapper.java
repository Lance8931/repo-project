package com.phoneerp.dao;

import com.phoneerp.bean.AllotDetail;

public interface AllotDetailMapper {
    int insert(AllotDetail record);

    int insertSelective(AllotDetail record);
}