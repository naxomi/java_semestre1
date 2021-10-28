package td2;

import PaD.*;

public class Card {
    private final CardColor color;
    private final CardValue value;
    private final PaD.Image img;

    public Card(CardValue v, CardColor c, PaD.Image image) {
        this.value = v;
        this.color = c;
        this.img = image;
    }

    @Override
    public String toString() {
        return ("[" + this.value + "(" + this.value.getValue() + ")," + this.color + "]");
    }

    public Integer compareTo(Card c) {
        int ordinalCard1 = this.value.ordinal();
        int ordinalCard2 = c.value.ordinal();

        return Integer.compare(ordinalCard1, ordinalCard2);
    }

    /*
     * Role : dessine la carte a jouer courante this en position (x,y) sur la
     * planche a dessiner graphique pad
     *
     * @param x un <code>int</code>
     *
     * @param y un <code>int</code>.
     *
     * @param pad un <code>PlancheADessin</code>.
     */
    public void draw(PlancheADessin pad, double x, double y) {
        // ---- Methode 1 ----
        this.img.setOrig(x, y);
        pad.ajouter(this.img);

        // ---- Methode 2 ----
        // Dessinable carte = new PaD.Image(x, y, "java_td2/Cartes/" + this.valeur + "-"
        // + this.couleur + ".gif");
        // pad.ajouter(carte);
    }

}
