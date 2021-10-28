package td3;

import PaD.*;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Game52 lesCartes = new Game52();
        PlancheADessin gameWindow = new PlancheADessin(Card.WIDTH_IMG * 13, Card.LENGTH_IMG * 4 + 30, true);

        while (true) {

            System.out.println(
                    "Que voulez-vous faire ? " +
                            "\n 1 : Montrer les cartes dans leur état actuel " +
                            "\n 2 : Melanger les cartes " +
                            "\n 3 : Ordonner les cartes " +
                            "\n 4 : Retourner toutes les cartes " +
                            "\n 0 : Quitter la boucle d'input");

            Scanner userInputScanner = new Scanner(System.in);
            int userInput = userInputScanner.nextInt();

            if (userInput == 1) {
                lesCartes.draw(gameWindow);
            }

            else if (userInput == 2) {
                lesCartes.mixCards();
                System.out.println("Les cartes ont ete melangees");
                lesCartes.draw(gameWindow);
            }

            else if (userInput == 3) {
                lesCartes.organize();
                System.out.println("Les cartes ont ete ordonnees");
                lesCartes.draw(gameWindow);
            }

            else if (userInput == 4) {
                lesCartes.returnEveryCard(gameWindow);
                System.out.println("Les cartes ont ete ordonnees");
                lesCartes.draw(gameWindow);
            }

            else if (userInput == 0) {
                System.out.println("La boucle d'input est finie");
                break;
            } else {
                System.out.println("Entrez une valeur valide");
            }
        }
    }
}
