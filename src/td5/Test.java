package td5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void question3() {
        File file = new File("fileQ3");
        file.writeRandom(100);

        /*
         * Answer to question 3 : we can see that the file size is equal to 100*4 = 400
         * octets. Which mean that we have exactly created 100 random numbers, each with
         * 4 octets.
         */
    }

    public static void question4(String[] inputArgs) {
        File file;
        if (inputArgs.length == 0) {
            file = new File("fileQ4");
        } else {
            file = new File(inputArgs[0]);
        }
        file.writeRandom(100);
    }

    public static void question5_6() {
        File file = new File("fileQ5_6");
        file.writeRandom(10);
        System.out.println("File content : " + file);
    }

    public static void question7() {
        File file = new File("fileQ7");
        file.writeRandom(10);
        try {
            System.out.println("File content : " + file);
            System.out.println("Minimum number : " + file.getMin());
        } catch (IOException e) {
            System.out.println("Error : IOException. Problem while reading or writing file.");
        }
    }

    public static void question9() {
        Scanner sc;
        PrintWriter fileWriter;

        Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String inputFilePath = currentDirectoryPath + "/td5/studentMarks.txt";
        String outputFilePath = currentDirectoryPath + "/td5/studentAverage.txt";

        try {
            sc = new Scanner(new java.io.File(inputFilePath));
            fileWriter = new PrintWriter(new FileWriter(outputFilePath));

            double sumStudentsAverage = 0.0;
            int numOfStudentWithNotes = 0;

            while (sc.hasNextLine()) {
                // Gather data
                String line = sc.nextLine();
                String[] listedLine = line.split(" ");

                String surname = listedLine[0];
                String name = listedLine[1];

                int numberOfNotes = 0;
                double sumNotes = 0.0;
                double average = 0.0;

                if (listedLine.length == 2) {
                    fileWriter.write(surname + " " + name + " : abs\n");
                } else {
                    for (String notes : Arrays.copyOfRange(listedLine, 2, listedLine.length)) {
                        numberOfNotes += 1;
                        sumNotes += Float.parseFloat(notes);
                        average = Math.round(sumNotes / numberOfNotes * 100) / 100.0;
                    }
                    fileWriter.write(surname + " " + name + " : " + average + "\n");
                    numOfStudentWithNotes += 1;
                    sumStudentsAverage += average;
                }

            }
            if (numOfStudentWithNotes != 0) {
                double classAverage = Math.round(sumStudentsAverage / numOfStudentWithNotes * 100) / 100.0;
                fileWriter.write("\nClass average : " + classAverage + "\n");
            } else {
                fileWriter.write("\n Class average : None");
            }

            sc.close();
            fileWriter.close();

        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        question9();
    }
}
