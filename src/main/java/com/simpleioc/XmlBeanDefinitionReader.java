package com.simpleioc;

import com.simpleioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    /**
     * 构造器必须有一个资源加载器，默认插件创建一个map 容器
     * @param resourceLoader
     */
    public XmlBeanDefinitionReader( ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void readXML(String location) throws IOException, SAXException, ParserConfigurationException {
        ResourceLoader resourceLoader = new ResourceLoader();
        InputStream inputStream = resourceLoader.getResource(location).getInputStream();
        //创建文档建造者工厂实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //文档创建者解析流
        Document doc = documentBuilder.parse(inputStream);

        registerBeanDefinitions(doc);

        inputStream.close();

    }

    /**
     * 根据给定的文档对象进行解析，并注册到bean容器中
     *
     * @param doc
     */
    private void registerBeanDefinitions(Document doc) {

        Element root = doc.getDocumentElement();
        //解析元素根节点及根节点下的所有子节点 并注册到容器中
        parseBeanDefinitions(root);
    }

    /**
     * 解析元素的根节点及 根节点下的所有子节点并添加进 注册容器
     *
     * @param root
     */
    private void parseBeanDefinitions(Element root) {
        //读取根元素的所有子元素
        NodeList nl = root.getChildNodes();

        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                //解析给定的节点 包括name class property  value ref
                processBeanDefinition(ele);

            }
        }


    }

    /**
     * 解析给定的节点 包括name，class, property,name,value,ref
     *
     * @param ele
     */
    private void processBeanDefinition(Element ele) {

        String name = ele.getAttribute("name");

        String className = ele.getAttribute("class");

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);

        //向bean 注入配置文件中的成员变量
        addPropertyValues(ele, beanDefinition);
        //向注册容器中 添加bean名称和 bean定义
        getRegistry().put(name, beanDefinition);


    }

    /**
     * 添加配置文件中的属性元素到 bean定义实例中
     *
     * @param ele
     * @param beanDefinition
     */
    private void addPropertyValues(Element ele, BeanDefinition beanDefinition) {

        NodeList propertyNode = ele.getElementsByTagName("property");

        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;

                String name = propertyEle.getAttribute("name");

                String value = propertyEle.getAttribute("value");

                if (value != null && value.length() > 0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if(ref == null || ref.length() == 0){
                        throw new IllegalArgumentException(
                                "Configuration problem: <property> element for property '" + name
                                + "' must specify a ref or value"
                        );

                        //
                    }
                    BeanReference beanReference = new BeanReference(name);

                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));


                }


            }
        }
    }


}
