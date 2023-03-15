package com.example.piratecertif.controllers;

import com.example.piratecertif.navigation.Navigation;
import com.example.piratecertif.navigation.Screen;
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
        if(counter<5){imagesVB.getStyleClass().add("level1");}
        else if(counter<10){imagesVB.getStyleClass().add("level2");}
        else if(counter<15){imagesVB.getStyleClass().add("level3");}
        else if(counter<20){imagesVB.getStyleClass().add("level4");}
        else if(counter<30){imagesVB.getStyleClass().add("level5");}
        else{Navigation.navigate(Screen.CERTIF);}
    }
}
