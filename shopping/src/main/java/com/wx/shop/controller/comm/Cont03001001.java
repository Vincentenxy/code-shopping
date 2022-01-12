package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.utils.CheckUtils;
import com.wx.shop.controller.ControlUtil;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.service.comm.Serv03001001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/comm/")
public class Cont03001001 implements ControllerInter<String> {


    @Autowired
    private Serv03001001 serv03001001;


    @RequestMapping(value = "/03001001")
    public JSONObject excute(@RequestBody String reqStr) {
        JSONObject reqBody = befExec(reqStr);
        JSONObject result = serv03001001.loginIn(reqBody);
        return aftExec(result);
    }

    @Override
    public JSONObject befExec(String reqStr) {
        JSONObject reqJson = (JSONObject) JSONObject.parse(reqStr);
        JSONObject reqBody = reqJson.getJSONObject("reqBody");
        CheckUtils.checkParamValidException(reqBody, "username", "password");
        return reqBody;
    }

    @Override
    public JSONObject aftExec(JSONObject result) {
        log.info("INFO: [Cont03001001] 业务处理结果 result: {}", result);
        return ControlUtil.packSuccResp(result);
    }
}
