package td4;

import PaD.PlancheADessin;

public abstract class Figure {
    protected final Point origin;

    protected Figure(Point orig) {
        this.origin = orig;
    }

    public Point getOrigin() {
        return this.origin;
    }

    public abstract Double getPerimeter();

    public abstract Double getSurface();

    public abstract void draw(PlancheADessin pad);
}
