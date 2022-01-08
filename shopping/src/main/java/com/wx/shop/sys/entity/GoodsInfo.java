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
 * 微信商城系统-商品信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品id
     */
      @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品标签
     */
    private String goodsLable;

    /**
     * 商品详情
     */
    private String goodsDesc;

    /**
     * 商品状态,0-下架，1-上架
     */
    private Integer goodsStatus;

    /**
     * 商品入库时间
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

    /**
     * 类别id
     */
    private Integer fkCategoryId;

    /**
     * 店铺id
     */
    private Integer fkShopId;


}
