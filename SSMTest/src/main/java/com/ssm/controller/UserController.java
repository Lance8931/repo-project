package com.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.bean.User;
import com.ssm.service.IUserService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月15日下午2:44:50
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "showUser";
	}
}
