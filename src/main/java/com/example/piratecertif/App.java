package com.example.piratecertif;

import com.example.piratecertif.navigation.Navigation;
import com.example.piratecertif.navigation.Screen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class App extends Application {

    @Setter @Getter private static Stage primaryStage;
    @Setter @Getter private static BorderPane rootPane;
    @Override
    public void start(Stage primaryStage) throws IOException {
        App.primaryStage=primaryStage;
        final FXMLLoader loader = new FXMLLoader(App.class.getResource("root.fxml"));
        final BorderPane root = loader.load();
        App.rootPane = root;
        Scene scene = new Scene(root);
        primaryStage.setTitle("Arrrgh!");
        primaryStage.setScene(scene);
        Navigation.navigate(Screen.LOGIN);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}