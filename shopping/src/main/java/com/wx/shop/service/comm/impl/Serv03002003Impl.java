package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.wx.shop.entities.pojo.FileInfoModel;
import com.wx.shop.mapper.CommMapper;
import com.wx.shop.service.comm.Serv03002002;
import com.wx.shop.service.comm.Serv03002003;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 20:54
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件删除接口实现
 */
@Slf4j
@Service
public class Serv03002003Impl implements Serv03002003 {

    @Autowired
    private CommMapper commMapper;

    @Override
    public JSONObject deleteFile(JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        ArrayList<String> fileIndexList = reqJson.getObject("fileIndexList", ArrayList.class);  // 要删除的文件列索引列表
        if(fileIndexList != null && fileIndexList.size() == 0){
            //return resp;
        }

        //test code begin
        System.out.println("--------------------------------------------");
        //test code end

        /* 1、删除数据库中数据 */
        List<String> result = commMapper.queryFileUrl();

        System.out.println(result);


        /* 2、删除服务器上文件 */

        resp.put("urls", result);
        return resp;
    }
}
