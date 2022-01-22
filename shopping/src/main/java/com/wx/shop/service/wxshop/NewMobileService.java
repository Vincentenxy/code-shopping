package com.wx.shop.service.wxshop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wx.shop.entities.pojo.NewMobile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
public interface NewMobileService extends IService<NewMobile> {

    IPage<NewMobile> selectPage(Page<NewMobile> page, QueryWrapper<NewMobile> wrapper);
}
