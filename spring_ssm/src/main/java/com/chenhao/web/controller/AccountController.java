package com.chenhao.web.controller;

import com.chenhao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/4 19:32
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    //
    @PutMapping
    public Result transferMoney(String origin,String target,Integer money){
        boolean flag = accountService.transferMoney(origin, target, money);
        Integer code = flag?Code.UPDATE_OK:Code.UPDATE_ERR;
        String str = flag?"成功":"失败";
        return new Result(code,flag,str);

    }
}
