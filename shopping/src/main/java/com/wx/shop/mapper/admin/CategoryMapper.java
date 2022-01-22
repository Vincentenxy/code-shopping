package com.wx.shop.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wx.shop.entities.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ProjectName: shopping
 * CreateTime: 2022/1/22 15:35
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 类别表Mapper
 */
@Mapper
@Repository // 代表持久层
public interface CategoryMapper extends BaseMapper<Category> {

}
