package com.wx.shop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.ControlUtil;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.service.admin.Serv02002002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/22 15:30
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 添加商品前相关信息查询接口
 */
@Slf4j
@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/api/pri/v1/adm")
public class Cont02002002 implements ControllerInter<String> {

    @Autowired
    private Serv02002002 serv02002002;

    @Override
    @RequestMapping("/02002002")
    public JSONObject excute(String s) {

        JSONObject result = serv02002002.queryInfo(null);
        return aftExec(result);
    }

    @Override
    public JSONObject befExec(String s) throws BusinessException {
        return null;
    }

    @Override
    public JSONObject aftExec(JSONObject result) {
        log.info("INFO: [Cont03001001] 业务处理结果 result: {}", result);
        return ControlUtil.packSuccResp(result);
    }
}
