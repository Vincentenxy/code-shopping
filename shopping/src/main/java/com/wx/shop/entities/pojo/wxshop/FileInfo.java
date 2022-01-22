package com.wx.shop.entities.pojo.wxshop;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-文件信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FileInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 文件id
     */
      private String fileId;

    /**
     * 文件url
     */
    private String fileUrl;

    /**
     * 文件顺序号
     */
    private Integer fileSeq;

    /**
     * 文件类型，0-图片，1-视频
     */
    private Integer fileType;

    /**
     * 是否主要文件，0-否，1-是
     */
    private Integer isMain;

    /**
     * 文件创建时间
     */
    private LocalDateTime createTime;

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
