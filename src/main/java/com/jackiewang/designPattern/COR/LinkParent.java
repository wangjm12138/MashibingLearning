package com.jackiewang.designPattern.COR;

public abstract  class LinkParent {

    protected LinkParent nextLink;

    public void proceed(){
        if(nextLink != null){
            nextLink.doSomething();
        }
    }

    public abstract void doSomething();
}
