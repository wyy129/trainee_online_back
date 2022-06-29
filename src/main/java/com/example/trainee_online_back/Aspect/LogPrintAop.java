package com.example.trainee_online_back.Aspect;

import com.alibaba.fastjson.JSON;
import com.example.trainee_online_back.utils.HttpContextUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @description: 入参以及出参的日志输出
 * @author: wangyangyang
 * @company: Persagy Technology Co.,Ltd
 * @since: 2021年9月1日 下午4:17:17
 * @version: V1.0
 **/
@Aspect
@Component
public class LogPrintAop implements PriorityOrdered {


    private static Logger logger = LoggerFactory.getLogger(LogPrintAop.class);


    @Pointcut("execution(* com.example.trainee_online_back.controller..*.*(..))")
    public void pointcut() {
    }


    /**
     * 注：这个方法不要捕获异常，异常转交给异常处理器来执行
     *
     * @param pjp
     * @throws Throwable
     * @description:
     * @author: wang ying
     * @company: Persagy Technology Co.,Ltd
     * @since: 2021年9月1日 下午4:26:24
     * @version: V1.0
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = 0;
        Object result = null;
        Throwable ex = null;
        try {

            try {
                startTime = System.currentTimeMillis();
                result = pjp.proceed();
                return result;
            } catch (Throwable e) {
                ex = e;
                throw e;
            }

        } finally {
            try {
                Object[] args = pjp.getArgs();
                // 限制所有Controller层第一个参数为业务对象
                Object obj = ArrayUtils.isEmpty(args) ? null : args[0];
                logPrint(System.currentTimeMillis() - startTime, obj, result, ex);
            } catch (Throwable e) {
                logger.error("入参、出参日志输出异常", e);
            }
        }

    }


    private void logPrint(long runTime, Object obj, Object result, Throwable e) throws Exception {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

        StringBuilder sb = new StringBuilder("\t\n接口名称：" + request.getRequestURI());
        if ("GET".equals(request.getMethod().toUpperCase())) {
            sb.append("\t\n请求参数：" + getGetParameters(request));
            sb.append("\t\n请求方式：" + "Get");
        } else {
            if (!(obj instanceof HttpServletRequest || obj instanceof HttpServletResponse)) {
                sb.append("\t\n请求参数：" + JSON.toJSONString(obj));
            } else {
                sb.append("\t\n请求参数：");
            }

            sb.append("\t\n请求方式：" + "Post");
        }
        sb.append("\t\n响应结果：" + JSON.toJSONString(result));
        sb.append("\t\n响应异常结果：" + (Objects.isNull(e) ? "" : e.getMessage()));
        sb.append("\t\n响应时间：" + runTime + "\t\n");

        logger.info(sb.toString());
    }


    public static String getGetParameters(HttpServletRequest request) throws Exception {

        StringBuilder sb = new StringBuilder();

        Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames != null) {
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);

                sb.append(name);
                sb.append("=");
                sb.append(value);
                sb.append("  ");
            }
        }

        return sb.toString();
    }


    @Override
    public int getOrder() {

        return Ordered.HIGHEST_PRECEDENCE;
    }


}
