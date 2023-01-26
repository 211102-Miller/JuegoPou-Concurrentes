package com.example.pelotascaen.models;

import java.util.Observable;
import java.util.Random;

public class CaePelota extends Observable implements Runnable{
    private Pelota pelotaPos;
    private boolean status;
    private Random random;


    public void setPelotaPos(Pelota pelotaPos){
        this.pelotaPos= pelotaPos;
    }
    public CaePelota(){
        status= true;
    }
    int numero = (int)(Math.random()*300+1);

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public void run() {

        pelotaPos.setX(numero);
        while (status){
            pelotaPos.setY(pelotaPos.getY() + 4);

            setChanged();
            notifyObservers(pelotaPos);
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(pelotaPos.getY() >= 733){
                 numero = (int)(Math.random()*300+1);
                pelotaPos.setY(0);
                pelotaPos.setX(numero);
                System.out.println("jijijji");
            }
        System.out.println("pasooo");

    }
}}
