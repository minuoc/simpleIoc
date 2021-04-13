package com.simpleioc.factory;

import com.simpleioc.BeanDefinition;

/**
 * @author chenlufeng
 * @date 2021/4/10
 */
public interface BeanFactory {


    /**
     * 根据bean 的名称 从容器中获取bean对象
     * @param name
     * @return bean实例
     * @throws Exception
     */
    Object getBean(String name) throws Exception;


    /**
     *
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
