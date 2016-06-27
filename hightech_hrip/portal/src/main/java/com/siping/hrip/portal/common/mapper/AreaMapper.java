package com.siping.hrip.portal.common.mapper;

import java.util.List;

import com.siping.domain.portal.entity.Area;

/**
 * 省市县地区Mapper接口
 * @author siping-L.J.H
 * @date 2016年4月29日上午9:56:36
 * @version 1.0
 */
public interface AreaMapper {
    /**
     * 获取所有省份
     * @return
     * @date 2016年4月29日上午10:07:54
     * @author siping-L.J.H
     */
    List<Area> getProvinceList();

    /**
     * 根据省份编码获取City
     * @param parentId
     * @return
     * @date 2016年4月29日上午10:08:25
     * @author siping-L.J.H
     */
    List<Area> getCityByPID(Integer parentId);

    /**
     * 根据市编码获取County
     * @param parentId
     * @return
     * @date 2016年4月29日上午10:08:48
     * @author siping-L.J.H
     */
    List<Area> getCountyByCID(Integer parentId);
}
