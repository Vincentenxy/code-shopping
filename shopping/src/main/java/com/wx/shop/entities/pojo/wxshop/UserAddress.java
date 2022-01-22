package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-收获地址表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddress implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 地址id
     */
      @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    /**
     * 用户id
     */
    private Integer fkUserId;

    /**
     * 国家
     */
    private Integer addressCountry;

    /**
     * 省份
     */
    private Integer addressProvince;

    /**
     * 城市
     */
    private Integer addressCity;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 是否默认，0-否，1-是
     */
    private Boolean isDefault;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 收货人姓名
     */
    private String consignee;

    /**
     * 手机号
     */
    private String mobile;

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
