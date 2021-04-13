package com.simpleioc;

/**
 * @author chenlufeng
 * @date 2021/4/10
 */
public class PropertyValue {
    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性对象
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 获取属性名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取属性对象
     * @return
     */
    public Object getValue() {
        return value;
    }
}
