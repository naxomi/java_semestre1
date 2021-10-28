package td4;

import PaD.*;

public class Ellipse extends Figure {

    protected Double bigAxis;
    protected Double smallAxis;

    public Ellipse(Double bigAxis, Double smallAxis) {
        super(new Point());

        this.bigAxis = bigAxis;
        this.smallAxis = smallAxis;
    }

    public Double getPerimeter() {
        return (Math.PI * Math.sqrt(2 * (Math.pow(this.bigAxis, 2) + Math.pow(this.smallAxis, 2))));
    }

    public Double getSurface() {
        return (Math.PI * this.bigAxis * this.smallAxis);
    }

    public void changeBigAxis(Double newBigAxis) {
        this.bigAxis = newBigAxis;
    }

    public void changeSmallAxis(Double newSmallAxis) {
        this.smallAxis = newSmallAxis;
    }

    public void draw(PlancheADessin drawWindow) {
        this.getOrigin().setX((double) Helper.randomInteger((int) drawWindow.getLargeur() / 8,
                (int) drawWindow.getLargeur() * 7 / 8));
        this.getOrigin().setY((double) Helper.randomInteger((int) drawWindow.getHauteur() / 8,
                (int) drawWindow.getHauteur() * 7 / 8));

        Dessinable ellipse = new EllipsePleine(this.getOrigin().getX(), this.getOrigin().getY(),
                this.bigAxis, this.smallAxis, Helper.randomColor());
        drawWindow.ajouter(ellipse);
    }

}
