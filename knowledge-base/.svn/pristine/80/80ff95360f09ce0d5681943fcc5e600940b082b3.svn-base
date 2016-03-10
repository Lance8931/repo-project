package com.siping.answer.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.answer.bean.UserAnswer;
import com.siping.answer.service.UserAnswerService;
import com.siping.problem.bean.UserProblem;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageModel;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;
import com.siping.web.bean.ResultMsg;

/**
 * 答案的controller层
 *
 * @author siping-L.J.H
 * @date 2016年3月10日上午11:02:50
 * @version 1.0
 */
@Controller
public class AnswerAction {
	
	@Autowired
	private UserAnswerService userAnswerService;
	
	/**
	 * 根据ProblemId获取答案列表
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年3月10日上午11:23:52
	 * @author siping-L.J.H
	 */
	@RequestMapping(value="/answer/getlist/data", method=RequestMethod.POST)
	@ResponseBody
	public PageModel<UserAnswer> getAnswersByProblemId(@RequestBody PageRequest pageRequest){
		PageModel<UserAnswer> pageModel = null;
		PageResponse<UserAnswer> pageResponse = new PageResponse<UserAnswer>();
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setProblemId(Integer.valueOf(pageRequest.getKeyword()));
		try {
			pageResponse = userAnswerService.getByPage(userAnswer, pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<UserAnswer>(pageRequest.getPageNo(), pageRequest.getPageSize(), pageResponse.getTotal(), pageResponse.getRecords());
		return pageModel;
	}
	
	/**
	 * 根据用户Id获取答案列表
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年3月10日上午11:26:06
	 * @author siping-L.J.H
	 */
	@RequestMapping(value="/answer/getlist/dataByUserId", method=RequestMethod.POST)
	@ResponseBody
	public PageModel<UserAnswer> getAnswersByUserId(@RequestBody PageRequest pageRequest){
		PageModel<UserAnswer> pageModel = null;
		PageResponse<UserAnswer> pageResponse = new PageResponse<UserAnswer>();
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setUserId(Integer.valueOf(pageRequest.getKeyword()));
		try {
			pageResponse = userAnswerService.getByPage(userAnswer, pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<UserAnswer>(pageRequest.getPageNo(), pageRequest.getPageSize(), pageResponse.getTotal(), pageResponse.getRecords());
		return pageModel;
	}
	
	/**
	 * 添加答案
	 * @param userAnswer
	 * @param session
	 * @return
	 *
	 * @date 2016年3月10日上午11:24:09
	 * @author siping-L.J.H
	 */
	@RequestMapping(value="/answer/add", method=RequestMethod.POST)
	@ResponseBody
	public ResultMsg addAnswer(@RequestBody UserAnswer userAnswer, HttpSession session){
		SysUser sysUser = (SysUser)session.getAttribute("loginUser");
		try {
			userAnswerService.insertAnswer(userAnswer, sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, 0, "添加失败！");
		}
		return new ResultMsg(true, 1, "添加成功！");
	}
	
	/**
	 * 更新问题
	 * @param userAnswer
	 * @param session
	 * @return
	 *
	 * @date 2016年3月10日上午11:36:21
	 * @author siping-L.J.H
	 */
	@RequestMapping(value="/answer/update", method=RequestMethod.POST)
	@ResponseBody
	public ResultMsg updateAnswer(@RequestBody UserAnswer userAnswer, HttpSession session){
		SysUser sysUser = (SysUser)session.getAttribute("loginUser");
		try {
			userAnswerService.updateAnswer(userAnswer, sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, 0, "更新失败！");
		}
		return new ResultMsg(true, 1, "更新成功！");
	}
}
