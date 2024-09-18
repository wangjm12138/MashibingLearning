package com.jackiewang.designPattern.COR;

public class CORtest {

    public static void main(String[] args) {
        Link_one one = new Link_one();
        Link_two two = new Link_two();
        Link_three three = new Link_three();

        two.registerNextLink(three);
        one.registerNextLink(two);

        one.doSomething();

    }

}
