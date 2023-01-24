package com.example.pelotascaen.models;

public class Pou {
    private int id;
    private int pouX;
    private int pouY;

    public Pou(int id, int pouX, int pouY) {
        this.id = id;
        this.pouX = pouX;
        this.pouY = pouY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPouX() {
        return pouX;
    }

    public void setPouX(int pouX) {
        this.pouX = pouX;
    }

    public int getPouY() {
        return pouY;
    }

    public void setPouY(int pouY) {
        this.pouY = pouY;
    }
}
