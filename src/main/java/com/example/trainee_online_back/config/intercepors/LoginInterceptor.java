//package com.example.trainee_online_back.config.intercepors;
//
//import com.alibaba.fastjson2.JSONObject;
//import com.example.trainee_online_back.utils.JsonResult;
//import com.example.trainee_online_back.utils.JwtUtils;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.BufferedReader;
//import java.io.IOException;
//
///**
// * @author wyy
// * 拦截器配置
// */
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        放行option
//        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
//            return true;
//        }
//        String token = request.getHeader("token");
//        String studentId = request.getHeader("studentId");
//        System.out.println(token + "----" + studentId);
//        boolean b = JwtUtils.verifyToken(token, studentId);
//        System.out.println(b);
//        if (!b) {
//            System.out.println("没有放行");
//            response.setStatus(401);
//            return false;
//        } else {
//            //放行，用户即可继续调用自己需要的接口
//            return true;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }
//}