package com.siping.hrip.portal.user.controller;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
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
    @RequestMapping(value = "/menu/list", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public PageResponse<Menu> getMenuList(){
        try{
            return homeService.getMenuList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 幻灯片页面
     * @return
     */
    @RequestMapping(value = "/slidePic/list/page", method = RequestMethod.GET)
    public String list() {

        return PagePath.SLIDEPIC_LIST;
    }
    
    /**
     * 幻灯片切换页面
     * @return
     */
    @RequestMapping(value = "/slidePic/preview", method = RequestMethod.GET)
    public String slideChg() {

        return PagePath.SLIDEPIC_PREVIEW;
    }
    
    @RequestMapping(value = "/slidePic/image/upload/page", method = RequestMethod.GET)
    public String upload() {

        return PagePath.SLIDEPIC_ADD;
    }
    
    @RequestMapping(value = "/slidePic/jcrop/page", method = RequestMethod.GET)
    public String jcrop() {

        return "user/slide/jcrop";
    }
    /**
     * 获取所有幻灯片图片
     * @return
     */
    @RequestMapping(value = "/slidePic/list", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public PageResponse<SlidePic> selectSlidePic(HttpServletRequest request,PageRequest pageRequest){
        try{
            return homeService.getSlidePicList(request, pageRequest);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 上传图片
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "/slidePic/image/upload")
    @ResponseBody
    public ResultMsg uploadImage(HttpServletRequest request, @RequestParam("uploadImage")List<MultipartFile> files){
        try {
            return homeService.uploadImage(files, request);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "上传失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "保存失败，请稍后再试");
        }
    }
   
    /**
     * 修改幻灯片
     * @param slidePic
     * @return
     */
    @RequestMapping(value = "/slidePic/image/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg updateSlidePic(@RequestBody List<SlidePic> slidePics){
        try {
            return homeService.updateSlidePic(slidePics);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "修改失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "修改失败，请稍后再试");
        }
    }
    
    /**
     * 删除幻灯片
     * @param id
     * @param picPath
     * @return
     */
    @RequestMapping(value = "/slidePic/image/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultMsg deleteSlidePic(String[] ids){
        try {
            return homeService.deleteSlidePic(ids);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "删除失败，请稍后再试");
        }
    }
}
