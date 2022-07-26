package com.example.trainee_online_back.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @description: 返回值工具类
 * @author: shiliqiang
 * @company: CTY Technology Co.,Ltd
 * @since: ${DATE} ${TIME}
 * @version: V1.0
 */
public class ResponseUtil {

    private static Logger log = LoggerFactory.getLogger(ResponseUtil.class);

    public static JSONObject returnResult(Integer status, Object obj) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("status", status);
        jsonObj.put("msg", obj);
        return jsonObj;
    }

    public static JSONObject returnSuccess(String message, Object object) {
        JSONObject obj = new JSONObject();
        obj.put("status", 0);
        obj.put("msg", message);
        obj.put("data", object);
        return obj;
    }


    public static JSONObject returnFail(String message, Object object) {
        JSONObject obj = new JSONObject();
        obj.put("status", 1);
        obj.put("msg", message);
        obj.put("data", object);
        return obj;
    }

    public static JSONObject returnFail(String message) {
        JSONObject obj = new JSONObject();
        obj.put("status", 1);
        obj.put("msg", message);
        return obj;
    }


}
