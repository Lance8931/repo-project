package com.siping.problem.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.answer.mapper.UserAnswerMapper;
import com.siping.problem.bean.ProblemInfo;
import com.siping.problem.bean.UserProblem;
import com.siping.problem.mapper.UserProblemMapper;
import com.siping.problem.service.UserProblemService;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

@Service
public class UserProbleServiceImpl implements UserProblemService {

	@Autowired
	private UserProblemMapper userProblemMapper;

	@Autowired
	private UserAnswerMapper userAnswerMapper;

	@Override
	public void insertProblem(UserProblem userProblem, SysUser sysUser)
			throws Exception {
		if (null != userProblem && null != sysUser && null != sysUser.getId()) {
			userProblem.setAddTime(new Date());
			userProblem.setAddBy(sysUser.getId());
			userProblem.setUpdateTime(new Date());
			userProblem.setUpdateBy(sysUser.getId());
			userProblem.setProblemDate(new Date());
			userProblem.setUserId(sysUser.getId());
			try {
				userProblemMapper.insert(userProblem);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		} else {
			throw new Exception("存在无效数据，数据插入失败！");
		}
	}

	@Override
	public void updateProblem(UserProblem userProblem, SysUser sysUser)
			throws Exception {
		if (null != userProblem && null != userProblem.getId()
				&& null != sysUser && null != sysUser.getId()) {
			userProblem.setUpdateTime(new Date());
			userProblem.setUpdateBy(sysUser.getId());
			userProblem.setProblemDate(new Date());
			try {
				userProblemMapper.updateByPrimaryKeySelective(userProblem);
			} catch (Exception e) {
				throw new Exception("更新数据异常，数据更新失败！");
			}
		} else {
			throw new Exception("存在无效数据，数据更新失败！");
		}

	}

	@Override
	public void deleteProblemsAndAnswers(Integer[] ids) throws Exception {
		if (null != ids && 0 > ids.length) {
			try {
				userProblemMapper.deleteByIds(Arrays.asList(ids));
				userAnswerMapper.deleteByProblemIds(Arrays.asList(ids));
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("删除数据出现异常，删除问题与答案失败！");
			}
		} else {
			throw new Exception("存在无效数据，删除问题与答案失败！");
		}

	}

	@Override
	public PageResponse<ProblemInfo> getByPage(UserProblem userProblem,
			PageRequest pageRequest) throws Exception {
		PageResponse<ProblemInfo> pageResponse = new PageResponse<ProblemInfo>();
		Map<String, Object> map = new HashMap<String, Object>();
		map = PropertyUtils.describe(userProblem);
		map.put("startNo", pageRequest.getStartNo());
		map.put("pageSize", pageRequest.getPageSize());
		List<ProblemInfo> list = userProblemMapper
				.getProblemInfoListByPage(map);
		if (null != list && 0 != list.size()) {
			pageResponse.setRecords(list);
			pageResponse.setTotal(userProblemMapper.getCount(map).intValue());
			return pageResponse;
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public UserProblem getProblem(UserProblem userProblem) throws Exception {
		Map<String, Object> map = PropertyUtils.describe(userProblem);
		List<UserProblem> list = userProblemMapper.get(map);
		if (null != list && 0 != list.size()) {
			return list.get(0);
		} else {
			throw new Exception("无数据");
		}
	}

	@Override
	public ProblemInfo getProblemInfo(UserProblem userProblem) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map = PropertyUtils.describe(userProblem);
		return userProblemMapper.getProblemInfoListByPage(map).get(0);
	}
}
