package java_td3;

import PaD.*;

public class Carte {
    private Couleur couleur;
    private Valeur valeur;
    private PaD.Image img;

    public static final int LARGEUR_IMG = 71;
    public static final int LONGUEUR_IMG = 100;

    public Carte(Valeur v, Couleur c, PaD.Image image) {
        this.valeur = v;
        this.couleur = c;
        this.img = image;
    }

    public PaD.Image getImg() {
        return this.img;
    }

    public Valeur getValeur() {
        return this.valeur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public String toString() {
        // return (" " +  this.valeur.toString().substring(0, 2) + "|" + this.couleur.toString().substring(0, 2) + " ");
        return ("[" +  this.valeur + "(" + this.valeur.valeur() + ")," + this.couleur + "]");
    }

    public Integer compareTo(Carte c) {
        int ordinalCard1 = this.valeur.ordinal();
        int ordinalCard2 = c.valeur.ordinal();

        if (ordinalCard1 > ordinalCard2) {
            return 1;
        }
        else if (ordinalCard1 < ordinalCard2) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public void dessiner(PlancheADessin pad, double x, double y) {
        this.img.setOrig(x, y);
        pad.ajouter(this.img);
    }

}
