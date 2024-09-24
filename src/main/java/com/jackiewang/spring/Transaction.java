package com.jackiewang.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Transaction {

    @Bean
    public BeanG BeanG() {
        BeanG g =  new BeanG();
        System.out.println(g);
        return g;
    }
}
