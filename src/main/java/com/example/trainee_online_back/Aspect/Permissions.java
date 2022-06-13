package com.example.trainee_online_back.Aspect;

import com.example.trainee_online_back.annotation.Role;
import com.example.trainee_online_back.exception.BasicInfoException;
import com.example.trainee_online_back.utils.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@SuppressWarnings({"unused"})
public class Permissions {
    @Pointcut("@annotation(com.example.trainee_online_back.annotation.Role)")
    public void annotationPointcut() {

    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        // 此处进入到方法前  可以实现一些业务逻辑

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String roleid = RequestUtil.getTLUserRole().toString();
        //获取自定义注解上的值
        String role = method.getAnnotation(Role.class).value();
        if (!role.equals(roleid)) {
            throw new BasicInfoException("用户权限不对应");
        }

    }

}

