package com.chenhao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenhao.dao.AccountDao;
import com.chenhao.domain.Account;
import com.chenhao.domain.query.AccountQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
    AccountDao accountDao;

    @Test
    void contextLoads() {
        List<Account> accounts = accountDao.selectList(null);
        System.out.println(accounts);
    }
    /*@Test
    public void testSave(){
        Account account = new Account(null,"悟空",12000d);
        accountDao.insert(account);
    }
*/
    @Test
    public void deleteById(){
        int i = accountDao.deleteById(1533281144417538049l);
    }

    /*@Test
    public void update(){
        Account account = new Account(1533283878944358402l,"ss狗",null);

        int i = accountDao.updateById(account);
    }*/

    //分页查询
    @Test
    public void selectByPage(){
        Page page = new Page(3,2);

        IPage<Account> pages = accountDao.selectPage(page,null);

        List<Account> records = pages.getRecords();
        System.out.println("数据是 = " + records);
    }
    //按条件查询
    @Test
    public void selectByCondition(){
//        //第二种方式查询
//        QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
//        queryWrapper.lambda().lt(Account::getMoney,10000);
//        List<Account> accounts = accountDao.selectList(queryWrapper);
//        System.out.println("accounts = " + accounts);
        //第三种方式查询
        LambdaQueryWrapper<Account> qw = new LambdaQueryWrapper<>();
        qw.lt(Account::getMoney,10000).or().gt(Account::getMoney,100000);

        List<Account> accounts = accountDao.selectList(qw);
        System.out.println("accounts = " + accounts);

    }

    @Test
    public void query(){
        LambdaQueryWrapper<Account> qw = new LambdaQueryWrapper<>();
        qw.select(Account::getId,Account::getUsername);

        List<Account> accounts = accountDao.selectList(qw);
        System.out.println(accounts);

    }

    @Test
    public void queryCondition(){
//        AccountQuery aq = new AccountQuery();
//        aq.setMoney2(500000d);
//
//        LambdaQueryWrapper<Account> qw = new LambdaQueryWrapper<>();
//
//        qw.lt(null!=aq.getMoney2(),Account::getMoney,aq.getMoney2())
//          .gt(null!=aq.getMoney(),Account::getMoney,aq.getMoney());
//
//        List<Account> accounts = accountDao.selectList(qw);
//        System.out.println(accounts);
        QueryWrapper<Account> qw = new QueryWrapper<>();
        qw.select("count(*) as count");
        List<Map<String, Object>> maps = accountDao.selectMaps(qw);
        System.out.println("maps = " + maps);
    }




}
