package com.wx.shop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.ControllerInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19 22:26
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 添加商品信息接口
 */
@Slf4j
@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/api/pri/v1/adm")
public class Cont02002001 implements ControllerInter<String> {

    @Override
    public JSONObject befExec(String s) {
        return null;
    }

    /**
     *
     * @param reqData
     * @return
     */
    @RequestMapping("/02002001")
    public JSONObject excute(@RequestBody String reqData) {

        JSONObject reqJson = (JSONObject) JSONObject.parse(reqData);
        log.info("02002001 reqData = {}", reqData);
        JSONObject resp = new JSONObject();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        resp.put("ceshi", "测试结果");

        return resp;
    }

    @Override
    public JSONObject aftExec(JSONObject retJson) {
        return null;
    }
}
