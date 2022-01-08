package com.wx.shop.exception.entity;

/**
 * ProjectName: shopping
 * CreateTime: 11:38
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 数据库异常
 */
public class DbException {

    private String exceCode = ""; // 异常编号

    private String exceMsg = "";  // 异常信息

    public DbException(String exceCode, String exceMsg) {
        this.exceCode = exceCode;
        this.exceMsg = exceMsg;
    }

    public String getExceCode() {
        return exceCode;
    }

    public void setExceCode(String exceCode) {
        this.exceCode = exceCode;
    }

    public String getExceMsg() {
        return exceMsg;
    }

    public void setExceMsg(String exceMsg) {
        this.exceMsg = exceMsg;
    }
}
