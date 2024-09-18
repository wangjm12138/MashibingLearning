package com.jackiewang.designPattern.COR;

public class Link_two extends LinkParent {

    public void registerNextLink(LinkParent next) {
       nextLink = next;
    }

    @Override
    public void doSomething() {
        System.out.println("Link_two do something");
        super.proceed();
    }

}
