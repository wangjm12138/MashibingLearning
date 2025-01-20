package com.jackiewang.functionCall;

public class PersonImp implements Person {


    public String addName(String name){

        return name;
    }

    public String addLocation(String province, String city){
        return province+" : "+city;
    }

}
