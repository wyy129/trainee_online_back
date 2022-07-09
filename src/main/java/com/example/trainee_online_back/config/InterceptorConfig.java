package com.example.trainee_online_back.config;

import com.example.trainee_online_back.Interceptor.AdminInterceptor;
import com.example.trainee_online_back.Interceptor.UserInfoInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @desc: 拦截器配置
 * @author: wyy
 * @date: 2022-06-07 20:59:28
 **/
@Configuration
@SuppressWarnings("all")
public class InterceptorConfig implements WebMvcConfigurer {


    /**
     * @desc: 通过bean的方式把实例交给容器管理
     * @author: wyy
     * @date: 2022-06-07 20:12:42
     **/
    @Bean
    public UserInfoInterceptor getUserInfoInterceptor() {
        return new UserInfoInterceptor();
    }

    @Bean
    public AdminInterceptor getAdminInterceptor() {
        return new AdminInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加管理员拦截器
        InterceptorRegistration adminInterceptor = registry.addInterceptor(getAdminInterceptor());
        adminInterceptor.addPathPatterns("/admin/**");
        adminInterceptor.excludePathPatterns("/admin/adminlogin");

        // 注册自己的拦截器
        InterceptorRegistration registration = registry.addInterceptor(getUserInfoInterceptor());
//        String excludePathStr = "/common/queryWechatArticle,/serviceStationActivation/getSfUserInfo," +
//                "/common/getCode,/common/isPhoneExisting,/serviceStationActivation/updateSfUserInfo,"
//                + "/serviceStationActivation/verityUserInfo,/serviceStationActivation/setUserInfo,/sf/**,/userUpload";
        String excludePathStr = "/login,/admin/**,/test/**,/userrouter/**";
        // 所有路径都被拦截
        String[] excludePath = excludePathStr.split(",");
        registration.excludePathPatterns(excludePath);
        // 所有路径都被拦截
        registration.addPathPatterns("/**");


        // 添加不拦截路径
        //registration.excludePathPatterns("/contents/getContentsTree","/common/queryWechatArticle");
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").
//                        //allowedOrigins("https://www.dustyblog.cn"). //允许跨域的域名，可以用*表示允许任何域名使用
//                                allowedOriginPatterns("*").
//                        allowedMethods("*"). //允许任何方法（post、get等）
//                        allowedHeaders("*"). //允许任何请求头
//                        allowCredentials(true). //带上cookie信息
//                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
//            }
//        };
//    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
//                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//                        "Access-Control-Request-Headers")
//                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//                .allowCredentials(true).maxAge(3600);
//    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        //*****这里设置了优先级*****
        bean.setOrder(1);
        return bean;
    }

    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 请求常用的三种配置，*代表允许所有，也可以自定义属性（比如 header 只能带什么，只能是 post 方式等）
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        // 建议允许get post option 接口规范
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

}
