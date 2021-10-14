package java_td3;

import PaD.*;

public class Carte implements Comparable<Carte> {
    private Couleur couleur;
    private Valeur valeur;

    private PaD.Image img;
    private PaD.Image carteDos;
    private PaD.Image carteFace;

    private double x;
    private double y;

    public static final String CARTE_DOS_PATH = "java_td3/Cartes/dos.gif";

    public static final int LARGEUR_IMG = (int) (new PaD.Image(CARTE_DOS_PATH)).getLargeur();
    public static final int LONGUEUR_IMG = (int) (new PaD.Image(CARTE_DOS_PATH)).getHauteur();

    public Carte(Valeur v, Couleur c, PaD.Image image) {
        this.valeur = v;
        this.couleur = c;

        this.carteFace = image;
        this.carteDos = new PaD.Image(CARTE_DOS_PATH);
        this.img = this.carteDos;
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

    public PaD.Image getCarteDos() {
        return this.carteDos;
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
        this.x = x;
        this.y = y;

        this.img.setOrig(x, y);
        pad.ajouter(this.img);
    }

    public void retounerCarte(PlancheADessin pad) {
        pad.supprimer(this.img);

        if (this.img == this.carteFace) {
            this.img = this.carteDos;
        } else {
            this.img = this.carteFace;
        }

        dessiner(pad, this.x, this.y);
    }

}
