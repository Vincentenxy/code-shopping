package com.wx.shop.entities.pojo.wxshop;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-首页轮播图信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SlideShow implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 轮播id
     */
      private Integer slideId;

    /**
     * 外键，图片id
     */
    private String fkFileId;

    /**
     * 详情链接
     */
    private String slideUrl;

    /**
     * 详情描述
     */
    private String slideDesc;

    /**
     * 备用字段
     */
    private String spare1;

    /**
     * 备用字段
     */
    private String spare2;

    /**
     * 备用字段
     */
    private String spare3;


}
