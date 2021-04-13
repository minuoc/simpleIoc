package com.simpleioc.ioc;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class ReferenceBean {

    private HelloWorld hello;

    public void say() {
        hello.say();
    }

    public void setHello(HelloWorld hello) {
        this.hello = hello;
    }
}
