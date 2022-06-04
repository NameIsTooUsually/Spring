package com.chenhao.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 15:02
 */
public interface AccountDao {
    //增加账户的金额
    @Update("update account set money = money-#{money} where username = #{name}")
    Integer addMoney(@Param("name") String name,@Param("money") Integer money);

    //减少账户的金额
    @Update("update account set money = money+#{money} where username = #{name}")
    Integer minusMoney(@Param("name") String name,@Param("money") Integer money);
}
