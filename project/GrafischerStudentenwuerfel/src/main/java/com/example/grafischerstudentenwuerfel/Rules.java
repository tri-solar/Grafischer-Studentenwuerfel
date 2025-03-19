package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.StudentModel;

import java.util.ArrayList;

public class Rules  {
    private static class Rule {
        protected boolean isActive = false;
        public void setActive(boolean active) { isActive = active; }
        public boolean isActive() { return isActive; }

        // Overloaded method to check if the rule is adhered
        // Must Override one in child
        protected boolean isAdhered (StudentModel student, StudentModel lastStudent){ throw new IllegalArgumentException();};
        protected boolean isAdhered (StudentModel student, ArrayList<StudentModel> selectedStudents){ throw new IllegalArgumentException();};
    }

    public static class IsStudentPerLessonRule extends Rule {
        public IsStudentPerLessonRule() {}

        @Override
        public boolean isAdhered (StudentModel student, ArrayList<StudentModel> selectedStudents) {
            if (!isActive) return true;
            return !selectedStudents.contains(student);
        }
    }

    public static class IsStudentInSuccessionRule extends Rule {
        public IsStudentInSuccessionRule() {}
        @Override
        protected boolean isAdhered(StudentModel student, StudentModel lastStudent) {
            if (!isActive) return true;
            return !student.equals(lastStudent);
        }
    }
}
