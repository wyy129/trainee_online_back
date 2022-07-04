package com.example.trainee_online_back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.Dto.GetProjectDTO;
import com.example.trainee_online_back.entity.InternshipWork;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.mapper.InternshipWorkMapper;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.service.ProjectInfoService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProjectInfoService projectInfoService;
    @Autowired
    private InternshipWorkMapper internshipWorkMapper;

    private static int number = 0;

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
     * @return
     * @description: 分页查询所有风险学生
     * @author wangyangyang
     * @date: 2022/6/9 13:42
     */
    @RequestMapping("/test6")
    public JSONObject test6(@RequestBody BaseQueryDto baseQueryDto) {
        JSONObject riskStudent = temperatureService.getRiskStudent(baseQueryDto);
        System.out.println(riskStudent);
        return ResponseUtil.returnSuccess("所有风险学生", riskStudent);
    }

    /**
     * @return
     * @description: 分页根据条件查询毕设信息
     * @author wangyangyang
     * @date: 2022/6/9 13:42
     */
    @RequestMapping("/test7")
    public JSONObject test7(@RequestBody GetProjectDTO getProjectDTOo) {
        JSONObject project = projectInfoService.getProject(getProjectDTOo);
        System.out.println(project);
        return ResponseUtil.returnSuccess("信息", project);
    }

    /**
     * @description: 测试时间格式
     * @author wangyangyang
     * @date: 2022/6/13 13:39
     * @return:
     */
    @RequestMapping("/test8")
    public JSONObject test8() {
        logger.info("这是测试log");
        List<InternshipWork> internshipWorks = internshipWorkMapper.selectList(null);
        System.out.println(internshipWorks);
        return ResponseUtil.returnSuccess("", internshipWorks);
    }

    /**
     * @description: 测试HttpSeverlet
     * @author wangyangyang
     * @date: 2022/6/15 15:49
     * @return:
     */
    @RequestMapping("/test9")
    public JSONObject test9(@RequestBody Map map, HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest);
        return ResponseUtil.returnSuccess("test9", httpServletRequest);
    }

    /**
     * @description: ThreadLocal内存泄漏测试
     * @author wangyangyang
     * @date: 2022/6/17 10:44
     * @return:
     */
    @RequestMapping("/test10")
    public void test10() {
        for (int i = 0; i < 100; i++) {
            ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
            String rsult = String.valueOf(i);
            stringThreadLocal.set(rsult);
            System.out.println(stringThreadLocal);
        }
    }

    /**
     * @desc: 研究并发
     * @author: wyy
     * @date: 2022-06-30 21:33:19
     * @return:
     **/
    @RequestMapping("/test11")
    public void test11() {
        int i = number++;
        System.out.println(i+"_________________");
    }
}
