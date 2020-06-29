package com.students.springbootstu.log;

import com.students.springbootstu.util.JSONUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LogRespectRecord {

    @Around("within(com.students.springbootstu..*)&&@annotation(com.students.springbootstu.log.LogAspect)")
    public Object addLogger(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName(); //获取连接点方法名
        Class<?> classTarget = joinPoint.getTarget().getClass(); //获取连接点方法所在的类
        Class<?>[] par = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();//获取参数类型
        Method objMethod = classTarget.getMethod(methodName, par); //获取方法
        LogAspect logAspect = objMethod.getAnnotation(LogAspect.class); //获取注释接口类

        printLog("入参", logAspect, joinPoint.getArgs());
        Object result =  joinPoint.proceed();
        printLog("出参", logAspect, result);

        return result;
    }

    //根据信息等级打印日志
    private void printLog(String argDesc, LogAspect logAspect, Object args){
        String level = logAspect.level().toUpperCase();
        String value = logAspect.value(); //获取注释类信息

        if(StringUtils.isNotEmpty(value)){
            argDesc = value + ',' + argDesc;
        }

        switch (level){
            case"TRACE":
                if(log.isTraceEnabled()){
                    log.trace(argDesc + JSONUtil.toJsonString(args));
                }
                break;
            case"DEBUG":
                if(log.isDebugEnabled()){
                    log.debug(argDesc + JSONUtil.toJsonString(args));
                }
                break;
            case"INFO":
                if(log.isInfoEnabled()){
                    log.info(argDesc + JSONUtil.toJsonString(args));
                }
                break;
            case"WARN":
                if(log.isWarnEnabled()){
                    log.warn(argDesc + JSONUtil.toJsonString(args));
                }
                break;
            case"ERROR":
                if(log.isErrorEnabled()){
                    log.error(argDesc + JSONUtil.toJsonString(args));
                }
                break;

            default:
                log.info("日志级别不存在：{}", level);

        }
    }

}
