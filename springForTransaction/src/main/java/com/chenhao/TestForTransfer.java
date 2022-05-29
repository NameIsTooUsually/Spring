package com.chenhao;


import com.chenhao.config.SpringConfig;
import com.chenhao.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestForTransfer {
    @Autowired
    AccountService accountService;
    @Test
    public void test1(){
        accountService.transfer("张三","李四",100D);
    }
}
