package com.wx.shop.controller.wxshop;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.exception.entity.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectName: shopping
 * CreateTime: 2022/01/22 22:00
 * Author: fanjh
 * Version: 1.0
 * Description: 小程序搜索按钮查询商品信息模块
 */

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/shop")
public class Cont01002003 implements ControllerInter<JSONObject> {
    @Override
    @RequestMapping("/01002003")
    public JSONObject excute(JSONObject jsonObject) {
        return null;
    }

    @Override
    public JSONObject befExec(JSONObject jsonObject) throws BusinessException {
        return null;
    }

    @Override
    public JSONObject aftExec(JSONObject retJson) {
        return null;
    }
}
