package study_exam1;

public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point p1, Point p2, Point p3) {
        if (!(p1.egal(p2)) && !(p2.egal(p3)) && !(p1.egal(p3))) {
            this.point1 = p1;
            this.point2 = p2;
            this.point3 = p3;
        }
    }

    public Point getSommet(Sommets sommet) {
        switch (sommet) {
            case S1: {
                return this.point1;
            }
            case S2: {
                return this.point2;
            }
            case S3: {
                return this.point3;
            }
            default:
                return new Point();
        }
    }

    public void setSommet(Sommets sommet, Point p) {
        switch (sommet) {

            case S1: {
                this.point1 = p;
            }
            case S2: {
                this.point2 = p;
            }
            case S3: {
                this.point3 = p;
            }

        }
    }

    public double perimeter() {
        return (this.point1.distance(this.point2) + this.point1.distance(this.point3)
                + this.point2.distance(this.point3));
    }

    @Override
    public String toString() {
        return ("[(" + this.point1 + ");(" + this.point2 + ");(" + this.point3 + ")] ; perimetre de t :"
                + this.perimeter());
    }

}
