package com.wx.shop.entities.pojo.wxshop;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-管理端左侧菜单栏表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单id
     */
      private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单id
     */
    private Integer menuParent;

    /**
     * 菜单对应的路由
     */
    private String router;

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
