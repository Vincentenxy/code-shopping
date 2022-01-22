package com.wx.shop.service.admin;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 16:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description:
 */
public interface Serv02003001 {

    /**
     * 管理端登录首页后查询相关信息
     * @return
     */
    public JSONObject queryAdminInfo(JSONObject reqJson) throws BusinessException;
}
