package td4;

public class Square extends Rectangle {

    public Square(Double lengthSide) {
        super(lengthSide, lengthSide);
    }

    @Override
    public void changeLength(Double newLength) {
        super.changeWidth(newLength);
        super.changeLength(newLength);
    }

    @Override
    public void changeWidth(Double newWidth) {
        super.changeLength(newWidth);
        super.changeWidth(newWidth);
    }
}
