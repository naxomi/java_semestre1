package td3;

import PaD.*;

import java.util.Random;

public class Player {
    private final String name;
    private Card[] myCards;
    private Integer score;

    private final Random random = new Random();

    public Player(String nom) {
        this.name = nom;
        this.score = 0;
    }

    public void takeMyCards(Game52 jeu, int from, int to) {
        myCards = new Card[to - from + 1];

        int counter = 0;
        for (int i = from; i <= to; i++) {
            myCards[counter] = jeu.getCard(i);
            counter++;
        }
    }

    public Card[] getJeu() {
        return this.myCards;
    }

    public Card getCarte(Integer index) {
        return this.myCards[index];
    }

    public Integer getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public Boolean playerIsWinning() {
        return (this.getScore() <= 21);
    }

    public Boolean playerWins() {
        return (this.getScore() == 21);
    }

    public void showCards(PlancheADessin gameWindow, double hauteur) {
        hauteur += 15; // Value to neglect the bar at the top of the window

        calculateScore();
        Dessinable playerInfo = new Texte(15, hauteur, this.name + " - " + this.score.toString() + " points");
        gameWindow.ajouter(playerInfo);

        for (int i = 0; i < this.getJeu().length; i++) {
            double x = (i % this.getJeu().length) * (double) Card.WIDTH_IMG;
            Card imgToPlace = this.getCarte(i);
            imgToPlace.draw(gameWindow, x, hauteur + 30); // The +30 is because of the text above (playerName)
        }
    }

    public Card chooseHiddenCard() {
        boolean wrongChoice = true;
        int numberChosen = -1;
        while (Boolean.TRUE.equals(wrongChoice)) {
            numberChosen = random.nextInt(this.getJeu().length - 1);
            if (this.getCarte(numberChosen).getImg() == this.getCarte(numberChosen).getImgCardBack()) {
                wrongChoice = false;
            }
        }
        return this.getCarte(numberChosen);
    }

    public void calculateScore() {

        Integer currentScore = 0;

        for (int i = 0; i < this.getJeu().length; i++) {
            if (this.getCarte(i).getImg() != this.getCarte(i).getImgCardBack()) {
                currentScore += this.getCarte(i).getCardValue().getValue();
            }
        }

        this.score = currentScore;
    }
}
