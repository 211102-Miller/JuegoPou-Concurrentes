package com.example.pelotascaen.controllers;

import com.example.pelotascaen.models.CaePelota;
import com.example.pelotascaen.models.MovePou;
import com.example.pelotascaen.models.Pelota;
import com.example.pelotascaen.models.Pou;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.security.PrivateKey;
import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    private int contador = 0;
    private Pelota comparacion;

    @FXML
    private AnchorPane rootScene;
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnPrepara;
    @FXML
    private Button btnLeft;
    @FXML
    private Button btnRight;
    @FXML
    private TextField btnContador;

    //Imagenes de las comidas
    private ImageView comida1;
    private ImageView comida2;
    private ImageView comida3;

    @FXML
    private ImageView pueEmo; //Imagen Pou

    private CaePelota moverCirculo1;

    private CaePelota [] moviComida = new CaePelota[5];


    private MovePou moverPou;

    @FXML
    void btnIniciarOnMouse(MouseEvent event) {

        //Movimiento de la comida 1
        moverCirculo1 = new CaePelota();
        moverCirculo1.setPelotaPos(new Pelota(1,0,0));
        moverCirculo1.addObserver(this);
        Thread hilo1 = new Thread(moverCirculo1);
        hilo1.start();
        System.out.println("paso aqui");

        //Movimiento de comida 2

        moviComida[0] = new CaePelota();
        moviComida[0].setPelotaPos(new Pelota(2,0,0));
        moviComida[0].addObserver(this);
        Thread hilo3 = new Thread(moviComida[0]);
        hilo3.start();

        //Movimiento de comida 3
        moviComida[1] = new CaePelota();
        moviComida[1].setPelotaPos(new Pelota(3,0,0));
        moviComida[1].addObserver(this);
        Thread hilo4 = new Thread(moviComida[1]);
        hilo4.start();


        //Movimiento del Pou
        moverPou =  new MovePou();
        moverPou.setPouPos(new Pou(2,143,525));
        moverPou.addObserver(this);
        Thread hilo2 = new Thread(moverPou);
        hilo2.start();
        System.out.println("paso aqui 2");


    }
    @FXML
    void btnPrepararOnMouse(MouseEvent event) {

        //Creacion de la imagen de la comida
        comida1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/galletaOreo.gif")));
        comida1.setFitHeight(50);
        comida1.setFitWidth(50);
        comida1.setLayoutX(0);
        comida1.setLayoutY(0);
        rootScene.getChildren().addAll(comida1);

        comida2 = new ImageView(new Image(getClass().getResourceAsStream("/assets/Mazapan.gif")));
        comida2.setFitHeight(50);
        comida2.setFitWidth(50);
        comida2.setLayoutX(0);
        comida2.setLayoutY(0);
        rootScene.getChildren().addAll(comida2);

        comida3 = new ImageView(new Image(getClass().getResourceAsStream("/assets/Pizza.gif")));
        comida3.setFitHeight(50);
        comida3.setFitWidth(50);
        comida3.setLayoutX(0);
        comida3.setLayoutY(0);
        rootScene.getChildren().addAll(comida3);


    }
    @FXML
    void btnLeftOnMouse(MouseEvent event) {
        //Movimiento con cada click izquiera
        moverPou.setRight(true);
        moverPou.setRightCam();
        System.out.println("pasooooooo");
    }
    @FXML
    void btnRightOnMouse(MouseEvent event) {
        //Movimiento con cada click derecha
        moverPou.setLeftCam();
        moverPou.setLeft(true);
        System.out.println("paso a paso");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MovePou){
            Pou posiPou = (Pou) arg;
            Platform.runLater(() -> pueEmo.setLayoutX(posiPou.getPouX()));
        }
        else if (o instanceof CaePelota){
            Pelota posiPelo =(Pelota) arg;

            switch (posiPelo.getId()){
                case 1:
                    Platform.runLater(() -> comida1.setLayoutY(posiPelo.getY()));
                    Platform.runLater(() -> comida1.setLayoutX(posiPelo.getX()));
                    break;
                case 2:
                    Platform.runLater(() -> comida2.setLayoutY(posiPelo.getY()));
                    Platform.runLater(() -> comida2.setLayoutX(posiPelo.getX()));
                    break;
                case 3:
                    Platform.runLater(() -> comida3.setLayoutY(posiPelo.getY()));
                    Platform.runLater(() -> comida3.setLayoutX(posiPelo.getX()));
                    break;
            }


        }if (comida1.getBoundsInParent().intersects(pueEmo.getBoundsInParent())) {
            moverCirculo1.setReinicio(true);

        }


    }
}