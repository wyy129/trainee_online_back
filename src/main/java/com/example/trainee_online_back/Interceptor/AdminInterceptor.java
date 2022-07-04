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
 * @author wangyangyang
 * @description: 对管理员功能模块信息请求拦截
 * @date: 2022/6/21 17:25
 * @return:
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
    @Autowired
    private RedisCache redisCache;

   /**
    * @desc: 管理员接口请求拦截器
    * @author: wyy
    * @date: 2022-06-21 20:54:52
    * @return:  是否放行
    **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String adminId = request.getHeader("adminId");
        String faceCode = request.getHeader("faceCode");

        if (StringUtils.isEmpty(adminId) || StringUtils.isEmpty(faceCode)) {
            throw new BasicInfoException("adminId或faceCode不能为空");
        }
        RequestUtil.adminId.set(Long.valueOf(adminId));
        // 方便测试
        // ------------------
        if ("test".equals(faceCode)) {
            logger.info("测试入参管理员id：" + adminId);
            return true;
        }
        // ----------------------------

        logger.info("入参管理员id：" + adminId);

        return true;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作,如果设置为true时，请求将会继续执行后面的操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (RequestUtil.adminId.get() != null) {
            RequestUtil.adminId.remove();
        }
        logger.info("-返回-");
    }
}
