package com.example.trainee_online_back.Aspect;

import com.example.trainee_online_back.annotation.Token;
import com.example.trainee_online_back.utils.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@SuppressWarnings({"unused"})
public class TestAs {
    JsonResult jsonResult = new JsonResult();

    @Pointcut("@annotation(com.example.trainee_online_back.annotation.Token)")
    public void annotationPointcut() {

    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        // 此处进入到方法前  可以实现一些业务逻辑

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //获取自定义注解上的值
        Token Token = method.getAnnotation(Token.class);
        String value  = Token.value();
        if (value.equals("123")){
            throw new RuntimeException();
        }

    }

}

