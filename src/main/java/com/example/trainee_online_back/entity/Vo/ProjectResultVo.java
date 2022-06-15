package com.example.trainee_online_back.entity.Vo;

import lombok.Data;

/**
 * @author wangyangyang
 * @description: 毕设结果返回实体类
 * @date: 2022/6/15 11:06
 * @return:
 */
@Data
public class ProjectResultVo {
    /**
     * @description: 毕设结果id
     * @author wangyangyang
     * @date: 2022/6/15 11:09
     * @return:
     */
    private String projectResultId;
    /**
     * @description: 用户id
     * @author wangyangyang
     * @date: 2022/6/15 11:09
     * @return:
     */
    private String userId;
    /**
     * @description: 毕设信息id
     * @author wangyangyang
     * @date: 2022/6/15 11:09
     * @return:
     */
    private String projectInfoId;
    /**
     * @description: 毕设信息名称
     * @author wangyangyang
     * @date: 2022/6/15 11:09
     * @return:
     */
    private String projectName;
    /**
     * @description: 毕设信息描述
     * @author wangyangyang
     * @date: 2022/6/15 11:10
     * @return:
     */
    private String projectContent;
    /**
     * @description: 毕设信息 所属专业id
     * @author wangyangyang
     * @date: 2022/6/15 11:10
     * @return:
     */
    private String majorId;
    /**
     * @description: 前期内容
     * @author wangyangyang
     * @date: 2022/6/15 11:10
     * @return:
     */
    private String early;
    /**
     * @description: 前期导师回复
     * @author wangyangyang
     * @date: 2022/6/15 11:10
     * @return:
     */
    private String earlyTeacher;
    /**
     * @description: 中期内容
     * @author wangyangyang
     * @date: 2022/6/15 11:10
     * @return:
     */
    private String metaphase;
    /**
     * @description: 中期导师回复
     * @author wangyangyang
     * @date: 2022/6/15 11:11
     * @return:
     */
    private String metaphaseTeacher;
    /**
     * @description: 后期内容
     * @author wangyangyang
     * @date: 2022/6/15 11:11
     * @return:
     */
    private String last;
    /**
     * @description: 后期导师回复
     * @author wangyangyang
     * @date: 2022/6/15 11:11
     * @return:
     */
    private String lastTeacher;
    /**
     * @description: 修改次数
     * @author wangyangyang
     * @date: 2022/6/15 11:11
     * @return:
     */
    private String revise;
}
