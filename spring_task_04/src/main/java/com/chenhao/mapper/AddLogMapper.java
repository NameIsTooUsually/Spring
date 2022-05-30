package com.chenhao.mapper;


import com.chenhao.domain.Log;
import org.apache.ibatis.annotations.Insert;

public interface AddLogMapper {
    //添加日志
    @Insert("insert into sys_log values(null,#{username},#{operation},#{method},#{params},#{created})")
    void addlog(Log log);
}
