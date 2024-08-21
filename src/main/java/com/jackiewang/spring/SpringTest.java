package com.jackiewang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./application.xml");
       // BeanG g= (BeanG)ApplicationContext.getBean("BeanG");
       // System.out.println(g);

        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./aop.xml");
        SimpleService service = ApplicationContext.getBean("simpleService", SimpleService.class);
        service.performAction();


    }
}
