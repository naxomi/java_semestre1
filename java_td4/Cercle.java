package java_td4;

public class Cercle extends Ellipse {

    public Cercle(Double diametre) {
        super(diametre, diametre);
    }

    @Override
    public void changerGrandAxe(Double diametre) {
        super.changerGrandAxe(diametre);
        super.changerPetitAxe(diametre);
    }

    @Override
    public void changerPetitAxe(Double diametre) {
        super.changerPetitAxe(diametre);
        super.changerGrandAxe(diametre);
    }
}
