package com.baidu.ueditor.upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;

public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			MultipartFile file = null;
			while (iter.hasNext()) {
				// 取得上传文件
				file = multiRequest.getFile(iter.next());
				if (!file.isEmpty()) {
					break;
				}
			}
			// 获取上传的地址
			String savePath = (String) conf.get("savePath");

			// 获取上传文件名
			String originFileName = file.getOriginalFilename();

			// 获取文件后缀
			String suffix = FileType.getSuffixByFilename(originFileName);

			// 获取除后缀外的文件名
			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());

			// 获取最大文件大小
			long maxSize = ((Long) conf.get("maxSize")).longValue();

			// 判断上传文件类型是否在允许的列表中
			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			// 格式化保存路径+文件名
			savePath = savePath + suffix;
			savePath = PathFormat.parse(savePath, originFileName);

			// 保存的物理路径
			String physicalPath = (String) conf.get("rootPath") + savePath;

			InputStream is;
			try {

				// 保存文件
				is = file.getInputStream();
				State storageState = StorageManager.saveFileByInputStream(is,
						physicalPath, maxSize);
				if (storageState.isSuccess()) {
					storageState.putInfo("url",
							"/static" + PathFormat.format(savePath));
					storageState.putInfo("type", suffix);
					storageState.putInfo("original", originFileName + suffix);
				}
				is.close();
				return storageState;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
