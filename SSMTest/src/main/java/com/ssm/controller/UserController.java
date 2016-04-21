package com.ssm.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.bean.ResultMsg;
import com.ssm.bean.User;
import com.ssm.service.UserService;

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

	@Autowired
	private UserService userService;

	private static final List<String> provinceList = Arrays
			.asList(new String[] { "北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省",
					"吉林省", "黑龙江省", "上海市", "江苏省", "浙江省", "安徽省", "福建省", "江西省",
					"山东省", "河南省", "湖北省", "湖南省", "广东省", "广西壮族自治区", "海南省", "重庆市",
					"四川省", "贵州省", "云南省", "西藏自治区", "陕西省", "甘肃省", "青海省",
					"宁夏回族自治区", "新疆维吾尔自治区", "台湾省", "香港特别行政区", "澳门特别行政区" });

	@RequestMapping("/showUser")
	public String toIndex(int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/showCheck")
	public String showCheck() {
		return "check";
	}

	@RequestMapping("/check")
	@ResponseBody
	public ResultMsg check(String area, String areaID) {
		if (provinceList.contains(area)) {
			return new ResultMsg(true, "存在");
		} else {
			try {
				userService.getCount(area, areaID);
				return new ResultMsg(true, "存在");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ResultMsg(false, e.getMessage());
			}
		}
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResultMsg add(String name, String id) {
		try {
			userService.insertData(name, id);
			return new ResultMsg(true, "已插入");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResultMsg(false, e.getMessage());
		}
	}
}
