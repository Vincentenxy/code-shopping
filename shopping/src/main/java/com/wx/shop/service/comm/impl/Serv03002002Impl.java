package com.wx.shop.service.comm.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.FileInfoModel;
import com.wx.shop.mapper.CommMapper;
import com.wx.shop.service.comm.Serv03002001;
import com.wx.shop.service.comm.Serv03002002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 0:05
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 文件入库实现
 */
@Service
public class Serv03002002Impl implements Serv03002002 {

    @Autowired
    private CommMapper commMapper;


    @Override
    public JSONObject insertFileInfo(JSONObject reqJson) {
        JSONObject resp = new JSONObject();

        FileInfoModel fileInfoModel = new FileInfoModel();
        fileInfoModel.setFileId("20211224_ae1167d4-639a-4150-8e04-7b8db8f3e2pa");
        fileInfoModel.setFileUrl("C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20211224\\20211224_ae1167d4-639a-4150-8eb4-7b8db8f3eaea.flv");
        fileInfoModel.setFileSeq("0");
        fileInfoModel.setFileType("1");
        fileInfoModel.setIsMain("0");
        fileInfoModel.setCreateTime("");
        fileInfoModel.setSpare1("");
        fileInfoModel.setSpare2("");
        fileInfoModel.setSpare3("");

        System.out.println("====>"+reqJson);
        JSONArray fileInfoList = reqJson.getJSONArray("fileInfoList");
        List<FileInfoModel> fileInfoModelList = new ArrayList<>();
        for(int i =0 , len= fileInfoList.size(); i < len; i ++){
            System.out.println("===--->"+fileInfoList.get(i));
            JSONObject oneFileInfo = (JSONObject) fileInfoList.get(i);
            fileInfoModelList.add(new FileInfoModel(
                oneFileInfo.getString("fileId"),
                oneFileInfo.getString("fileUrl"),
                oneFileInfo.getString("fileSeq"),
                oneFileInfo.getString("fileType"),
                oneFileInfo.getString("isMain"),
                "", // 入库时间为空
                oneFileInfo.getString("spare1"),
                oneFileInfo.getString("spare2"),
                oneFileInfo.getString("spare3")
            ));
        }
        for(FileInfoModel f : fileInfoModelList)
            System.out.println(fileInfoModelList.toString());
        //int insertResult = commMapper.insertFileInfo(fileInfoModel);
        //System.out.println("-------insertResult====="+ insertResult);

        return resp;
    }
}
