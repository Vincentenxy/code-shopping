package com.wx.shop.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-订单信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单主键
     */
      @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 用户id，用户表外键
     */
    private Integer fkUserId;

    /**
     * 订单价格
     */
    private Double payPrice;

    /**
     * 是否支付，0-未支付，1-支付
     */
    private Integer isPay;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 是否收货，0-未收货，1-已收货
     */
    private Integer isShip;

    /**
     * 发货时间
     */
    private LocalDateTime shipTime;

    /**
     * 是否发货，0-未发货，1-已发货
     */
    private Integer isReceipt;

    /**
     * 快递公司订单编号，用来查询物流信息
     */
    private String shipNumber;

    /**
     * 订单状态，1-正常，0-禁用，-1-删除
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单更新时间
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
