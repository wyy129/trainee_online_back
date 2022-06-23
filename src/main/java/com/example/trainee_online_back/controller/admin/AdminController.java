package com.example.trainee_online_back.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.example.trainee_online_back.entity.AdminUser;
import com.example.trainee_online_back.exception.ParameterException;
import com.example.trainee_online_back.service.AdminUserService;
import com.example.trainee_online_back.utils.ResponseUtil;
import com.example.trainee_online_back.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyangyang
 * @description: 管理员控制器
 * @date: 2022/6/21 16:52
 * @return:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * @description: 管理员登录
     * @author wangyangyang
     * @date: 2022/6/21 16:54
     * @return:
     */
    @RequestMapping("/adminlogin")
    public JSONObject adminLogin(@RequestBody AdminUser loginAdmin) {
        String adminUsername = loginAdmin.getAdminUsername();
        String adminPassword = loginAdmin.getAdminPassword();
        if (StringUtils.isEmpty(adminUsername) || StringUtils.isEmpty(adminPassword)) {
            throw new ParameterException("参数有误");
        }
        AdminUser adminUser = adminUserService.adminLogin(adminUsername, adminPassword);
        if (adminUser == null) {
            return ResponseUtil.returnFail("登录失败，未找到用户", loginAdmin);
        }
        // -------------------获取人脸信息逻辑，根据获取人脸信息后保存为AdminToken，根据这个访问业务


        //-----------------------------------------------------------------------------

        return null;
    }

    @RequestMapping("/test")
    public void test() {
        System.out.println("管理员测试");
    }
}
