package com.example.piratecertif.navigation;

import com.example.piratecertif.App;
import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class Navigation {
    public static void navigate(final Screen screen) {
        final String filename = screen.getFilename();

        try {
            final var resource = App.class.getResource(filename);
            final FXMLLoader loader = new FXMLLoader(resource);

            App.getRootPane().setCenter(loader.load());
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}

