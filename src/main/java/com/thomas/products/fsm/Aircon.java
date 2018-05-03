package com.thomas.products.fsm;

public class Aircon {
    State state = State.OFF;//private改默认，删除getState()。
    //两个Action  
    public void power(){//按power键  
        state.power(this);  
    }  
    public void cool(){//按制冷键  
        state.cool(this);  
    }

    public static void main(String[] args) {
        Aircon ac = new Aircon();
        System.out.println("Current State:" + ac.state.name());
        ac.cool();
        ac.power();
        ac.cool();
        ac.cool();
        ac.power();
        ac.power();
        ac.power();
    }
}