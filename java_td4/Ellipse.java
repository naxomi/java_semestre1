package java_td4;

import PaD.*;

public class Ellipse extends Figure {

    protected Double grandAxe;
    protected Double petitAxe;

    public Ellipse(Double grandAxe, Double petitAxe) {
        super(new Point());

        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    public Double getPerimetre() {
        return (Math.PI * Math.sqrt(2 * (Math.pow(this.grandAxe, 2) + Math.pow(this.petitAxe, 2))));
    }

    public Double getSurface() {
        return (Math.PI * this.grandAxe * this.petitAxe);
    }

    public void changerGrandAxe(Double newGrandAxe) {
        this.grandAxe = newGrandAxe;
    }

    public void changerPetitAxe(Double newPetitAxe) {
        this.petitAxe = newPetitAxe;
    }

    public void dessiner(PlancheADessin fenetreDessin) {
        this.getOrigine().setAbscisse((double) UsefulMethod.randomInteger((int) fenetreDessin.getLargeur() / 8,
                (int) fenetreDessin.getLargeur() * 7 / 8));
        this.getOrigine().setOrdonnee((double) UsefulMethod.randomInteger((int) fenetreDessin.getHauteur() / 8,
                (int) fenetreDessin.getHauteur() * 7 / 8));

        Dessinable ellipse = new EllipsePleine(this.getOrigine().getAbscisse(), this.getOrigine().getOrdonnee(),
                this.grandAxe, this.petitAxe, UsefulMethod.randomColor());
        fenetreDessin.ajouter(ellipse);
    }

}
