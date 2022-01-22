package com.wx.shop.entities.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城-物流信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LogisticInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * id,自增主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id,外键
     */
    private Integer fkOrderId;

    /**
     * 快递公司快递单号
     */
    private String tackingNumber;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

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
