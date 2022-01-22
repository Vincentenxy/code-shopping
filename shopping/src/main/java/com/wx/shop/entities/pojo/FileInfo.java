package com.wx.shop.entities.pojo;

import java.io.Serializable;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/25 13:47
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 保存的文件
 */
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 7312117949855179477L;


    private String fileId; 		// 文件id

    private String fileUrl; 	// 文件url

    private String fileSeq; 	// 文件序号

    private String fileType; 	// 文件类型 0-图片，1-视频

    private String isMain; 		// 是否为主要文件

    private String createTime; 	// 创建时间

    private String spare1; 		// 备用字段1

    private String spare2; 		// 备用字段2

    private String spare3; 		// 备用字段3

    public FileInfo() { }

    public FileInfo(String fileId, String fileUrl, String fileSeq, String fileType, String isMain, String createTime, String spare1, String spare2, String spare3) {
        this.fileId = fileId;
        this.fileUrl = fileUrl;
        this.fileSeq = fileSeq;
        this.fileType = fileType;
        this.isMain = isMain;
        this.createTime = createTime;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.spare3 = spare3;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileSeq() {
        return fileSeq;
    }

    public void setFileSeq(String fileSeq) {
        this.fileSeq = fileSeq;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getIsMain() {
        return isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId='" + fileId + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileSeq='" + fileSeq + '\'' +
                ", fileType='" + fileType + '\'' +
                ", isMain='" + isMain + '\'' +
                ", createTime='" + createTime + '\'' +
                ", spare1='" + spare1 + '\'' +
                ", spare2='" + spare2 + '\'' +
                ", spare3='" + spare3 + '\'' +
                '}';
    }
}
