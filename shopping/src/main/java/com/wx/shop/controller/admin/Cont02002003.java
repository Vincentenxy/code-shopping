package com.wx.shop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.ControllerInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/20 22:35
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 增加图片信息接口
 */
@Slf4j
@ResponseBody
@RequestMapping
public class Cont02002003 implements ControllerInter<JSONObject> {


    @Override
    public JSONObject befExec(JSONObject jsonObject) {
        return null;
    }

    public JSONObject excute(JSONObject jsonObject) {
        JSONObject resp = new JSONObject();


        return resp;
    }

    @Override
    public JSONObject aftExec(JSONObject retJson) {
        return null;
    }


}
