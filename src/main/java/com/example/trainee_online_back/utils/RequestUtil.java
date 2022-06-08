package com.example.trainee_online_back.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @description: 处理请求数据工具
 * @author: shiliqiang
 * @company: CTY Technology Co.,Ltd
 * @since: 2021/8/24 11:21
 * @version: V1.0
 */
public class RequestUtil {
    private static Logger log = LoggerFactory.getLogger(RequestUtil.class);

    private static final String CHARSET = "UTF-8";
    private static final String IV_STRING = "Cty-china-ER-app";

    /**
     *本地userid
     */
    public static final ThreadLocal<Long> userId = new ThreadLocal<>();
    public static final ThreadLocal<Long> userRole = new ThreadLocal<>();

    /**
     * @description: 获取userid
     * @param:
     * @return:
     * @exception:
     * @author: shiliqiang
     * @company: CTY Technology Co.,Ltd
     * @since: 2021/8/24 11:17
     * @version: V1.0
     */
    public static String getUserId(HttpHeaders headers) {
        String userid = headers.getFirst("userid");
        return userid;
    }

    /**
     * @description: userInfo.get()封装，避免重复判断返回结果null的情况
      * @param: null
     * @return:
     * @exception:
     * @author: wunan
     * @company: Pactera Technology Co.,Ltd
     * @since: 2021/9/17 14:09
     * @version: V1.0
     */
    public static Long getTLUserId(){
        Assert.notNull(userId.get(),"请登录系统");
        return userId.get();
    }

    public static Long getTLUserRole(){
        Assert.notNull(userRole.get(),"请登录系统");
        return userRole.get();
    }

    /**
     * 加密ID
     * @param content
     * @return
     */
    public static String decryptString(String content){
        try{
            byte[] decryptFrom = parseHexStr2Byte(content);
            byte[] decryptResult = decrypt(decryptFrom, "L03-Cumminschine");
            return new String(decryptResult,CHARSET);

//			Decoder decoder = Base64.getDecoder();
//			byte[] decryptFrom = decoder.decode(content);
//			byte[] decryptResult = decrypt(decryptFrom, "16BytesLengthKey");
//			return new String(decryptResult,charset);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        }
        return null;
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 解密
     *
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
//			 //防止linux下 随机生成key
//			KeyGenerator kgen = KeyGenerator.getInstance("AES");
//            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
//            secureRandom.setSeed(password.getBytes());
//			// 根据密钥初始化密钥生成器
//			kgen.init(128, secureRandom);
//			SecretKey secretKey = kgen.generateKey();
//			byte[] enCodeFormat = secretKey.getEncoded();
//			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
//			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
//			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
//			byte[] result = cipher.doFinal(content);


            byte[] enCodeFormat = password.getBytes(CHARSET);
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes(CHARSET);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(content);

            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
