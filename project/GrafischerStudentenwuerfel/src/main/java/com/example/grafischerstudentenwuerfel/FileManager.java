package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.ClassModel;
import com.example.grafischerstudentenwuerfel.model.StudentModel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManager {
    private static final String preferredDir = "H:/";
    private static final String defaultDir = System.getProperty("user.home");
    private static final String applicationDir = (Files.exists(Paths.get(defaultDir)) ? defaultDir : preferredDir) + "/studentenwuerfel";
    private static final Path classesDir = Paths.get(applicationDir + "/classes/");
    private static final Path optionsPath = Paths.get(applicationDir + "/options.json");
    private static final Path protocolsDir= Paths.get(applicationDir + "/protocols");

    public static void initialSetup() {
        System.out.println("Initialize FileManager");
        try {
            // Create application directory if not present
            Path applicationDirPath = Paths.get(applicationDir);
            if (Files.notExists(applicationDirPath)) {
                Files.createDirectory(applicationDirPath);
                System.out.println("Directory created: " + applicationDirPath);
            }

            // Create classes directory if not present
            if (Files.notExists(classesDir)) {
                Files.createDirectory(classesDir);
                System.out.println("Directory created: " + classesDir);
            }

            // Create protocol directory if not present
            if (Files.notExists(protocolsDir)) {
                Files.createDirectory(protocolsDir);
                System.out.println("Directory created: " + protocolsDir);
            }
        } catch (IOException e) {
            System.out.println("Error creating directories: " +e.getMessage());
        }
    }

    public static ArrayList<ClassModel> readClasses() {
        System.out.println("Read Classes");
        ArrayList<ClassModel> classes = new ArrayList<>();
        File classesDirectory = classesDir.toFile();
        File[] classFiles = classesDirectory.listFiles();

        for (File classFile : classFiles) {
            String className = classFile.getName().split("\\.")[0];
            ArrayList<StudentModel> students = new ArrayList<>();

            try {
                List<String> studentsLines = Files.readAllLines(classFile.toPath());
                // remove header line
                studentsLines.remove(0);
                for (String line : studentsLines) {
                    String firstname = line.split(",")[0];
                    String lastname = line.split(",")[1];
                    students.add(new StudentModel(firstname, lastname, className));
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            classes.add(new ClassModel(className, students));
        }
        return classes;
    }

    public static boolean writeProtocol (ArrayList<StudentModel> calledStudents) {
        Date today = new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateFormatted = dateFormat.format(today);

        String protocolName = String.format("%s.txt", dateFormatted);
        String protocolPath = protocolsDir + "/" + protocolName;

        String studentsString = "";
        for(StudentModel student : calledStudents) {
            studentsString += student + ",\n";
        }

        try {
            PrintWriter pw = new PrintWriter(protocolPath);
            pw.println(studentsString);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error writing protocol: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean writeOptions(boolean isStudentPerLesson, boolean isStudentInSuccession){
        String optionsJSON = String.format("{\"isStudentPerLesson\": %b, \"isStudentInSuccession\": %b}", isStudentPerLesson, isStudentInSuccession );

        try {
            PrintWriter pw = new PrintWriter(optionsPath.toString());
            pw.println(optionsJSON);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error writing options: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean[] readOptions() {
        boolean[] options = { false, false };
        String lines = "";
        try {
            lines = Files.readString(optionsPath);
            String[] linesSplit = lines.split(",");
            String perLessonOption = linesSplit[0];
            boolean perLessonValue = Boolean.parseBoolean(perLessonOption.split(":")[1].trim());

            String successionOption = linesSplit[1];
            boolean successionValue = Boolean.parseBoolean(successionOption.split(":")[1].trim());
            options[0] = perLessonValue;
            options[1] = successionValue;
        } catch (IOException e) {
            System.out.println("Error reading options: " + e.getMessage());
        }
        return options;
    }
}
