package com.wx.shop.entities.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 16:13
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 管理端左侧菜单栏对象实例
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuInfo implements Serializable {

    private static final long serialVersionUID = 19984074456487804L;

    private String menuId;     // 菜单id

    private String menuName;   // 菜单名称

    private String menuParent; // 父级菜单id

    private String menuIcon;   // 菜单图标

    private String router;     // 菜单对应对应路由

    private String spare1;     // 备用字段

    private String spare2;     // 备用字段

    private String spare3;     // 备用字段

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(String menuParent) {
        this.menuParent = menuParent;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }

    @Override
    public String toString() {
        return "MenuInfoModel{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuParent='" + menuParent + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", router='" + router + '\'' +
                ", spare1='" + spare1 + '\'' +
                ", spare2='" + spare2 + '\'' +
                ", spare3='" + spare3 + '\'' +
                '}';
    }
}
