package com.wx.shop.entities.exceptions;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 异常类
 */
public class ShopException {

    public String exceptCode = "";

    public String exceptMsg = "";

    ShopException(){}

    ShopException(String exceptCode, String exceptMsg){
        this.exceptCode = exceptCode;
        this.exceptMsg = exceptMsg;
    }

    public String getExceptCode() {
        return exceptCode;
    }

    public void setExceptCode(String exceptCode) {
        this.exceptCode = exceptCode;
    }

    public String getExceptMsg() {
        return exceptMsg;
    }

    public void setExceptMsg(String exceptMsg) {
        this.exceptMsg = exceptMsg;
    }
}
