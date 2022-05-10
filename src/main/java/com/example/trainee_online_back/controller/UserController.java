package com.example.trainee_online_back.controller;


import com.alibaba.fastjson2.JSONObject;
import com.example.trainee_online_back.entity.Student;
import com.example.trainee_online_back.mapper.StudentMapper;
import com.example.trainee_online_back.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/login")
    public JsonResult login(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        Student student = studentMapper.selectById(1);
        System.out.println(student);
        return jsonResult.success(student);
    }
}
