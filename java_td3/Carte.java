package java_td3;

import PaD.*;

public class Carte implements Comparable<Carte> {
    private Couleur couleur;
    private Valeur valeur;
    private PaD.Image img;

    public static final double LARGEUR_IMG = (new PaD.Image("java_td3/Cartes/dos.gif")).getLargeur();
    public static final double LONGUEUR_IMG = (new PaD.Image("java_td3/Cartes/dos.gif")).getHauteur();

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
        return ("[" + this.valeur + "(" + this.valeur.valeur() + ")," + this.couleur + "]");
    }

    @Override
    public int compareTo(Carte c) {
        if (this.getCouleur().ordinal() > c.getCouleur().ordinal()) {
            return 1;
        } else if (this.getCouleur().ordinal() < c.getCouleur().ordinal()) {
            return -1;
        } else {
            if (this.getValeur().ordinal() > c.getValeur().ordinal()) {
                return 1;
            } else if (this.getValeur().ordinal() < c.getValeur().ordinal()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public void dessiner(PlancheADessin pad, double x, double y) {
        this.img.setOrig(x, y);
        pad.ajouter(this.img);
    }

}
