package com.example.trainee_online_back.entity.Dto;

import lombok.Data;

/**
 * @author wangyangyang
 * @description: 根据条件查询毕设信息传输类
 * @date: 2022/6/13 9:05
 * @return:
 */
@Data
public class GetProjectDTO extends BaseQueryDto {
    /**
     * @description: 专业id
     * @author wangyangyang
     * @date: 2022/6/13 9:05
     * @return:
     */
    private Integer majorId;

}
