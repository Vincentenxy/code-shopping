package com.wx.shop.mapper;

import com.wx.shop.entities.pojo.MenuInfoModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 16:08
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 管理端查询数据mapper
 */
@Mapper
public interface AdminMapper {

    /**
     * 查询管理端左侧菜单栏信息
     * @return
     */
    public List<MenuInfoModel> queryMenuInfo();

}
