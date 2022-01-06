package com.wx.shop.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Locale;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:34
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 检测相关工具类
 *          1、controlelr中非空数据校验 checkParamValid
 */
public class CheckUtils {


    /**
     * 校验checkJson 中params 是否为空
     * @param checkJson 入参json
     * @param params 校验字段
     * @return
     *      "": 校验通过
     *      param: 参数param非空
     */
    public static String checkParamValid(JSONObject checkJson, String... params){
        for(String param : params){
            System.out.println(param);
            if(checkJson.getString(param) == null || "".equals(checkJson.getString(param)))
                return param.toUpperCase(Locale.ROOT);
        }
        return "";
    }


}
