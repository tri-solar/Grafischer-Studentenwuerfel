package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.ClassModel;
import com.example.grafischerstudentenwuerfel.model.DiceModel;
import com.example.grafischerstudentenwuerfel.model.StudentModel;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class MainController {

    @FXML
    private ComboBox<String> classBoxOne, classBoxTwo, classBoxThree;

    @FXML
    private Label studentCountOne, studentCountTwo, studentCountThree, studentNameText;

    @FXML
    private Button optionsButton, rollDiceButton, addStudentButton;

    @FXML
    private TextField addStudentText;

    public ObservableList<String> classList;

    ArrayList<ClassModel> classes = FileManager.readClasses();
    ArrayList<StudentModel> calledStudents = new ArrayList<>();
    DiceModel dice;

    public void initialize() {
        System.out.println("Initialize MainController");
        FileManager.initialSetup();
        generateClasses();
    }

    public void generateClasses() {
        classes = FileManager.readClasses();
        classList = FXCollections.observableArrayList();
        classList.add("Keine Klasse");
        for (ClassModel aClass : classes) {
            classList.add(aClass.getClassname());
        }
        classBoxOne.setItems(classList);
        classBoxTwo.setItems(classList);
        classBoxThree.setItems(classList);
        classBoxOne.setValue(classList.get(0));
        classBoxTwo.setValue(classList.get(0));
        classBoxThree.setValue(classList.get(0));
        dice = new DiceModel(getStudentModel(classBoxOne),
                getStudentModel(classBoxTwo),
                getStudentModel(classBoxThree));
    }

    @FXML
    public void addStudent(ActionEvent actionEvent) {
        String newStudentName = addStudentText.getText();
        System.out.println(newStudentName);
        StudentModel newStudent = new StudentModel(
                "", newStudentName, "Manuell hinzugefügt");
        calledStudents.add(newStudent);
        FileManager.writeProtocol(calledStudents);
    }

    @FXML
    public void rollDice(ActionEvent actionEvent) {
        if (dice.getStudents().isEmpty()) {
            return;
        }

        StudentModel randomStudent = dice.rollDice();
        System.out.println(randomStudent);
        studentNameText.setText(randomStudent.getFirstname() +
                " " + randomStudent.getLastname());
        calledStudents.add(randomStudent);
        FileManager.writeProtocol(calledStudents);
    }

    @FXML
    public void optionsPressed(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("options-view.fxml"));
        Scene optionsScene = new Scene(loader.load(), 500, 360);
        URL stylesheetUrl = Objects.requireNonNull(getClass().getResource("style.css"));
        optionsScene.getStylesheets().add(stylesheetUrl.toExternalForm());

        Stage optionsStage = new Stage();
        optionsStage.initModality(Modality.APPLICATION_MODAL);
        optionsStage.setResizable(false);
        optionsStage.setTitle("Optionen");
        optionsStage.setScene(optionsScene);
        optionsStage.setOnCloseRequest(event -> {
            generateClasses();
        });
        optionsStage.showAndWait();
    }

    public void updateStudentCount(ActionEvent actionEvent) {
        dice.setStudents(getStudentModel(classBoxOne),
                getStudentModel(classBoxTwo),
                getStudentModel(classBoxThree));
        countStudents(classBoxOne, studentCountOne);
        countStudents(classBoxTwo, studentCountTwo);
        countStudents(classBoxThree, studentCountThree);
    }

    private ArrayList<StudentModel> getStudentModel(ComboBox classBox) {
        if (classBox.getValue().equals("Keine Klasse")) {
            return null;
        }

        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getClassname().equals(classBox.getValue())) {
                return classes.get(i).getStudents();
            }
        }
        return null;
    }

    private void countStudents(ComboBox<String> classBox, Label studentCount) {
        if (classBox.getValue() == null || classBox.getValue().equals("Keine Klasse")) {
            studentCount.setText("00");
            return;
        }

        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getClassname().equals(classBox.getValue())) {
                String countStr = String.valueOf(classes.get(i).getStudents().size());
                countStr = String.format("%2s", countStr);
                countStr = countStr.replaceAll(" ", "0");
                studentCount.setText(countStr);
            }
        }
    }
}