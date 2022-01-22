package com.wx.shop.service.wxshop.impl;

import com.wx.shop.entities.pojo.OrderInfo;
import com.wx.shop.mapper.OrderInfoMapper;
import com.wx.shop.service.wxshop.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信商城系统-订单信息表 服务实现类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
