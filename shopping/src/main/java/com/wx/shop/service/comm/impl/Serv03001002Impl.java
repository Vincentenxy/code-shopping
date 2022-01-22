package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.UserInfo;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.mapper.UserInfoMapper;
import com.wx.shop.service.comm.Serv03001002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        /* 检查用户名是否已经存在 */
        String insertUserName = reqJson.getString("username");
        UserInfo queryUser = userInfoMapper.queryByUserName(reqJson.getString("username"));
        if(queryUser != null && insertUserName.equals(queryUser.getUserName())){
            resp.put("registResult", "0");
            resp.put("registMsg", "用户名已存在，请重试！");
        } else {
            UserInfo userInfo = new UserInfo();
            //userInfoModel.setUserId(new Random().nextInt(2147483647)); // 随机生成用户id
            userInfo.setUserName(reqJson.getString("username"));
            userInfo.setUserPasswd(reqJson.getString("password"));
            userInfo.setUserPhone(reqJson.getString("userPhone"));
            userInfo.setImgId(reqJson.getString("imgId"));
            userInfo.setFkRoleId(reqJson.getInteger("fkRoleId"));
            int rows = userInfoMapper.insertUserInfo(userInfo);

            if(rows > 0){
                resp.put("registResult", "1");
                resp.put("registMsg", "恭喜你，注册成功");
            }else {
                resp.put("registResult", "0");
                resp.put("registMsg", "很抱歉，注册失败，请重试！");
            }

        }

        return resp;
    }
}
