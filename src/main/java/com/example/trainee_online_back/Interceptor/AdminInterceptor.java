package com.example.trainee_online_back.Interceptor;

import com.example.trainee_online_back.exception.BasicInfoException;
import com.example.trainee_online_back.utils.RedisCache;
import com.example.trainee_online_back.utils.RequestUtil;
import com.example.trainee_online_back.utils.StringUtils;
import com.example.trainee_online_back.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


/**
 * @description: 对管理员功能模块信息请求拦截
 * @author wangyangyang
 * @date: 2022/6/21 17:25
 * @return:
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
    @Autowired
    private RedisCache redisCache;

    /**
     * @description: 请求拦截器
     * @author wangyangyang
     * @date: 2022/6/16 8:58
     * @return:
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userid = request.getHeader("userid");
        String role = request.getHeader("role");
        String token = request.getHeader("token");

        if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(token) || StringUtils.isEmpty(role)) {
            throw new BasicInfoException("userid或token或role不能为空");
        }
        RequestUtil.userId.set(Long.valueOf(userid));
        RequestUtil.userRole.set(Long.valueOf(role));
        // 方便测试
        // ------------------
        if ("test".equals(token)) {
            logger.info("测试入参用户id：" + userid);
            return true;
        }
        // ----------------------------
        TokenUtil.verifyToken(token, userid);
        Object cachetoken = redisCache.getCacheObject("user_" + userid + "token");
        if (cachetoken != null) {

            redisCache.expire("user_" + userid + "token", 20, TimeUnit.MINUTES);
        } else {
            throw new BasicInfoException("token失效");
        }
        logger.info("入参用户id：" + userid);

        return true;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作,如果设置为true时，请求将会继续执行后面的操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//         System.out.println("执行了TestInterceptor的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (RequestUtil.userId.get() != null) {
            RequestUtil.userId.remove();
        }
        if (RequestUtil.userRole.get() != null) {
            RequestUtil.userRole.remove();
        }
        logger.info("-返回-");
    }
}