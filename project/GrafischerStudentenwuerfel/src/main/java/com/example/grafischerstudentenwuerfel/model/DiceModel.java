package com.example.grafischerstudentenwuerfel.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DiceModel {
    private ArrayList<StudentModel> students;
    private Random rn;

    DiceModel(StudentModel [] firstSelection, StudentModel [] secondSelection, StudentModel [] thirdSelection) {
        this.students = new ArrayList<>();
        this.students.addAll(Arrays.asList(firstSelection));
        this.students.addAll(Arrays.asList(secondSelection));
        this.students.addAll(Arrays.asList(thirdSelection));

        this.rn = new Random();
    }
}
