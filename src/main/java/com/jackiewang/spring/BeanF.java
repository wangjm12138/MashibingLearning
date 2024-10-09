package com.jackiewang.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BeanH.class)
public class BeanF {
    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

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
