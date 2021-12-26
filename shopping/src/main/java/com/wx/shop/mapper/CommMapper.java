package com.wx.shop.mapper;

import com.wx.shop.entities.pojo.FileInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 1:04
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 公共部分相关mapper
 */
@Mapper
@Repository
public interface CommMapper {

    /**
     * 获取文件信息
     * @param fileIndexList
     */
    public List<FileInfoModel> getFileInfo(List<String> fileIndexList);

    /**
     * 获取文件的url
//     * @param fileIndexList
     * @return
     */
    //public List<String> queryFileUrl(List<String> fileIndexList);
    public List<String> queryFileUrl();

    /**
     * 插入文件信息
     * @param fileInfoModels
     */
    public int insertFileInfo(FileInfoModel fileInfoModels);
}
