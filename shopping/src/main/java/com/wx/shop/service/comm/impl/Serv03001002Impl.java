package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.UserInfoModel;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.mapper.UserInfoMapper;
import com.wx.shop.service.comm.Serv03001002;
import com.wx.shop.sys.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/13 22:30
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户注册接口实现
 */
@Slf4j
@Service
public class Serv03001002Impl implements Serv03001002 {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public JSONObject regist(JSONObject reqJson) throws BusinessException {

        JSONObject resp = new JSONObject();

        int rows = 0;
        /* 检查用户名是否已经存在 */
        String insertUserName = reqJson.getString("username");
        UserInfoModel queryUser = userInfoMapper.queryByUserName(reqJson.getString("username"));
        if(queryUser != null && insertUserName.equals(queryUser.getUserName())){
            resp.put("registFailResult","该用户名已经存在，请重新输入用户名");
        } else {
            UserInfoModel userInfoModel = new UserInfoModel();
            //userInfoModel.setUserId(new Random().nextInt(2147483647)); // 随机生成用户id
            userInfoModel.setUserName(reqJson.getString("username"));
            userInfoModel.setUserPasswd(reqJson.getString("password"));
            userInfoModel.setUserPhone(reqJson.getString("userPhone"));
            userInfoModel.setImgId(reqJson.getString("imgId"));
            userInfoModel.setFkRoleId(reqJson.getInteger("fkRoleId"));
            rows = userInfoMapper.insertUserInfo(userInfoModel);
        }
        resp.put("registResult", rows > 0 ? "1" : "0");

        return resp;
    }
}
