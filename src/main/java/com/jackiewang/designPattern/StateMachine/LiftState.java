package com.jackiewang.designPattern.StateMachine;

public abstract class LiftState {
    private Context context;

    public void setState(Context context){
        this.context = context;
    }

    public abstract void toOpen();

    public abstract void toClose();

    public abstract void toRun();

    public abstract void toStop();
}
