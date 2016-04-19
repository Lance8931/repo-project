package com.siping.hrip.portal.user.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.common.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.SlidePic;
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
     * 获取所有幻灯片图片
     * @return
     */
    @RequestMapping(value = "/slidePic/getlist", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String selectSlidePic(){
        String slidePic = null;
        try{
            slidePic = homeService.getSlidePicList();
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return slidePic;
    }
    
    @RequestMapping(value = "/slidePic/uploadImage", method = RequestMethod.GET)
    public String uploadImage() {
        return "slidepic/uploadImage";
    }
    
    /**
     * 上传图片
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "/slidePic/uploadImage")
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
    
    @RequestMapping(value = "/slidePic/updateImage", method = RequestMethod.GET)
    public String redirect() {
        return "slidepic/updateTest";
    }
   
    /**
     * 修改幻灯片
     * @param slidePic
     * @return
     */
    @RequestMapping(value = "/slidePic/updateImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateSlidePic(@RequestBody List<SlidePic> slidePics){
        ResultMsg resultMsg = null;
        try {
            resultMsg = homeService.updateSlidePic(slidePics);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false, e.getMessage());
        }
        
        return resultMsg;
    }
    
    /**
     * 删除幻灯片
     * @param id
     * @param picPath
     * @return
     */
    @RequestMapping(value = "/slidePic/deleteImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteSlidePic(@Required String id, @Required String picPath){
        ResultMsg resultMsg = null;
        try {
            resultMsg = homeService.deleteSlidePic(id, picPath);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false, e.getMessage());
        }
        
        return resultMsg;
    }
}
