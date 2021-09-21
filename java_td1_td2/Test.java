import PaD.PlancheADessin;

/**
 * Classe de Test pour tester les différentes classes du td1 et 2
 *
 * @author V. Granet vg@unice.fr
 */

public class Test {

    static final Point pointO = new Point();
    static final Point pointA = new Point(14,-5, "A");
    static final Point pointB = new Point(2, 7, "B");
    static final Point pointC = new Point(5,4, "C");
    static final Point pointD = new Point(1, 2, "D");
    static final Point pointE = new Point(2, 0, "E");
    static final Point pointF = new Point(3, 2, "F");
    static final Point pointG = new Point(-2, -3, "G");
    static final Point pointH = new Point(9, 5, "H");

    static final String TEXT_SEPARATOR = "------------------------";

    public static void exercice1() {
        System.out.println("-------- Exercice 1 --------");

        System.out.println(pointO);
        System.out.println(pointA);
        System.out.println(pointB);
        
        System.out.println("distance (O,A) = " + pointO.distance(pointA));
        System.out.println("distance (O,B) = " + pointO.distance(pointB));
        System.out.println("distance (A,B) = " + pointA.distance(pointB));

        System.out.println("A=B ? : " + pointA.egal(pointB));

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercice2() {
        System.out.println("-------- Exercice 2 --------");

        Vecteur2 vecteurAO = new Vecteur2(pointA, pointO);
        Vecteur2 vecteurOB = new Vecteur2(pointO, pointB);
        Vecteur2 vecteurAB = new Vecteur2(pointA, pointB);
    
        System.out.println("Vecteur AO : " + vecteurAO);
        System.out.println("Vecteur OB : " + vecteurOB);
        System.out.println("Vecteur AB : " + vecteurAB);
    
        Boolean cond1 = vecteurAO.getX() + vecteurOB.getX() == vecteurAB.getX();
        Boolean cond2 = vecteurAO.getY() + vecteurOB.getY() == vecteurAB.getY();
        if (cond1 && cond2) {
            System.out.println("AO + OB = AB");
        }
    
        Vecteur2 vecteurAC = new Vecteur2(pointA, pointC);
    
        if (vecteurAC.colineaire(vecteurAB)) {
            System.out.println("AC est colineaire a BC");
        }

        Vecteur2 vecteurOD = new Vecteur2(pointO, pointD);
        Vecteur2 vecteurEF = new Vecteur2(pointE, pointF);
    
        if (vecteurOD.egal(vecteurEF)) {
            System.out.println("ODFE est un parallelogramme");
        }

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercice3() {    
        System.out.println("-------- Exercice 3 --------");
        
        Segment segmentAB = new Segment(pointA, pointB);
        Segment segmentGH = new Segment(pointG, pointH);

        System.out.println("Vecteur AB : " + segmentAB);
        System.out.println("C appartient a AB : " + segmentAB.appartient(pointC));
        System.out.println("D appartient a AB : " + segmentAB.appartient(pointD));
        
        Point pointIntersection = segmentAB.intersection(segmentGH);
        System.out.println("AB intersection GH : " + pointIntersection);

        if (segmentAB.appartient(pointIntersection) && (segmentGH.appartient(pointIntersection))) {
            System.out.println("Le point d'intersection appartient bien a AB et GH.");
        }

        System.out.println(TEXT_SEPARATOR);
    }

    public static void exercice4() {
        System.out.println("-------- Exercice 4 --------");

        Segment segmentAB = new Segment(pointA, pointB);
        Segment segmentGH = new Segment(pointG, pointH);
    
        Plan2D graphique = new Plan2D();
    
        graphique.tracerPoint(pointA, PlancheADessin.BLEU);
        graphique.tracerPoint(pointB, PlancheADessin.BLEU);
        graphique.tracerPoint(pointC, PlancheADessin.BLEU);
        graphique.tracerPoint(pointD, PlancheADessin.BLEU);
        graphique.tracerPoint(pointG, PlancheADessin.BLEU);
        graphique.tracerPoint(pointH, PlancheADessin.BLEU);
    
        graphique.tracerSegment(segmentAB);
        graphique.tracerSegment(segmentGH);
    
        Point pointIntersection = segmentAB.intersection(segmentGH);
        graphique.tracerPoint(pointIntersection, PlancheADessin.GRIS_FONCÉ);

        System.out.println(TEXT_SEPARATOR);
    } 
    public static void main(String [] args)  throws Exception {
        System.out.println("########## Debut du td ##########");
        Test.exercice1();
        Test.exercice2();
        Test.exercice3();
        Test.exercice4();
        System.out.println(TEXT_SEPARATOR);
    }
}
