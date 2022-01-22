package com.wx.shop.entities.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ProjectName: shopping
 * CreateTime: 2022/01/11 22:29
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 用户信息表实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPasswd;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 用户头像图片编号,图片表外键
     */
    private String imgId;

    /**
     * 角色类型
     */
    private Integer fkRoleId;

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
