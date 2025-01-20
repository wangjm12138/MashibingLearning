package com.jackiewang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./application.xml");
        //ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("{file}.xml");

//        BeanG g= (BeanG)ApplicationContext.getBean("beanG");
//        System.out.println(g.getUrl());


//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./aop.xml");
//        SimpleService service = ApplicationContext.getBean("simpleService", SimpleService.class);
//        service.performAction();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.jackiewang.spring.annotationTest");
//        annotationConfigApplicationContext.register(Transaction.class);
//        annotationConfigApplicationContext.refresh();
//        Transaction a = annotationConfigApplicationContext.getBean(Transaction.class);
//        System.out.println(a);
//        annotationConfigApplicationContext.close();
    }
}
