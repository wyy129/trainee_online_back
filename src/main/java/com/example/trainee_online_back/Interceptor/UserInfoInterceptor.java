package com.example.trainee_online_back.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.trainee_online_back.exception.BasicInfoException;
import com.example.trainee_online_back.utils.RequestUtil;
import com.example.trainee_online_back.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @description: 对用户数据进行处理
 * @author: shiliqiang
 * @company: CTY Technology Co.,Ltd
 * @since: 2021/8/24 13:46
 * @version: V1.0
 */
@Component
public class UserInfoInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(UserInfoInterceptor.class);


    /**
     * @description: 在请求处理之前进行调用（Controller方法调用之前）
     * @param:
     * @return:
     * @exception:
     * @author: shiliqiang
     * @company: CTY Technology Co.,Ltd
     * @since: 2021/8/24 13:50
     * @version: V1.0
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userid = request.getHeader("userid");
        String token = request.getHeader("token");

        if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(token)) {
            throw new BasicInfoException("userid或token不能为空");
        }
        RequestUtil.userInfo.set(Long.valueOf(userid));
        TokenUtil.verifyToken(token,userid);
//        tokenrecordTService.checkToken(token, userid);
        logger.info("入参：" + userid);

        return true;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作,如果设置为true时，请求将会继续执行后面的操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (RequestUtil.userInfo.get() != null) {
            RequestUtil.userInfo.remove();
        }
        logger.info("-返回-");
    }
}
