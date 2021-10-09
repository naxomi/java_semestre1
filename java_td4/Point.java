package java_td4;

public class Point {
    private Double x;
    private Double y;

    public Point(Double a, Double b) {
        this.x = a;
        this.y = b;
    }

    public Point() {
        this(0.0, 0.0);
    }

    public Double getAbscisse() {
        return this.x;
    }

    public Double getOrdonnee() {
        return this.y;
    }

    public void setAbscisse(Double newAbscisse) {
        this.x = newAbscisse;
    }

    public void setOrdonnee(Double newOrdonee) {
        this.y = newOrdonee;
    }
}
