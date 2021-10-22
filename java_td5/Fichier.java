package java_td5;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class Fichier {

    private String nomFichier;
    private Random randGenerator = new Random();

    public Fichier(String inputNom) {
        this.nomFichier = inputNom;
    }

    public void aleatoire(int numberOfRand) {

        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("").toAbsolutePath();
            String filePath = currentDirectoryPath.toString() + "/java_td5/" + this.nomFichier;
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 0; i < numberOfRand; i++) {
                System.out.println("i = " + (i + 1));
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

    }
}
