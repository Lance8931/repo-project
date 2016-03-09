package com.siping.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.demo.bean.Product;
import com.siping.demo.service.DemoService;
import com.siping.web.bean.PageModel;
import com.siping.web.bean.PagePath;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;


@Controller
public class DemoAction {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/product/getlist/page")
	public String pageAllProducts(){
		return PagePath.ALL_PRODUCTS;
	}

	@RequestMapping(value="/product/getlist/data", method=RequestMethod.POST)
	@ResponseBody
	public PageModel<Product> getProducts(@RequestBody PageRequest pageRequest){
		PageModel<Product> pageModel = null;
		PageResponse<Product> pageResponse = new PageResponse<Product>();
		try {
			pageResponse = demoService.getProducts(pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<Product>(pageRequest.getPageNo(), pageRequest.getPageSize(), pageResponse.getTotal(), pageResponse.getRecords());
		return pageModel;
	}
}
