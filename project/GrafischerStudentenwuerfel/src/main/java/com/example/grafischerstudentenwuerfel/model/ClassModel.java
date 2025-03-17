package com.example.grafischerstudentenwuerfel.model;

public class ClassModel {
    private StudentModel [] students;
    private String classname;

    public ClassModel(StudentModel [] students, String classname) {
        this.students = students;
        this.classname = classname;
    }
}
