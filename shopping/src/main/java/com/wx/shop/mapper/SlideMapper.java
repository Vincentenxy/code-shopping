package com.wx.shop.mapper;

import com.wx.shop.entities.pojo.SlideModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19 21:42
 * Author: vincentEnxy
 * Version: 1.0
 * Description:
 */
@Mapper
public interface SlideMapper {


    /**
     * 查询首页轮播图信息
     * @return
     */
    public List<SlideModel> selectSlideList();

}
