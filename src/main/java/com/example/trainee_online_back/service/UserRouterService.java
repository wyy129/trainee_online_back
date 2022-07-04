package com.example.trainee_online_back.service;

import com.alibaba.fastjson.JSONObject;

public interface UserRouterService {

    JSONObject getRouter(Integer role);
}
