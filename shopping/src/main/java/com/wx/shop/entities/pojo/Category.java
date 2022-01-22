package com.wx.shop.entities.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/22 15:49
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 类别信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Category implements Serializable {

    private static final long serialVersionUID = 1904943958768367971L;

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
