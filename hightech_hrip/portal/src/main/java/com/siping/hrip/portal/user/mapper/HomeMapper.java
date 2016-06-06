package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.SlidePic;

/**
 * 主页菜单和幻灯片sql映射文件
 * @author yangxu
 *
 */
public interface HomeMapper {

    /**
     * 获取菜单列表
     * @return
     */
    List<Menu> getMenuList () throws Exception;
    
    /**
     * 获取幻灯片列表
     * @return
     */
    List<SlidePic> getSlidePicList(Map<String, Object> map) throws Exception;
    
    /**
     * 获取幻灯片数量
     * @return
     */
    Integer countAllSlidePic(Map<String, Object> map);
    
    /**
     * 保存幻灯片图片相关信息
     * @param slidePicList
     * @return
     */
    Integer saveSlidePicInfo(List<SlidePic> list) throws Exception;
    
    /**
     * 修改幻灯片
     * @param slidePic
     * @return
     */
    Integer updateSlidePic(List<SlidePic> list) throws Exception;
    
    /**
     * 根据id删除幻灯片
     * @param slidePic
     * @return
     */
    Integer deleteSlidePic(String id) throws Exception;
 
    /**
     * 批量获取幻灯片
     * @param id
     * @return
     * @throws Exception
     */
    List<SlidePic> getSlidePics(List<String> id) throws Exception;
    
    /**
     * 批量删除幻灯片
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteSlidePics(List<String> id) throws Exception;
    
}
