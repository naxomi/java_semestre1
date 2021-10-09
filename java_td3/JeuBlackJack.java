package java_td3;

import PaD.*;
import javax.swing.JOptionPane;

public class JeuBlackJack {

    private static final Double ESPACE_ENTRE_JOUEUR_AFFICHES = 130.0;

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    private Joueur joueur4;

    private Jeu52 jeuDeCarte;
    private PlancheADessin fenetreJeu;

    public Joueur getJoueur1() {
        return this.joueur1;
    }

    public Joueur getJoueur2() {
        return this.joueur2;
    }

    public Joueur getJoueur3() {
        return this.joueur3;
    }

    public Joueur getJoueur4() {
        return this.joueur4;
    }

    public Jeu52 getJeuDeCarte() {
        return this.jeuDeCarte;
    }

    public PlancheADessin getFenetreJeu() {
        return this.fenetreJeu;
    }

    private static int retourner(String playerName) {
        return JOptionPane.showConfirmDialog(null, "Retourner 1 carte au hasard ?", playerName,
                JOptionPane.OK_CANCEL_OPTION);
    }

    public JeuBlackJack(String player1Name, String player2Name, String player3Name, String player4Name) {

        // Initiate the game screen
        this.fenetreJeu = new PlancheADessin(Carte.LARGEUR_IMG * 13,
                (int) Math.round(JeuBlackJack.ESPACE_ENTRE_JOUEUR_AFFICHES) * 4 + 30, true);

        // Initiate the 52 cards set
        this.jeuDeCarte = new Jeu52();
        this.jeuDeCarte.melanger();
        this.jeuDeCarte.retournerToutesLesCartes(this.fenetreJeu);

        // Initiate player 1
        this.joueur1 = new Joueur("J1 | " + player1Name);
        this.joueur1.prendreMesCartes(jeuDeCarte, 0, 12);
        // Initiate player 2
        this.joueur2 = new Joueur("J2 | " + player2Name);
        this.joueur2.prendreMesCartes(jeuDeCarte, 13, 25);
        // Initiate player 3
        this.joueur3 = new Joueur("J3 | " + player3Name);
        this.joueur3.prendreMesCartes(jeuDeCarte, 26, 38);
        // Initiate player 4
        this.joueur4 = new Joueur("J4 | " + player4Name);
        this.joueur4.prendreMesCartes(jeuDeCarte, 39, 51);
    }

    public void displayGame() {
        // Show all the players cards
        this.joueur1.montrerCarte(this.fenetreJeu, ESPACE_ENTRE_JOUEUR_AFFICHES * 0);
        this.joueur2.montrerCarte(this.fenetreJeu, ESPACE_ENTRE_JOUEUR_AFFICHES * 1);
        this.joueur3.montrerCarte(this.fenetreJeu, ESPACE_ENTRE_JOUEUR_AFFICHES * 2);
        this.joueur4.montrerCarte(this.fenetreJeu, ESPACE_ENTRE_JOUEUR_AFFICHES * 3);
    }

    public static void playerPlays(Joueur player1, PlancheADessin fenetreJeu) {
        if (retourner(player1.getName()) == JOptionPane.OK_OPTION) {
            Carte carteARetourner = player1.choisirCarteCacheeAuHasard();
            carteARetourner.retounerCarte(fenetreJeu);
        }
    }

    public static void main(String[] args) {

        JeuBlackJack game = new JeuBlackJack("Jaime", "Hugo", "Raphaël", "Théo");
        game.displayGame();

        // Start of the game loop
        for (int i = 0; i < 7; i++) {
            playerPlays(game.getJoueur1(), game.getFenetreJeu());
            game.getFenetreJeu().clear();
            game.displayGame();

            playerPlays(game.getJoueur2(), game.getFenetreJeu());
            game.getFenetreJeu().clear();
            game.displayGame();

            playerPlays(game.getJoueur3(), game.getFenetreJeu());
            game.getFenetreJeu().clear();
            game.displayGame();

            playerPlays(game.getJoueur4(), game.getFenetreJeu());
            game.getFenetreJeu().clear();
            game.displayGame();
        }

    }
}
