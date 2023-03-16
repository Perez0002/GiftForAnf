package com.example.piratecertif.controllers;

import com.example.piratecertif.navigation.Navigation;
import com.example.piratecertif.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML private MFXButton clickBT;
    @FXML private VBox imagesVB;
    private int counter = 0;
    @FXML
    public void initialize(){
        counter = 0;
        clickBT.setOnMouseClicked(event -> {
            clickBT.setDisable(true);
            level1();
            updateImage();
        });
    }

    public void updateImage(){
        imagesVB.getStyleClass().clear();
        if(counter<5){imagesVB.getStyleClass().add("level1");}
        else if(counter<10){imagesVB.getStyleClass().add("level2");}
        else if(counter<15){imagesVB.getStyleClass().add("level3");}
        else if(counter<20){imagesVB.getStyleClass().add("level4");}
        else if(counter<30){imagesVB.getStyleClass().add("level5");}
        else{Navigation.navigate(Screen.CERTIF);}
    }

    public void level1(){
        int num = (int)(Math.random() * (2 - 1 + 1)) + 1; //(int)(Math.random() * max - min + 1) + min;
        switch (num) {
            case 1 -> clickBT.setText("->");
            case 2 -> clickBT.setText("<-");
            default-> clickBT.setText("error");
            }
        check();
    }

    public void check() {
        clickBT.getScene().setOnKeyPressed(event -> {
            if(clickBT.getText().equals("->") && event.getCode() == KeyCode.D){counter++;}
            else if (clickBT.getText().equals("<-") && event.getCode() == KeyCode.A) {counter++;}
            else {counter--;}
            System.out.println(counter);
            next();
        });
    }
    public void next() {
        if(counter<5){level1();}
        else if(counter<10){clickBT.setText("level 2!"); updateImage();}
        else if(counter<15){level1();}
        else if(counter<20){level1();}
        else if(counter<30){level1();}
        else{Navigation.navigate(Screen.CERTIF);}
    }
}
