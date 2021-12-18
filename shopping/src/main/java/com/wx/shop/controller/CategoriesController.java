package com.wx.shop.controller;

import com.wx.shop.common.model.request.ResponseModel;
import com.wx.shop.service.CategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/8 22:45
 * @description: 分类页面Controller
 **/
@Controller
@RequestMapping(value = "/api/pub/v1/categories")
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    public ResponseModel getCategoriesInfo(){
        ResponseModel responseModel = new ResponseModel();
        String retMsg = "数据查询成功！";

        responseModel = categoriesService.queryCategoriesInfo();

        return new ResponseModel(0, retMsg, responseModel);
    }

}
