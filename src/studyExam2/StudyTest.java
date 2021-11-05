package studyExam2;

import java.io.IOException;

public class StudyTest {
    public static void main(String[] args) {
        String fileName;
        if (args.length == 0) {
            fileName = "imStudying";
        } else {
            fileName = args[0];
        }
        StudyFile file = new StudyFile(fileName);
        file.writeRandomNumber(10);
        System.out.println(file);
        try {
            System.out.println(file.min());
        } catch (IOException err) {
            System.err.println("Error while reading or opening the file");
            err.printStackTrace();
        }
    }
}