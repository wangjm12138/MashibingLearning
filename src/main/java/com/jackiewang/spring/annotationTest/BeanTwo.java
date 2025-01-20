package com.jackiewang.spring.annotationTest;

import org.springframework.stereotype.Component;

@Component
public class BeanTwo {

    public BeanTwo() {
        System.out.println("BeanTwo");
    }
}
