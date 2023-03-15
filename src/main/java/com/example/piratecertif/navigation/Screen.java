package com.example.piratecertif.navigation;

public enum Screen {
    LOGIN("login.fxml"),
    HOME("home.fxml"),
    CERTIF("certificate.fxml");

    private final String filename;

    Screen(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
