package com.jackiewang.designPattern.StateMachine;

public class SM {

    private STATE current;

    private int[][] stateMap;

    public SM(int[][] stateMap) {
        this.stateMap = stateMap;
    }

    public void SetState(STATE state) {
        this.current = state;
    }
}