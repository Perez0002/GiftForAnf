package com.example.piratecertif.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML private MFXButton clickBT;
    @FXML private VBox imagesVB;
    private int counter = 0;
    @FXML
    public void initialize(){
        clickBT.setOnMouseClicked(event -> {
            counter++;
            updateImage();
        });
    }

    public void updateImage(){
        imagesVB.getStyleClass().clear();
        if(counter<5){imagesVB.getStyleClass().add("stage1");}
        else if(counter<10){imagesVB.getStyleClass().add("stage2");}
        else if(counter<15){imagesVB.getStyleClass().add("stage3");}
        else {imagesVB.getStyleClass().add("stage4");}
    }
}
