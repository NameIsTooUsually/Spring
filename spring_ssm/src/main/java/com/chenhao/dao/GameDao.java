package com.chenhao.dao;

import com.chenhao.domain.Game;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameDao {
    /**
     * @description:  通过id进行查询
     * @param:
     * @return:
     * @author ChenHao
     * @date: 2022/6/4 10:42
     */
    @Select("select * from tb_game where id = #{id}")
    public Game findById(@Param("id") Integer id);

}
