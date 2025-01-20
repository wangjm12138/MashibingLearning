package com.jackiewang.proxy.cglib;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class ProxyTestCglib {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib_classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        SimpleClass proxy  = (SimpleClass) enhancer.create();
        int result = proxy.value;
        proxy.doSomething();


    }
}
