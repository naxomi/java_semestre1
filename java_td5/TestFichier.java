package java_td5;

public class TestFichier {

    public static void question3_4() {
        Fichier fichier = new Fichier("fileQ3");
        fichier.aleatoire(100);

        /*
         * Answer to question 4 : we can see that the file size is equal to 100*4 = 400
         * octets. Which mean that we have exactly created 100 random numbers, each with
         * 4 octets.
         */
    }

    public static void main(String[] args) {
        question3_4();
    }
}
