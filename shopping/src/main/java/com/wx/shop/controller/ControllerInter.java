package com.wx.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19
 * Author: vincentEnxy
 * Version: 1.0
 * Description: controller 统一继承接口
 */
public interface ControllerInter<T> {

    /**
     * 主要处理方法
     * @param t
     * @return
     */
    public JSONObject excute(T t);

    /**
     * excute 前公共处理
     * @param t
     * @return
     */
    public JSONObject befExec(T t) throws BusinessException;

    /**
     * excute后处理，如有需要可单独进行返回处理
     * @param retJson
     * @return
     */
    public JSONObject aftExec(JSONObject retJson);
}
