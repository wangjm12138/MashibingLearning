package com.jackiewang.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GreetingHandler implements InvocationHandler {
    private Object target;

    public GreetingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After method " + method.getName());
        return result;
    }
}
