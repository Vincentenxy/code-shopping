package com.wx.shop.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shop.entities.pojo.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/10 22:18
 * Author: vincentEnxy
 * Version: 1.0
 * Description: menu_info 数据库表对应的mapper
 */
@Mapper
@Repository
public interface MenuInfoMapper extends BaseMapper<MenuInfo> {

}
