import PaD.*;

public class Carte {
    private Couleur couleur;
    private Valeur valeur;
    private PaD.Image img;

    public Carte(Valeur v, Couleur c, PaD.Image image) {
        this.valeur = v;
        this.couleur = c;
        this.img = image;
    }

    @Override
    public String toString() {
        return ("[" + this.valeur + "(" + this.valeur.valeur() + ")," + this.couleur + "]");
    }

    public Integer compareTo(Carte c) {
        int ordinalCard1 = this.valeur.ordinal();
        int ordinalCard2 = c.valeur.ordinal();

        if (ordinalCard1 > ordinalCard2) {
            return 1;
        } else if (ordinalCard1 < ordinalCard2) {
            return -1;
        } else {
            return 0;
        }
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
    public void dessiner(PlancheADessin pad, double x, double y) {
        // ---- Methode 1 ----
        this.img.setOrig(x, y);
        pad.ajouter(this.img);

        // ---- Methode 2 ----
        // Dessinable carte = new PaD.Image(x, y, "java_td2/Cartes/" + this.valeur + "-"
        // + this.couleur + ".gif");
        // pad.ajouter(carte);
    }

}
