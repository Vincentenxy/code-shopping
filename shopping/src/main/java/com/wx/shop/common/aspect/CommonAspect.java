package com.wx.shop.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/18
 * Author: vincentEnxy
 * Version: 1.0
 * Description: (这里用一句话描述这个类的作用)
 */
@Component
@Aspect
public class CommonAspect {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//
//    // 自定义切入点
//    private final String POINT_CUT_LOG = "execution( public * com.wx.shop.*.(..))";
//
//    @Pointcut(POINT_CUT_LOG)
//    public void pointCut(){}
//
//    @Before(value = "pointCut()")
//    public void before (){
//
//    }

}
