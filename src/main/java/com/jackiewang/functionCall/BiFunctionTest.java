package com.jackiewang.functionCall;

import java.util.function.BiFunction;

public class BiFunctionTest {

    public static void test(BiFunction<Person, String, String> action){
        PersonImp person = new PersonImp();

        String result = action.apply(person,"xxxx");
        System.out.println(result);
    }

    public static void main(String[] args) {
        test(Person::addName);
        PersonImp person2 = new PersonImp();

        BiFunction<String, String, String> action = person2::addLocation;
        System.out.println(action.apply("fujian", "xiamen"));
    }
}
