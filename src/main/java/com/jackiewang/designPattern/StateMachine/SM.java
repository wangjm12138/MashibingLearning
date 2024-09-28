package com.jackiewang.designPattern.StateMachine;

public class SM {

    private STATE current=STATE.CLOSE;

    private Object[][] stateMap;

    public SM(Object[][] stateMap) {
        this.stateMap = stateMap;
    }

    public STATE getCurrent() {
        return current;
    }

    public void setCurrent(STATE current) {
        STATE old = this.current;

        for (int i = 0; i < stateMap.length; i++) {
            if((old==stateMap[i][0])&&(current==stateMap[i][1])) {
                ACTION a = (ACTION) stateMap[i][2];
                a.apply();
            }
        }
        this.current = current;
    }

}