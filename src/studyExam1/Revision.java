package studyExam1;

import java.util.Scanner;

public class Revision {
    public static void multiplication(int x) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(x + " x " + i + " = " + x * i);
        }
    }

    public static void quadraticResolution(int a, int b, int c) {
        double delta = (Math.pow(b, 2) - 4 * a * c);

        if (delta > 0) {
            double root1 = ((-b - Math.sqrt(delta)) / (2 * a));
            double root2 = ((-b + Math.sqrt(delta)) / (2 * a));

            System.out.println("Racine 1 : " + root1);
            System.out.println("Racine 2 : " + root2);
        }

        else if (delta == 0) {
            double root = (-b) / (2 * a);
            System.out.println("La seule racine est : " + root);
        }

        else {
            System.out.println("Il n'y a pas de racines réelles.");
        }
    }

    public static void testFloatingPoint(double a, double b) {

        if (Math.abs(a - b) < 1E-3) {
            System.out.println("a et b sont egales a 3 decimales pres");
        } else {
            System.out.println("a et b ne sont pas egales a 3 decimales pres");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a : ");
        double a = sc.nextDouble();
        System.out.print("b : ");
        double b = sc.nextDouble();

        testFloatingPoint(a, b);

        sc.close();
    }

}
