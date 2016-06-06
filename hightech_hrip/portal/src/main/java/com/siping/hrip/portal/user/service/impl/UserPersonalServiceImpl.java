package com.siping.hrip.portal.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.mapper.UserPersonalMapper;
import com.siping.hrip.portal.user.service.UserPersonalService;

@Service
public class UserPersonalServiceImpl implements UserPersonalService {

    @Autowired
    private UserPersonalMapper personalMapper;

    @Override
    public ResultMsg addPersonal(UserPersonalInfo personal) throws BusinessProcessException {
        try {
            personalMapper.addUserPersonalInfo(personal);
            return new ResultMsg(true, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("操作数据库失败。");
        }
    }

    @Override
    public ResultMsg updatePersonal(UserPersonalInfo personal) throws BusinessProcessException {
        if (personal.getId() != null) {
            try {
                personalMapper.updatePersonal(personal);
                return new ResultMsg(true, "更新成功。");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("操作数据库失败。");
            }
        } else {
            return new ResultMsg(false, "更新失败，非法Id。");
        }
    }

    @Override
    public UserPersonalInfo getUserPersonal(String username) throws BusinessProcessException {
        try {
            return personalMapper.getUserpersonal(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("操作数据库失败。");
        }
    }

    @Override
    public PageResponse<User> getListByPage(PageRequest pageRequest, UserPersonalInfo personal) throws BusinessProcessException {
        PageResponse<User> pageresponse = new PageResponse<User>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("startNo", pageRequest.getStartNo());
            map.put("pageSize", pageRequest.getPageSize());
            List<User> listPersonal = personalMapper.getListByPage(map);
            Integer total = personalMapper.getCount(map);
            pageresponse.setRecords(listPersonal);
            pageresponse.setTotal(total);
            return pageresponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("查询个人用户列表失败。");
        }

    }

}
