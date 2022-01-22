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
 * 微信商城系统-商品规格信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsFormat implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 规格id,自增主键
     */
      @TableId(value = "format_id", type = IdType.AUTO)
    private Long formatId;

    /**
     * 商品id
     */
    private Integer fkGoodsId;

    /**
     * 规格名称
     */
    private String formatName;

    /**
     * 此规格价格
     */
    private Double formatPrice;

    /**
     * 此规格数量
     */
    private Integer formatCount;

    /**
     * 此规格当前状态，0-停用，1-在用
     */
    private Integer formatStatus;

    /**
     * 此规格创建时间
     */
    private LocalDateTime createTime;

    /**
     * 平台价格
     */
    private Double platformPrice;

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
