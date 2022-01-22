package com.wx.shop.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.wx.shop.service.wxshop.BrandInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 微信商城系统-品牌信息表 前端控制器
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Slf4j
@RestController
@RequestMapping("/brandInfo")
public class BrandInfoController {

    @Autowired
    private BrandInfoService brandInfoService;

    @RequestMapping("/test")
    public JSONObject excute(@RequestBody JSONObject reqData){
        JSONObject resp = new JSONObject();
        resp.put("retCode", "0000");
        return resp;
    }

//    @RequestMapping("/page")
//    public IPage<BrandInfo> selectBookPage(){
//        Page<BrandInfo> page = new Page<>(1, 2);
//        QueryWrapper<BrandInfo> wrapper = new QueryWrapper<>();
//        wrapper.orderByDesc("brand_id");
//        IPage<BrandInfo> bookIPage = brandInfoService.selectPage(page,wrapper);
//        //IPage<BrandInfo> bookIPage = bookDao.selectPage(page, wrapper);
//        bookIPage.orders();
//        return bookIPage;
//    }
//    @RequestMapping("/page1")
//    public IPage<Map<String, Object>>  selectBookPage1(){
//        Page<BrandInfo> page = new Page<>(1, 2);
//        QueryWrapper<BrandInfo> wrapper = new QueryWrapper<>();
//        wrapper.orderByDesc("Book_id");
//        IPage<Map<String, Object>> mapIPage = brandInfoService.selectMapsPage(page, wrapper);
//        return mapIPage;
//    }

}

