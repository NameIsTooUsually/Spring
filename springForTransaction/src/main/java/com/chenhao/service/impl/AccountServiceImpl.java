package com.chenhao.service.impl;

import com.chenhao.dao.AccountDao;
import com.chenhao.log.Log;
import com.chenhao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    Log log;

    public void transfer(String name1, String name2, Double money) {
            //name1账户向name2账户转账Money
        try {
            minus(name1,money);
            int i = 1/0;
            add(name2,money);
        } finally {
            log.log(name1,name2,money);
        }

    }


    public void add( String name, Double money){
        Double money1 = accountDao.getMoney(name);
        money = money1+money;
        accountDao.updateAccoutn(name,money);
    }

    public void minus( String name, Double money){
        Double money1 = accountDao.getMoney(name);
        money = money1-money;
        accountDao.updateAccoutn(name,money);
    }



}
