package com.chenhao.log;

import com.chenhao.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Component
public class Log {
    @Autowired
    AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String name1, String name2, Double money){
        String description = name1+"向"+name2+"转账了"+money+"元";
        LocalDateTime now = LocalDateTime.now();
        accountDao.addLog(description,now);
    }
}
