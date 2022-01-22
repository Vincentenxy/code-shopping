package com.wx.shop.mapper;

import com.wx.shop.entities.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 微信商城系统-类别信息表 Mapper 接口
 * </p>
 *
 * @author fanjh
 * @since 2022-01-09
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
