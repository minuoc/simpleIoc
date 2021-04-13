package com.simpleioc.ioc;

import com.simpleioc.BeanDefinition;
import com.simpleioc.PropertyValue;
import com.simpleioc.PropertyValues;
import com.simpleioc.factory.AutowireBeanFactory;
import com.simpleioc.factory.BeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class BeanFactoryTest {

    private final String className = "com.simpleioc.ioc.HelloWorld";

    private final String property = "text";

    //属性值
    private String value = "测试自动";

    //类id
    private final String name = "hello";

    @Test
    public void test() throws Exception {
        BeanFactory beanFactory = new AutowireBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);

        PropertyValues pv = new PropertyValues();

        beanDefinition.setPropertyValues(pv);

        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(property,value));

        beanFactory.registerBeanDefinition(name,beanDefinition);

        HelloWorld hello = (HelloWorld) beanFactory.getBean(name);
        hello.say();

    }

}
