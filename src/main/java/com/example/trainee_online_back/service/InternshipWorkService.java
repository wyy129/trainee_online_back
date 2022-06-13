package com.example.trainee_online_back.service;

import com.example.trainee_online_back.entity.InternshipWork;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
