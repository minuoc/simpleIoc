package com.simpleioc.ioc;

import com.simpleioc.BeanDefinition;
import com.simpleioc.XmlBeanDefinitionReader;
import com.simpleioc.factory.AutowireBeanFactory;
import com.simpleioc.factory.BeanFactory;
import com.simpleioc.io.ResourceLoader;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());

        reader.readXML("myspring.xml");

        BeanFactory beanFactory = new AutowireBeanFactory();

        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : reader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        ReferenceBean referenceBean = (ReferenceBean) beanFactory.getBean("referenceBean");
        referenceBean.say();


    }
}
