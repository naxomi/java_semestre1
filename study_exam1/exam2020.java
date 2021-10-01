package study_exam1;

public class exam2020 {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 1.0, "p1");
        Point p2 = new Point(2.0, 2.0, "p2");
        Point p3 = new Point(0.0, 2.0, "p3");
        Point p4 = new Point(4.0, 3.0, "p4");

        Triangle triangle1 = new Triangle(p1, p2, p3);
        Triangle triangle2 = new Triangle(p1, p4, p3);

        System.out.println(triangle1);
        System.out.println(triangle2);

    }
}
