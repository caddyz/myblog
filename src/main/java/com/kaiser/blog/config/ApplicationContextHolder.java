package com.kaiser.blog.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicationContextHolder
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/29 21:25
 * @Version 1.0
 **/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }
    public static <T>T getBean(String beanName){
        return (T)applicationContext.getBean(beanName);
    }

    public static <T>T getBean(Class<T> clazz){
        return (T)applicationContext.getBean(clazz);
    }
}
