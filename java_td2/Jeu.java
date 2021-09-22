import PaD.*;

public class Jeu {
    public static void main(String[] args) {
        
        Carte dameDePique = new Carte(Valeur.dame, Couleur.pique, new PaD.Image("java_td2/Cartes/dame-pique.gif"));
        Carte sixDeTrefle = new Carte(Valeur.six, Couleur.trefle, new PaD.Image("java_td2/Cartes/six-trefle.gif"));
        
        PlancheADessin fenetreJeu = new PlancheADessin(true);

        System.out.println(dameDePique);
        System.out.println(sixDeTrefle);

        System.out.println("Comparaison de 'dame de pique' contre 'six de trefle' : " + dameDePique.compareTo(sixDeTrefle));
        
        dameDePique.dessiner(fenetreJeu, 100, 100);
        sixDeTrefle.dessiner(fenetreJeu, 200, 100);
    }
}
