package com.simpleioc.factory;

import com.simpleioc.BeanDefinition;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String,BeanDefinition> map = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if (beanDefinition == null){
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null){
            bean = doCreate(beanDefinition);
        }
        return bean;
    }

    public abstract Object doCreate(BeanDefinition beanDefinition) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, Exception;

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name,beanDefinition);
    }
}
