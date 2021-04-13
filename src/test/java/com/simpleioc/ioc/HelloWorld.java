package com.simpleioc.ioc;

/**
 * @author chenlufeng
 * @date 2021/4/13
 */
public class HelloWorld {
    private String text;

    void say() {
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
