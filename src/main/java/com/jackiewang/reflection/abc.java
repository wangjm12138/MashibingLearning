package com.jackiewang.reflection;

public class abc {

    public abc(){
        System.out.println("abc");
    }

    public abc(int a, int b, int c){
        System.out.println("abc a b c public");
    }

    private abc(int a, int b){
        System.out.println("abc a b private");
    }

//    public void Pprint(int a){
//        System.out.println(a);
//    }

    private void test(){
        System.out.println("test");
    }
    private void Pprint(int a, int b, int c){
        System.out.println(a+b+c);
    }
//    public void Pprint(int a, int b){
//        System.out.println(a+b);
//    }
}


class bcd extends abc{
    public bcd(){
        System.out.println("bcd");
    }


}
class ccc {
    public ccc(){
        System.out.println("cdf");
    }
}