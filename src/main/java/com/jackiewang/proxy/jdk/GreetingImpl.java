package com.jackiewang.proxy.jdk;

public class GreetingImpl implements Greeting{
    @Override
    public void greet() {
        System.out.println("hello world");
    }
}
