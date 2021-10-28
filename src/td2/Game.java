package td2;

import PaD.*;

public class Game {
    public static void main(String[] args) {

        Card queenOfSpade = new Card(CardValue.dame, CardColor.pique, new PaD.Image("data/CardImages/dame-pique.gif"));
        Card sixOfClover = new Card(CardValue.six, CardColor.trefle, new PaD.Image("data/CardImages/six-trefle.gif"));

        PlancheADessin gameWindow = new PlancheADessin(true);

        System.out.println(queenOfSpade);
        System.out.println(sixOfClover);

        System.out.println(
                "Compare queen of spade against six of clover : " + queenOfSpade.compareTo(sixOfClover));

        queenOfSpade.draw(gameWindow, 100, 100);
        sixOfClover.draw(gameWindow, 200, 100);
    }
}
