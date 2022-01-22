package com.wx.shop.entities.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/19 21:29
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 首页轮播图信息model
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SlideShow implements Serializable {

    private static final long serialVersionUID = -6181119448684811238L;

    private String slideId;     // 轮播图id

    private String fkImgId;     // 图片id

    private String slideUrl;    // 详情链接

    private String slideDesc;   // 轮播图描述

    private String spare1;      // 备用字段1

    private String spare2;      // 备用字段2

    private String spare3;      // 备用字段3

    public String getSlideId() {
        return slideId;
    }

    public void setSlideId(String slideId) {
        this.slideId = slideId;
    }

    public String getFkImgId() {
        return fkImgId;
    }

    public void setFkImgId(String fkImgId) {
        this.fkImgId = fkImgId;
    }

    public String getSlideUrl() {
        return slideUrl;
    }

    public void setSlideUrl(String slideUrl) {
        this.slideUrl = slideUrl;
    }

    public String getSlideDesc() {
        return slideDesc;
    }

    public void setSlideDesc(String slideDesc) {
        this.slideDesc = slideDesc;
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
        return "SlideModel{" +
                "slideId='" + slideId + '\'' +
                ", fkImgId='" + fkImgId + '\'' +
                ", slideUrl='" + slideUrl + '\'' +
                ", slideDesc='" + slideDesc + '\'' +
                ", spare1='" + spare1 + '\'' +
                ", spare2='" + spare2 + '\'' +
                ", spare3='" + spare3 + '\'' +
                '}';
    }
}
