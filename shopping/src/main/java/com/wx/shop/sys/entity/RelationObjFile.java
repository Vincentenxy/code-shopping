package com.wx.shop.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微信商城系统-实体与商品图片视频对应表
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RelationObjFile implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品与图片关系映射关系id
     */
      @TableId(value = "relation_id", type = IdType.AUTO)
    private Long relationId;

    /**
     * 实体信息id
     */
    private Integer objId;

    /**
     * 文件id,
     */
    private String fkFileId;

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
