package com.wx.shop.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.exception.entity.ExecConstant;

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
            if(checkJson.getString(param) == null || "".equals(checkJson.getString(param)))
                return param.toUpperCase(Locale.ROOT);
        }
        return "";
    }

    /**
     * 抛出异常的非空校验方法
     * 不能校验非String类型字段
     * @param checkJson 入参json
     * @param params 校验字段
     * @return
     * @throws BusinessException
     */
    public static boolean checkParamValidException(JSONObject checkJson, String... params) throws BusinessException{
        for(String param: params){
            if(checkJson.getString(param) == null || "".equals(checkJson.getString(param)))
                throw new BusinessException(ExecConstant.ERR_CODE_1001, param.toUpperCase(Locale.ROOT)+"_IS_INVALID");
        }
        return true;
    }

}
