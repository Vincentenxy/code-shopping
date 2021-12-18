package com.wx.shop.homePage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/4 0:31
 * @description: 获取首页相关信息
 **/
@Mapper
public interface HomePageMapper {

     /**
      * 查询相关图片
      * @param imgType 图片类型
      * @return
      */
     public List<Map<String, String>> queryHomePageInfo(@Param("imgType") String imgType);

     /**
      * 获取楼层头部信息
      * @return
      */
     public List<Map<String, String>> queryFloorTopInfo();

     /**
      * 获取楼层上产品信息
      * @param floorType 楼层参数
      * @return
      */
     public List<Map<String, String>> queryProductList(@Param("floorType") String floorType);




}
