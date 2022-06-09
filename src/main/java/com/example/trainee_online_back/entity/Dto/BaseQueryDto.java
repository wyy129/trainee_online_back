package com.example.trainee_online_back.entity.Dto;

import lombok.Data;

/**
 * @description: 基接受分页参数DTO
 * @author wangyangyang
 * @date: 2022/6/9 11:28
 */
@Data
public class BaseQueryDto {

    /**
     * page
     */
    private Long page;

    /**
     * pageSize
     */
    private Long pageSize;

//    /**
//     * userId
//     */
//    private Long userId;
}
