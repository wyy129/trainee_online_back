package com.example.trainee_online_back.controller;


import com.alibaba.fastjson2.JSONObject;
import com.example.trainee_online_back.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户控制层
 *
 * @author wyy
 */
@RestController
@RequestMapping("/user")
public class UserController {
    JsonResult jsonResult = new JsonResult();

    @RequestMapping("/login")
    public JsonResult login(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        return jsonResult.success(jsonObject);
    }
}
