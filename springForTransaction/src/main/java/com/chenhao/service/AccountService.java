package com.chenhao.service;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    //从xxx账户转钱到YYY账户
    @Transactional
    void transfer(String name1,String name2,Double money);
}
