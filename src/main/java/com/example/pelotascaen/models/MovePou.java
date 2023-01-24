package com.example.pelotascaen.models;

import java.util.Observable;

public class MovePou extends Observable implements Runnable{
    private Pou pouPos;
    private boolean status;

    public void setPouPos(Pou pouPos){
        this.pouPos=pouPos;
    }
    public MovePou(){
        status =true;
    }

    @Override
    public void run() {
        while (status){
            pouPos.setPouX(pouPos.getPouX() + 3);
            setChanged();
            notifyObservers(pouPos);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
