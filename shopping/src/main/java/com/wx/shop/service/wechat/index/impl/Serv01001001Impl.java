package com.wx.shop.service.wechat.index.impl;

import com.alibaba.fastjson.JSONObject;
import com.wx.shop.entities.pojo.SlideShow;
import com.wx.shop.mapper.SlideShowMapper;
import com.wx.shop.service.wechat.index.Serv01001001;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/16
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 首页查询公共信息接口
 */
@Slf4j
@Service
public class Serv01001001Impl implements Serv01001001 {

    @Autowired
    private SlideShowMapper slideShowMapper;

    public JSONObject queryIndexInfo() {

        List<SlideShow> slideShowList = slideShowMapper.selectSlideList();

        log.info(slideShowList.toString());

        return null;
    }
}
