package com.example.grafischerstudentenwuerfel.model;

import java.util.ArrayList;

public class ClassModel {
    private ArrayList<StudentModel> students;
    private String classname;

    public ClassModel(String classname, ArrayList<StudentModel> students) {
        this.students = students;
        this.classname = classname;
    }

    public ArrayList<StudentModel> getStudents() {
        return students;
    }

    public String getClassname() {
        return classname;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", classname, students);
    }
}
