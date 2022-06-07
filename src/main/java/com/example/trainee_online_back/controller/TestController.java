package com.example.trainee_online_back.controller;

import com.aliyun.teautil.models.RuntimeOptions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.trainee_online_back.mapper.Test1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import com.aliyun.tea.*;
import com.aliyun.dyvmsapi20170525.*;
import com.aliyun.dyvmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;
/**
 * @desc:
 * @author: wyy
 * @date: 2022-06-03 12:02:16
 * @param: null
 * @return: null
 **/
@RequestMapping("/test")
@RestController
public class TestController {
    @Autowired
    private Test1Mapper test1Mapper;

    @RequestMapping("/deletebyname")
    public List deleteByname(@RequestBody Map map) {

        String name = map.get("name").toString();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", name);
        List list = test1Mapper.selectList(queryWrapper);
        System.out.println(list.get(0));
        System.out.println("____________________");
        int i = test1Mapper.deleteByMap(map);
        System.out.println(i);
        return list;
    }

    public static com.aliyun.dyvmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dyvmsapi.aliyuncs.com";
        return new com.aliyun.dyvmsapi20170525.Client(config);
    }

    @RequestMapping("/test")
    public void test() {

        com.aliyun.dyvmsapi20170525.Client client = null;
        try {
            client = TestController.createClient("LTAIBnCX5wTd2Onc", "zlbCzSH6nBIbO2pn32ii2pIrzeGFSQ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SingleCallByTtsRequest singleCallByTtsRequest = new SingleCallByTtsRequest()
                .setCalledNumber("18132108980")
                .setTtsCode("TTS_242708403")
                .setTtsParam("{\"alarm_type\":\"黑名单告警\"}");
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            SingleCallByTtsResponse singleCallByTtsResponse = client.singleCallByTtsWithOptions(singleCallByTtsRequest, runtime);
            System.out.println("查看响应");
            System.out.println(singleCallByTtsResponse);
            System.out.println(singleCallByTtsResponse.getBody());
            System.out.println(singleCallByTtsResponse.getBody().getCode());
            System.out.println(singleCallByTtsResponse.getBody().getMessage());
            System.out.println(singleCallByTtsResponse.getHeaders());
        } catch (TeaException error) {
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        }

    }


}
