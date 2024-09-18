package com.jackiewang.designPattern.COR;

public class Link_three extends LinkParent{

    public void registerNextLink(LinkParent next) {
        nextLink = next;
    }

    @Override
    public void doSomething() {
        System.out.println("Link_three do something");
        super.proceed();
    }
}
