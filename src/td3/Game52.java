package td3;

import PaD.PlancheADessin;

import java.util.Random;

public class Game52 {
    private final Card[] jeu;
    private final Random random = new Random();
    private static final Integer NB_CARDS = 52;

    public Game52() {
        this.jeu = new Card[NB_CARDS];

        int i = 0;
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                this.jeu[i] = new Card(value, color, new PaD.Image("data/CardImages/" + value + "-" + color + ".gif"));
                i++;
            }
        }
    }

    public Card[] getGame() {
        return this.jeu;
    }

    public Card getCard(int index) {
        if (index >= 0 && index < NB_CARDS) {
            return this.jeu[index];
        } else {
            return null;
        }
    }

    public void draw(PlancheADessin gameWindow) {
        double y = 15;
        for (int i = 0; i < NB_CARDS; i++) {

            if ((i != 0) && (i % 13 == 0)) {
                y += Card.LENGTH_IMG;
            }
            double x = (i % 13) * (double) Card.WIDTH_IMG;
            Card imgToPlace = this.getCard(i);
            imgToPlace.draw(gameWindow, x, y);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NB_CARDS; i++) {
            if ((i != 0) && (i % 13 == 0)) {
                builder.append("\n");
            }
            builder.append(this.jeu[i]);
        }
        return builder.toString();
    }

    public void mixCards() {

        for (int i = 0; i < NB_CARDS; i++) {
            int randNumber1 = random.nextInt(NB_CARDS);
            int randNumber2 = random.nextInt(NB_CARDS);

            if (randNumber1 != randNumber2) {
                exchangeTwoCards(randNumber1, randNumber2);
            }
        }
    }

    private void exchangeTwoCards(int i, int j) {
        Card temporaryCard = this.jeu[i];
        this.jeu[i] = this.jeu[j];
        this.jeu[j] = temporaryCard;
    }

    public void organize() {

        for (int indexActualCard = 0; indexActualCard < NB_CARDS; indexActualCard++) {
            int indexMinCard = indexActualCard;
            for (int j = indexActualCard; j < NB_CARDS; j++) {
                if (this.jeu[indexMinCard].compareTo(this.jeu[j]) > 0) {
                    // compareTo() returns 1 if the self is higher.
                    indexMinCard = j;
                }
            }
            exchangeTwoCards(indexActualCard, indexMinCard);
        }
    }

    public void returnEveryCard(PlancheADessin gameWindow) {
        for (int i = 0; i < 52; i++) {
            this.getCard(i).returnCard(gameWindow);
        }
    }
}
