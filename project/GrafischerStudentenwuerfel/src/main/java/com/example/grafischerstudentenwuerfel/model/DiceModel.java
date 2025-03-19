package com.example.grafischerstudentenwuerfel.model;

import java.util.ArrayList;
import java.util.Random;

public class DiceModel {
    private ArrayList<StudentModel> students;
    private final Random RN;

    public DiceModel(ArrayList<StudentModel> firstSelection, ArrayList<StudentModel> secondSelection, ArrayList<StudentModel> thirdSelection) {
        setStudents(firstSelection, secondSelection, thirdSelection);
        this.RN = new Random();
    }

    public ArrayList<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentModel> firstSelection, ArrayList<StudentModel> secondSelection, ArrayList<StudentModel> thirdSelection) {
        this.students = new ArrayList<>();
        if (!(firstSelection == null)) {
            this.students.addAll(firstSelection);
        }
        if (!(secondSelection == null)) {
            this.students.addAll(secondSelection);
        }
        if (!(thirdSelection == null)) {
            this.students.addAll(thirdSelection);
        }
    }

    public StudentModel rollDice() {
        return this.students.get(RN.nextInt(0, this.students.size()));
    }
}
