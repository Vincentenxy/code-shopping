package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-品牌信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BrandInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 品牌id
     */
      @TableId(value = "brand_id", type = IdType.AUTO)
    private Integer brandId;

    /**
     * 品牌中文名
     */
    private String brandName;

    /**
     * 品牌英文名
     */
    private String brandNameEng;

    /**
     * 品牌描述
     */
    private String brandDesc;

    /**
     * 外键，类别表id主键
     */
    private Integer fkCategoryId;

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
