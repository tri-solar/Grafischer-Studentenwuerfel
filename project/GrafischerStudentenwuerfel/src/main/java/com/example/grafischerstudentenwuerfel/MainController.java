package com.example.grafischerstudentenwuerfel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void optionsPressed(ActionEvent actionEvent) {
    }
}