package Personne;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperation {

    public static boolean readFile(String filename, ArrayList<String> people) {
        if (filename == null || people == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        Scanner scanner;
        File file = new File(filename);
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
            } else
                return false;
        } catch (FileNotFoundException e) {
            System.out.println("Can not open" + filename);
            return false;
        }

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            for (String word : line.split(";")){
                people.add(word);
            }
        }
        return true;
    }
}
