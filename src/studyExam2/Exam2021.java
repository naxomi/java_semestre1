package studyExam2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class Exam2021 {
    private final String fileName;
    private final Random random = new Random();

    public Exam2021(String fileName) {
        this.fileName = fileName;
    }

    public int generateSorted(int n) {
        Integer nbIntFound = 0;
        Integer lastNbFound = -1;
        DataOutputStream os = null;

        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath + "/src/studyExam2/" + this.fileName;

            os = new DataOutputStream(new FileOutputStream(filePath));

            while (nbIntFound < n) {
                int randNb = random.nextInt(100);
                Boolean value = randNb > lastNbFound;
                System.out.println(randNb + value.toString());
                if (randNb > lastNbFound) {
                    os.writeInt(randNb);
                    nbIntFound++;
                    lastNbFound = randNb;
                }
                if (randNb == 99) {
                    break;
                }
            }
        } catch (FileNotFoundException errFNF) {
            System.err.println("File not found.");
            errFNF.printStackTrace();
        } catch (IOException errIO) {
            System.err.println("Error while reading or writing file");
            errIO.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException errIO) {
                    System.err.println("Could not close file");
                    errIO.printStackTrace();
                }
            }
        }
        return nbIntFound;
    }
}
