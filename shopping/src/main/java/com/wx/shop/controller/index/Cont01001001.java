package com.wx.shop.controller.index;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.model.request.ResponseModel;
import com.wx.shop.controller.controlinter.ControllerInter;
import com.wx.shop.service.CategoriesService;
import com.wx.shop.service.index.Serv01001001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/6
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 获取首页相关信息接口
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping(value = "/api/pub/v1")
public class Cont01001001 implements ControllerInter<JSONObject> {

    @Autowired
    private Serv01001001 serv01001001;

    @RequestMapping("/01001001")
    public JSONObject excute(@RequestBody JSONObject reqData){

        JSONObject resp = new JSONObject();
        resp.put("retCode", "0000");
        log.info("info日志");
        log.warn("warn日志");
        log.debug("debug日志");
        log.error("error日志");




        log.info("======>" + resp);
        return resp;
    }

}
