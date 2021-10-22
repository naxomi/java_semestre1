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

    public static void question4(String[] inputArgs) {
        Fichier fichier = null;
        if (inputArgs.length == 0) {
            fichier = new Fichier("fileQ4");
        } else {
            fichier = new Fichier(inputArgs[0]);
        }
        fichier.aleatoire(100);
    }

    public static void question5_6() {
        Fichier fichier = new Fichier("fileQ5_6");
        fichier.aleatoire(10);
        System.out.println("Filecontent : " + fichier);
    }

    public static void main(String[] args) {
        question5_6();
    }
}
