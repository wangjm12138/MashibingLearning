package com.jackiewang.spring.selfEditor;

import com.jackiewang.spring.BeanG;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestSelfEditor {

    public static void main(String[] args) {
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./selfEditor.xml");

        SomeClass g= (SomeClass) ApplicationContext.getBean("SomeClass");
        System.out.println(g.getPerson().getAge());


//        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("./aop.xml");
//        SimpleService service = ApplicationContext.getBean("simpleService", SimpleService.class);
//        service.performAction();

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(Transaction.class);
//        annotationConfigApplicationContext.refresh();
//        Transaction a = annotationConfigApplicationContext.getBean(Transaction.class);
//        System.out.println(a);
//        annotationConfigApplicationContext.close();
    }
}
