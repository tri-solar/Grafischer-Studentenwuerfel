package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.ClassModel;
import com.example.grafischerstudentenwuerfel.model.StudentModel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManager {
    private static String applicationDir = System.getProperty("user.home") + "/studentenwuerfel";
    private static Path classesDir = Paths.get(applicationDir + "/classes/");
    private static Path optionsPath = Paths.get(applicationDir + "/options.json");
    private static Path protocolsDir= Paths.get(applicationDir + "/protocols");

    public static void initialSetup() {
        try {
            // Create application directory if not present
            Path applicationDirPath = Paths.get(applicationDir);
            if (Files.notExists(applicationDirPath)) {
                Files.createDirectory(applicationDirPath);
            }

            // Create classes directory if not present
            if (Files.notExists(classesDir)) {
                Files.createDirectory(classesDir);
            }

            // Create protocol directory if not present
            if (Files.notExists(protocolsDir)) {
                Files.createDirectory(protocolsDir);
            }
        } catch (IOException e) {
            System.out.println("Error creating directories: " +e.getMessage());
        }
    }

    public static ArrayList<ClassModel> readClasses() {
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
        DateFormat timeFormat = new SimpleDateFormat("HH");

        String dateFormatted = dateFormat.format(today);
        String timeFormatted = timeFormat.format(today);

        String protocolName = String.format("%s-%s.txt", dateFormatted, timeFormatted);
        String protocolPath = protocolsDir.toString() + "/" + protocolName;

        String studentsJSON = "{\"students\": [";
        for(StudentModel student : calledStudents) {
            studentsJSON += student.toJSONString() + ",";
        }
        studentsJSON = studentsJSON.substring(0, studentsJSON.length() - 1);
        studentsJSON += "]}";

        try {
            PrintWriter pw = new PrintWriter(protocolPath);
            pw.println(studentsJSON);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error writing protocol: " + e.getMessage());
            return false;
        }
        return true;
    }
}
