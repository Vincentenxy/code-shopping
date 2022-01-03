package com.wx.shop.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.MenuInfoModel;
import com.wx.shop.mapper.AdminMapper;
import com.wx.shop.service.admin.Serv02003001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 16:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description:
 */
@Slf4j
@Service
public class Serv02003001Impl implements Serv02003001 {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录成功后查询相关信息
     * @param reqJson
     * @return
     */
    @Override
    public JSONObject queryAdminInfo(JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        /* 查询左侧导航栏信息 */
        List<MenuInfoModel> menuInfoModelList = adminMapper.queryMenuInfo();

        log.info("search menu info ==", menuInfoModelList);


        return resp;
    }
}
