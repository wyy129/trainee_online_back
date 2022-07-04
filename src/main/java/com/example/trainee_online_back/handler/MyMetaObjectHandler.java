package com.example.trainee_online_back.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.trainee_online_back.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


/**
 * @author wangyangyang
 * @description: mybatis-plus新增和修改前，对公共字段进行处理
 * @date: 2022/6/8 10:53
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        String userid = RequestUtil.getTLUserId().toString();
        this.strictInsertFill(metaObject, "createdTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "temperatureCreadetime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createdBy", String.class, userid);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String userid = RequestUtil.getTLUserId().toString();
        this.strictUpdateFill(metaObject, "updatedTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updatedBy", String.class, userid);

    }
}