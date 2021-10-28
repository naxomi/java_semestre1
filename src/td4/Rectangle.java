package td4;

import PaD.*;

public class Rectangle extends Figure {

    protected Double length;
    protected final Double width;

    // - Answer to question 1 :
    // Implicit super constructor Figure() is undefined.
    // Must explicitly invoke another constructor.

    public Rectangle(Double length, Double width) {
        super(new Point());

        this.length = length;
        this.width = width;
    }

    public Double getPerimeter() {
        return (this.length * 2 + this.width * 2);
    }

    public Double getSurface() {
        return (this.length * this.width);
    }

    public void changeLength(Double newLength) {
        this.length = newLength;
    }

    public void changeWidth(Double newWidth) {
        this.length = newWidth;
    }

    @Override
    public String toString() {
        String outsideLength = "+ " + "--".repeat((int) Math.round(this.length)) + " +\n";
        String insideLength = "| " + " ".repeat((int) Math.round(this.length) * 2) + " |\n";

        return (outsideLength + insideLength.repeat((int) Math.round(this.width)) + outsideLength);
    }

    public void draw(PlancheADessin drawWindow) {
        this.getOrigin().setX((double) Helper.randomInteger((int) drawWindow.getLargeur() / 8,
                (int) drawWindow.getLargeur() * 7 / 8));
        this.getOrigin().setY((double) Helper.randomInteger((int) drawWindow.getHauteur() / 8,
                (int) drawWindow.getHauteur() * 7 / 8));

        Dessinable rectangle = new RectanglePlein(this.getOrigin().getX(), this.getOrigin().getY(),
                this.length, this.width, Helper.randomColor());
        drawWindow.ajouter(rectangle);
    }
}
