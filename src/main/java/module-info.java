module com.example.piratecertif {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.example.piratecertif to javafx.fxml;
    exports com.example.piratecertif;
    exports com.example.piratecertif.controllers;
    opens com.example.piratecertif.controllers to javafx.fxml;
}