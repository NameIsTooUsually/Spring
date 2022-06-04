package com.chenhao.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.chenhao.dao.AccountDao;
import com.chenhao.service.AccountService;
import com.chenhao.web.controller.Code;
import com.chenhao.web.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 15:20
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public boolean transferMoney(String origin, String target, Integer money) {
        boolean flag = false;
        //源账户减少钱
        Integer money1 = accountDao.minusMoney(origin, money);

        if(true){
            throw  new SystemException(50001,"系统蹦了");
        }
        //目标账户增加钱
        Integer money2 = accountDao.addMoney(target, money);
        flag = true;
        return true;
    }
}
