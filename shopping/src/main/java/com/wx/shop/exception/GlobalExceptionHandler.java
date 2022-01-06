package com.wx.shop.exception;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.exception.entity.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/6 22:25
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 全局异常处理类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     * @param req http请求
     * @param e 异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public JSONObject businessExceptionHandler(HttpServletRequest req, BusinessException e){
        log.error("ERR: 发生业务处理异常：{}", e.getMessage());
        return  ExceptionUtil.PackErrInfo(e);
    }


}


