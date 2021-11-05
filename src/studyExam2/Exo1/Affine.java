package studyExam2.Exo1;

public class Affine {
    int a, b;
    double racine;

    public Affine(int a, int b) {
        this.b = b;
        this.setA(a);
    }

    public Affine(int a) {
        this(a, 0);
    }

    private double resoudre() throws ArithmeticException {
        return ((double) -b / a);
    }

    public void setA(int a) {
        this.a = a;
        try {
            this.racine = this.resoudre();
        } catch (ArithmeticException e) {
            System.err.println("Error : divided by 0");
            e.printStackTrace();
        }
    }

    public void setB(int b) {
        this.b = b;
        this.racine = this.resoudre();
    }

    public static void main(String[] args) {
        Affine equation = new Affine(10, 10);
        System.out.println(equation.racine); // -1.0
        equation.setA(50);
        System.out.println(equation.racine); // -0.2
        equation.setB(100);
        System.out.println(equation.racine); // -2.0
    }
}
