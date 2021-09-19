import javax.sql.XAConnection;

/**
 * Cette classe représente les segments de droite entre 2 points du plan. 
 * Ces deux points doivent être différents.
 *
 * @author V. Granet vg@unice.fr
 */

public class Segment {
    private Point orig, fin;
    /**
     * Rôle : initialise le Segment de droite d'orgine O et de fin a 
     * Antécédent : a != 0
     */
    public Segment(Point a) {
        this(new Point(0.0, 0.0), a);
    }
    
    /**
     * Rôle : initialise le Segment de droite d'orgine a et de fin b
     * Antécédent : a != b
     */
    public Segment(Point a, Point b) {
        if (!(a.egal(b))) {
            this.orig = a;
            this.fin = b;
        }
        else {System.out.println("Couldn't initialize because A = B");}
    }
    
    /**
     * Rôle : renvoie le point d'origne du Segment courant
     */
    public Point getOrig() {
        return this.orig;
    }

    /**
     * Rôle : renvoie le point de fin du Segment courant
     */
    public Point getFin() {
        return this.fin;
    }

    /**
     * Rôle : modifie le point d'origine du Semgent courant
     */
    public void setOrig(Point orig) {
        this.orig = orig;
    }

    /**
     * Rôle : modifie le point de fin du Semgent courant
     */
    public void setFin(Point fin) {
        this.fin = fin;
    }

    /**
     * Rôle : renvoie la représentation du Segment courant sous
     *        forme d'une chaîne de caratères
     */
    @Override
    public String toString() {
	    return "[(" + this.getOrig() + ") ; (" + this.getFin() + ")]"; 
    }
    /**
     * Rôle : renvoie la longueur du Segment courant sous
     *        forme d'un double
     */
    public double longueur() {
        return this.getOrig().distance(this.getFin());
    }

    /**
     * rôle : teste si le Point p appartient au Segment courant
     */ 
    public boolean appartient(Point p) {

        Vecteur2 AB = new Vecteur2(this.getOrig(), this.getFin());
        Vecteur2 AC = new Vecteur2(this.getOrig(), p);
    
        if (AB.colineaire(AC)) {
            double k = AC.getX() / AB.getX();
            return ((k <= 1) && (k >= 0));
        }
        else {
            return false;
        }
    }

    /**
     * rôle : renvoie le Point d'intersection entre le Segment courant
     *        et le Segment s. Si pas de point d'intersaction, la
     *        fonction renvoie null
     */
    public Point intersection(Segment s) {

        double x_a = this.getOrig().getX();
        double x_b = this.getFin().getX();
        double x_c = s.getOrig().getX();
        double x_d = s.getFin().getX();

        double y_a = this.getOrig().getY();
        double y_b = this.getFin().getY();
        double y_c = s.getOrig().getY();
        double y_d = s.getFin().getY();

        double k_ab_num = (y_a-y_c) * (x_d-x_c) - (x_a-x_c)*(y_d-y_c);
        double k_ab_denom = (x_b-x_a) * (y_d-y_c) - (y_b-y_a) * (x_d-x_c);
        double k_cd_num = (x_c-x_a) * (y_b-y_a) + (y_a-y_c) * (x_b-x_a);
        double k_cd_denom = (y_d-y_c) * (x_b-x_a) - (x_d-x_c) * (y_b-y_a);

        double k_ab = k_ab_num / k_ab_denom;
        double k_cd = k_cd_num / k_cd_denom;
        
        if ((k_ab >= 0 && k_ab <= 1) && (k_cd >= 0 && k_cd <= 1)) {
            double x_i_ab = k_ab * (x_b-x_a) +x_a;
            double y_i_ab = k_ab * (y_b-y_a) +y_a;

            // double x_i_cd = k_cd * (x_d-x_c) +x_c;
            // double y_i_cd = k_cd * (y_d-y_c) +y_c;

            return new Point(x_i_ab, y_i_ab);
        }
        
        return null;
    }
}