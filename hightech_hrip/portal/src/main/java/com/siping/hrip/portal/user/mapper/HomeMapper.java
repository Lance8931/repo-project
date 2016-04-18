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
     * 保存幻灯片图片相关信息
     * @param slidePicList
     * @return
     */
    Integer saveSlidePicInfo(List<SlidePic> list);
}
