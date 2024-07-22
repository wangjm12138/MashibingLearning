package com.jackiewang.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanF {
    public BeanF() {
        System.out.println("BeanF");
    }

    @Bean
    public BeanG BeanG() {
        return new BeanG();
    }
}
