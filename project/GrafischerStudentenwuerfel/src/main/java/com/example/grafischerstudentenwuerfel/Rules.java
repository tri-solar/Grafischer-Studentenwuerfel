package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.StudentModel;

import java.util.ArrayList;

public class Rules  {
    public static class IsStudentPerLessonRule{
        private static boolean isActive = false;
        public static void setActive(boolean active) { isActive = active; }
        public static boolean isActive() { return isActive; }
        public static boolean isAdhered (StudentModel student, ArrayList<StudentModel> selectedStudents) {
            if (!isActive) return true;
            return !selectedStudents.contains(student);
        }
    }

    public static class IsStudentInSuccessionRule {
        private static boolean isActive = false;
        public static void setActive(boolean active) { isActive = active; }
        public static boolean isActive() { return isActive; }

        public static boolean isAdhered(StudentModel student, StudentModel lastStudent) {
            if (!isActive || lastStudent == null) return true;
            return !student.equals(lastStudent);
        }
    }
}
