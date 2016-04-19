package com.siping.hrip.portal.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.SlidePic;

public interface HomeService {
    
    
    /**
     * 获取菜单列表
     * @return
     */
    public String getMenuList() throws Exception;
    
    /**
     * 获取幻灯片图片列表
     * @return
     * @throws Exception
     */
    public String getSlidePicList() throws Exception;
    
    /**
     * 上传文件
     * @param request
     * @return
     * @throws Exception
     */
    public ResultMsg uploadImage(List<MultipartFile> files,  HttpServletRequest request) throws Exception;
    
    /**
     * 修改幻灯片
     * @param slidePic
     * @return
     * @throws Exception
     */
    public ResultMsg updateSlidePic(List<SlidePic> slidePic) throws Exception;
    
    public ResultMsg deleteSlidePic(String id, String picPath) throws Exception;
}
