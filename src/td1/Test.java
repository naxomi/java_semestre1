package td1;

import PaD.PlancheADessin;

/**
 * Classe de Test pour tester les différentes classes du td1 et 2
 *
 * @author V. Granet vg@unice.fr
 */

public class Test {

    static final Point pointO = new Point();
    static final Point pointA = new Point(14, -5, "A");
    static final Point pointB = new Point(2, 7, "B");
    static final Point pointC = new Point(5, 4, "C");
    static final Point pointD = new Point(1, 2, "D");
    static final Point pointE = new Point(2, 0, "E");
    static final Point pointF = new Point(3, 2, "F");
    static final Point pointG = new Point(-2, -3, "G");
    static final Point pointH = new Point(9, 5, "H");

    static final String TEXT_SEPARATOR = "------------------------";

    public static void exercise1() {
        System.out.println("-------- Exercise 1 --------");

        System.out.println(pointO);
        System.out.println(pointA);
        System.out.println(pointB);

        System.out.println("distance (O,A) = " + pointO.distance(pointA));
        System.out.println("distance (O,B) = " + pointO.distance(pointB));
        System.out.println("distance (A,B) = " + pointA.distance(pointB));

        System.out.println("A=B ? : " + pointA.equals(pointB));

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercise2() {
        System.out.println("-------- Exercise 2 --------");

        Vector2 vectorAO = new Vector2(pointA, pointO);
        Vector2 vectorOB = new Vector2(pointO, pointB);
        Vector2 vectorAB = new Vector2(pointA, pointB);

        System.out.println("Vector AO : " + vectorAO);
        System.out.println("Vector OB : " + vectorOB);
        System.out.println("Vector AB : " + vectorAB);

        Boolean cond1 = vectorAO.getX() + vectorOB.getX() == vectorAB.getX();
        Boolean cond2 = vectorAO.getY() + vectorOB.getY() == vectorAB.getY();
        if (cond1 && cond2) {
            System.out.println("AO + OB = AB");
        }

        Vector2 vectorAC = new Vector2(pointA, pointC);

        if (vectorAC.collinear(vectorAB)) {
            System.out.println("AC is collinear with BC");
        }

        Vector2 vectorOD = new Vector2(pointO, pointD);
        Vector2 vectorEF = new Vector2(pointE, pointF);

        if (vectorOD.equals(vectorEF)) {
            System.out.println("ODFE est un parallelogramme");
        }

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercise3() {
        System.out.println("-------- Exercice 3 --------");

        Segment segmentAB = new Segment(pointA, pointB);
        Segment segmentGH = new Segment(pointG, pointH);

        System.out.println("Vector AB : " + segmentAB);
        System.out.println("C belongs to AB : " + segmentAB.belongsTo(pointC));
        System.out.println("D belongs to AB : " + segmentAB.belongsTo(pointD));

        Point pointIntersection = segmentAB.intersection(segmentGH);
        System.out.println("AB intersection GH : " + pointIntersection);

        if (segmentAB.belongsTo(pointIntersection) && (segmentGH.belongsTo(pointIntersection))) {
            System.out.println("The intersection point belongs to AB and GH.");
        }

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercise4() {
        System.out.println("-------- Exercise 4 --------");

        Segment segmentAB = new Segment(pointA, pointB);
        Segment segmentGH = new Segment(pointG, pointH);

        Plan2D graph = new Plan2D();

        graph.tracerPoint(pointA, PlancheADessin.BLEU);
        graph.tracerPoint(pointB, PlancheADessin.BLEU);
        graph.tracerPoint(pointC, PlancheADessin.BLEU);
        graph.tracerPoint(pointD, PlancheADessin.BLEU);
        graph.tracerPoint(pointG, PlancheADessin.BLEU);
        graph.tracerPoint(pointH, PlancheADessin.BLEU);

        graph.tracerSegment(segmentAB);
        graph.tracerSegment(segmentGH);

        Point pointIntersection = segmentAB.intersection(segmentGH);
        graph.tracerPoint(pointIntersection, PlancheADessin.GRIS_FONCÉ);

        System.out.println(TEXT_SEPARATOR);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("# --- Start of the exercises --- #");
        Test.exercise1();
        Test.exercise2();
        Test.exercise3();
        Test.exercise4();
        System.out.println(TEXT_SEPARATOR);
    }
}
