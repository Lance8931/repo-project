package com.siping.service;

import org.springframework.web.multipart.MultipartFile;

import com.siping.bean.MaterialImportBean;
import com.siping.bean.PageRequest;
import com.siping.bean.PageResponse;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月18日下午1:20:08
 * @version 1.0
 */
public interface ExcelService {

	/**
	 * 导入方法
	 * 
	 * @param multipartFiles
	 * @return 临时表表名
	 *
	 * @date 2016年3月21日下午3:32:13
	 * @author siping-L.J.H
	 */
	public String excelImport(MultipartFile[] multipartFiles) throws Exception;

	/**
	 * 获取临时表数据(分页)
	 * 
	 * @param pageRequest
	 * @param tableName
	 *            临时表表名
	 * @return
	 *
	 * @date 2016年3月21日下午3:32:25
	 * @author siping-L.J.H
	 */
	public PageResponse<MaterialImportBean> getList(PageRequest pageRequest,
			String tableName);

	/**
	 * 添加数据至正式表中
	 * 
	 * @param tableName
	 *
	 * @date 2016年3月22日上午10:10:45
	 * @author siping-L.J.H
	 */
	public void insertFromTempTable(String tableName);

	/**
	 * 创建Excel导入模板
	 * 
	 * @return 文件路径
	 * @throws Exception
	 *
	 * @date 2016年3月23日上午9:47:41
	 * @author siping-L.J.H
	 */
	public String createExcelTemplateFile() throws Exception;

	public void test();
}
