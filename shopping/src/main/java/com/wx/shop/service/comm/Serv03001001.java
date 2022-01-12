package com.wx.shop.service.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/11 0:01
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户登录接口
 */
public interface Serv03001001 {

    /**
     * 用户登录接口
     * @param reqJson
     * @return
     */
    public JSONObject loginIn(JSONObject reqJson) throws BusinessException;

}
