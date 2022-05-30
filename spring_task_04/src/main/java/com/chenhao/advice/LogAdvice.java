package com.chenhao.advice;

import com.chenhao.domain.Equipment;
import com.chenhao.domain.Log;
import com.chenhao.mapper.AddLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
//配置切面类
@Aspect
public class LogAdvice {

    @Autowired
    AddLogMapper addLogMapper;

    //添加切点方法
    @Pointcut("execution(void  com.chenhao.service.*Service.*(..))")
    private void logPt(){}

    //添加after通知
    @After("LogAdvice.logPt()")
    public void addLog(JoinPoint jp){

        Object[] args = jp.getArgs();
        String para = "";
        for (int i = 0; i < args.length; i++) {
            if(args[i].getClass().equals(Equipment.class)){
                para = ((Equipment)args[i]).toString();
            }
        }
        Signature signature = jp.getSignature();
        //方法名
        String name = signature.getName();
        //获取接口或类全限定类名
        String declaringTypeName = signature.getDeclaringTypeName();

        Log log = new Log();
        log.setCreated(new Date());
        log.setUsername("admin");
        log.setParams(para);
        log.setOperation(name);
        log.setMethod(declaringTypeName);

        addLogMapper.addlog(log);
    }
}
