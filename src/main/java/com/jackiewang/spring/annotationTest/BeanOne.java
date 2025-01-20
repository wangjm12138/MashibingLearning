package com.jackiewang.spring.annotationTest;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanOne {

    public BeanOne(){
        System.out.println("HHH");
    }
}
