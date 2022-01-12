package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.mapper.UserInfoMapper;
import com.wx.shop.service.comm.Serv03001001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/11 0:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户登录接口实现
 */
@Slf4j
@Service
public class Serv03001001Impl implements Serv03001001 {


    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 用户登录接口实现
     * @param reqJson 前端请求数据
     * @return
     * @throws BusinessException
     */
    @Override
    public JSONObject loginIn(JSONObject reqJson) throws BusinessException {
        log.info("INFO: [Serv03001001Impl] reqParams = {} ", reqJson);
        JSONObject resp = new JSONObject();

        String userName = reqJson.getString("username");
        String password = reqJson.getString("password");
        String sqlPasswd = userInfoMapper.queryUserPassword(userName);
        if(password.equals(sqlPasswd)){
            resp.put("verifyResult", "1");
            resp.put("verifyMsg", "登录成功");
        }else{
            resp.put("verifyResult", "0");
            resp.put("verifyMsg", "用户名或者密码不正确");
        }

        log.info("INFO: [Serv03001001Impl] result = {} ", resp);
        return resp;
    }
}
