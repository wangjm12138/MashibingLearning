package com.jackiewang.proxy.jdk;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        MyProxyInterface myProxyInterfaceImp = new MyProxyInterfaceImp();
        MyProxyHandler myProxyHandler = new MyProxyHandler(myProxyInterfaceImp);

        System.out.println(((MyProxyInterfaceImp)myProxyInterfaceImp).value);
        MyProxyInterface proxy = (MyProxyInterface)Proxy.newProxyInstance(MyProxyInterfaceImp.class.getClassLoader(), new Class[]{MyProxyInterface.class},myProxyHandler);

        proxy.doSomething();
//        Greeting greeting = new GreetingImpl();
//        Greeting proxy = (Greeting) Proxy.newProxyInstance(
//                Greeting.class.getClassLoader(),
//                new Class[] { Greeting.class },
//                new GreetingHandler(greeting)
//        );
//
//        proxy.greet();
    }
}

class MyProxyHandler implements InvocationHandler{
    private Object target;
    public MyProxyHandler(Object t){
        target = t;

    }
    public Object invoke(Object proxy, Method m, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.print(target);
        System.out.println("before doing something");
        return m.invoke(target,args);
    }
}