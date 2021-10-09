package java_td4;

import java.util.Random;
import PaD.PlancheADessin;

public class TestTd4 {

    public void exerciceRelationAppartenance() {
        // Answer to question 1 :
        // Implicit super constructor Figure() is undefined. Must explicitly invoke
        // another constructor

        // Answer to question 12 :
        // We can see that the square is no longer a square because the longueur was
        // changed like if it was a rectangle.
        Carre carre = new Carre(10.0);
        System.out.println(carre);
        carre.changerLongueur(5.0);
        System.out.println(carre);
    }

    public static void exercicePolymorphisme() {

        // Answer to question 15
        // The information from the TD are verified because we can a Carre stored in a
        // Rectangle variable but not a Cercle stored in a Rectangle variable.

        // Answer to question 16
        // We get the error "Type mismatch: cannot convert from Rectangle to Carre"
        // which means that a rectangle cannot be stored in a Carre variable.

        // Answer to question 17
        // Even if a Carre was created in r1, since r1 is a Rectangle it is considered
        // as a Rectangle by Java.

        // Question 18 -> 21

        // Figure[] tf = new Figure[4];
        // tf[0] = new Ellipse(3.0, 5.0);
        // tf[1] = new Rectangle(8.0, 3.0);
        // tf[2] = new Carre(4.0);
        // tf[3] = new Cercle(4.0);

        // for (int i = 0; i < 4; i++) {
        // System.out.println(tf[i].getPerimetre());
        // System.out.println(tf[i].getSurface());
        // }

        // Question 22 -> 23
        Random random = new Random();
        Figure[] tf = new Figure[4];

        for (int i = 0; i < 4; i++) {
            Integer randNumber = random.nextInt(4);

            if (randNumber == 0) {
                tf[i] = new Ellipse(15.0, 20.0);
            } else if (randNumber == 1) {
                tf[i] = new Cercle(15.0);
            } else if (randNumber == 2) {
                tf[i] = new Rectangle(15.0, 20.0);
            } else if (randNumber == 3) {
                tf[i] = new Carre(15.0);
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(tf[i].getClass());
            System.out.println(tf[i].getPerimetre());
            System.out.println(tf[i].getSurface());
        }
    }

    public static void exerciceVisualisationDeForme() {

        Integer numberOfFigure = 10;
        Figure[] tf = new Figure[numberOfFigure];

        PlancheADessin fenetreDessin = new PlancheADessin();

        for (int i = 0; i < numberOfFigure; i++) {
            Integer randNumber = UsefulMethod.randomInteger(0, 4);

            if (randNumber == 0) {
                tf[i] = new Ellipse(150.0, 200.0);
            } else if (randNumber == 1) {
                tf[i] = new Cercle(150.0);
            } else if (randNumber == 2) {
                tf[i] = new Rectangle(150.0, 200.0);
            } else if (randNumber == 3) {
                tf[i] = new Carre(150.0);
            }

            System.out.println("Figure drawn : " + tf[i].getClass().toString().replace("class java_td4.", ""));
            tf[i].dessiner(fenetreDessin);
        }
    }

    public static void main(String[] args) {
        exerciceVisualisationDeForme();
    }
}
