package com.siping.hrip.portal.common.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.domain.portal.entity.Area;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.common.mapper.AreaMapper;
import com.siping.hrip.portal.common.service.AreaService;

/**
 * 省市县地区Service实现
 * @author siping-L.J.H
 * @date 2016年4月29日上午9:57:04
 * @version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public PageResponse<Area> getProvinceList() {
        PageResponse<Area> areas = new PageResponse<Area>();
        areas.setRecords(areaMapper.getProvinceList());
        return areas;
    }

    @Override
    public PageResponse<Area> getCityByPID(Integer parentId) {
        PageResponse<Area> areas = new PageResponse<Area>();
        areas.setRecords(areaMapper.getCityByPID(parentId));
        return areas;
    }

    @Override
    public PageResponse<Area> getCountyByCID(Integer parentId) {
        PageResponse<Area> areas = new PageResponse<Area>();
        areas.setRecords(areaMapper.getCountyByCID(parentId));
        return areas;
    }

    @Override
    public PageResponse<Area> getAreaDatas(String type, Integer parentId) {
        List<Integer> tempList = Arrays.asList(new Integer[] { 110000, 120000, 310000, 500000 });
        PageResponse<Area> areas = new PageResponse<Area>();
        if (StringUtils.isBlank(type)) {
            areas.setRecords(areaMapper.getProvinceList());
        } else if (tempList.contains(parentId) || type.equals("city")) {
            areas.setRecords(areaMapper.getCountyByCID(parentId));
        } else if (type.equals("province")) {
            areas.setRecords(areaMapper.getCityByPID(parentId));
        }
        return areas;
    }
}
