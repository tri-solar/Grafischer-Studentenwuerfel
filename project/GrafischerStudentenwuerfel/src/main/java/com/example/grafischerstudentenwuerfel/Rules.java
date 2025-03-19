package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.StudentModel;

import java.util.ArrayList;

public class Rules  {

    private static abstract class RuleFactory {
        // Overloaded method to check if the rule is adhered
        // Must Override one in child
        protected boolean isAdhered (StudentModel student, StudentModel lastStudent){ throw new IllegalArgumentException();};
        protected boolean isAdhered (StudentModel student, ArrayList<StudentModel> selectedStudents){ throw new IllegalArgumentException();};
    }

    public static class IsStudentPerLessonRule extends RuleFactory {
        @Override
        public boolean isAdhered (StudentModel student, ArrayList<StudentModel> selectedStudents) {
            return !selectedStudents.contains(student);
        }
    }

    public static class IsStudentInSuccessionRule extends RuleFactory {
        @Override
        protected boolean isAdhered(StudentModel student, StudentModel lastStudent) {
            return !student.equals(lastStudent);
        }
    }
}
