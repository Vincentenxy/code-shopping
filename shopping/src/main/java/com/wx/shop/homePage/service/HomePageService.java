package com.wx.shop.homePage.service;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/5 0:58
 * @description: (这里用一句话描述这个接口的作用)
 **/
public interface HomePageService {

    /**
     * 获取首页图片有关信息
     * @param imgType
     * @return
     */
    public List<Map<String, String>> queryHomePageImgInfo(String imgType);

    /**
     * 获取首页楼层相关数据
     * @return
     */
    public JSONObject getFloorData();
}
