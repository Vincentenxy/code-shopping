package com.wx.shop.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.util.StringUtils;
import com.wx.shop.entities.pojo.MenuInfo;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.mapper.admin.AdminMapper;
import com.wx.shop.mapper.admin.MenuInfoMapper;
import com.wx.shop.service.admin.Serv02003001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/3 16:02
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 02003001接口具体实现
 */
@Slf4j
@Service
public class Serv02003001Impl implements Serv02003001 {

    @Autowired
    private MenuInfoMapper menuInfoMapper;

    /**
     * 登录成功后查询相关信息
     * @param reqJson
     * @return
     */
    @Override
    public JSONObject queryAdminInfo(JSONObject reqJson) throws BusinessException{
        JSONObject resp = new JSONObject();
        try {

            /* 1、查询左侧导航栏信息 */
            List<MenuInfo> menuInfoList = menuInfoMapper.selectList(null);
            HashMap<String, JSONObject> firstMenu = new HashMap<>();
            for (MenuInfo menuInfo : menuInfoList) {
                JSONObject menuJson = (JSONObject) JSONObject.toJSON(menuInfo);
                if (null == menuInfo.getMenuParent() || StringUtils.isNullOrEmpty(menuInfo.getMenuParent())) {    // 1级菜单
                    menuJson.put("childMenus", new JSONArray());// 添加子菜单数组
                    firstMenu.put(menuInfo.getMenuId(), menuJson);
                } else {    // 2级菜单
                    JSONObject parMenu = firstMenu.get(menuInfo.getMenuParent());
                    parMenu.getJSONArray("childMenus").add(menuJson);   // 放入子菜单
                }
            }
            JSONArray menuInfoJsonArr = new JSONArray();
            for (Map.Entry<String, JSONObject> entry : firstMenu.entrySet()) {
                menuInfoJsonArr.add(0, entry.getValue());
            }

            /* 2、菜单权限过滤 */
            // TODO

            resp.put("menuInfo", menuInfoJsonArr);

        }catch (Exception e){
            throw new BusinessException("ERR0002", e.getMessage());
        }

        return resp;
    }



}
