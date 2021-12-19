package com.wx.shop.controller.controlinter;

import com.alibaba.fastjson.JSONObject;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19
 * Author: vincentEnxy
 * Version: 1.0
 * Description: controller 统一继承接口
 */
public interface ControllerInter<T> {

    public JSONObject excute(T t);
}
