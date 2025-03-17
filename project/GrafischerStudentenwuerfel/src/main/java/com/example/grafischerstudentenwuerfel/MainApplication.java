package com.example.grafischerstudentenwuerfel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 460);
        stage.setTitle("Studentenwürfel");
        stage.setResizable(false);
        URL stylesheetUrl = Objects.requireNonNull(getClass().getResource("style.css"));
        scene.getStylesheets().add(stylesheetUrl.toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}