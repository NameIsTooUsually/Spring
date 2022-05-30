package com.chenhao.advice;

import com.chenhao.domain.Equipment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

//创建一个通知类，并设置为组件
@Component
@Aspect
public class TimeAdvice {

    //创建切点表达式
    @Pointcut("execution(* com.chenhao.service.*Service.*(..))")
    private void timePt(){}

    //创建环绕通知
    @Around("TimeAdvice.timePt()")
    public Object creatTime(ProceedingJoinPoint pjp) throws Throwable {
        //获取切点参数
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if(args[i].getClass().equals(Equipment.class)){
                //说明该参数是需要添加时间的参数,将其向下转型值目标类型
                //添加时间参数
                Equipment temp = (Equipment)args[i];
                temp.setCreated(new Date());
                temp.setUpdated(new Date());
                //再赋值给切点参数
                args[i] = temp;
            }
        }
        //执行切点方法,并给添加时间的参数
        Object proceed = pjp.proceed(args);
        return proceed;
    }


}
