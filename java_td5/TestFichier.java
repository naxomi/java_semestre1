package java_td5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class TestFichier {

    public static void question3() {
        Fichier fichier = new Fichier("fileQ3");
        fichier.aleatoire(100);

        /*
         * Answer to question 3 : we can see that the file size is equal to 100*4 = 400
         * octets. Which mean that we have exactly created 100 random numbers, each with
         * 4 octets.
         */
    }

    public static void question4(String[] inputArgs) {
        Fichier fichier = null;
        if (inputArgs.length == 0) {
            fichier = new Fichier("fileQ4");
        } else {
            fichier = new Fichier(inputArgs[0]);
        }
        fichier.aleatoire(100);
    }

    public static void question5_6() {
        Fichier fichier = new Fichier("fileQ5_6");
        fichier.aleatoire(10);
        System.out.println("Filecontent : " + fichier);
    }

    public static void question7() {
        Fichier fichier = new Fichier("fileQ7");
        fichier.aleatoire(10);
        try {
            System.out.println("Filecontent : " + fichier);
            System.out.println("Minimum number : " + fichier.min());
        } catch (IOException e) {
            System.out.println("Error : IOException. Problem while reading or writing file.");
        }
    }

    public static void question8() {
        Scanner sc = null;
        PrintWriter prWriter = null;

        Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String inputFilePath = currentDirectoryPath.toString() + "/java_td5/studentMarks.txt";
        String outputFilePath = currentDirectoryPath.toString() + "/java_td5/studentAverage.txt";

        try {
            sc = new Scanner(new File(inputFilePath));
            prWriter = new PrintWriter(new FileWriter(outputFilePath));

            System.out.println("-".repeat(10));

            Double sumStudentsAverage = 0.0;
            Integer numOfStudentWithNotes = 0;

            while (sc.hasNextLine()) {
                // Gather data
                String line = sc.nextLine();
                String[] listedLine = line.split(" ");

                String surname = listedLine[0];
                String name = listedLine[1];

                Integer numberOfNotes = 0;
                Double sumNotes = 0.0;
                Double average = 0.0;

                if (listedLine.length == 2) {
                    // Export data
                    System.out.println(surname + " " + name + " : abs");
                } else {
                    for (String notes : Arrays.copyOfRange(listedLine, 2, listedLine.length)) {
                        numberOfNotes += 1;
                        sumNotes += Float.valueOf(notes);
                        average = Math.round(sumNotes / numberOfNotes * 100) / 100.0;
                    }
                    // Export data
                    System.out.println(surname + " " + name + " : " + average);
                    numOfStudentWithNotes += 1;
                    sumStudentsAverage += average;
                }

            }

            Double classAverage = Math.round(sumStudentsAverage / numOfStudentWithNotes * 100) / 100.0;
            System.out.println("-".repeat(10));
            System.out.println("Class average : " + classAverage);
            sc.close();
            prWriter.close();

        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        question8();
    }
}
