package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.ClassModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    public ObservableList classList;

    ArrayList<ClassModel> classes = FileManager.readClasses();


    public void initialize() {
        System.out.println("Initialize MainController");
        classList = FXCollections.observableArrayList();

        FileManager.initialSetup();
        classList.add("Keine Klasse");
        for (int i = 0; i < classes.size(); i++) {
            classList.add(classes.get(i).getClassname());
        }
        classBoxOne.setItems(classList);
        classBoxTwo.setItems(classList);
        classBoxThree.setItems(classList);
        classBoxOne.setValue(classList.get(0));
        classBoxTwo.setValue(classList.get(0));
        classBoxThree.setValue(classList.get(0));
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

    public void updateStudenCount(ActionEvent actionEvent) {
        countStudents(classBoxOne, studentCountOne);
        countStudents(classBoxTwo, studentCountTwo);
        countStudents(classBoxThree, studentCountThree);
    }

    private void countStudents(ComboBox classBox, Label studentCount) {
        if (!classBox.getValue().equals("Keine Klasse")) {
            for (int i = 0; i < classes.size(); i++) {
                if (classes.get(i).getClassname().equals(classBox.getValue())) {
                    studentCount.setText(String.valueOf(classes.get(i).getStudents().size()));
                }
            }
        } else {
            studentCount.setText("00");
        }
    }
}