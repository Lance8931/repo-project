package com.siping.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.demo.bean.Product;
import com.siping.demo.mapper.DemoMapper;
import com.siping.demo.service.DemoService;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoMapper demoMapper;

	@Override
	public PageResponse<Product> getProducts(PageRequest pageRequest) throws Exception {
		PageResponse<Product> pageResponse = new PageResponse<Product>();
		List<Product> pros = demoMapper.getProductsByPage(pageRequest);
		Integer total = demoMapper.getTotalProducts(pageRequest);
		pageResponse.setRecords(pros);
		pageResponse.setTotal(total);
		return pageResponse;
	}
	
}
