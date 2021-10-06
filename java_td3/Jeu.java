package java_td3;
import PaD.*;

import java.util.Scanner;

public class Jeu {

    public static void displayCards(Jeu52 lesCartes, PlancheADessin fenetreJeu) {
        double y = 15;
        for (int i = 0; i < 52; i++) {

            if ((i != 0) && (i % 13 == 0)) {
                y += Carte.LONGUEUR_IMG;
            }
            Dessinable dessinCarte = lesCartes.getJeu()[i].getImg();
            fenetreJeu.ajouter(dessinCarte);
            double x = (i % 13) * Double.valueOf(Carte.LARGEUR_IMG);
            fenetreJeu.déplacer(dessinCarte, x, y);
        }
    }
    public static void main(String[] args) {
        
        Jeu52 lesCartes = new Jeu52();
        PlancheADessin fenetreJeu = new PlancheADessin(Carte.LARGEUR_IMG * 13, Carte.LONGUEUR_IMG * 4 + 30, true);
    
        while (true) {

            System.out.println("Que voulez-vous faire ? \n 1 : Montrer les cartes dans leur état actuel \n 2 : Melanger les cartes \n 3 : Ordonner les cartes \n 0 : Quitter la boucle d'input");

            Scanner userInputScanner = new Scanner(System.in);
            int userInput = userInputScanner.nextInt();

            if (userInput == 1) {
                displayCards(lesCartes, fenetreJeu);
            }

            else if (userInput == 2) {
                lesCartes.melanger();
                System.out.println("Les cartes ont ete melangees");
                displayCards(lesCartes, fenetreJeu);
            }

            else if (userInput == 3) {
                lesCartes.ordonner();
                System.out.println("Les cartes ont ete ordonnees");
                displayCards(lesCartes, fenetreJeu);
            }

            else if (userInput == 0) {
                System.out.println("La boucle d'input finit");
                break;
            }
            else {
                System.out.println("Entrez une valeur valide");
            }
        }
    }
}

