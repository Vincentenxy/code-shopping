package com.wx.shop.entities.pojo.wxshop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-公司信息表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CompanyInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 公司id，主键
     */
      @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司描述
     */
    private String companyDesc;

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
