package com.example.grafischerstudentenwuerfel.model;

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

    // Unused right now, for later use
    public String toJSONString() {
        return String.format("{\"firstname\": \"%s\", \"lastname\": \"%s\", \"classname\": \"%s\"}", firstname, lastname, classname);
    }

    @Override
    public String toString() {
        return String.format("%s / %s %s", classname, firstname, lastname);
    }

    @Override
    public int compareTo(StudentModel o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.lastname, o.lastname);
    }
}
