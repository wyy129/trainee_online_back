package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.InternshipWork;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wangyangyang
 * @description 针对表【internship_work(周记表)】的数据库操作Service
 * @createDate 2022-06-08 10:43:31
 */
public interface InternshipWorkService extends IService<InternshipWork> {
    /**
     * @description: 添加周记
     * @author wangyangyang
     * @date: 2022/6/13 10:03
     * @return: 添加的条数
     */
    int addInternship(InternshipWork internshipWork);

    /**
     * @description: 根据id删除周记
     * @author wangyangyang
     * @date: 2022/6/13 10:26
     * @return: 删除的条数
     */
    int deleteInternshipById(Integer internshipId);

    /**
     * @description: 根据id更新周记
     * @author wangyangyang
     * @date: 2022/6/13 10:30
     * @return: 更新的条数
     */
    int updateInternshipById(InternshipWork internshipWork);

    /**
     * @description: 根据用户id获取所有周记id
     * @author wangyangyang
     * @date: 2022/6/13 10:41
     * @return: 周记列表
     */
    List<InternshipWork> getAllInternshipByUserId(Integer userid);
}
