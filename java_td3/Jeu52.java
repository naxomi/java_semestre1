package java_td3;

import java.util.Random;

public class Jeu52 {
    private Carte []jeu;
    private Random random = new Random();
    private static final Integer NB_CARTES = 52;

    public Jeu52() {
        this.jeu = new Carte[NB_CARTES];

        int i = 0;
        for (Couleur color : Couleur.values()){
            for (Valeur value : Valeur.values()) {
                this.jeu[i] = new Carte(value, color, new PaD.Image("java_td3/Cartes/" + value + "-" + color + ".gif"));
                i++;
            }
        }
    }

    public Carte[] getJeu() {
        return this.jeu;
    }

    public Carte getCarte(int indice) {
        if (indice >= 0 && indice < NB_CARTES) {
            return this.jeu[indice];
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NB_CARTES; i++) {
            if ((i != 0) && (i % 13 == 0)) {
                builder.append("\n");
            }
            builder.append(this.jeu[i]);
        }
        return builder.toString();
    }

    public void melanger() {

        for (int i = 0; i < NB_CARTES; i++) {
            int randNumber1 = random.nextInt(NB_CARTES);
            int randNumber2 = random.nextInt(NB_CARTES);

            if (randNumber1 != randNumber2) {
                Carte temporaryValue = this.jeu[randNumber1];
                this.jeu[randNumber1] = this.jeu[randNumber2];
                this.jeu[randNumber2] = temporaryValue;
            }
        }
    }

    private void exchangeTwoCards(int i, int j) {
        Carte temporaryValue = this.jeu[i];
        this.jeu[i] = this.jeu[j];
        this.jeu[j] = temporaryValue;
    }

    public void ordonner() {
        
        for (int indexActualCard = 0; indexActualCard < NB_CARTES; indexActualCard++) {

            // Manage the beginning of the line, when we need to change of card color
            if (indexActualCard % 13 == 0) {
                for (int j = indexActualCard; j < NB_CARTES; j++) {
                    if ((this.jeu[j].getValeur().ordinal() == 0) && (this.jeu[j].getCouleur().ordinal() == indexActualCard / 13)) {
                        exchangeTwoCards(indexActualCard, j);
                        break;
                    }
                }
            }

            // Manage all the cells except the 4 beginning of the lines
            else {
                for (int j = indexActualCard; j < NB_CARTES; j++) {
                    Boolean cond1 = this.jeu[j].getValeur().ordinal() == (this.jeu[indexActualCard-1].getValeur().ordinal() + 1);
                    Boolean cond2 = this.jeu[j].getCouleur().ordinal() == this.jeu[indexActualCard-1].getCouleur().ordinal();

                    if (cond1 && cond2) {
                        exchangeTwoCards(indexActualCard, j);
                        break;
                    }
                }
            } 
        }
    }
}
