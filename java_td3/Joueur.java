package java_td3;

import PaD.*;
import java.util.Random;

public class Joueur {
    private String nom;
    private Carte[] mesCartes;
    private Integer score;

    private Random random = new Random();

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    public void prendreMesCartes(Jeu52 jeu, int from, int to) {
        mesCartes = new Carte[to - from + 1];

        int counter = 0;
        for (int i = from; i <= to; i++) {
            mesCartes[counter] = jeu.getCarte(i);
            counter++;
        }
    }

    public Carte[] getJeu() {
        return this.mesCartes;
    }

    public Carte getCarte(Integer indice) {
        return this.mesCartes[indice];
    }

    public Integer getScore() {
        return this.score;
    }

    public String getName() {
        return this.nom;
    }

    public void montrerCarte(PlancheADessin fenetreJeu, double hauteur) {
        hauteur += 15; // Value to negligate the bar at the top of the window

        calculerScore();
        Dessinable playerInfo = new Texte(15, hauteur, this.nom + " - " + this.score.toString() + " points");
        fenetreJeu.ajouter(playerInfo);

        for (int i = 0; i < this.getJeu().length; i++) {
            double x = (i % this.getJeu().length) * Double.valueOf(Carte.LARGEUR_IMG);
            Carte imgToPlace = this.getCarte(i);
            imgToPlace.dessiner(fenetreJeu, x, hauteur + 30); // The +30 is because of the text above (playerName)
        }
    }

    public Carte choisirCarteCacheeAuHasard() {
        Boolean wrongChoice = true;
        int numberChosen = -1;
        while (Boolean.TRUE.equals(wrongChoice)) {
            numberChosen = random.nextInt(this.getJeu().length - 1);
            if (this.getCarte(numberChosen).getImg() == this.getCarte(numberChosen).getCarteDos()) {
                wrongChoice = false;
            }
        }
        return this.getCarte(numberChosen);
    }

    public void calculerScore() {

        Integer currentScore = 0;

        for (int i = 0; i < this.getJeu().length; i++) {
            if (this.getCarte(i).getImg() != this.getCarte(i).getCarteDos()) {
                currentScore += this.getCarte(i).getValeur().valeur();
            }
        }

        this.score = currentScore;
    }
}
