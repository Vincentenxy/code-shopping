package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.service.comm.Serv03002002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件入库接口
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/comm")
public class Cont03002002 implements ControllerInter<String> {

    @Autowired
    private Serv03002002 serv03002002;

    @Override
    @RequestMapping(value = "/03002002")
    public JSONObject excute(@RequestBody String req) {
        JSONObject reqJson = (JSONObject) JSONObject.parse(req);
        JSONObject reqData = reqJson.getJSONObject("reqBody"),
                    resp = new JSONObject();


        log.info("---->"+reqData);
        /* 数据非空校验 */
        //String checkResult = CheckUtils.checkParamValid(reqData, "fileInfoList"); // 校验文件信息字段是否有
        //log.info("checkReulst==>" + checkResult);

        /* 业务逻辑 */
        JSONObject result = serv03002002.insertFileInfo(reqData);

        /* 放入通用返回体 */
        resp.put(Constant.RET_CODE, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, result);
        return resp;

    }


}
