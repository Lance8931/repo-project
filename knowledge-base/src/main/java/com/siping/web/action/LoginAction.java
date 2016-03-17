package com.siping.web.action;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.siping.web.bean.PagePath;

@Controller
public class LoginAction {

	@Autowired
	private SessionLocaleResolver localeResolver;

	/**
	 * 更换语言
	 * 
	 * @param request
	 * @param locale
	 * @param response
	 */
	@RequestMapping(value = "/language", method = RequestMethod.GET)
	public String changeLanguage(HttpServletRequest request, String locale,
			HttpServletResponse response) {
		Locale l;
		if ("en".equals(locale)) {
			l = new Locale("en");
		} else {
			l = new Locale("zh");
		}
		localeResolver.setLocale(request, response, l);

		// 设置语言信息保存在客户端，有效日期为86400秒，下次访问直接进入该语言环境
		Cookie cookie = new Cookie("logistics_locale", locale);
		cookie.setMaxAge(86400);
		response.addCookie(cookie);
		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return "redirect:/login";
	}

	@RequestMapping(value = "/access-denied")
	public String accessDenied() {
		return PagePath.ACCESS_DENIED;
	}

	@RequestMapping(value = "/loginError")
	public String loginError() {
		return PagePath.LOGIN_ERROR;
	}
}
