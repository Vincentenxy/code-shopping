package com.wx.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shop.sys.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ProjectName: shopping
 * CreateTime: 2022/01/11 22:36
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户信息表mapper接口
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 查询用户密码
     * @param username 用户名
     * @return
     */
    public String queryUserPassword(String username);
}
