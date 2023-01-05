package org.example;

import java.io.File;
import java.util.Scanner;

public class WordCount {

    public static void main (String [] args) throws Exception {
        File file = new File ("The Adventures of Sherlock Holmes, by Arthur Conan Doyle.txt");
        Scanner scanner1 = new Scanner(file);

        int words =0;
        while(scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            words += line.split( " ").length;
        }
        System.out.println("The file contains: " + words + " words.");
    }
}
