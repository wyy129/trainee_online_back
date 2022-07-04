package com.example.trainee_online_back.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;

/** 
 * @description: mybatis分页处理
 * @author wangyangyang 
 * @date: 2022/6/9 11:43
 */
public class PageUtil {

    /**
     * @description: 对Ipage分页返回的数据统一处理
     * @author wangyangyang
     * @date: 2022/6/9 11:43
     */
    public static<T> JSONObject getPageData(IPage<T> page) {
        JSONObject obj = new JSONObject();
        obj.put("list", page.getRecords());
        obj.put("total", page.getTotal());
        obj.put("pages", page.getPages());
        return obj;
    }
}
