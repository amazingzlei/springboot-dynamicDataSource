package com.example.demo.common.aspect;

import com.example.demo.common.annotation.DataBase;
import com.example.demo.common.config.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
public class DataBaseAspect {

    @Pointcut("@annotation(com.example.demo.common.annotation.DataBase)")
    public void dbPointCut() {

    }

    @Before("dbPointCut()")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

            // 判断是否存在@DateBase注解
            if (method.isAnnotationPresent(DataBase.class)) {
                DataBase annotation = method.getAnnotation(DataBase.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("dbPointCut()")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}