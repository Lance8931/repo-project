package com.siping.problem.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siping.problem.bean.ProblemInfo;
import com.siping.problem.bean.UserProblem;
import com.siping.problem.service.UserProblemService;
import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageModel;
import com.siping.web.bean.PagePath;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;
import com.siping.web.bean.ResultMsg;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月3日上午11:32:41
 * @version 1.0
 */
@Controller
public class ProblemAction {

	@Autowired
	private UserProblemService userProblemService;

	/**
	 * 跳转至问题列表页面
	 * 
	 * @return
	 *
	 * @date 2016年3月10日上午11:34:54
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/getlist/page")
	public String pageAllProducts() {
		return PagePath.ALL_PROBLEMS;
	}

	/**
	 * 获取单个问题明细
	 * 
	 * @param id
	 * @return
	 *
	 * @date 2016年3月10日上午11:34:12
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/detail", method = RequestMethod.GET)
	public ModelAndView problemDetail(int id) {
		ModelAndView mav = new ModelAndView();
		UserProblem userProblem = new UserProblem();
		userProblem.setId(id);
		try {
			mav.addObject("problem",
					userProblemService.getProblemInfo(userProblem));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName(PagePath.PROBLEM_DETAIL);
		return mav;
	}

	/**
	 * 获取问题数据分页
	 * 
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年3月3日上午11:33:08
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/getlist/data", method = RequestMethod.POST)
	@ResponseBody
	public PageModel<ProblemInfo> getProblems(
			@RequestBody PageRequest pageRequest) {
		PageModel<ProblemInfo> pageModel = null;
		PageResponse<ProblemInfo> pageResponse = new PageResponse<ProblemInfo>();
		UserProblem userProblem = new UserProblem();
		userProblem.setTheme(pageRequest.getKeyword());
		try {
			pageResponse = userProblemService.getByPage(userProblem,
					pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<ProblemInfo>(pageRequest.getPageNo(),
				pageRequest.getPageSize(), pageResponse.getTotal(),
				pageResponse.getRecords());
		return pageModel;
	}

	/**
	 * 根据用户Id获取问题列表
	 * 
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年3月10日上午11:31:19
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/getlist/dataByUserId", method = RequestMethod.POST)
	@ResponseBody
	public PageModel<ProblemInfo> getProblemsByUserId(
			@RequestBody PageRequest pageRequest) {
		PageModel<ProblemInfo> pageModel = null;
		PageResponse<ProblemInfo> pageResponse = new PageResponse<ProblemInfo>();
		UserProblem userProblem = new UserProblem();
		userProblem.setUserId(Integer.valueOf(pageRequest.getKeyword()));
		try {
			pageResponse = userProblemService.getByPage(userProblem,
					pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<ProblemInfo>(pageRequest.getPageNo(),
				pageRequest.getPageSize(), pageResponse.getTotal(),
				pageResponse.getRecords());
		return pageModel;
	}

	/**
	 * 添加问题
	 * 
	 * @param session
	 * @param userProblem
	 * @return
	 *
	 * @date 2016年3月3日下午3:07:31
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addProblem(@RequestBody UserProblem userProblem,
			HttpSession session) {
		SysUser sysUser = (SysUser) session.getAttribute("loginUser");
		try {
			userProblemService.insertProblem(userProblem, sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, 0, e.getMessage());
		}
		return new ResultMsg(true, 1, "添加成功！");
	}

	/**
	 * 更新问题
	 * 
	 * @param session
	 * @param userProblem
	 * @return
	 *
	 * @date 2016年3月3日下午3:19:04
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/problem/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg updateProblem(HttpSession session,
			@RequestBody UserProblem userProblem) {
		SysUser sysUser = (SysUser) session.getAttribute("loginUser");
		try {
			userProblemService.updateProblem(userProblem, sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, 0, e.getMessage());
		}
		return new ResultMsg(true, 1, "更新成功！");
	}

	public ResultMsg deleteProblems(@RequestBody Integer[] ids) {
		try {
			userProblemService.deleteProblemsAndAnswers(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, 0, e.getMessage());
		}
		return new ResultMsg(true, 1, "删除成功！");
	}
}
