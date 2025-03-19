package com.example.grafischerstudentenwuerfel;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OptionsController {

    @FXML
    private CheckBox checkOne, checkTwo;

    @FXML
    private Label pickedFileLabel;

    public void initialize() {
        System.out.println("Initialize OptionsController");
    }

    @FXML
    public void pickFile(ActionEvent actionEvent)  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Dateien", "*.csv"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) { // placeholder logik
            pickedFileLabel.setText(file.getName());
            FileManager.copyFile(file);
        }
    }

    @FXML
    public void saveOptionsButton(ActionEvent actionEvent) {
        System.out.println("Saved");
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
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

    @FXML
    public void addClassButton(ActionEvent actionEvent) {
        if (pickedFileLabel.getText().equals("") || pickedFileLabel.getText().equals("Klasse hinzugefügt!") ) {
            pickedFileLabel.setText("");
            return;
        }
        pickedFileLabel.setText("Klasse hinzugefügt!");
    }
}
