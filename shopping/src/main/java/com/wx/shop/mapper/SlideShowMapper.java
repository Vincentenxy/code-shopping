package com.wx.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shop.entities.pojo.Category;
import com.wx.shop.entities.pojo.SlideShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19 21:42
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 首页轮播图mapper
 */
@Mapper
public interface SlideShowMapper extends BaseMapper<SlideShow> {


    /**
     * 查询首页轮播图信息
     * @return
     */
    public List<SlideShow> selectSlideList();

}
