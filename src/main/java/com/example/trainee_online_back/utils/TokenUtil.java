
package com.example.trainee_online_back.utils;

import java.util.Date;
import java.util.Objects;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import com.example.trainee_online_back.exception.BasicInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @description: 创建和验证token
 * @author: shiliqiang
 * @company: CTY Technology Co.,Ltd
 * @since: 2021/9/28 9:20
 * @version: V1.0
 */
public class TokenUtil {


    /**
     * 过期时间一天
     * 单位为秒
     */
    private static final long EXPIRATION = 3600;
    private static final String USER_TOKEN = "user_token-";


    /**
     * @description: 创建token
     * @author wangyangyang
     * @date: 2022/6/7 13:27
     */
    public static String createToken(String userId) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000 * 24);
        String token = JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256("waimou" + userId));
        return token;
    }

    /**
     * @description: 校验token
     * @author wangyangyang
     * @date: 2022/6/7 14:52
     */
    public static void verifyToken(String token, String userid) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("waimou" + userid)).build();
            verifier.verify(token);
        } catch (Exception e) {
            //效验失败
            //这里抛出的异常是我自定义的一个异常，你也可以写成别的
            throw new BasicInfoException("token无效");
        }
    }


}
