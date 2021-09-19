import PaD.*;

public class Dessin {
    public static void main(String [] args) {
        PlancheADessin pad = new PlancheADessin();
        double milieu = pad.getLargeur()/2;

        double body_width = 80;
        double body_height = 170;

        Dessinable titre = new Texte(milieu - 60, 10, "Mon bonhomme");
        Dessinable tete = new CerclePlein(milieu, 80, 60, PlancheADessin.ROUGE);
        Dessinable coup = new Ligne(milieu, 110, milieu, 170);
        Dessinable corps = new RectanglePlein(milieu-40, 170, 80, 100, PlancheADessin.VERT);

        Dessinable arm_1 = new Ligne(milieu - body_width / 2, 200, milieu - body_width * 2, 230, PlancheADessin.BLEU);
        Dessinable arm_2 = new Ligne(milieu + body_width / 2, 200, milieu + body_width * 2, 230, PlancheADessin.BLEU);
        Dessinable leg_1 = new Ligne(milieu - body_width / 4, 100 + body_height, milieu - body_width / 4, 100 + body_height + 100, PlancheADessin.BLEU);
        Dessinable leg_2 = new Ligne(milieu + body_width / 4, 100 + body_height, milieu + body_width / 4, 100 + body_height + 100, PlancheADessin.BLEU);
        
        pad.ajouter(titre);
        pad.ajouter(tete);
        pad.ajouter(coup);
        pad.ajouter(corps);
        pad.ajouter(arm_1);
        pad.ajouter(arm_2);
        pad.ajouter(leg_1);
        pad.ajouter(leg_2);

    }
}


