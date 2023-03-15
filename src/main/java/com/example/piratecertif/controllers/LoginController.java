package com.example.piratecertif.controllers;

import com.example.piratecertif.navigation.Navigation;
import com.example.piratecertif.navigation.Screen;
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
            if(nameTF.getText().equals("ANF") || nameTF.getText().equals("!!!")){
                Navigation.navigate(Screen.HOME);
            } else {
                nameTF.setPromptText("That isnt your name >:(");
            }
            nameTF.setText("");
        });
    }

}