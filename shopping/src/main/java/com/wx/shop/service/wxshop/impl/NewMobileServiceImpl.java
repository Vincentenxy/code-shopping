package com.wx.shop.service.wxshop.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.entities.pojo.wxshop.NewMobile;
import com.wx.shop.mapper.wxshop.NewMobileMapper;
import com.wx.shop.service.wxshop.NewMobileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Service
public class NewMobileServiceImpl extends ServiceImpl<NewMobileMapper, NewMobile> implements NewMobileService {

    @Autowired
    private NewMobileMapper newMobileMapper;

    @Override
    public IPage<NewMobile> selectPage(Page<NewMobile> page, QueryWrapper<NewMobile> wrapper) {
        return newMobileMapper.selectPage(page,wrapper);
    }
}
