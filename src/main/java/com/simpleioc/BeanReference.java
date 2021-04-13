package com.simpleioc;

/**
 * bean 的 引用
 * @author chenlufeng
 * @date 2021/4/13
 */
public class BeanReference {

    /**
     * bean 名称
     */
    private String name;

    /**
     * bean 对象
     */
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
