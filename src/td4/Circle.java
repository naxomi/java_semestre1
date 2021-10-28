package td4;

public class Circle extends Ellipse {

    public Circle(Double diameter) {
        super(diameter, diameter);
    }

    @Override
    public void changeBigAxis(Double diameter) {
        super.changeBigAxis(diameter);
        super.changeSmallAxis(diameter);
    }

    @Override
    public void changeSmallAxis(Double diameter) {
        super.changeSmallAxis(diameter);
        super.changeBigAxis(diameter);
    }
}
