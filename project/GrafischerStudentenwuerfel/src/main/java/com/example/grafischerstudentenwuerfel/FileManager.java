package com.example.grafischerstudentenwuerfel;

import com.example.grafischerstudentenwuerfel.model.ClassModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static String applicationDir = System.getProperty("user.home") + "/studentenwuerfel";
    private static Path classesPath = Paths.get(applicationDir + "/classes/");
    private static Path optionsPath = Paths.get(applicationDir + "/options.json");
    private static Path protocolPath = Paths.get(applicationDir + "/protocol.txt");

    public static void initialSetup() {
        try {
            // Create application directory if not present
            Path applicationDirPath = Paths.get(applicationDir);
            if (Files.notExists(applicationDirPath)) {
                Files.createDirectory(applicationDirPath);
            }

            // Create classes directory if not present
            if (Files.notExists(classesPath)) {
                Files.createDirectory(classesPath);
            }
        } catch (IOException e) {
            System.out.println("Error creating directories: " +e.getMessage());
        }
    }

    public static ArrayList<ClassModel> readClasses() {
        ArrayList<ClassModel> classes = new ArrayList<>();
        File classesDirectory = classesPath.toFile();
        File[] classFiles = classesDirectory.listFiles();

        for (File classFile : classFiles) {
            try {
                List<String> classLines = Files.readAllLines(classFile.toPath());
                for (String line : classLines) {

                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }

}
