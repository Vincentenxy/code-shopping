package com.wx.shop.controller.comm;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.controller.controlinter.ControllerInter;
import com.wx.shop.service.comm.Serv03002001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/20 23:04
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 图片上传接口
 */
@Slf4j
@ResponseBody
@Controller
@RequestMapping("/api/pub/v1/comm")
public class Cont03002001 implements ControllerInter<MultipartFile[]>{

    @Autowired
    private Serv03002001 serv03002001;

    /**
     * 图片上传接口
     * @param files
     * @return
     */
    @RequestMapping(value = "/03002001")
    public JSONObject excute(@RequestParam("files")MultipartFile[] files) {
        JSONObject resp = serv03002001.uploadFiles(files);
        return resp;
    }
}
