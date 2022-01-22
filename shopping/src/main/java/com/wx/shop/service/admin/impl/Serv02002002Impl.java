package com.wx.shop.service.admin.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.Category;
import com.wx.shop.mapper.CategoryMapper;
import com.wx.shop.service.admin.Serv02002002;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/22 15:33
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 02002002 接口实现
 */
@Slf4j
@Service
public class Serv02002002Impl implements Serv02002002 {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public JSONObject queryInfo(JSONObject reqJson) {

        List<Category> categoryModels = categoryMapper.selectList(null);



        JSONObject resp = new JSONObject();
        resp.put("categories", categoryModels);
        return resp;
    }
}
