package com.chenhao.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AccountDao {
    //根据姓名更新账户
    @Update("update account set money =#{money} where username =#{name}")
    void updateAccoutn(@Param("name") String name, @Param("money") Double money);
    //根据姓名减钱

    //获取当前账户的钱
    @Select("select money from account where username = #{name}")
    Double getMoney(String name);

    //添加日志
    @Insert("insert into log values(null,#{description},#{creatTime})")
    void addLog(@Param("description") String description, @Param("creatTime") LocalDateTime creatTime);
}
