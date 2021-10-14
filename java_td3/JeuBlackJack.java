package java_td3;

import PaD.*;
import javax.swing.JOptionPane;

public class JeuBlackJack {

    private static final Double ESPACE_ENTRE_JOUEUR_AFFICHES = 130.0;

    private Joueur[] listeJoueur;
    private Integer numberOfPlayers;
    private Jeu52 jeuDeCarte;
    private PlancheADessin fenetreJeu;

    public Joueur[] getListeJoueur() {
        return this.listeJoueur;
    }

    public Joueur getJoueur(Integer i) {
        return this.listeJoueur[i];
    }

    public Jeu52 getJeuDeCarte() {
        return this.jeuDeCarte;
    }

    public PlancheADessin getFenetreJeu() {
        return this.fenetreJeu;
    }

    public Integer getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    private static int retourner(String playerName) {
        return JOptionPane.showConfirmDialog(null, "Retourner 1 carte au hasard ?", playerName,
                JOptionPane.OK_CANCEL_OPTION);
    }

    private static int dialogBox(String text, String title) {
        return JOptionPane.showConfirmDialog(null, text, title, JOptionPane.OK_OPTION);
    }

    public void displayWinner(Joueur winner) {
        dialogBox("The player '" + winner.getName() + "' won with a total of " + winner.getScore(), "Game finished");
    }

    public void displayText(String text) {
        dialogBox(text, "Game finished");
    }

    public JeuBlackJack(String... allNames) {

        // Initiate number of players
        this.numberOfPlayers = allNames.length;
        this.listeJoueur = new Joueur[this.numberOfPlayers];

        // Initiate the game screen
        this.fenetreJeu = new PlancheADessin(Carte.LARGEUR_IMG * 13,
                (int) Math.round(JeuBlackJack.ESPACE_ENTRE_JOUEUR_AFFICHES) * this.numberOfPlayers + 30, true);

        // Initiate the 52 cards set
        this.jeuDeCarte = new Jeu52();
        this.jeuDeCarte.melanger();
        this.jeuDeCarte.retournerToutesLesCartes(this.fenetreJeu);

        // Initiate all players
        Integer counter = 0;
        for (String playerName : allNames) {
            this.listeJoueur[counter] = new Joueur("J" + (counter + 1) + " | " + playerName);
            this.listeJoueur[counter].prendreMesCartes(jeuDeCarte, 13 * counter, 13 * (counter + 1) - 1);
            counter++;
        }
    }

    public void displayGame() {
        // Show all the players cards
        for (int i = 0; i < this.numberOfPlayers; i++) {
            this.listeJoueur[i].montrerCarte(this.fenetreJeu, ESPACE_ENTRE_JOUEUR_AFFICHES * i);
        }
    }

    public Boolean gameIsWon() {
        Boolean winnerFound = false;
        for (Joueur joueur : this.listeJoueur) {
            if (Boolean.TRUE.equals(joueur.playerIsWinning())) {
                if (Boolean.TRUE.equals(winnerFound)) {
                    return false;
                } else {
                    winnerFound = true;
                }
            }
        }
        return winnerFound;
    }

    public Joueur getGameWinner() { // Need to change this method
        Joueur winner = null;
        Integer winningScore = 0;
        for (Joueur joueur : this.getListeJoueur()) {
            if (joueur.getScore() > winningScore && joueur.getScore() <= 21) {
                winner = joueur;
                winningScore = joueur.getScore();
            } else {
                winner = null;
            }
        }
        return winner;
    }

    public static void playerPlays(Joueur player, PlancheADessin fenetreJeu) {
        if (retourner(player.getName()) == JOptionPane.OK_OPTION) {
            Carte carteARetourner = player.choisirCarteCacheeAuHasard();
            carteARetourner.retounerCarte(fenetreJeu);
        }
    }

    public static void main(String[] args) {

        JeuBlackJack game = new JeuBlackJack("Jaime", "Raphaël", "test");
        game.displayGame();

        // Start of the game loop
        Boolean gameContinues = true;
        while (Boolean.TRUE.equals(gameContinues)) {
            for (int i = 0; i < game.getNumberOfPlayers(); i++) { // Loop on all the players
                if (game.getJoueur(i).getScore() < 21) {
                    // Verify that the player can still player (score <= 21)
                    playerPlays(game.getJoueur(i), game.getFenetreJeu());
                    game.getFenetreJeu().clear();
                    game.displayGame();
                } else if (Boolean.TRUE.equals(game.getJoueur(i).playerWins())) {
                    // Test if the player has won thanks to his choice
                    gameContinues = false;
                    game.displayWinner(game.getJoueur(i));
                    break;
                } else if (i == game.getNumberOfPlayers()) {
                    // If none of the players can play then it is the end of the game
                    game.displayText("No one won the game.....");
                    gameContinues = false;
                }
            }
            if (Boolean.TRUE.equals(game.gameIsWon())) {
                // Verify if the game is won by any players
                game.displayWinner(game.getGameWinner());
                gameContinues = false;
            }
        }
    }
}
