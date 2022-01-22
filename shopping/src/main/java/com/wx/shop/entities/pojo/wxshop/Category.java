package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-类别信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 类别id
     */
      @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 父类别id
     */
    private Integer categoryParentId;

    /**
     * 类别描述
     */
    private String categoryDesc;

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
