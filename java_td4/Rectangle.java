package java_td4;

import PaD.*;

public class Rectangle extends Figure {

    protected Double longueur;
    protected Double largeur;

    // - Answer to question 1 :
    // Implicit super constructor Figure() is undefined.
    // Must explicitly invoke another constructor.

    public Rectangle(Double longueur, Double largeur) {
        super(new Point());

        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Double getPerimetre() {
        return (this.longueur * 2 + this.largeur * 2);
    }

    public Double getSurface() {
        return (this.longueur * this.largeur);
    }

    public void changerLongueur(Double newLongueur) {
        this.longueur = newLongueur;
    }

    public void changerLargeur(Double newLargeur) {
        this.longueur = newLargeur;
    }

    @Override
    public String toString() {
        String exterieurLongueur = "+ " + "--".repeat((int) Math.round(this.longueur)) + " +\n";
        String interieurLongueur = "| " + " ".repeat((int) Math.round(this.longueur) * 2) + " |\n";

        return (exterieurLongueur + interieurLongueur.repeat((int) Math.round(this.largeur)) + exterieurLongueur);
    }

    public void dessiner(PlancheADessin fenetreDessin) {
        this.getOrigine().setAbscisse((double) UsefulMethod.randomInteger((int) fenetreDessin.getLargeur() / 8,
                (int) fenetreDessin.getLargeur() * 7 / 8));
        this.getOrigine().setOrdonnee((double) UsefulMethod.randomInteger((int) fenetreDessin.getHauteur() / 8,
                (int) fenetreDessin.getHauteur() * 7 / 8));

        Dessinable rectangle = new RectanglePlein(this.getOrigine().getAbscisse(), this.getOrigine().getOrdonnee(),
                this.longueur, this.largeur, UsefulMethod.randomColor());
        fenetreDessin.ajouter(rectangle);
    }
}
