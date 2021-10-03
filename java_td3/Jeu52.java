package java_td3;

import java.util.Random;

public class Jeu52 {
    private Carte []jeu;
    private Random random = new Random();

    public Jeu52() {
        jeu = new Carte[52];

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            if ((i != 0) && (i % 13 == 0)) {
                builder.append("\n");
            }
            builder.append(this.jeu[i]);
        }
        return builder.toString();
    }

    public void melanger() {

        for (int i = 0; i < 52; i++) {
            int randNumber1 = random.nextInt(52);
            int randNumber2 = random.nextInt(52);

            if (randNumber1 != randNumber2) {
                Carte temporaryValue = this.jeu[randNumber1];
                this.jeu[randNumber1] = this.jeu[randNumber2];
                this.jeu[randNumber2] = temporaryValue;
            }
        }
    }

    public void findFirstCardPerColor(int colorOrdinal) {

    }

    public void ordonner() {
        
        for (int indexActualCard = 0; indexActualCard < 52; indexActualCard++) {

            // Manage the beginning of the line, when we need to change of card color
            if (indexActualCard % 13 == 0) {
                for (int j = 0; j < 52; j++) {
                    if ((this.jeu[j].getValeur().ordinal() == 0) && (this.jeu[j].getCouleur().ordinal() == indexActualCard / 13)) {
                        Carte temporaryValue = this.jeu[indexActualCard];
                        this.jeu[indexActualCard] = this.jeu[j];
                        this.jeu[j] = temporaryValue;
                        break;
                    }
                }
            }

            // Manage all the cells except the 4 beginning of the lines
            else {
                for (int j = indexActualCard; j < 52; j++) {
                    Boolean cond1 = this.jeu[j].getValeur().ordinal() == (this.jeu[indexActualCard-1].getValeur().ordinal() + 1);
                    Boolean cond2 = this.jeu[j].getCouleur().ordinal() == this.jeu[indexActualCard-1].getCouleur().ordinal();

                    if (cond1 && cond2) {
                        Carte temporaryCard = this.jeu[indexActualCard];
                        this.jeu[indexActualCard] = this.jeu[j];
                        this.jeu[j] = temporaryCard;
                    
                        break;
                    }
                }
            } 
        }
    }
}
