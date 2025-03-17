package com.example.grafischerstudentenwuerfel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OptionsController {

    @FXML
    CheckBox checkOne, checkTwo;

    @FXML
    Label pickedFileLabel, saveMessageLabel;

    @FXML
    Button saveButton;

    public void initialize() {
        System.out.println("Initialize OptionsController");
    }

    @FXML
    public void pickFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Dateien", "*.csv"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Alle Dateien", "*.*"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) { // placeholder logik
            pickedFileLabel.setText(file.getName());
        }
    }

    @FXML
    public void saveOptionsButton(ActionEvent actionEvent) {
        saveMessageLabel.setText("Optionen gespeichert!");
    }

    @FXML
    public void optionOneSelected(ActionEvent actionEvent) {
        if (checkOne.isSelected() && !checkTwo.isSelected()) {
            checkTwo.setSelected(true);
        }
    }

    @FXML
    public void optionTwoSelected(ActionEvent actionEvent) {
        if (checkOne.isSelected()) {
            checkTwo.setSelected(true);
        }
    }
}
