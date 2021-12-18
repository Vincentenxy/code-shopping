package com.wx.shop.common.model.entity;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/9 0:12
 * @description: 数据库查询出错异常实体类
 **/
public class SqlException {


    private String code;

    private String errMsg;

    private Object errObj;

    public SqlException(){}

    public SqlException(String code, String errMsg, Object errObj){
        this.code = code;
        this.errMsg = errMsg;
        this.errObj = errObj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getErrObj() {
        return errObj;
    }

    public void setErrObj(Object errObj) {
        this.errObj = errObj;
    }

    /**
     * 默认错误返回，仅默认错误返回码，无返回信息与错误信息
     * @return
     */
    public static SqlException defaultFail(){
        return new SqlException("11111111", "", null);
    }

}
