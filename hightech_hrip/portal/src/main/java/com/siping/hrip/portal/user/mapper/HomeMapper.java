package com.siping.hrip.portal.user.mapper;

import java.util.List;

import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.SlidePic;

public interface HomeMapper {

    /**
     * 获取菜单列表
     * @return
     */
    List<Menu> getMenuList();
    
    /**
     * 获取菜单列表
     * @return
     */
    List<SlidePic> getSlidePicList();
    
    /**
     * 保存幻灯片图片相关信息
     * @param slidePicList
     * @return
     */
    Integer saveSlidePicInfo(List<SlidePic> list);
    
    /**
     * 修改幻灯片
     * @param slidePic
     * @return
     */
    Integer updateSlidePic(List<SlidePic> list);
    
    /**
     * 根据id删除幻灯片
     * @param slidePic
     * @return
     */
    Integer deleteSlidePic(String id);
 
}
