package com.wx.shop.service.wxshop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.entities.pojo.wxshop.BrandInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 微信商城系统-品牌信息表 服务类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
public interface BrandInfoService extends IService<BrandInfo> {

    IPage<BrandInfo> selectPage(Page<BrandInfo> page, QueryWrapper<BrandInfo> wrapper);

    IPage<Map<String, Object>> selectMapsPage(Page<BrandInfo> page, QueryWrapper<BrandInfo> wrapper);
}
