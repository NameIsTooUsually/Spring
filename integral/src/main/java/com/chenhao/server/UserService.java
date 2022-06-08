package com.chenhao.server;

import com.chenhao.domain.LoginDto;
import com.chenhao.domain.User;
import com.chenhao.domain.UserVo;

import java.util.List;


public interface UserService {
    User isTeacher(String mobile);


    User longin(LoginDto loginDto);

    List<UserVo> findByClassId(Integer classId);

    boolean addIntegral(User user);

    boolean resetGScoreByGroupId(Integer classId);
}
