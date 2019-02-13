package com.kaiser.blog.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringContextHolder
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/26 22:20
 * @Version 1.0
 **/
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static void assertApplicationContext(){
        if(SpringContextHolder.applicationContext == null){
            throw new RuntimeException("appliectionContext为空，查看是否注入SpringContextHolder");
        }
    }

    public static ApplicationContext getApplicationContext(){
        assertApplicationContext();
        return applicationContext;
    }

    public static<T> T getBean(String beanName){
        assertApplicationContext();
        return (T)applicationContext.getBean(beanName);
    }

    public static<T> T getBean(Class<T> clazz){
        assertApplicationContext();
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }
}
