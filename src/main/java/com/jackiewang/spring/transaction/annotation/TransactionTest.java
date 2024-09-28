package com.jackiewang.spring.transaction.annotation;


import com.jackiewang.spring.transaction.annotation.config.TransactionConfig;
import com.jackiewang.spring.transaction.annotation.dao.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TransactionConfig.class);
        applicationContext.refresh();
//        BookService bean = applicationContext.getBean(BookService.class);
//        bean.checkout("zhangsan",1);
        BookDao bean = applicationContext.getBean(BookDao.class);
        bean.test();
    }
}
