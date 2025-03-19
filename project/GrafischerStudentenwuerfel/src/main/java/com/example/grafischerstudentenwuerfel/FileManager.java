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
    private static final String PREFERRED_DIR = "H:/";
    private static final String DEFAULT_DIR = System.getProperty("user.home");
    private static final String APPLICATION_DIR = (Files.exists(Paths.get(DEFAULT_DIR)) ? DEFAULT_DIR : PREFERRED_DIR) + "/studentenwuerfel";
    private static final Path CLASSES_DIR = Paths.get(APPLICATION_DIR + "/classes/");
    private static final Path OPTIONS_PATH = Paths.get(APPLICATION_DIR + "/options.json");
    private static final Path PROTOCOLS_DIR = Paths.get(APPLICATION_DIR + "/protocols");

    public static void copyFile(File file)  {
        try {
            Path sourceDir = Path.of(file.getAbsolutePath());
            Path destDir = Path.of(CLASSES_DIR + "\\" + file.getName());
            Files.copy(sourceDir, destDir);
        } catch (IOException e) {
            System.out.println("Error copying class: " +e.getMessage());
        }

    }

    public static void initialSetup() {
        System.out.println("Initialize FileManager");
        try {
            // Create application directory if not present
            Path applicationDirPath = Paths.get(APPLICATION_DIR);
            if (Files.notExists(applicationDirPath)) {
                Files.createDirectory(applicationDirPath);
                System.out.println("Directory created: " + applicationDirPath);
            }

            // Create classes directory if not present
            if (Files.notExists(CLASSES_DIR)) {
                Files.createDirectory(CLASSES_DIR);
                System.out.println("Directory created: " + CLASSES_DIR);
            }

            // Create protocol directory if not present
            if (Files.notExists(PROTOCOLS_DIR)) {
                Files.createDirectory(PROTOCOLS_DIR);
                System.out.println("Directory created: " + PROTOCOLS_DIR);
            }
        } catch (IOException e) {
            System.out.println("Error creating directories: " +e.getMessage());
        }
    }

    public static ArrayList<ClassModel> readClasses() {
        ArrayList<ClassModel> classes = new ArrayList<>();
        File classesDirectory = CLASSES_DIR.toFile();
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
        String protocolPath = PROTOCOLS_DIR + "/" + protocolName;

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

    public static void writeOptions(){
        boolean isStudentPerLesson = Rules.IsStudentPerLessonRule.isActive();
        boolean isStudentInSuccession = Rules.IsStudentInSuccessionRule.isActive();

        String optionsJSON = String.format("{\"isStudentPerLesson\": %b, \"isStudentInSuccession\": %b}", isStudentPerLesson, isStudentInSuccession );

        try {
            PrintWriter pw = new PrintWriter(OPTIONS_PATH.toString());
            pw.println(optionsJSON);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error writing options: " + e.getMessage());
        }
    }

    public static void readOptions() {
        boolean[] options = { false, false };
        String lines = "";
        try {
            lines = Files.readString(OPTIONS_PATH);

            lines = lines.replace("{", "");
            lines = lines.replace("}", "");
            lines = lines.replace("[", "");
            lines = lines.replace("}", "");

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

        Rules.IsStudentPerLessonRule.setActive(options[0]);
        Rules.IsStudentInSuccessionRule.setActive(options[1]);
    }
}
