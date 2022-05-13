package com.example.trainee_online_back.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lehr
 * @create: 2020-02-04
 */
public class JwtUtils {

    /**
     * 签发对象：用户-字符串形式
     * 签发时间：现在
     * 有效时间：24小时
     * 载荷内容：
     * 加密密钥：这个人的id加上jwt
     */
    public static String createToken(String userId) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 24);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(userId + "jwt"));
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户-字符串形式
     *
     * @param token
     * @throws
     */
    public static boolean verifyToken(String token, String user) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user + "jwt")).build();
            jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
            //效验失败
            //这里抛出的异常是我自定义的一个异常，你也可以写成别的
        }
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
        }
        return audience;
    }
}

