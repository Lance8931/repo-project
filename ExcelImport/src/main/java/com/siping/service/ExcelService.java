package com.siping.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月18日下午1:20:08
 * @version 1.0
 */
public interface ExcelService {

	public void excelImport(MultipartFile[] multipartFiles);
}
