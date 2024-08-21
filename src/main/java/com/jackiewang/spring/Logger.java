package com.jackiewang.spring;

// 定义记录日志的类,这个类就封装了我们所有的公共的代码
public class Logger {

    //  该方法的作用是在切入点方法执行之前执行
    public void beforePrintLog(){
        System.out.println("前置通知(beforePrintLog)：开始打印日志啦");
    }

    //  该方法的作用是在切入点方法执行之后执行
//    public void afterReturningPrintLog(){
//        System.out.println("后置通知(afterReturningPrintLog)：业务方法执行完了，日志打印");
//    }
//
//    //  该方法的作用是在切入点方法执行出错后执行
//    public void afterThrowingPrintLog(){
//        System.out.println("异常通知(afterThrowingPrintLog)：业务方法出现异常了，日志打印");
//    }

    //  该方法的作用是在切入点方法执行之后不管有没有错误，都最终要执行
    public void afterPrintLog(){
        System.out.println("最终通知(afterPrintLog)：业务方法不管有没有异常了，日志打印");
    }
}