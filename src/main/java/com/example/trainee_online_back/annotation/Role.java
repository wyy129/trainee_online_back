package com.example.trainee_online_back.annotation;

import java.lang.annotation.*;
/**
 * @description: 用户角色注解，用于校验权限
 * @author wangyangyang
 * @date: 2022/6/23 10:08
 * @return:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Role {

    String value() default "";

}

