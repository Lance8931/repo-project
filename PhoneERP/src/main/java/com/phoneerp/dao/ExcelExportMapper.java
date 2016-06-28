package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.PhoneExportBean;

public interface ExcelExportMapper {

	List<PhoneExportBean> getList(Map<?, ?> map);
}
