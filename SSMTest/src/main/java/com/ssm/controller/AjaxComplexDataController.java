package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.bean.AjaxDataBean;
import com.ssm.bean.ResultMsg;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月3日上午11:18:01
 * @version 1.0
 */
@Controller
@RequestMapping("/ajax")
public class AjaxComplexDataController {

	@RequestMapping(value = "/method1", method = RequestMethod.GET)
	@ResponseBody
	public ResultMsg method1(String userName) {
		System.out.println(userName);
		return new ResultMsg(true, "存在");
	}

	@RequestMapping(value = "/method2", method = RequestMethod.GET)
	@ResponseBody
	public ResultMsg method2(String userName, String nickName) {
		System.out.println(userName);
		System.out.println(nickName);
		return new ResultMsg(true, "存在");
	}

	@RequestMapping(value = "/method3", method = RequestMethod.GET)
	@ResponseBody
	public ResultMsg method3(AjaxDataBean bean) {
		System.out.println(bean.getUserName());
		System.out.println(bean.getNickName());
		return new ResultMsg(true, "存在");
	}

	@RequestMapping(value = "/method4", method = RequestMethod.GET)
	@ResponseBody
	public ResultMsg method4(String userName, String nickName) {
		System.out.println(userName);
		System.out.println(nickName);
		return new ResultMsg(true, "存在");
	}

	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }
	//
	// @RequestMapping(value = "/method5", method = RequestMethod.GET)
	// @ResponseBody
	// public ResultMsg method5() {
	// return new ResultMsg(true, "存在");
	// }

	@RequestMapping("/show")
	public String showCheck() {
		return "ajaxComplexObjectTransfer";
	}
}
