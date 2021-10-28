package td4;

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

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public void setX(Double newX) {
        this.x = newX;
    }

    public void setY(Double newY) {
        this.y = newY;
    }
}
