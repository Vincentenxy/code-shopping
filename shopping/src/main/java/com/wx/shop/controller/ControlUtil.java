package com.wx.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/6 23:29
 * Author: vincentEnxy
 * Version: 1.0
 * Description: Controller层工具类
 */
public class ControlUtil {

    /**
     * 成功情况下封装数据
     * @param respBody 处理后的业务逻辑
     * @return
     */
    public static JSONObject packSuccResp(JSONObject respBody){
        JSONObject resp = new JSONObject();
        resp.put(Constant.RET_CODE, Constant.RET_CODE_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, respBody);
        return resp;
    }

    /**
     * 失败情况下封装数据
     * @param respBody
     * @return
     */
    public static JSONObject packFailResp(JSONObject respBody){
        JSONObject resp = new JSONObject();
        resp.put(Constant.RET_CODE, Constant.RET_CODE_FAIL);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_FAIL);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, respBody);
        return resp;
    }


}
