package com.wx.shop.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/4
 * Author: vincentEnxy
 * Version: 1.0
 * Description: (这里用一句话描述这个类的作用)
 */
@Controller
@ResponseBody
@RequestMapping(value = "/api/pub/v1")
public class test001Controller {

    @RequestMapping("/test")
    public JSONObject test(@RequestBody JSONObject reqJson){
        System.out.println("-->test receive data is:" + reqJson);

        JSONObject resp = new JSONObject();
        resp.put("code", 200);
        resp.put("msg", "请求成功");
        resp.put("retBody", null);
        return resp;
    }
}
