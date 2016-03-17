package com.siping.answer.service;

import com.siping.answer.bean.UserAnswer;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

/**
 * 答案service接口类
 *
 * @author siping-L.J.H
 * @date 2016年3月3日上午11:43:19
 * @version 1.0
 */
public interface UserAnswerService {

	/**
	 * 添加答案
	 * 
	 * @param userAnswer
	 * @param sysUser
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:50:14
	 * @author siping-L.J.H
	 */
	void insertAnswer(UserAnswer userAnswer, SysUser sysUser) throws Exception;

	/**
	 * 修改答案
	 * 
	 * @param userAnswer
	 * @param sysUser
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:50:26
	 * @author siping-L.J.H
	 */
	void updateAnswer(UserAnswer userAnswer, SysUser sysUser) throws Exception;

	/**
	 * 删除单个问题
	 * 
	 * @param userAnswer
	 * @throws Exception
	 *
	 * @date 2016年3月3日下午2:13:20
	 * @author siping-L.J.H
	 */
	void deleteAnswer(UserAnswer userAnswer) throws Exception;

	/**
	 * 分页获取答案
	 * 
	 * @param userAnswer
	 * @param pageRequest
	 * @throws Exception
	 * @return
	 *
	 * @date 2016年3月3日上午11:50:34
	 * @author siping-L.J.H
	 */
	PageResponse<UserAnswer> getByPage(UserAnswer userAnswer,
			PageRequest pageRequest) throws Exception;
}
