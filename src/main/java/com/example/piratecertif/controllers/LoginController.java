package com.example.piratecertif.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class LoginController {
    @FXML MFXButton startBT;
    @FXML MFXTextField nameTF;

    @FXML
    public void initialize (){
        startBT.setOnMouseClicked(event -> {
            nameTF.setText(nameTF.getText().trim().toUpperCase());
            if(nameTF.getText().equals("ANF")){
                nameTF.setPromptText("Correct, you are my Anf :)");

            } else {
                nameTF.setPromptText("That isnt your name >:(");
            }
            nameTF.setText("");
        });
    }

}