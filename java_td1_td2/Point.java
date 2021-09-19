/**
 * Cette classe représente les points du plan cartésien.
 *
 * @author V. Granet vg@unice.fr
 */


public class Point {
    private double abs;
    private double ord;
    /* 
     * Rôle : initialise le point (0,0)
     */
    public Point() {
        this(0.0, 0.0);
    }
    
    /* 
     * Rôle : initialise le point (x,y)
     */
    public Point(double x, double y) {
        this.abs = x;
        this.ord = y;
    }

    /**
     *  Rôle : renvoie l'abscisse du Point courant 
     */
    public double getX() {
        return this.abs;
    }

    /**
     *  Rôle : renvoie l'ordonnée du Point courant 
     */
    public double getY() {
        return this.ord;
    }

    /**
     *  Rôle :  change l'abscisse du Point courant 
     */
    public void setX(double x) {
        this.abs = x;
    }

    /**
     *  Rôle : change l'ordonnée du Point courant 
     */
    public void setY(double y) {
        this.ord = y;
    }

    /**
     * Rôle : teste si le Point courant est égal à au Point p
     */
    public boolean egal(Point p) {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }

    /**
     *  Rôle : envoie la distance entre le Point courant et le Point p
     *  Rappel : distance(a,b) = rac2((b_x-a-x)^2+(b_y-a-y)^2)
     */
    public double distance(Point p) {
        return Math.sqrt( Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2) );
    }
    
    /**
     * Rôle : renvoie la représentation du Point courant sous
     *        forme d'une chaîne de caratères
     */
    @Override
     public String toString() {
        return (this.getX() + ", " + this.getY()).toString();
    }

}
