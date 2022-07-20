package com.example.trainee_online_back.utils;

import com.example.trainee_online_back.exception.BasicInfoException;

/**
 * @author wangyangyang
 * @description: 校验用户信息真实性工具
 * @date: 2022/6/13 15:38
 * @return:
 */
public class VerifyUserUtil {
    /**
     * @description: 校验被操作用户id是否是当前线程变量中用户id
     * @author wangyangyang
     * @date: 2022/6/13 15:39
     * @return: 如果不是则抛出异常
     */
    public static void verifyOperationUser(String userId) {
        if (!userId.equals(RequestUtil.getTLUserId().toString())) {
            throw new BasicInfoException("用户信息错误");
        }

    }
}
