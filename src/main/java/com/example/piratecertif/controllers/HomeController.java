package com.example.piratecertif.controllers;

import com.example.piratecertif.navigation.Navigation;
import com.example.piratecertif.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import org.kordamp.ikonli.javafx.FontIcon;

public class HomeController {
    @FXML private MFXButton clickBT;
    @FXML private VBox imagesVB;
    @FXML private FontIcon arrowFontIcon;
    @FXML private Label instructionsLabel;
    private int counter = 0;
    private int currentLevel = 0;
    @FXML
    public void initialize(){
        clickBT.setOnMouseClicked(event -> {
            clickBT.setVisible(false);
            clickBT.setPrefHeight(0);
            instructionsLabel.setPrefHeight(60);
            next();
        });
    }

    public void updateImage(int level){
        imagesVB.getStyleClass().clear();
        String css = "level" + level;
        imagesVB.getStyleClass().add(css);
    }

    public void levelControl(){
        switch(currentLevel){
            case 1 -> instructionsLabel.setText("Sailing! Steer left and right!");
            case 2 -> instructionsLabel.setText("Fencing! Strike up, down, left, and right!");
            case 3 -> instructionsLabel.setText("Pistol! Empty arrow = pull backwards to reload");
            case 4 -> instructionsLabel.setText("Cannon! Empty arrow = pull backwards to reload");
            case 5 -> instructionsLabel.setText("Finish your training!!!");
        }

        int num = (int)(Math.random() * ((currentLevel*2) - 1 + 1)) + 1;
        switch (num) {
            case 1 -> arrowFontIcon.setIconLiteral("typ-arrow-right-thick");
            case 2 -> arrowFontIcon.setIconLiteral("typ-arrow-left-thick");
            case 3 -> arrowFontIcon.setIconLiteral("typ-arrow-up-thick");
            case 4 -> arrowFontIcon.setIconLiteral("typ-arrow-down-thick");
            case 5 -> arrowFontIcon.setIconLiteral("typ-arrow-right-outline");
            case 6 -> arrowFontIcon.setIconLiteral("typ-arrow-left-outline");
            case 7 -> arrowFontIcon.setIconLiteral("typ-arrow-up-outline");
            case 8 -> arrowFontIcon.setIconLiteral("typ-arrow-down-outline");
            default-> clickBT.setText("error");
        }
        check();
    }


    public void check() {
        clickBT.getScene().setOnKeyPressed(event -> {
            if ((arrowFontIcon.getIconLiteral().equals("typ-arrow-right-thick")
                    ||  arrowFontIcon.getIconLiteral().equals("typ-arrow-left-outline"))
                    && event.getCode() == KeyCode.RIGHT){counter++;}
            else if ((arrowFontIcon.getIconLiteral().equals("typ-arrow-left-thick")
                    || arrowFontIcon.getIconLiteral().equals("typ-arrow-right-outline"))
                    && event.getCode() == KeyCode.LEFT) {counter++;}
            else if ((arrowFontIcon.getIconLiteral().equals("typ-arrow-up-thick")
                    || arrowFontIcon.getIconLiteral().equals("typ-arrow-down-outline"))
                    && event.getCode() == KeyCode.UP) {counter++;}
            else if ((arrowFontIcon.getIconLiteral().equals("typ-arrow-down-thick")
                    || arrowFontIcon.getIconLiteral().equals("typ-arrow-down-outline"))
                    && event.getCode() == KeyCode.DOWN) {counter++;}
            else {counter--;}
            System.out.println(counter);
            next();
        });
    }
    public void next() {
        if(counter<5){currentLevel=1; updateImage(1); levelControl();}
        else if(counter<10){currentLevel=2; updateImage(2); levelControl();}
        else if(counter<15){currentLevel=3; updateImage(3); levelControl();}
        else if(counter<20){currentLevel=4; updateImage(4); levelControl();}
        else if(counter<30){currentLevel=5; updateImage(5); levelControl();}
        else{Navigation.navigate(Screen.CERTIF);}
    }
}
