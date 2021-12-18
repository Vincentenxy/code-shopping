package com.wx.shop.common.model.request;

import javax.xml.ws.Response;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/4 0:41
 * @description: 通用返回实体类
 **/
public class ResponseModel {

    /**
     * 状态码
     * 0 返回成功
     * 1 处理中
     * -1 失败
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回的业务数据
     */
    private Object respData;

    public ResponseModel(){ }

    public ResponseModel(Integer code, String msg, Object respData){
        this.code = code;
        this.msg = msg;
        this.respData = respData;
    }


    /**
     * 返回成功,无任何数据
     * @return
     */
    public static ResponseModel buildSuccess(){
        return new ResponseModel(0, "", null);
    }

    /**
     * 返回成功.返回数据
     * @param respData
     * @return
     */
    public static ResponseModel buildSuccess(Object respData){
        return new ResponseModel(0, "", respData);
    }


    /**
     * 返回失败,固定状态码
     * @param msg
     * @return
     */
    public static ResponseModel buildFail(String msg){
        return new ResponseModel(-1, msg, null);
    }

    /**
     * 返回失败,自定义错误码,错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResponseModel buildFail(Integer code, String msg){
        return new ResponseModel(code, msg, null);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }
}
