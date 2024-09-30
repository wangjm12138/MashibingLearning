package com.jackiewang.proxy.jdk;

public class MyProxyInterfaceImp implements MyProxyInterface{
    public int value = 10;

    public MyProxyInterfaceImp() {
    }

    @Override
    public void doSomething() {
        System.out.println("do something");
    }
}
