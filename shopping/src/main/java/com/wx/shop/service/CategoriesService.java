package com.wx.shop.service;

import com.wx.shop.common.model.request.ResponseModel;
import org.springframework.stereotype.Service;

/**
 * @program: shopping
 * @autohr: wx
 * @createTime: 2021/3/8 22:46
 * @description: 分类页面接口
 **/
public interface CategoriesService {

    /**
     * 获取分类页面信息
     * @return
     */
    public ResponseModel queryCategoriesInfo();
}
