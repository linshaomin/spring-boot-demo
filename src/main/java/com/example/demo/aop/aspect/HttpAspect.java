package com.example.demo.aop.aspect;

import com.example.demo.exception.domain.Result;
import com.example.demo.exception.handler.ExceptionHandle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shaomin.lin
 * @Description:
 * @date 2018/10/17 15:46
 */
@Aspect
@Component
public class HttpAspect {

    //使用org.slf4j.Logger,这是Spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    /**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
//    @Pointcut("execution(public * com.example.demo.aop.controller.AopTestController.aopTest())")
    @Pointcut("execution(* com.example.demo..controller.*.*(..))")
    public void log(){}

    /**
     * 记录HTTP请求开始时的日志
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class={} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //参数
        logger.info("参数={}",joinPoint.getArgs());
    }

    /**
     * HTTP请求异常处理
     */
    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }
        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    /**
     * 记录HTTP请求结束时的日志
     */
    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution", request.getRequestURL());
    }

    /**
     * 获取返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        if(object != null) {
            logger.info("response={}",object.toString());
        }
    }
}
