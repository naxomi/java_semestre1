package td5;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class File {

    private final String fileName;
    private final Random random = new Random();

    private static final String FOLDER_TO_SAVE_IN = "/td5/";

    public File(String inputNom) {
        this.fileName = inputNom;
    }

    public void writeRandom(int numberOfRand) {

        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath + FOLDER_TO_SAVE_IN + this.fileName;
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < numberOfRand; i++) {
                dataOut.writeInt(random.nextInt(100));
            }
            dataOut.close();
        } catch (FileNotFoundException error) {
            System.err.println("Error with the file name.");
            error.printStackTrace();
        } catch (IOException error) {
            System.err.println("Error while writing the integer or closing the file.");
            error.printStackTrace();
        }
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath + FOLDER_TO_SAVE_IN + this.fileName;
            DataInputStream dataIn = new DataInputStream(new FileInputStream(filePath));

            boolean endNotReached = true;
            while (Boolean.TRUE.equals(endNotReached)) {
                try {
                    int readNumber = dataIn.readInt();
                    strBuilder.append(readNumber).append("_");
                } catch (EOFException error) {
                    strBuilder.deleteCharAt(strBuilder.length() - 1);
                    endNotReached = false;
                    dataIn.close();
                }
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found.");
        } catch (IOException error) {
            System.err.println("Error : IOException");
        }
        return strBuilder.toString();
    }

    public Integer getMin() throws IOException {

        int minNumber = 2147483647; // Largest int handled by Java

        Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String filePath = currentDirectoryPath + FOLDER_TO_SAVE_IN + this.fileName;
        DataInputStream dataIn = new DataInputStream(new FileInputStream(filePath));

        boolean endNotReached = true;
        while (Boolean.TRUE.equals(endNotReached)) {
            try {
                int readNumber = dataIn.readInt();
                if (readNumber < minNumber) {
                    minNumber = readNumber;
                }
            } catch (EOFException error) {
                endNotReached = false;
                dataIn.close();
            }
        }
        return minNumber;
    }
}
