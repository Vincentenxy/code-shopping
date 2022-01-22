package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-用户收藏列表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CollectGoods implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 收藏id,主键
     */
      @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;

    /**
     * 外键，用户id
     */
    private Integer fkUserId;

    /**
     * 外键，商品id
     */
    private Integer fkGoodsId;

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
