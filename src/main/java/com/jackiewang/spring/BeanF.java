package com.jackiewang.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanH.class)
public class BeanF {
    public BeanF() {
        System.out.println("BeanF");
    }

    @Bean
    public BeanG BeanG() {
        BeanG g =  new BeanG();
        System.out.println(g);
        return g;
    }
}
