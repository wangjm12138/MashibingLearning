package com.jackiewang.designPattern.COR;

public class Link_one extends LinkParent{


    public void registerNextLink(LinkParent next) {
        nextLink = next;
    }

    @Override
    public void doSomething() {
        System.out.println("Link_one do something");
        proceed();
    }
}
