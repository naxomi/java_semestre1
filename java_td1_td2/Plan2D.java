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
    private final double unite = 20;
    private final double diametre_point = 5;
    private PlancheADessin pad;
    private final double largeur;
    private final double hauteur;
    private final double milieu_l;
    private final double milieu_h;

    /**
     * Rôle crée un Plan2D avec les axes gradués des abscisses et des ordonnées
     *
     */
    public Plan2D() {
        this.pad = new PlancheADessin(true);
        this.largeur = pad.getLargeur();
        this.hauteur = pad.getHauteur();
        this.milieu_l=  largeur/2;
        this.milieu_h = hauteur/2;
        this.tracerAxes();
        this.tracerGraduations();
    }

    /*
     * Rôle : convertit une coordonnée x du PaD en abscisse du Plan2D courant
     */
    private double coordX(double x) {
	    return (unite*x)+milieu_l;
    }

    /*
     * Rôle : convertit une coordonnée y du PaD en ordonnée du Plan2D courant
     */
    private double coordY(double y) {
	    return -(unite*y)+milieu_h;
    }

    /*
     * Rôle : trace les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerAxes() {
        Dessinable axe_abscisse = new Ligne(0, milieu_h, largeur, milieu_h);
        Dessinable axe_ordonnee = new Ligne(milieu_l, 0, milieu_l, hauteur);

        pad.ajouter(axe_abscisse);
        pad.ajouter(axe_ordonnee);
    }

    /*
     * Rôle : gradue les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerGraduations() {
        // Tracer les graduations sur l'axe des abscisses
        // Tracer du centre du graphique jusqu'au bord gauche
        for (double x = milieu_l; x <= largeur; x = x + unite) {
            Dessinable graduation_abs = new Ligne(x, milieu_h + unite/4, x, milieu_h - unite/4);
            pad.ajouter(graduation_abs);
        }
        // Tracer du centre du graphique jusqu'au bord droit
        for (double x = milieu_l; x >= 0; x = x - unite) {
            Dessinable graduation_abs = new Ligne(x, milieu_h + unite/4, x, milieu_h - unite/4);
            pad.ajouter(graduation_abs);
        }

        // Tracer les graduations sur l'axe des ordonées
        // Tracer du centre du graphique jusqu'en haut 
        for (double y = milieu_h; y <= hauteur; y = y + unite) {
            Dessinable graduation_ord = new Ligne(milieu_l + unite/4, y, milieu_l - unite/4, y);
            pad.ajouter(graduation_ord);
        }
        // Tracer du centre du graphique jusqu'en bas
        for (double y = milieu_h; y >= 0; y = y - unite) {
            Dessinable graduation_ord = new Ligne(milieu_l + unite/4, y, milieu_l - unite/4, y);
            pad.ajouter(graduation_ord);
        }

    }

    /**
     * Rôle : trace le Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerPoint(Point p, Color c) {
        Dessinable point = new CerclePlein(coordX(p.getX()), coordY(p.getY()), diametre_point, c);
        pad.ajouter(point);
    }

    /**
     * Rôle : trace le nom d'un Point p dans la couleur c sur le Plan2D courant
     */

    public void tracerNomPoint(Point p, String nom_point, Color c) {
        Dessinable texte_point = new Texte(coordX(p.getX()), coordY(p.getY()), nom_point, c);
        pad.ajouter(texte_point);
    }

    /**
     * Rôle : trace le Segment s sur le Plan2D courant
     */
    public void tracerSegment(Segment s) {
        Dessinable segment = new Ligne(coordX(s.getOrig().getX()), coordY(s.getOrig().getY()), coordX(s.getFin().getX()), coordY(s.getFin().getY()), PlancheADessin.ROUGE);
        pad.ajouter(segment);
    }
}
