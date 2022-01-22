package com.wx.shop.service.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/22 15:32
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 02002002Service接口
 */
public interface Serv02002002 {

    /**
     * 查询相关信息接口
     * @param reqJson
     * @return
     */
    public JSONObject queryInfo(JSONObject reqJson);
}
