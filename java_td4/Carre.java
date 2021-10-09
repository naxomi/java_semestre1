package java_td4;

public class Carre extends Rectangle {

    public Carre(Double longueurCote) {
        super(longueurCote, longueurCote);
    }

    @Override
    public void changerLongueur(Double newLongueur) {
        super.changerLargeur(newLongueur);
        super.changerLongueur(newLongueur);
    }

    @Override
    public void changerLargeur(Double newLargeur) {
        super.changerLongueur(newLargeur);
        super.changerLargeur(newLargeur);
    }
}
