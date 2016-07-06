package com.freemarkertest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freemarkertest.model.UserDo;
import com.freemarkertest.service.IUserService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月11日上午10:38:03
 * @version 1.0
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/User/helloUser")
	public String helloUser(ModelMap modelMap) {
		List<UserDo> list = this.userService.findAllUser();
		modelMap.addAttribute("userDo", list);
		return "/user_list";
	}
}
