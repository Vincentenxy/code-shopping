package com.wx.shop.controller.wxshop.PageInteceptConfig;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 微信商城系统-分页拦截器，自动分页处理
 * </p>
 *
 * @author fanjh
 * @since 2022-01-20
 */

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
