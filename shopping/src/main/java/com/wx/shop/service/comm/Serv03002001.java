package com.wx.shop.service.comm;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/24 20:29
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件上传接口实现
 */
public interface Serv03002001 {

    /**
     * 文件上传接口
     * @param files
     * @return
     */
    public JSONObject uploadFiles(MultipartFile[] files);
}
