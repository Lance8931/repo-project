package com.siping.hrip.portal.user.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Area;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.common.service.AreaService;
import com.siping.hrip.portal.user.service.UserPersonalService;

@Controller
@RequestMapping(value = "/userPsersonal")
public class UserPersonalController {
    @Autowired
    UserPersonalService personalService;

    @Autowired
    private AreaService areaService;

    private static List<Integer> TEMP_LIST = Arrays.asList(new Integer[] { 110000, 120000, 310000, 500000 });

    /**
     * 分页查询个人用户
     * @param request
     * @return
     * @date 2016年5月5日上午10:26:54
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<User> list(PageRequest request, UserPersonalInfo userPersonalInfo) {
        try {
            return personalService.getListByPage(request, userPersonalInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加个人用户
     * @param user
     * @param userPersonalInfo
     * @return
     * @date 2016年5月5日下午5:41:07
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg add(UserPersonalInfo userPersonalInfo) {
        if (TEMP_LIST.contains(userPersonalInfo.getProvince())) {
            userPersonalInfo.setCity(0);
        }
        try {
            return personalService.addPersonal(userPersonalInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "添加失败，" + e.getMessage());
        }
    }

    /**
     * 修改个人用户
     * @param userPersonalInfo
     * @return
     * @date 2016年5月5日下午5:40:46
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg edit(UserPersonalInfo userPersonalInfo) {
        if (TEMP_LIST.contains(userPersonalInfo.getProvince())) {
            userPersonalInfo.setCity(0);
        }
        try {
            return personalService.updatePersonal(userPersonalInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "修改失败，" + e.getMessage());
        }
    }

    /**
     * 跳转至个人用户列表
     * @return
     * @date 2016年4月28日下午1:48:20
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectList")
    public String redirectList() {
        return PagePath.USER_PERSONAL_LIST;
    }

    /**
     * 跳转至个人用户添加页面
     * @return
     * @date 2016年4月28日下午2:42:23
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectAdd")
    public String redirectAdd(String username, String email, ModelMap map) {
        map.put("username", username);
        map.put("email", email);
        return PagePath.USER_PERSONAL_ADD;
    }

    /**
     * 跳转至个人用户编辑页面
     * @param id
     * @param map
     * @return
     * @date 2016年5月4日上午9:34:03
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectEdit")
    public String redirectEdit(String username, ModelMap map) {
        if (StringUtils.isNotBlank(username)) {
            getUserPersonalMap(username, map);
        }
        return PagePath.USER_PERSONAL_EDIT;
    }

    /**
     * 跳转至个人用户详情页面
     * @param idCode
     * @param map
     * @return
     * @date 2016年5月4日下午2:45:32
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectView")
    public String redirectView(String username, ModelMap map) {
        if (StringUtils.isNotBlank(username)) {
            getUserPersonalMap(username, map);
        }
        return PagePath.USER_PERSONAL_VIEW;
    }

    /**
     * 获取个人用户详情/编辑与页面所需的数据
     * @param idCode
     * @return
     * @date 2016年5月4日下午2:41:01
     * @author siping-L.J.H
     */
    private void getUserPersonalMap(String username, ModelMap map) {

        UserPersonalInfo info = new UserPersonalInfo();
        PageResponse<Area> proList = null;
        PageResponse<Area> cityList = null;
        PageResponse<Area> countyList = null;
        PageResponse<Area> reCityList = null;
        boolean isEnabledCity = true;
        try {
            info = personalService.getUserPersonal(username);
            proList = areaService.getAreaDatas(null, null);

            if (TEMP_LIST.contains(info.getProvince())) {
                isEnabledCity = false;
                countyList = areaService.getAreaDatas("city", info.getProvince());
            } else if (info.getProvince() != null) {
                cityList = areaService.getAreaDatas("province", info.getProvince());
            }
            if (info.getCity() != 0) {
                countyList = areaService.getAreaDatas("city", info.getCity());
            }
            if (info.getResidentCity() != null) {
                Integer reProCode = new Integer(info.getResidentCity().toString().substring(0, 2) + "0000");
                map.put("reProCode", reProCode);
                if (TEMP_LIST.contains(reProCode)) {
                    reCityList = areaService.getAreaDatas("city", reProCode);
                } else {
                    reCityList = areaService.getAreaDatas("province", reProCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("personal", info);
        map.put("proList", proList);
        map.put("cityList", cityList);
        map.put("countyList", countyList);
        map.put("reCityList", reCityList);
        map.put("isEnabledCity", isEnabledCity);
    }
}
