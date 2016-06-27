package com.siping.hrip.portal.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.SlidePic;

/**
 * 菜单列表和幻灯片service
 * @author yangxu
 *
 */
public interface HomeService {
    
    
    /**
     * 获取菜单列表
     * @return
     */
    public PageResponse<Menu> getMenuList() throws Exception;
    
    /**
     * 分页获取幻灯片图片列表
     * @return
     * @throws Exception
     */
    public PageResponse<SlidePic> getSlidePicList(HttpServletRequest request, PageRequest pageRequest) throws Exception;
    
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
    
    /**
     * 删除幻灯片
     * @param id
     * @param picPath
     * @return
     * @throws Exception
     */
    public ResultMsg deleteSlidePic(String[] ids) throws Exception;
}
