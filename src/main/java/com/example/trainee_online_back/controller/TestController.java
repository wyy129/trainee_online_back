package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.service.TemperatureService;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.utils.PageUtil;
import com.example.trainee_online_back.utils.RedisCache;
import com.example.trainee_online_back.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc:
 * @author: wyy
 * @date: 2022-06-07 20:10:45
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TemperatureService temperatureService;

    /**
     * @desc: 测试redis的使用
     * @author: wyy
     * @date: 2022-06-07 20:11:12
     **/
    @RequestMapping("/test1")
    public void test1() {
        redisCache.setCacheObject("abc", "abc");
        Object abc = redisCache.getCacheObject("abc");
        System.out.println(abc);
    }

    /**
     * @description: 测试mybatis-plus
     * @author wangyangyang
     * @date: 2022/6/8 14:00
     */
    @RequestMapping("/test2")
    public void test2() {
        User user = new User();
        user.setUsername("a2bc");
        user.setPassword("1234");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    /**
     * @description: 测试接口拦截器，是否没错访问接口都更新redis缓存
     * @author wangyangyang
     * @date: 2022/6/8 14:01
     */
    @RequestMapping("/test3")
    public void test3() {
        System.out.println("进入到test3");
    }

    /**
     * @description: 测试根据角色获取所有学生信息
     * @author wangyangyang
     * @date: 2022/6/9 11:34
     */
    @RequestMapping("/test4")
    public void test4(@RequestBody BaseQueryDto baseQueryDto) {
        Page<User> allStudent = userService.getAllStudent(baseQueryDto);
        JSONObject pageData = PageUtil.getPageData(allStudent);
        System.out.println(pageData);

    }
    /**
     * @description: 测试mybatis-plus逻辑删除
     * @author wangyangyang
     * @date: 2022/6/9 11:53
     */
    @RequestMapping("/test5")
    public void test5() {
        User user = userMapper.selectById(1);
        System.out.println(user);
        userMapper.deleteById(1);
        User user1 = userMapper.selectById(1);
        System.out.println(user1);
    }
    /**
     * @description: 分页查询所有风险学生（，测试一下git，一会删除）
     * @author wangyangyang
     * @date: 2022/6/9 13:42
     * @return
     */
    @RequestMapping("/test6")
    public JSONObject test6(@RequestBody BaseQueryDto baseQueryDto) {
        JSONObject riskStudent = temperatureService.getRiskStudent(baseQueryDto);
        System.out.println(riskStudent);
        return ResponseUtil.returnSuccess("所有风险学生",riskStudent);
    }
}
