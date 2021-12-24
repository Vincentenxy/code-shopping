package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.shop.service.comm.Serv03002001;
import com.wx.shop.service.comm.Serv03002002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:05
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件删除实现
 */
@Service
public class Serv03002002Impl implements Serv03002002 {

    @Override
    public JSONObject deleteFile(JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        ArrayList<String> fileIndexList = reqJson.getObject("fileIndexList", ArrayList.class);  // 要删除的文件列索引列表
        if(fileIndexList.size() == 0){
            return resp;
        }

        /* 1、删除数据库中数据 */



        /* 2、删除服务器上文件 */


        // TODO
        return resp;
    }
}
