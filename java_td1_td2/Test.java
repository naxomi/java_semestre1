import PaD.PlancheADessin;

/**
 * Classe de Test pour tester les différentes classes du td1 et 2
 *
 * @author V. Granet vg@unice.fr
 */

public class Test {
    public static void main(String [] args)  throws Exception {

/*         // ----- 1 -----
        Point O = new Point();
        Point A = new Point(14,-5);
        Point B = new Point(2, 7);

        System.out.println(O);
        System.out.println(A);
        System.out.println(B);
        
        System.out.println("distance (O,A) = " + O.distance(A));
        System.out.println("distance (O,B) = " + O.distance(B));
        System.out.println("distance (A,B) = " + A.distance(B));

        System.out.println("A=B ? : " + A.egal(B)); */

    // ----- 2 -----
/*     Point O = new Point();
    Point A = new Point(14,-5);
    Point B = new Point(2, 7);

    Vecteur2 AO = new Vecteur2(A, O);
    Vecteur2 OB = new Vecteur2(O, B);
    Vecteur2 AB = new Vecteur2(A, B);

    System.out.println("Vecteur AO : " + AO);
    System.out.println("Vecteur OB : " + OB);
    System.out.println("Vecteur AB : " + AB);

    Boolean cond1 = AO.getX() + OB.getX() == AB.getX();
    Boolean cond2 = AO.getY() + OB.getY() == AB.getY();
    if (cond1 && cond2) {
        System.out.println("AO + OB = AB");
    }

    Point C = new Point(5,4);

    Vecteur2 AC = new Vecteur2(A, C);
    Vecteur2 BC = new Vecteur2(B, C);

    if (AC.colineaire(AB)) {
        System.out.println("AC est colineaire a BC");
    }

    Point D = new Point(1, 2);
    Point E = new Point(2,0);
    Point F = new Point(3,2);

    Vecteur2 OD = new Vecteur2(O, D);
    Vecteur2 EF = new Vecteur2(E, F);

    if (OD.egal(EF)) {
        System.out.println("ODFE est un parallelogramme");
    } */

    // ----- 3 -----

/*     Point A = new Point(14,-5);
    Point B = new Point(2, 7);
    Point C = new Point(5,4);
    Point D = new Point(1, 2);
    Point G = new Point(-2, -3);
    Point H = new Point(9, 5);
 
    Segment AB = new Segment(A, B);
    Segment GH = new Segment(G, H);

    System.out.println("Vecteur AB : " + AB);
    System.out.println("C appartient a AB : " + AB.appartient(C));
    System.out.println("D appartient a AB : " + AB.appartient(D));
    
    Point point_intersection = AB.intersection(GH);
    System.out.println("AB intersection GH : " + point_intersection);

    if ((AB.appartient(point_intersection)) && (GH.appartient(point_intersection))) {
        System.out.println("Le point d'intersection appartient bien a AB et GH.");
    }
    else {
        System.out.println("Le point d'intersection n'appartient pas a AB ou GH.");
    } */

    // ----- 4 -----

    Point A = new Point(14,-5);
    Point B = new Point(2, 7);
    Point C = new Point(5,4);
    Point D = new Point(1, 2);
    Point G = new Point(-2, -3);
    Point H = new Point(9, 5);

    Segment AB = new Segment(A, B);
    Segment GH = new Segment(G, H);

    Plan2D graphique = new Plan2D();

    graphique.tracerPoint(A, PlancheADessin.BLEU);
    graphique.tracerNomPoint(A, "A", PlancheADessin.BLEU);
    graphique.tracerPoint(B, PlancheADessin.BLEU);
    graphique.tracerNomPoint(B, "B", PlancheADessin.BLEU);
    graphique.tracerPoint(C, PlancheADessin.BLEU);
    graphique.tracerNomPoint(C, "C", PlancheADessin.BLEU);
    graphique.tracerPoint(D, PlancheADessin.BLEU);
    graphique.tracerNomPoint(D, "D", PlancheADessin.BLEU);
    graphique.tracerPoint(G, PlancheADessin.BLEU);
    graphique.tracerNomPoint(G, "G", PlancheADessin.BLEU);
    graphique.tracerPoint(H, PlancheADessin.BLEU);
    graphique.tracerNomPoint(H, "H", PlancheADessin.BLEU);

    graphique.tracerSegment(AB);
    graphique.tracerSegment(GH);

    Point point_intersection = AB.intersection(GH);
    graphique.tracerPoint(point_intersection, PlancheADessin.VERT);

    }
}
