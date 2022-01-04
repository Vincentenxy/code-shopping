package com.wx.shop.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.service.admin.Serv02003001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.PreparedStatement;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 12:04
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 管理端首页信息获取
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/adm")
public class Cont02003001 implements ControllerInter<String> {

    @Autowired
    private Serv02003001 serv02003001;

    @Override
    @RequestMapping("/02003001")
    public JSONObject excute(@RequestBody String reqStr) {

        log.info("====reqStr="+ reqStr);

        /* 业务逻辑处理前公共数据处理 */
        JSONObject reqJson = befExec(reqStr);

        /* 处理业务逻辑 */
        JSONObject result = serv02003001.queryAdminInfo(reqJson);

        /* 业务逻辑处理后数据处理 */
        return aftExec(result);
    }

    @Override
    public JSONObject befExec(String s) {
        JSONObject reqJson = (JSONObject) JSONObject.parse(s);
        log.info("======>{}", s);
        JSONObject reqBody = reqJson.getJSONObject("reqBody");
        log.info("02003001 接收业务数据:", reqBody);
        return reqBody;
    }

    /**
     * 返回前数据处理
     * @param retJson 业务逻辑处理结果
     * @return
     */
    @Override
    public JSONObject aftExec(JSONObject retJson) {
        JSONObject resp = new JSONObject();
        resp.put(Constant.RET_CODE, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, retJson);
        log.info("02003001 返回数据：", resp);
        return resp;
    }
}
