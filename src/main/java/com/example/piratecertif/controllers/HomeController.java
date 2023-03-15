package com.example.piratecertif.controllers;

import com.example.piratecertif.App;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {
    @FXML private MFXButton clickBT;
    @FXML private VBox imagesVB;
    private int counter = 0;
    @FXML
    public void initialize(){
        clickBT.setOnMouseClicked(event -> {
            counter++;
            updateImage();
            System.out.println(counter);
        });
    }

    public void updateImage(){
        imagesVB.getStyleClass().clear();
        if(counter<5){imagesVB.getStyleClass().add("image-vbox1");}
        else {imagesVB.getStyleClass().add("vbox");}
    }
}
