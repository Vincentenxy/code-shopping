package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.utils.CheckUtils;
import com.wx.shop.controller.ControlUtil;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.service.comm.Serv03001002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/13 0:31
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户注册接口
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/comm")
public class Cont03001002 implements ControllerInter<String> {

    @Autowired
    private Serv03001002 serv03001002;

    /**
     * 处理方法
     * @param s
     * @return
     */
    @Override
    @RequestMapping("/03001002")
    public JSONObject excute(@RequestBody String s) {
        JSONObject reqBody = befExec(s);
        JSONObject result = serv03001002.regist(reqBody);
        return aftExec(result);
    }

    @Override
    public JSONObject befExec(String reqStr) throws BusinessException {
        log.info("INFO: [Cont03001002] 请求参数 reqStr: {}", reqStr);
        JSONObject reqJson = (JSONObject) JSONObject.parse(reqStr);
        JSONObject reqBody = reqJson.getJSONObject("reqBody");

        /* 入参非空校验：用户名、密码、用户手机号、用户角色id */
        CheckUtils.checkParamValidException(reqBody, "username", "password", "userPhone", "fkRoleId");

        return reqBody;
    }

    @Override
    public JSONObject aftExec(JSONObject result) {
        log.info("INFO: [Cont03001002] 业务处理结果 result: {}", result);
        return ControlUtil.packSuccResp(result);
    }
}
