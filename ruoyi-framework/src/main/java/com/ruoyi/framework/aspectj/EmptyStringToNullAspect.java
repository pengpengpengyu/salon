package com.ruoyi.framework.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * EmptyStringToNullAspect
 *
 * @author pywang
 * @version 1.0
 * @description Controller空字符串转null
 * @date 2024/5/19 10:39
 */
@Aspect
@Component
public class EmptyStringToNullAspect {

    @Around("execution(* com.ruoyi.web.controller..*.*(..))")
    public Object convertEmptyStringsToNull(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            replaceEmptyStringsWithNull(args[i]);
        }
        return joinPoint.proceed(args);
    }

    private static void replaceEmptyStringsWithNull(Object object) {
        if (object == null) return;

        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true); // 允许访问私有字段
                Object value = field.get(object);
                if (value instanceof String) {
                    if (((String) value).trim().isEmpty()) {
                        field.set(object, null);
                    } else {
                        field.set(object, ((String) value).trim());
                    }
                }
            } catch (IllegalAccessException e) {
                // 处理反射访问权限异常
                e.printStackTrace();
            }
        }
    }
}
