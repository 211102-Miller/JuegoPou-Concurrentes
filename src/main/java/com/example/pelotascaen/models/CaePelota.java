package com.example.pelotascaen.models;

import java.util.Observable;

public class CaePelota extends Observable implements Runnable{
    private Pelota pelotaPos;
    private boolean status;

    public void setPelotaPos(Pelota pelotaPos){
        this.pelotaPos= pelotaPos;
    }
    public CaePelota(){
        status= true;
    }

    @Override
    public void run() {
        while (status){
            pelotaPos.setY(pelotaPos.getY() + 4);
            setChanged();
            notifyObservers(pelotaPos);
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("pasooo");

    }
    public void setStatus(boolean status){
        this.status=status;

    }
}
