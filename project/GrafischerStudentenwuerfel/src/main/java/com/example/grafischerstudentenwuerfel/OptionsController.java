package com.example.grafischerstudentenwuerfel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OptionsController {

    @FXML
    private CheckBox checkOne, checkTwo;

    @FXML
     private Label pickedFileLabel;

    public void initialize() {
        System.out.println("Initialize OptionsController");
        checkOne.setSelected(Rules.IsStudentPerLessonRule.isActive());
        checkTwo.setSelected(Rules.IsStudentInSuccessionRule.isActive());
    }

    @FXML
    public void pickFile(ActionEvent actionEvent)  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Dateien", "*.csv"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) { // placeholder logic
            pickedFileLabel.setText(file.getName());
            FileManager.copyFile(file);
        }
    }

    @FXML
    public void saveOptions(ActionEvent actionEvent) {
        Rules.IsStudentPerLessonRule.setActive(checkOne.isSelected());
        Rules.IsStudentInSuccessionRule.setActive(checkTwo.isSelected());

        FileManager.writeOptions();
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
    public void addClass(ActionEvent actionEvent) {
        if (pickedFileLabel.getText().equals("") || pickedFileLabel.getText().equals("Klasse hinzugefügt!") ) {
            pickedFileLabel.setText("");
            return;
        }
        pickedFileLabel.setText("Klasse hinzugefügt!");
    }
}
