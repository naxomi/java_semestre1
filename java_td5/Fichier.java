package java_td5;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.util.Random;

public class Fichier {

    private String nomFichier;
    private Random randGenerator = new Random();

    private static final String FOLDER_TO_SAVE_IN = "/java_td5/";

    public Fichier(String inputNom) {
        this.nomFichier = inputNom;
    }

    public void aleatoire(int numberOfRand) {

        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath.toString() + FOLDER_TO_SAVE_IN + this.nomFichier;
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < numberOfRand; i++) {
                dataOut.writeInt(randGenerator.nextInt(100));
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
            String filePath = currentDirectoryPath.toString() + FOLDER_TO_SAVE_IN + this.nomFichier;
            DataInputStream dataIn = new DataInputStream(new FileInputStream(filePath));

            Boolean endNotReached = true;
            while (Boolean.TRUE.equals(endNotReached)) {
                try {
                    Integer readNumber = dataIn.readInt();
                    strBuilder.append(Integer.toString(readNumber) + "_");
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

    public Integer min() throws IOException {

        Integer minNumber = 2147483647; // Largest int handled by Java

        Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
        String filePath = currentDirectoryPath.toString() + FOLDER_TO_SAVE_IN + this.nomFichier;
        DataInputStream dataIn = new DataInputStream(new FileInputStream(filePath));

        Boolean endNotReached = true;
        while (Boolean.TRUE.equals(endNotReached)) {
            try {
                Integer readNumber = dataIn.readInt();
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
