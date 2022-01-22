package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.service.comm.Serv03002003;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 20:46
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件删除接口
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/comm")
public class Cont03002003 implements ControllerInter<JSONObject> {

    @Autowired
    private Serv03002003 serv03002003;

    @Override
    public JSONObject befExec(JSONObject jsonObject) {
        return null;
    }

    @Override
    @RequestMapping(value = "/03002003")
    public JSONObject excute(@RequestBody JSONObject reqJson){


        JSONObject resp = new JSONObject();
        log.info("Controller-->03002002");
        /* 数据非空校验 */
        //CheckUtils.checkParamValid(reqJson, "fileIndexList");

        /* 业务逻辑 */
        JSONObject result = serv03002003.deleteFile(reqJson);

        /* 放入通用返回体 */
        resp.put(Constant.RET_CODE, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, result);
        return resp;
    }

    @Override
    public JSONObject aftExec(JSONObject retJson) {
        return null;
    }

}
