package com.example.pelotascaen.models;

import java.util.Observable;

public class MovePou extends Observable implements Runnable{
    private Pou pouPos;
    private boolean status;
    private boolean left= false;

    private boolean right = false;

    public void setRight(boolean right){
        this.right=right;
    }
    public void setRightCam(){
        pouPos.setPouX(pouPos.getPouX() - 0);
    }

    public void setLeft(boolean left){
        this.left=left;
    }
    public void setLeftCam(){
        pouPos.setPouX(pouPos.getPouX() + 0);
    }

    public void setPouPos(Pou pouPos){
        this.pouPos=pouPos;
    }
    public MovePou(){
        status =true;
    }

    @Override
    public void run() {
        while (status){

            setChanged();
            notifyObservers(pouPos);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /*if(pouPos.getPouX() >= 0 || pouPos.getPouX() <= 500 ){*/
                if(left == true){
                    if(pouPos.getPouX() <= 290){
                        pouPos.setPouX(pouPos.getPouX() + 30);
                        System.out.println("Derecha");

                    }
                    left = false;
                }
                else if (right == true){
                    if (pouPos.getPouX() >= 0){
                        pouPos.setPouX(pouPos.getPouX() - 30);
                        System.out.println("Izquierda");
                    }
                    right=false;
                }
            /*}
            else{
                left = false;
                right = false;
            }*/

            /*if(pouPos.getPouX() > 290){
                distanciaX *= -1;
            }
            if(pouPos.getPouX() < 1){
                distanciaX *= -1;
            }*/

        }


    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
