package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.common.utils.CheckUtils;
import com.wx.shop.controller.controlinter.ControllerInter;
import com.wx.shop.service.comm.Serv03002002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 删除文件接口
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/comm")
public class Cont03002002 implements ControllerInter<JSONObject> {

    @Autowired
    private Serv03002002 serv03002002;

    @Override
    public JSONObject excute(JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        /* 数据非空校验 */
        CheckUtils.checkParamValid(reqJson, "fileIndexList");

        /* 业务逻辑 */
        JSONObject uploadResult = serv03002002.deleteFile(reqJson);

        /* 放入通用返回体 */
        resp.put(Constant.RET_CODE, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, uploadResult);
        return resp;
    }


}
