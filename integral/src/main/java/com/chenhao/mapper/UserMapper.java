package com.chenhao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhao.domain.User;
import com.chenhao.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserVo> findByClassId(Integer classId);

    @Update("update user set integral = integral+#{integral} where id = #{id}")
    int addIntegral(User user);

    @Update("update user set integral=0 where class_id = #{classId}")
    int resetGScoreByGroupId(Integer classId );
}
