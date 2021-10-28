package td3;

import PaD.*;

public class Card implements Comparable<Card> {
    private final CardColor color;
    private final CardValue value;

    private PaD.Image img;
    private final PaD.Image imgCardBack;
    private final PaD.Image imgCardFront;

    private double x;
    private double y;

    public static final String CARTE_DOS_PATH = "data/CardImages/dos.gif";

    public static final int WIDTH_IMG = (int) (new PaD.Image(CARTE_DOS_PATH)).getLargeur();
    public static final int LENGTH_IMG = (int) (new PaD.Image(CARTE_DOS_PATH)).getHauteur();

    public Card(CardValue v, CardColor c, PaD.Image image) {
        this.value = v;
        this.color = c;

        this.imgCardFront = image;
        this.imgCardBack = new PaD.Image(CARTE_DOS_PATH);
        this.img = this.imgCardBack;
    }

    public PaD.Image getImg() {
        return this.img;
    }

    public CardValue getCardValue() {
        return this.value;
    }

    public CardColor getCardColor() {
        return this.color;
    }

    public PaD.Image getImgCardBack() {
        return this.imgCardBack;
    }

    @Override
    public String toString() {
        return ("[" + this.value + "(" + this.value.getValue() + ")," + this.color + "]");
    }

    @Override
    public int compareTo(Card c) {
        if (this.getCardColor().ordinal() > c.getCardColor().ordinal()) {
            return 1;
        } else if (this.getCardColor().ordinal() < c.getCardColor().ordinal()) {
            return -1;
        } else {
            return Integer.compare(this.getCardValue().ordinal(), c.getCardValue().ordinal());
        }
    }

    public void draw(PlancheADessin pad, double x, double y) {
        this.x = x;
        this.y = y;

        this.img.setOrig(x, y);
        pad.ajouter(this.img);
    }

    public void returnCard(PlancheADessin pad) {
        pad.supprimer(this.img);

        if (this.img == this.imgCardFront) {
            this.img = this.imgCardBack;
        } else {
            this.img = this.imgCardFront;
        }

        draw(pad, this.x, this.y);
    }

}
