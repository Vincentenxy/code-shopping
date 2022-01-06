package com.wx.shop.exception.entity;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/6 22:24
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 业务
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -2834700424752718099L;

    private String errCode;   // 异常代码

    private String errMessage;// 异常信息


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public BusinessException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BusinessException(String message, String errCode, String errMessage) {
        super(message);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }



}
