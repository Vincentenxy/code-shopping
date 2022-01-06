package com.wx.shop.exception;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.exception.entity.BusinessException;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/6 22:53
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 异常处理工具类
 */
public class ExceptionUtil<T> {

    /**
     * 封装异常信息
     * @param e
     * @return
     */
    public static JSONObject PackErrInfo(BusinessException e){
        JSONObject resp = new JSONObject();
        resp.put(Constant.RET_CODE, e.getErrCode());    // 异常代码
        resp.put(Constant.RET_MSG, e.getErrMessage());  // 异常信息
        return resp;
    }
}
