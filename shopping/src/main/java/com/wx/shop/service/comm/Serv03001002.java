package com.wx.shop.service.comm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/13 22:28
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户注册接口实现
 */
public interface Serv03001002 {

    /**
     * 用户注册接口
     * @param reqJson
     * @return
     */
    public JSONObject regist(JSONObject reqJson) throws BusinessException;

}
