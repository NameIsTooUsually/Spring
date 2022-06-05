package com.chenhao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenhao.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/5 10:24
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {
}
