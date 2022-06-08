package com.example.trainee_online_back.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.trainee_online_back.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createdBy", String.class, userid);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String userid = RequestUtil.getTLUserId().toString();
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateBy", String.class, userid);

    }
}