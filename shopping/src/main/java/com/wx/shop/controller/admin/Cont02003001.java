package com.wx.shop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.controller.ControlUtil;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.exception.entity.ExecConstant;
import com.wx.shop.service.admin.Serv02003001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.basic.BasicButtonUI;

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

    /**
     * 业务处理
     * @param reqStr
     * @return
     */
    @Override
    @RequestMapping("/02003001")
    public JSONObject excute(@RequestBody String reqStr) {
        JSONObject reqJson = befExec(reqStr);
        JSONObject result = serv02003001.queryAdminInfo(reqJson);
        return aftExec(result);
    }

    /**
     * 数据处理前校验
     * @param s 接收的数据
     * @return
     * @throws BusinessException
     */
    @Override
    public JSONObject befExec(String s) throws BusinessException {
        JSONObject reqJson = (JSONObject) JSONObject.parse(s);
        JSONObject reqBody = reqJson.getJSONObject("reqBody");
        if(null == reqBody.getString("userId") || "".equals(reqBody.getString("userId"))){
            throw new BusinessException(ExecConstant.ERR_CODE_1001, "USER_ID 非空");
        }
        return reqBody;
    }

    /**
     * 数据返回前处理
     * @param respJson 业务逻辑处理结果
     * @return
     */
    @Override
    public JSONObject aftExec(JSONObject respJson) {
        log.info("02003001 处理的业务逻辑结果", respJson);
        return ControlUtil.packSuccResp(respJson);
    }
}
