package com.wx.shop.controller.noaop;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.common.Constant;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.service.comm.Serv03002001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/20 23:04
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件上传接口
 */
@Slf4j
@ResponseBody
@Controller
@RequestMapping("/api/pub/v1/comm")
public class Cont03002001 implements ControllerInter<MultipartFile[]>{

    @Autowired
    private Serv03002001 serv03002001;

    /**
     * 文件上传接口
     * @param files
     * @return
     */
    @RequestMapping(value = "/03002001")
    public JSONObject excute(@RequestParam("files")MultipartFile[] files) {
        JSONObject resp = new JSONObject();

        /* 处理业务逻辑 */
        JSONObject uploadResult = serv03002001.uploadFiles(files);

        /* 放入通用返回体 */
        resp.put(Constant.RET_CODE, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_MSG, Constant.RET_MSG_SUCC);
        resp.put(Constant.RET_COMM, null);
        resp.put(Constant.RET_BODY, uploadResult);
        return resp;
    }
}
