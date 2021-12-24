package com.wx.shop.service.comm;

import com.alibaba.fastjson.JSONObject;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:04
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 删除文件接口
 */
public interface Serv03002002 {

    /**
     * 文件删除接口
     * @param reqJson
     * @return
     */
    public JSONObject deleteFile(JSONObject reqJson);
}
