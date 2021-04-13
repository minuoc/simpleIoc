package com.simpleioc.factory;

import com.simpleioc.BeanDefinition;
import com.simpleioc.BeanReference;
import com.simpleioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * 实现自动注入 和 递归注入
 * @author chenlufeng
 * @date 2021/4/13
 */
public class AutowireBeanFactory extends AbstractBeanFactory{

    /**
     * 根据bean 定义创建实例， 并将实例作为key, bean 定义作为value 存放，并调用 addProperties
     * @param beanDefinition
     * @return
     */
    @Override
    public Object doCreate(BeanDefinition beanDefinition) throws Exception {
        Object bean  = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        addPropertyValue(bean,beanDefinition);
        return bean;
    }

    /**
     * 给定一个bean 定义 和 一个bean 实例，为给定的bean中的属性注入实例。
     * @param bean
     * @param beanDefinition
     */
    private void addPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValueList()){

            Field declareField = bean.getClass().getDeclaredField(pv.getName());

            declareField.setAccessible(true);

            Object value = pv.getValue();

            if (value instanceof BeanReference){

                BeanReference beanReference = (BeanReference) value;

                value = getBean(beanReference.getName());

            }

            declareField.set(bean,value);


        }

    }
}
