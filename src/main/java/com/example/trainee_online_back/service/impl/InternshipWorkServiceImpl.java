package com.example.trainee_online_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.entity.InternshipWork;
import com.example.trainee_online_back.service.InternshipWorkService;
import com.example.trainee_online_back.mapper.InternshipWorkMapper;
import com.example.trainee_online_back.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @description: 根据id删除周记
     * @author wangyangyang
     * @date: 2022/6/13 10:26
     * @return: 删除的条数
     */
    @Override
    public int deleteInternshipById(Integer internshipId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", RequestUtil.getTLUserId());
        queryWrapper.eq("work_id", internshipId);
        return internshipWorkMapper.delete(queryWrapper);
    }

    /**
     * @description: 根据id更新周记
     * @author wangyangyang
     * @date: 2022/6/13 10:30
     * @return: 更新的条数
     */
    @Override
    public int updateInternshipById(InternshipWork internshipWork) {
        Integer workId = internshipWork.getWorkId();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("work_id", workId);
        return internshipWorkMapper.update(internshipWork, queryWrapper);
    }

    /**
     * @description: 根据用户id获取所有周记id
     * @author wangyangyang
     * @date: 2022/6/13 10:41
     * @return: 周记列表
     */
    @Override
    public List<InternshipWork> getAllInternshipByUserId(Integer userid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userid);
        return internshipWorkMapper.selectList(queryWrapper);
    }

}




