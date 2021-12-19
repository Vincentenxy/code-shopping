package com.wx.shop.common.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ProjectName: shopping
 * CreateTime: 2021/12/18
 * Author: vincentEnxy
 * Version: 1.0
 * Description: 切面
 */
@Slf4j
@Component
@Aspect
public class CommonAspect {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String POINT_CUT_LOG = "execution( public * com.wx.shop.controller.*.*.*(..))";

    // 定义切面，记录日志
    @Pointcut(POINT_CUT_LOG)
    public void pointCut(){}

    @Around(value = "pointCut()")
    public Object aroundLog (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String className = proceedingJoinPoint.getClass().toString();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arr = proceedingJoinPoint.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        log.info("{}-{} 请求入参：{}", className, methodName, mapper.writeValueAsString(arr));
        Object obj = proceedingJoinPoint.proceed();
        log.info("{}-{} 请求返回：{}", className, methodName, mapper.writeValueAsString(obj));

        return obj;
    }

}
