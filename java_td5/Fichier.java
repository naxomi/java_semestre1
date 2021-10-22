package java_td5;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Fichier {

    private String nomFichier;
    private Random randGenerator = new Random();

    public Fichier(String inputNom) {
        this.nomFichier = inputNom;
    }

    public void aleatoire(int numberOfRand) {

        try {
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(this.nomFichier));
            for (int i = 0; i < numberOfRand; i++) {
                System.out.println(i + 1);
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
}
