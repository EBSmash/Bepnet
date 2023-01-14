package com.bep.bepspam;


public class Timer {
    private long current;

    public Timer(){
        this.current = System.currentTimeMillis();
    }

    public boolean hasReached(long delay){
        return System.currentTimeMillis() - current >= delay;
    }

    public void reset(){
        this.current = System.currentTimeMillis();
    }

    public long getCurrent() {
        return current;
    }
}