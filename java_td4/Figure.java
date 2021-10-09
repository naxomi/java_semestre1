package java_td4;

import PaD.PlancheADessin;

public abstract class Figure {
    protected Point origine;

    protected Figure(Point orig) {
        this.origine = orig;
    }

    public Point getOrigine() {
        return this.origine;
    }

    public abstract Double getPerimetre();

    public abstract Double getSurface();

    public abstract void dessiner(PlancheADessin pad);
}
