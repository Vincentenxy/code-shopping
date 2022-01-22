package com.wx.shop.controller.wxshop;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.controller.ControllerInter;
import com.wx.shop.entities.pojo.BrandInfo;
import com.wx.shop.exception.entity.BusinessException;
import com.wx.shop.service.wxshop.BrandInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName: shopping
 * CreateTime: 2022/01/22 22:00
 * Author: fanjh
 * Version: 1.0
 * Description: 小程序登录首页请求相关信息模块
 */

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/api/pub/v1/shop")
public class Cont01001001 implements ControllerInter<JSONObject> {

    @Autowired
    private BrandInfoService brandInfoService;

    @Override
    @RequestMapping("/01001001")
    public JSONObject excute(JSONObject jsonObject) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Map<String, Object> svcBodyMap = new HashMap<String,Object>();
        Page<BrandInfo> page = new Page<>(1, 2);
        QueryWrapper<BrandInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("brand_id");
        IPage<BrandInfo> bookIPage = brandInfoService.selectPage(page,wrapper);
        bookIPage.orders();
        svcBodyMap.put("totalPage",bookIPage.getPages());
        svcBodyMap.put("totalNum",bookIPage.getRecords());
        svcBodyMap.put("resultList",bookIPage.getRecords());
        resultMap.put("respCode","200");
        resultMap.put("respMsg","操作成功");
        resultMap.put("respComm","");
        resultMap.put("respBody",svcBodyMap);
        return (JSONObject) JSONObject.parse(resultMap.toString());
    }

    @Override
    public JSONObject befExec(JSONObject jsonObject) throws BusinessException {
        return null;
    }

    @Override
    public JSONObject aftExec(JSONObject retJson) {
        return null;
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
//    @RequestMapping("/pageOfMap")
//    public IPage<Map<String, Object>>  selectBookPage1(){
//        Page<BrandInfo> page = new Page<>(1, 2);
//        QueryWrapper<BrandInfo> wrapper = new QueryWrapper<>();
//        wrapper.orderByDesc("Book_id");
//        IPage<Map<String, Object>> mapIPage = brandInfoService.selectMapsPage(page, wrapper);
//        return mapIPage;
//    }
}
