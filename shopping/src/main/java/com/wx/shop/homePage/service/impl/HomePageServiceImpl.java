package com.wx.shop.homePage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.shop.homePage.mapper.HomePageMapper;
import com.wx.shop.homePage.service.HomePageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/5 0:55
 * @description: 首页实现类
 **/
@Service
public class HomePageServiceImpl implements HomePageService {

    @Resource
    private HomePageMapper homePageMapper;

    /**
     * 获取首页图片信息
     * @param imgType
     * @return
     */
    public List<Map<String, String>> queryHomePageImgInfo(String imgType){
        return homePageMapper.queryHomePageInfo(imgType);
    }

    /**
     * 获取楼层相关数据
     * @return
     */
    public JSONObject getFloorData() {
        JSONObject resp = new JSONObject();
        JSONObject top = new JSONObject();
        JSONObject center = new JSONObject();
        JSONObject bottom = new JSONObject();

        Map<String, JSONObject> topInfo = new HashMap<String, JSONObject>();    //获取头部
        Map<String, JSONObject> centerInfo = new HashMap<String, JSONObject>(); //获取头部
        Map<String, JSONObject> bottomInfo = new HashMap<String, JSONObject>(); //获取头部

        top.put("floorTitle", topInfo);       //top头信息
        top.put("productList", homePageMapper.queryProductList("1"));
        center.put("centerTitle", centerInfo);//center头信息
        center.put("productList", homePageMapper.queryProductList("2"));
        top.put("bottomTitle", bottomInfo);   //bottom头信息
        top.put("productList", homePageMapper.queryProductList("3"));

        resp.put("top", top);
        resp.put("center", center);
        resp.put("bottom", bottom);
        return resp;
    }



}
