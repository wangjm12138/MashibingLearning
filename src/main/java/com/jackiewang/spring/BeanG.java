package com.jackiewang.spring;

import org.springframework.beans.factory.annotation.Value;

public class BeanG {

//    @Value("${db.url}")
    private String url;

//    @Value("${db.username}")
    private String username;

//    @Value("${db.password}")
    private String password;
    public BeanG() {
        System.out.println("xxxxxx");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
