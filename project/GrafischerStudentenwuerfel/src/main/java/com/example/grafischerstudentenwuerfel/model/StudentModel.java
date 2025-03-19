package com.example.grafischerstudentenwuerfel.model;

import java.util.Objects;

public class StudentModel implements Comparable<StudentModel> {
    private String firstname;
    private String lastname;
    // redundant information for easier identification, fix later
    private String classname;

    public StudentModel(String firstname, String lastname, String classname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.classname = classname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return String.format("%s / %s %s", classname, firstname, lastname);
    }

    @Override
    public int compareTo(StudentModel o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.lastname, o.lastname);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;

        StudentModel o = (StudentModel) obj;
        return Objects.equals(firstname, o.firstname) &&
                Objects.equals(lastname, o.lastname) &&
                Objects.equals(classname, o.classname);
    }
}
