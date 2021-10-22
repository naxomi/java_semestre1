package java_td5;

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

    public static void question4() {
        Fichier fichier = new Fichier("fileQ4");
        fichier.aleatoire(5);
        System.out.println(fichier);
    }

    public static void main(String[] args) {
        question4();
    }
}
