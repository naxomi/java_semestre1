import PaD.*;
import java.awt.Color;

/**
 * Cette classe représente le plan cartésien et permet de visualiser à
 * l'aide de la planche à dessin (PaD) des segments de droite et des
 * points du plan
 *
 * @author V. Granet vg@unice.fr
 */

public class Plan2D {
    private final double unité = 20;
    private PlancheADessin pad;
    private final double milieuL;
    private final double milieuH;

    /**
     * Rôle crée un Plan2D avec les axes gradués des abscisses et des ordonnées
     *
     */
    public Plan2D() {
        this.pad = new PlancheADessin(true);
        this.milieuL=  pad.getLargeur()/2;
        this.milieuH = pad.getHauteur()/2;
        this.tracerAxes();
        this.tracerGraduations();
    }

    /*
     * Rôle : convertit une coordonnée x du PaD en abscisse du Plan2D courant
     */
    private double coordX(double x) {
	    return (unité*x)+milieuL;
    }

    /*
     * Rôle : convertit une coordonnée y du PaD en ordonnée du Plan2D courant
     */
    private double coordY(double y) {
	    return -(unité*y)+milieuH;
    }

    /*
     * Rôle : trace les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerAxes() {
    }

    /*
     * Rôle : gradue les axes des abscisses et des ordonnées du Plan2D courant
     */
     */
    private void tracerGraduations() {
    }

    /**
     * Rôle : trace le Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerPoint(Point p, Color c) {
    }

    /**
     * Rôle : trace le Point s sur le Plan2D courant
     */
    public void tracerSegment(Segment s) {
    }
}
