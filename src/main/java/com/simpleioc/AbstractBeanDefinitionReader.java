package com.simpleioc;

import com.simpleioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{


    /**
     * 注册bean 容器
     */
    private Map<String, BeanDefinition> registry;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    /**
     *  构造器必须有一个资源加载器，默认插件创建一个map 容器
     * @param resourceLoader
     */
    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    /**
     * 获取容器
     * @return
     */
    public Map<String,BeanDefinition> getRegistry() {
        return registry;
    }

    /**
     * 获取资源加载器
     * @return
     */
    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
}
