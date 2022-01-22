package com.wx.shop.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.entities.pojo.NewMobile;
import com.wx.shop.service.wxshop.NewMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@RestController
@RequestMapping("/newMobile")
public class NewMobileController {

    @Autowired
    private NewMobileService newMobileService;

    @RequestMapping("/page")
    public IPage<NewMobile> selectBookPage(){
        Page<NewMobile> page = new Page<>(1, 2);
        QueryWrapper<NewMobile> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<NewMobile> mobileIPage = newMobileService.selectPage(page,wrapper);

        JSONObject resp = new JSONObject();



        mobileIPage.orders();
        return mobileIPage;
    }

}

