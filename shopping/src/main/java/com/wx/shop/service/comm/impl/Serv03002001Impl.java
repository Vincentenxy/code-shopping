package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.wx.shop.service.comm.Serv03002001;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/24 20:31
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 03002001 文件上传接口实现类
 */
@Service
public class Serv03002001Impl implements Serv03002001 {

    @Value("${savefile.file.root.path}")
    private String fileSavePath;


    @Override
    public JSONObject uploadFiles(MultipartFile[] files) {

        JSONObject resp = new JSONObject();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String nowDay = dtf.format(LocalDateTime.now());
        String filePathPre = new StringBuilder(fileSavePath).append(nowDay).append(File.separator).toString();
        String filePath = "",
                fileHashCode = "",
                originalFilename = "",
                fileFix = "";

        /* 文件夹不存在就创建文件夹 */
        File pathExist = new File(filePathPre.toString());
        if(!pathExist.exists()){
            pathExist.mkdirs();
        }

        /* 多文件上传 */
        for(MultipartFile file : files){
            fileHashCode = nowDay + "_" + UUID.randomUUID().toString();
            originalFilename = file.getOriginalFilename();// 上传的文件名
            fileFix = originalFilename.substring(originalFilename.lastIndexOf("."));
            filePath = filePathPre + fileHashCode + fileFix; //最终文件存储路径
            try{
                // 保存文件
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            resp.put(fileHashCode, filePath);
        }

        System.out.println("===》 " + resp);
        return resp;
    }
}
