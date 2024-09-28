package com.jackiewang.designPattern.StateMachine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SmTest {

    public static void Test (){
        System.out.println("test");
    }

    public static void main(String[] args) {
        Object[][] stateMap = new Object[][] {
                {STATE.OPEN, STATE.CLOSE, (ACTION)ActionTake::action1},
                {STATE.CLOSE, STATE.RUNNING, (ACTION)ActionTake::action2},
                {STATE.RUNNING, STATE.STOP, (ACTION)ActionTake::action3},
                {STATE.STOP, STATE.OPEN, (ACTION)ActionTake::action4},
                {STATE.CLOSE, STATE.OPEN, (ACTION)ActionTake::action5},
        };

        SM sm = new SM(stateMap);
        sm.setCurrent(STATE.OPEN);
        sm.setCurrent(STATE.CLOSE);
        sm.setCurrent(STATE.RUNNING);
        sm.setCurrent(STATE.STOP);
        sm.setCurrent(STATE.OPEN);
    }

}
