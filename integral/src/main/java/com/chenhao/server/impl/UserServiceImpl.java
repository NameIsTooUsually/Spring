package com.chenhao.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chenhao.domain.LoginDto;
import com.chenhao.domain.User;
import com.chenhao.domain.UserVo;
import com.chenhao.mapper.UserMapper;
import com.chenhao.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 12:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User isTeacher(String mobile) {
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.eq(User::getMobile, mobile);
        User user = userMapper.selectOne(qw);
        return user;

    }

    @Override
    public User longin(LoginDto loginDto) {
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.eq(User::getMobile,loginDto.getName()).eq(User::getPassword,loginDto.getPassword());
        User user = userMapper.selectOne(qw);
        return user;
    }

    @Override
    public List<UserVo> findByClassId(Integer classId) {
        List<UserVo> list =  userMapper.findByClassId(classId);
        return list;
    }

    @Override
    public boolean addIntegral(User user) {
        int flag = userMapper.addIntegral(user);
        return flag>0;
    }


}
