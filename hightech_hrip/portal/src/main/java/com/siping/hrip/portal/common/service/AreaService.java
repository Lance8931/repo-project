package com.siping.hrip.portal.common.service;

import com.siping.domain.portal.entity.Area;
import com.siping.domain.portal.entity.PageResponse;

/**
 * 省市县地区Service接口
 * @author siping-L.J.H
 * @date 2016年4月29日上午9:56:48
 * @version 1.0
 */
public interface AreaService {
    /**
     * 获取所有省份
     * @return
     * @date 2016年4月29日上午10:07:54
     * @author siping-L.J.H
     */
    public PageResponse<Area> getProvinceList();

    /**
     * 根据省份编码获取City
     * @param parentId
     * @return
     * @date 2016年4月29日上午10:08:25
     * @author siping-L.J.H
     */
    public PageResponse<Area> getCityByPID(Integer parentId);

    /**
     * 根据市编码获取County
     * @param parentId
     * @return
     * @date 2016年4月29日上午10:08:48
     * @author siping-L.J.H
     */
    public PageResponse<Area> getCountyByCID(Integer parentId);

    /**
     * 根据type与上一级区域ID获取当前区域数据
     * @param type
     * @param parentId
     * @return
     * @date 2016年5月6日下午2:45:54
     * @author siping-L.J.H
     */
    public PageResponse<Area> getAreaDatas(String type, Integer parentId);
}
