package com.siping.hrip.portal.article.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月12日下午1:36:13
 * @version 1.0
 */
@Controller
public class UEditorController {

	@RequestMapping(value = "ueditor/dispatch")
	public void config(HttpServletRequest request,
			HttpServletResponse response, String action) throws Exception {
		String rootPath = "D:/code/workspace-work/hightech_hrip/static/";// 配置static文件夹的物理路径
		String exec = new ActionEnter(request, rootPath).exec();
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		try {
			// exec = new ActionEnter(request, rootPath1).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
