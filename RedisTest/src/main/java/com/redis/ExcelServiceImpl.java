package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 导入ExcelService层
 *
 * @author siping-L.J.H
 * @date 2016年3月18日下午1:19:00
 * @version 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

	@Autowired
	private MaterialMapper materialMapper;

	@Override
	public void test() {
		System.out.println(materialMapper.selectByPrimaryKey());
	}
}
