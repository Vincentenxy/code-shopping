package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.controlinter.ControllerInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/18
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户登录接口
 */
@Slf4j
@ResponseBody
@RequestMapping("/api/pri/v1/")
public class Cont03001001 implements ControllerInter<JSONObject> {


    @RequestMapping(value = "03001001")
    public JSONObject excute(@RequestBody JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        return resp;
    }
}
