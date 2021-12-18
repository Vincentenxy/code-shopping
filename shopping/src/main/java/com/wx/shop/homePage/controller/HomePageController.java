package com.wx.shop.homePage.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.model.request.ResponseModel;
import com.wx.shop.homePage.service.HomePageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import javax.xml.transform.Result;
import javax.xml.ws.Response;


/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/4 0:30
 * @description: 首页Controller
 **/
@RestController
@RequestMapping(value = "/api/v2/pri/homePage")
public class HomePageController {

    @Resource
    private HomePageService homePageService;

    /**
     * 获取首页图片信息
     * @param id
     * @return
     */
    @RequestMapping(value = "getHomePageImgInfo")
    public ResponseModel getHomePageImgInfo(@PathParam("id") Integer id){
        return new ResponseModel(0, "", homePageService.queryHomePageImgInfo(id.toString()));
    }

    /**
     * 获取不同层级数据
     * @return
     */
    @RequestMapping(value = "getFloorData")
    public ResponseModel getFloorDate(){
        return new ResponseModel(0, "", homePageService.getFloorData());
    }
}
