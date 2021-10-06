import PaD.*;
import java.awt.Color;

/**
 * Cette classe représente le plan cartésien et permet de visualiser à l'aide de
 * la planche à dessin (PaD) des segments de droite et des points du plan
 *
 * @author V. Granet vg@unice.fr
 */

public class Plan2D {
    private static final double UNITE = 20;
    private static final double DIAMETRE_POINT = 5;
    private PlancheADessin pad;
    private final double largeur;
    private final double hauteur;
    private final double milieuL;
    private final double milieuH;

    /**
     * Rôle crée un Plan2D avec les axes gradués des abscisses et des ordonnées
     *
     */
    public Plan2D() {
        this.pad = new PlancheADessin(true);
        this.largeur = pad.getLargeur();
        this.hauteur = pad.getHauteur();
        this.milieuL = largeur / 2;
        this.milieuH = hauteur / 2;
        this.tracerAxes();
        this.tracerGraduations();
    }

    /*
     * Rôle : convertit une coordonnée x du PaD en abscisse du Plan2D courant
     */
    private double coordX(double x) {
        return (UNITE * x) + milieuL;
    }

    /*
     * Rôle : convertit une coordonnée y du PaD en ordonnée du Plan2D courant
     */
    private double coordY(double y) {
        return -(UNITE * y) + milieuH;
    }

    /*
     * Rôle : trace les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerAxes() {
        Dessinable axeAbscisse = new Ligne(0, milieuH, largeur, milieuH);
        Dessinable axeOrdonnee = new Ligne(milieuL, 0, milieuL, hauteur);

        pad.ajouter(axeAbscisse);
        pad.ajouter(axeOrdonnee);
    }

    /*
     * Rôle : gradue les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerGraduations() {
        // Tracer les graduations sur l'axe des abscisses
        // Tracer du centre du graphique jusqu'au bord gauche
        for (double x = milieuL; x <= largeur; x = x + UNITE) {
            Dessinable graduationAbs = new Ligne(x, milieuH + UNITE / 4, x, milieuH - UNITE / 4);
            pad.ajouter(graduationAbs);
        }
        // Tracer du centre du graphique jusqu'au bord droit
        for (double x = milieuL; x >= 0; x = x - UNITE) {
            Dessinable graduationAbs = new Ligne(x, milieuH + UNITE / 4, x, milieuH - UNITE / 4);
            pad.ajouter(graduationAbs);
        }

        // Tracer les graduations sur l'axe des ordonées
        // Tracer du centre du graphique jusqu'en haut
        for (double y = milieuH; y <= hauteur; y = y + UNITE) {
            Dessinable graduationOrd = new Ligne(milieuL + UNITE / 4, y, milieuL - UNITE / 4, y);
            pad.ajouter(graduationOrd);
        }
        // Tracer du centre du graphique jusqu'en bas
        for (double y = milieuH; y >= 0; y = y - UNITE) {
            Dessinable graduationOrd = new Ligne(milieuL + UNITE / 4, y, milieuL - UNITE / 4, y);
            pad.ajouter(graduationOrd);
        }

    }

    /**
     * Rôle : trace le Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerPoint(Point p, Color c) {
        Dessinable point = new CerclePlein(coordX(p.getX()), coordY(p.getY()), DIAMETRE_POINT, c);
        pad.ajouter(point);
        tracerNomPoint(p, p.getName(), c);
    }

    /**
     * Rôle : trace le nom d'un Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerNomPoint(Point p, String nomPoint, Color c) {
        Dessinable textePoint = new Texte(coordX(p.getX()), coordY(p.getY()), nomPoint, c);
        pad.ajouter(textePoint);
    }

    /**
     * Rôle : trace le Segment s sur le Plan2D courant
     */
    public void tracerSegment(Segment s) {
        double x1 = coordX(s.getOrig().getX());
        double y1 = coordY(s.getOrig().getY());
        double x2 = coordX(s.getFin().getX());
        double y2 = coordY(s.getFin().getY());

        Dessinable segment = new Ligne(x1, y1, x2, y2, PlancheADessin.ROUGE);
        pad.ajouter(segment);
    }
}
