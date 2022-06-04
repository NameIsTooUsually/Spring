package com.chenhao.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ChenHao
 * @version 1.0
 * @description: 编写一个通知类，进行通知相关测试
 * @date 2022/6/4 9:35
 */
//通知类必须配置成Spring管理的bean
//@Component
//设置当前类为切面类类  切面 = 切点 + 通知
@Aspect
public class AccountAdvicere {
    //切点表达式
    @Pointcut("execution(* com.chenhao.service.GameService.*(..))")
    public void pt(){}

    //通知方法-环绕通知
    @Around("AccountAdvicere.pt()")
    public Object aroundTest(ProceedingJoinPoint pjp){

        try {

            //获取参数名称
            Object[] args = pjp.getArgs();
            //获取方法签名
            Signature signature = pjp.getSignature();
            //获取所属类名
            String typeName = signature.getDeclaringTypeName();
            //方法名
            String name = signature.getName();
            //开始时间
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                //执行切点程序
                pjp.proceed();
            }
            //开始时间
            long end = System.currentTimeMillis();

            System.out.println("万次执行时间:"+typeName+"."+name+":"+(end-start)+"ms");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
