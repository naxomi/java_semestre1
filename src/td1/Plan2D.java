package td1;

import PaD.*;

import java.awt.*;

public class Plan2D {
    private static final double UNITE = 20;
    private static final double DIAMETER_POINT = 5;
    private final PlancheADessin pad;
    private final double length;
    private final double height;
    private final double middleLength;
    private final double middleHeight;

    public Plan2D() {
        this.pad = new PlancheADessin(true);
        this.length = pad.getLargeur();
        this.height = pad.getHauteur();
        this.middleLength = length / 2;
        this.middleHeight = height / 2;
        this.tracerAxes();
        this.tracerGraduations();
    }

    private double coordinateX(double x) {
        return (UNITE * x) + middleLength;
    }

    private double coordinateY(double y) {
        return -(UNITE * y) + middleHeight;
    }

    private void tracerAxes() {
        Dessinable axeAbscisse = new Ligne(0, middleHeight, length, middleHeight);
        Dessinable axeOrdonnee = new Ligne(middleLength, 0, middleLength, height);

        pad.ajouter(axeAbscisse);
        pad.ajouter(axeOrdonnee);
    }

    /*
     * Rôle : gradue les axes des abscisses et des ordonnées du Plan2D courant
     */
    private void tracerGraduations() {
        // Tracer les graduations sur l'axe des abscisses
        // Tracer du centre du graphique jusqu'au bord gauche
        for (double x = middleLength; x <= length; x = x + UNITE) {
            Dessinable graduationAbs = new Ligne(x, middleHeight + UNITE / 4, x, middleHeight - UNITE / 4);
            pad.ajouter(graduationAbs);
        }
        // Tracer du centre du graphique jusqu'au bord droit
        for (double x = middleLength; x >= 0; x = x - UNITE) {
            Dessinable graduationAbs = new Ligne(x, middleHeight + UNITE / 4, x, middleHeight - UNITE / 4);
            pad.ajouter(graduationAbs);
        }

        // Tracer les graduations sur l'axe des ordonées
        // Tracer du centre du graphique jusqu'en haut
        for (double y = middleHeight; y <= height; y = y + UNITE) {
            Dessinable graduationOrd = new Ligne(middleLength + UNITE / 4, y, middleLength - UNITE / 4, y);
            pad.ajouter(graduationOrd);
        }
        // Tracer du centre du graphique jusqu'en bas
        for (double y = middleHeight; y >= 0; y = y - UNITE) {
            Dessinable graduationOrd = new Ligne(middleLength + UNITE / 4, y, middleLength - UNITE / 4, y);
            pad.ajouter(graduationOrd);
        }

    }

    /**
     * Rôle : trace le Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerPoint(Point p, Color c) {
        Dessinable point = new CerclePlein(coordinateX(p.getX()), coordinateY(p.getY()), DIAMETER_POINT, c);
        pad.ajouter(point);
        tracerNomPoint(p, p.getName(), c);
    }

    /**
     * Rôle : trace le nom d'un Point p dans la couleur c sur le Plan2D courant
     */
    public void tracerNomPoint(Point p, String nomPoint, Color c) {
        Dessinable textePoint = new Texte(coordinateX(p.getX()), coordinateY(p.getY()), nomPoint, c);
        pad.ajouter(textePoint);
    }

    /**
     * Rôle : trace le Segment s sur le Plan2D courant
     */
    public void tracerSegment(Segment s) {
        double x1 = coordinateX(s.getOrig().getX());
        double y1 = coordinateY(s.getOrig().getY());
        double x2 = coordinateX(s.getFin().getX());
        double y2 = coordinateY(s.getFin().getY());

        Dessinable segment = new Ligne(x1, y1, x2, y2, PlancheADessin.ROUGE);
        pad.ajouter(segment);
    }
}
