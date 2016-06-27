package com.siping.hrip.portal.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.portal.entity.Area;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.common.service.AreaService;

/**
 * 省市县地区Controller
 * @author siping-L.J.H
 * @date 2016年4月29日上午9:56:11
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/area")
public class AreaController extends StromaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getAreaDatas", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse<Area> getAreaDatas(String type, Integer parentId) {
        return areaService.getAreaDatas(type, parentId);
    }
}
