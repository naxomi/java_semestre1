package td3;

import PaD.*;

import javax.swing.*;

public class GameBlackJack {

    private static final Double VISUAL_SPACE_BETWEEN_PLAYERS = 130.0;

    private final Player[] listPlayer;
    private final Integer numberOfPlayers;
    private final Game52 cardGame;
    private final PlancheADessin gameWindow;

    public Player[] getListPlayer() {
        return this.listPlayer;
    }

    public Player getPlayer(Integer i) {
        return this.listPlayer[i];
    }

    public Game52 getCardGame() {
        return this.cardGame;
    }

    public PlancheADessin getGameWindow() {
        return this.gameWindow;
    }

    public Integer getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    private static int returnCard(String playerName) {
        return JOptionPane.showConfirmDialog(null, "Retourner 1 carte au hasard ?", playerName,
                JOptionPane.OK_CANCEL_OPTION);
    }

    private static int dialogBox(String text, String title) {
        return JOptionPane.showConfirmDialog(null, text, title, JOptionPane.OK_OPTION);
    }

    public void displayWinner(Player winner) {
        dialogBox("The player '" + winner.getName() + "' won with a total of " + winner.getScore() + " points.",
                "Game finished");
    }

    public void displayText(String text) {
        dialogBox(text, "Game finished");
    }

    public GameBlackJack(String... allNames) {

        // Initiate number of players
        this.numberOfPlayers = allNames.length;
        this.listPlayer = new Player[this.numberOfPlayers];

        // Initiate the game screen
        this.gameWindow = new PlancheADessin(Card.WIDTH_IMG * 13,
                (int) Math.round(GameBlackJack.VISUAL_SPACE_BETWEEN_PLAYERS) * this.numberOfPlayers + 30, true);

        // Initiate the 52 cards set
        this.cardGame = new Game52();
        this.cardGame.mixCards();

        // Initiate all players
        int counter = 0;
        for (String playerName : allNames) {
            this.listPlayer[counter] = new Player("J" + (counter + 1) + " | " + playerName);
            this.listPlayer[counter].takeMyCards(cardGame, 13 * counter, 13 * (counter + 1) - 1);
            counter++;
        }
    }

    public void displayGame() {
        // Show all the players cards
        for (int i = 0; i < this.numberOfPlayers; i++) {
            this.listPlayer[i].showCards(this.gameWindow, VISUAL_SPACE_BETWEEN_PLAYERS * i);
        }
    }

    public Boolean gameIsWon() {
        boolean winnerFound = false;
        for (Player player : this.listPlayer) {
            if (Boolean.TRUE.equals(player.playerIsWinning())) {
                if (Boolean.TRUE.equals(winnerFound)) {
                    return false;
                } else {
                    winnerFound = true;
                }
            }
        }
        return winnerFound;
    }

    public Player getGameWinner() {
        for (Player player : this.getListPlayer()) {
            if (player.getScore() <= 21) {
                return player;
            }
        }
        return null;
    }

    public static void playerPlays(Player player, PlancheADessin gameWindow) {
        if (returnCard(player.getName()) == JOptionPane.OK_OPTION) {
            Card cardToReturn = player.chooseHiddenCard();
            cardToReturn.returnCard(gameWindow);
        }
    }

    public static void main(String[] args) {

        GameBlackJack game = new GameBlackJack("Hugo", "Raphaël", "Jaime", "Tony");
        game.displayGame();

        // Start of the game loop
        boolean gameContinues = true;
        while (Boolean.TRUE.equals(gameContinues)) {
            for (int i = 0; i < game.getNumberOfPlayers(); i++) { // Loop on all the players
                if (game.getPlayer(i).getScore() < 21) {
                    // Verify that the player can still player (score <= 21)
                    playerPlays(game.getPlayer(i), game.getGameWindow());
                    game.getGameWindow().clear();
                    game.displayGame();
                }

                if (Boolean.TRUE.equals(game.getPlayer(i).playerWins())) {
                    // Test if the player has exactly 21 points thanks to his choice
                    game.displayWinner(game.getPlayer(i));
                    gameContinues = false;
                    break;
                }

                if (Boolean.TRUE.equals(game.gameIsWon())) {
                    // Verify if the game is won by any players
                    game.displayWinner(game.getGameWinner());
                    gameContinues = false;
                    break;
                }
            }
        }
    }
}
