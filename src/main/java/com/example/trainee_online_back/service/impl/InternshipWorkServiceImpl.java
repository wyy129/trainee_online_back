package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.InternshipWork;
import com.example.trainee_online_back.service.InternshipWorkService;
import com.example.trainee_online_back.mapper.InternshipWorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyangyang
 * @description 针对表【internship_work(周记表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class InternshipWorkServiceImpl extends ServiceImpl<InternshipWorkMapper, InternshipWork>
        implements InternshipWorkService {
    @Autowired
    private InternshipWorkMapper internshipWorkMapper;

    /**
     * @description: 添加周记
     * @author wangyangyang
     * @date: 2022/6/13 10:03
     * @return: 添加的条数
     */
    @Override
    public int addInternship(InternshipWork internshipWork) {

        return internshipWorkMapper.insert(internshipWork);
    }
}




