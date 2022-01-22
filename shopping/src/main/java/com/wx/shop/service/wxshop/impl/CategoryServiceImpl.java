package com.wx.shop.service.wxshop.impl;

import com.wx.shop.entities.pojo.Category;
import com.wx.shop.mapper.CategoryMapper;
import com.wx.shop.service.wxshop.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信商城系统-类别信息表 服务实现类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
