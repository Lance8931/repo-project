package com.siping.answer.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.answer.bean.UserAnswer;
import com.siping.answer.mapper.UserAnswerMapper;
import com.siping.answer.service.UserAnswerService;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

/**
 * 答案Service实现类
 *
 * @author siping-L.J.H
 * @date 2016年3月3日上午11:51:13
 * @version 1.0
 */
@Service
public class UserAnswerServiceImpl implements UserAnswerService {

	@Autowired
	private UserAnswerMapper userAnswerMapper;
	
	@Override
	public void insertAnswer(UserAnswer userAnswer, SysUser sysUser) throws Exception {
		if (null != userAnswer 
				&& null != userAnswer.getProblemId() 
				&& null != userAnswer.getContent()
				&& null != sysUser
				&& null != sysUser.getId()) {
			userAnswer.setAddBy(sysUser.getId());
			userAnswer.setAddTime(new Date());
			userAnswer.setUpdateBy(sysUser.getId());
			userAnswer.setUpdateTime(new Date());
			userAnswer.setAnswerDate(new Date());
			userAnswer.setUserId(sysUser.getId());
			userAnswer.setNickName(sysUser.getNickName());
			userAnswerMapper.insert(userAnswer);
		}else {
			throw new Exception("存在无效信息，插入答案失败！");
		}
		
	}

	@Override
	public void updateAnswer(UserAnswer userAnswer, SysUser sysUser) throws Exception {
		if (null != userAnswer 
				&& null != userAnswer.getProblemId() 
				&& null != userAnswer.getId()
				&& null != userAnswer.getContent()
				&& null != sysUser
				&& null != sysUser.getId()) {
			userAnswer.setUpdateBy(sysUser.getId());
			userAnswer.setUpdateTime(new Date());
			userAnswer.setNickName(sysUser.getNickName());
			userAnswerMapper.updateByPrimaryKeySelective(userAnswer);
		}else {
			throw new Exception("存在无效信息，更新答案失败！");
		}
	}
	
	@Override
	public void deleteAnswer(UserAnswer userAnswer) throws Exception  {
		if (null != userAnswer.getProblemId()) {
			userAnswerMapper.deleteByPrimaryKey(userAnswer.getId());
		}else {
			throw new Exception("Id为null，删除答案失败！");
		}
		
	}

	@Override
	public PageResponse<UserAnswer> getByPage(UserAnswer userAnswer,
			PageRequest pageRequest) throws Exception {
		PageResponse<UserAnswer> pageResponse = new PageResponse<UserAnswer>();
		Map<String, Object> map = new HashMap<String, Object>();
		map = PropertyUtils.describe(userAnswer);
		map.put("startNo", pageRequest.getStartNo());
		map.put("pageSize", pageRequest.getPageSize());
		List<UserAnswer> list = userAnswerMapper.getByPage(map);
		if (null != list && 0 != list.size()) {
			pageResponse.setRecords(list);
			pageResponse.setTotal(userAnswerMapper.getCount(map).intValue());
			return pageResponse;
		}else {
			throw new Exception("无数据");
		}
		
	}

}
