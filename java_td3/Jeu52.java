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
                exchangeTwoCards(randNumber1, randNumber2);
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
            int indexMinCard = indexActualCard;
            for (int j = indexActualCard; j < NB_CARTES; j++) {
                if (this.jeu[indexMinCard].compareTo(this.jeu[j]) == 1) {
                    indexMinCard = j;
                }
            }
            exchangeTwoCards(indexActualCard, indexMinCard);
         }
    }
}
