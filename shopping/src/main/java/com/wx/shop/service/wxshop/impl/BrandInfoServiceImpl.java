package com.wx.shop.service.wxshop.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.entities.pojo.BrandInfo;
import com.wx.shop.mapper.BrandInfoMapper;
import com.wx.shop.service.wxshop.BrandInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 微信商城系统-品牌信息表 服务实现类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Service
public class BrandInfoServiceImpl extends ServiceImpl<BrandInfoMapper, BrandInfo> implements BrandInfoService {

    @Autowired
    private BrandInfoMapper brandInfoMapper;
    @Override
    public IPage<BrandInfo> selectPage(Page<BrandInfo> page, QueryWrapper<BrandInfo> wrapper) {
        return brandInfoMapper.selectPage(page,wrapper);
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(Page<BrandInfo> page, QueryWrapper<BrandInfo> wrapper) {
        return null;
    }
}
