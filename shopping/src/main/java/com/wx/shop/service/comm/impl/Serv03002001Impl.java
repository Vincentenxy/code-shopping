package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.wx.shop.service.comm.Serv03002001;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

        JSONArray fileList = new JSONArray();
        JSONObject tmpSavedFile = null;
        /* 多文件上传 */
        for(MultipartFile file : files){
            fileHashCode = nowDay + "_" + UUID.randomUUID().toString();
            originalFilename = file.getOriginalFilename();// 上传的文件名
            fileFix = originalFilename.substring(originalFilename.lastIndexOf("."));
            filePath = filePathPre + fileHashCode + fileFix; //最终文件存储路径
            tmpSavedFile = new JSONObject();
            try{
                file.transferTo(new File(filePath)); // 保存文件
                tmpSavedFile.put("saveResult", "1");
            } catch (IOException e) {
                tmpSavedFile.put("saveResult", "0"); // 文件保存结果, 1-成功，0-失败
                log.error("Serv03002001Impl [uploadFiles] 保存文件出现异常！fileName：{}, 异常信息: {}", originalFilename, e);
            }
            tmpSavedFile.put("fileIndex", fileHashCode);
            tmpSavedFile.put("fileUrl", filePath);
            fileList.add(tmpSavedFile);
        }
        resp.put("uploadSuccFiles", fileList);
        return resp;
    }
}
