package com.example.trainee_online_back.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wyy
 * 封装结果类
 */
@Data
public class JsonResult implements Serializable {
    private Integer status;

    private String msg;

    private Object data;

    public JsonResult() {
    }

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult success(Object data) {
        JsonResult result = new JsonResult(1, "成功", null);
        result.setData(data);
        return result;
    }

    public JsonResult error(Object data) {
        JsonResult result = new JsonResult(0, "失败", null);
        result.setData(data);
        return result;
    }
}
