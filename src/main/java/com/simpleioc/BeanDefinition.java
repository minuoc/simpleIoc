package com.simpleioc;

/**
 * bean 的定义
 * @author chenlufeng
 * @date 2021/4/10
 */
public class BeanDefinition {

    private Object bean;

    /**
     * bean 的 class 对象
     */
    private Class beanClass;

    /**
     * bean 的类全限定名称
     */
    private String className;


    /**
     * 类的属性集合
     */
    private PropertyValues propertyValues = new PropertyValues();


    /**
     * 获取bean 对象
     */
    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }


    /**
     * 通过设置类名称 反射生成 class 对象
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
        try {
            this.beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
