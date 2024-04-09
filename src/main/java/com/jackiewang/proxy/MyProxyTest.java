package com.jackiewang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态地创建一个实现了指定接口的新代理实例。这种技术通常被称为动态代理,其实它是接口代理，实际上减少编写一个类的麻烦，
//正常一个类要实现很多接口要写implement，而用proxy可以在动态的创建一个类对象，并且它实现了很多接口。
public class MyProxyTest {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        a_in aaaa = (a_in) Proxy.newProxyInstance(a_in.class.getClassLoader(), new Class<?>[]{a_in.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+" is proxied");
                for(Object arg:args){
                    System.out.println(arg);
                }
                return null;
            }
        });
        aaaa.print(1);
        aaaa.print2(2,3);
    }
    public static void test2(){
        a_imp a_imp_1 = new a_imp();

        a_in a_imp_proxy = (a_in) Proxy.newProxyInstance(a_imp.class.getClassLoader(), new Class<?>[]{a_in.class}, new a_imp_handler(a_imp_1));
        System.out.println(a_imp_proxy.print2(1,2));
    }
}

class a_imp_handler implements InvocationHandler{

    private Object o;
    public a_imp_handler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" is proxied");
        return method.invoke(o,args);
    }
}


interface a_in {

    public void print(int input);

    public int print2(int input1,int input2);

}
class a_imp implements a_in{
    public a_imp() {
        System.out.println("init");
    }

    @Override
    public void print(int input) {
        System.out.println(input);
    }

    @Override
    public int print2(int input2,int input3) {
        return input2+input3;
    }

}