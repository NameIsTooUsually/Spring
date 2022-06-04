package com.chenhao.service;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    //配置当前接口方法具有事务
    @Transactional  // 和 @EnableTransactionManagement 成对出现
    public boolean transferMoney(String origin,String target,Integer money);
}
