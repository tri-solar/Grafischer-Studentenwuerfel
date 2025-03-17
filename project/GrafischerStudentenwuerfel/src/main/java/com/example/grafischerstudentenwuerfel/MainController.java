package com.example.grafischerstudentenwuerfel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainController {

    @FXML
    private ComboBox classBoxOne, classBoxTwo, classBoxThree;

    @FXML
    private Label studentCountOne, studentCountTwo, studentCountThree, studentNameText;

    @FXML
    private Button optionsButton, rollDiceButton, addStudentButton;

    @FXML
    private TextField addStudentText;


    public void initialize() {
        System.out.println("Initialize MainController");
    }

    @FXML
    public void addStudent(ActionEvent actionEvent) {
    }

    @FXML
    public void rollDice(ActionEvent actionEvent) {
    }

    @FXML
    public void optionsPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("options-view.fxml"));
        Scene optionsScene = new Scene(loader.load(), 500, 320);
        URL stylesheetUrl = Objects.requireNonNull(getClass().getResource("style.css"));
        optionsScene.getStylesheets().add(stylesheetUrl.toExternalForm());

        Stage optionsStage = new Stage();
        optionsStage.initModality(Modality.APPLICATION_MODAL);
        optionsStage.setResizable(false);
        optionsStage.setTitle("Optionen");
        optionsStage.setScene(optionsScene);

        optionsStage.showAndWait();
    }
}