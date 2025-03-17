package com.example.grafischerstudentenwuerfel.model;

import java.util.ArrayList;

public class ClassModel {
    private ArrayList<StudentModel> students;
    private String classname;

    public ClassModel(String classname, ArrayList<StudentModel> students) {
        this.students = students;
        this.classname = classname;
    }

    public String toJSONString() {
        String studentsJSON = "";
        for(StudentModel student : students) {
            studentsJSON += student.toJSONString() + ",";
        }
        // Remove last ,
        studentsJSON = studentsJSON.substring(0, studentsJSON.length() - 1);
        return String.format("{\"classname\": \"%s\", \"students\": [%s]}", classname, studentsJSON);
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
