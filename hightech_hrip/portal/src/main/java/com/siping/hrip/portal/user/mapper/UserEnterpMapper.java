package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.UserEnterprise;

public interface UserEnterpMapper {
    
    /**
     * 删除企业用户
     * @param userName
     * @return
     */
    Integer deleteEnterprise(List<String> nameList) throws Exception;
    
    /**
     * 获取企业用户数据总条数
     * @return
     * @throws Exception
     */
    Integer countEnterprise(Map<String, Object> map) throws Exception;
    
    
    /**
     * 分页获取企业用户S
     * @return
     */
    List<UserEnterprise> getAllEnterprise(Map<String, Object> map) throws Exception;

    /**
     * 添加入住企业用户信息
     * @param org
     * @return
     */
    Integer addEnterprise(UserEnterprise enterprise) throws Exception;

    /**
     * 验证用户账号是否存在username
     * @param user
     * @return
     */
    Integer selectUserName(String username) throws Exception;

    /**
     * 查询入住企业用户信息详情
     * @param org
     * @return
     */
    UserEnterprise getEnterpByName(UserEnterprise enterprise) throws Exception;

    /**
     * 修改入住企业用户信息
     * @param org
     * @return
     */
    Integer updateEnterprise(UserEnterprise enterprise) throws Exception;
    
    /**
     * 根据用户名列表获取入驻企业详情
     * @param nameList
     * @return 
     */
    List<UserEnterprise> getEnterpList(List<String> nameList) throws Exception;
}
