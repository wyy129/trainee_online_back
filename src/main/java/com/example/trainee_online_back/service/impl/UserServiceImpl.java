package com.example.trainee_online_back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.trainee_online_back.constant.TokenConstants;
import com.example.trainee_online_back.entity.Dto.BaseQueryDto;
import com.example.trainee_online_back.entity.User;
import com.example.trainee_online_back.service.UserService;
import com.example.trainee_online_back.mapper.UserMapper;
import com.example.trainee_online_back.utils.RedisCache;
import com.example.trainee_online_back.utils.RequestUtil;
import com.example.trainee_online_back.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyangyang
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2022-06-08 10:43:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;

    /**
     * @description: 校验用户名和密码，获取token
     * @author wangyangyang
     * @date: 2022/6/9 12:31
     */
    @Override
    public JSONObject login(String username, String password, String uuid) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        userQueryWrapper.eq("password", password);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            return null;
        }
        String userid = user.getId().toString();
        String token = TokenUtil.createToken(userid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("token", token);
//        将token缓存到redis当中
        redisCache.setCacheObject(TokenConstants.USER + userid + TokenConstants.TOKEN, token, 20, TimeUnit.MINUTES);
        return jsonObject;
    }

    /**
     * @description: 根据用户id获取用户信息
     * @author wangyangyang
     * @date: 2022/6/8 13:10
     */
    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        return userMapper.selectOne(userQueryWrapper);

    }

    /**
     * @description: 分页获取所有学生信息
     * @author wangyangyang
     * @date: 2022/6/9 11:22
     */
    @Override
    public Page<User> getAllStudent(BaseQueryDto baseQueryDto) {
        Page<User> userPage = new Page<>(Optional.ofNullable(baseQueryDto.getPage()).orElse(1L), Optional.ofNullable(baseQueryDto.getPageSize()).orElse(20L));
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("role", 1);
        IPage<User> userIPage = userMapper.selectPage(userPage, userQueryWrapper);
        return userPage;
    }

    /**
     * @desc: 用户登出逻辑
     * @author: wyy
     * @date: 2022-06-26 18:08:45
     * @return: 是否登出成功
     **/
    @Override
    public boolean logOut() {
        Long userId = RequestUtil.getTLUserId();
        // 重置当前的token。 不用重置，因为在拦截器中 redis中token失效就不能访问业务了
        // TokenUtil.createToken(String.valueOf(userId));
        // 删除缓存中的token
        return redisCache.deleteObject("user_" + userId + "token");
    }

    /**
     * @desc: 添加用户
     * @author: wyy
     * @date: 2022-06-27 21:38:56
     * @return: 添加条数
     **/
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * @description: 根据用户id删除用户
     * @author wangyangyang
     * @date: 2022/6/28 10:20
     * @return: 删除的数量
     */
    @Override
    public int deleteUserById(Long userId) {
        return userMapper.deleteById(userId);
    }

    /**
     * @desc: 更新用户
     * @author: wyy
     * @date: 2022-06-28 21:19:45
     * @return: 更改的条数
     **/
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

}




