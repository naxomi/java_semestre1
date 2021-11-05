package studyExam2.TDs;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class StudyFile {
    private final String fileName;
    private final Random random = new Random();

    public StudyFile(String fileName) {
        this.fileName = fileName;
    }

    public void writeRandomNumber(int n) {
        DataOutputStream os = null;
        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath + "/src/studyExam2/" + this.fileName;

            os = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < n; i++) {
                int randNumber = random.nextInt(100);
                os.writeInt(randNumber);
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found exception");
        } catch (IOException error) {
            System.err.println("Some kind of IOException");
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException error) {
                System.err.println("Can't close the file");
            }
        }
    }

    public String toString() {
        DataInputStream is = null;
        String fileText = "";
        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath + "/src/studyExam2/" + this.fileName;

            is = new DataInputStream(new FileInputStream(filePath));
            while (true) {
                fileText += is.readInt();
            }
        } catch (EOFException error) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException errorIOF) {
                    System.err.println("Can't close the file");
                    errorIOF.printStackTrace();
                }
            }
        } catch (FileNotFoundException errorFNF) {
            System.err.println("File not found error.");
            errorFNF.printStackTrace();
        } catch (IOException errorIO) {
            System.err.println("Error while writing or reading the file");
            errorIO.printStackTrace();
        }
        return fileText;
    }

    public int min() throws IOException {
        int min = Integer.MAX_VALUE;
        DataInputStream is = null;

        Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String filePath = currentDirectoryPath + "/src/studyExam2/" + this.fileName;

        is = new DataInputStream(new FileInputStream(filePath));

        try {
            while (true) {
                int readNumber = is.readInt();
                if (readNumber < min) {
                    min = readNumber;
                }
            }
        } catch (EOFException errorEOF) {
            is.close();
        }

        return min;
    }
}