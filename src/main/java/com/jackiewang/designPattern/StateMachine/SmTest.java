package com.jackiewang.designPattern.StateMachine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SmTest {

//    public void openToRunningAction(ACTION action) {
////        Object[][] stateMap = new Object[][]{
////                {STATE.OPEN, STATE.RUNNING, SmTest::openToRunningAction},
////                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
////        };
////        ACTION a = SmTest::openToRunningAction
//        action.apply();
//        System.out.println(111);
////        Map<String, ACTION> map = new HashMap<>();
//    }

    public static void Test (){
        System.out.println("test");
    }


    public static void main(String[] args) {
        Object[][] stateMap = new Object[][]{
                {STATE.OPEN, STATE.RUNNING, (ACTION)SmTest::Test},
        };

        ACTION a = (ACTION) stateMap[0][2];
        a.apply();
    }

}
