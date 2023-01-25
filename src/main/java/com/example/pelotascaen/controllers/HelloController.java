package com.example.pelotascaen.controllers;

import com.example.pelotascaen.models.CaePelota;
import com.example.pelotascaen.models.MovePou;
import com.example.pelotascaen.models.Pelota;
import com.example.pelotascaen.models.Pou;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private AnchorPane rootScene;
    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnPrepara;
    @FXML
    private ImageView pueEmo;

    @FXML
    private Button btnLeft;

    @FXML
    private Button btnRight;


    private Circle circulo1;
    private CaePelota moverCirculo1;

    private MovePou moverPou;

    @FXML
    void btnIniciarOnMouse(MouseEvent event) {


        moverCirculo1 = new CaePelota();
        moverCirculo1.setPelotaPos(new Pelota(1,30,28));
        moverCirculo1.addObserver(this);
        Thread hilo1 = new Thread(moverCirculo1);
        hilo1.start();
        System.out.println("paso aqui");

        moverPou =  new MovePou();
        moverPou.setPouPos(new Pou(2,143,525));
        moverPou.addObserver(this);
        Thread hilo2 = new Thread(moverPou);
        hilo2.start();
        System.out.println("paso aqui 2");


    }
    @FXML
    void btnPrepararOnMouse(MouseEvent event) {
        circulo1 = new Circle(10);
        circulo1.setLayoutY(30);
        circulo1.setLayoutX(29);
        rootScene.getChildren().add(circulo1);

    }
    @FXML
    void btnLeftOnMouse(MouseEvent event) {
        moverPou.setRight(true);
        moverPou.setRightCam();
        System.out.println("pasooooooo");
    }
    @FXML
    void btnRightOnMouse(MouseEvent event) {
        moverPou.setLeftCam();
        moverPou.setLeft(true);
        System.out.println("paso a paso");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MovePou){
            Pou posiPou = (Pou) arg;
            pueEmo.setLayoutX(posiPou.getPouX());
        }
        else if (o instanceof CaePelota){
            Pelota posiPelo =(Pelota) arg;
            circulo1.setLayoutY(posiPelo.getY());

        }


    }
}