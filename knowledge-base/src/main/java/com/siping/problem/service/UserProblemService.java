package com.siping.problem.service;

import com.siping.problem.bean.ProblemInfo;
import com.siping.problem.bean.UserProblem;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

public interface UserProblemService {

	/**
	 * 添加问题
	 * 
	 * @param userProblem
	 * @param sysUser
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:38:08
	 * @author siping-L.J.H
	 */
	void insertProblem(UserProblem userProblem, SysUser sysUser)
			throws Exception;

	/**
	 * 修改问题
	 * 
	 * @param userProblem
	 * @param sysUser
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:38:20
	 * @author siping-L.J.H
	 */
	void updateProblem(UserProblem userProblem, SysUser sysUser)
			throws Exception;

	/**
	 * 批量删除问题及对应的答案
	 * 
	 * @param ids
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:38:30
	 * @author siping-L.J.H
	 */
	void deleteProblemsAndAnswers(Integer[] ids) throws Exception;

	/**
	 * 分页获取问题信息
	 * 
	 * @param userProblem
	 * @param pageRequest
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:38:39
	 * @author siping-L.J.H
	 */
	PageResponse<ProblemInfo> getByPage(UserProblem userProblem,
			PageRequest pageRequest) throws Exception;

	/**
	 * 获取单个问题
	 * 
	 * @param userProblem
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年3月3日上午11:38:49
	 * @author siping-L.J.H
	 */
	UserProblem getProblem(UserProblem userProblem) throws Exception;

	/**
	 * 获取单个问题信息
	 * 
	 * @param userProblem
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年3月8日下午4:10:03
	 * @author siping-L.J.H
	 */
	ProblemInfo getProblemInfo(UserProblem userProblem) throws Exception;

}
