package com.siping.hrip.portal.user.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.elasticsearch.cluster.routing.allocation.decider.Decision.Multi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.hrip.portal.user.service.HomeService;

@Controller
public class HomeController {
    
    @Autowired
    private HomeService homeService;

    /**
     * 获取菜单列表
     * @return
     */
    @RequestMapping(value = "/menu/getlist", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String getMenuList(){
        String menuList = null;
        try{
            menuList = homeService.getMenuList();
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return menuList;
    }
    
    /**
     * 上传图片
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "/upload/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg uploadImage(HttpServletRequest request, @RequestParam("uploadImage")List<MultipartFile> files){
        ResultMsg resultMsg = null;
        try {
            resultMsg = homeService.uploadImage(files, request);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false, e.getMessage());
        }
        return resultMsg;
    }
}
