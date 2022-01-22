package com.wx.shop.entities.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-订单商品表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RelationOrderGoods implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品id，主键自增
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id，订单信息表id主键
     */
    private Integer fkOrderId;

    /**
     * 外键，店铺id
     */
    private Integer fkShopId;

    /**
     * 外键，商品编号
     */
    private Integer fkGoodsId;

    /**
     * 订单中此商品数量，默认1件
     */
    private Integer goodsCount;

    /**
     * 订单中商品的最终售卖价格，用于计算订单费用使用
     */
    private Double goodPrice;

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
