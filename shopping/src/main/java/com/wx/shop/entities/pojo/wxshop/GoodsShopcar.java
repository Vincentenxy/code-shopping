package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-购物车表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsShopcar implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车id
     */
      @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    /**
     * 用户id
     */
    private Integer fkUserId;

    /**
     * 店铺id
     */
    private Integer fkShopId;

    /**
     * 商品id
     */
    private Integer fkGoodsId;

    /**
     * 商品价格
     */
    private Double goodsPrice;

    /**
     * 商品数量，默认为1
     */
    private Integer goodsCount;

    /**
     * 此条商品状态，0-正常，1-禁用
     */
    private Integer status;

    /**
     * 加入购物车的时间
     */
    private LocalDateTime addTime;

    /**
     * 此条记录更新时间
     */
    private LocalDateTime updateTime;

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
