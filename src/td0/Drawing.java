package td0;

import PaD.*;

public class Drawing {
    public static void main(String[] args) {
        PlancheADessin pad = new PlancheADessin();

        double middleWidth = pad.getLargeur() / 2;
        double body_width = 80;
        double body_height = 170;

        Dessinable title = new Texte(middleWidth - 60, 10, "That's my man");
        Dessinable head = new CerclePlein(middleWidth, 80, 60, PlancheADessin.ROUGE);
        Dessinable neck = new Ligne(middleWidth, 110, middleWidth, 170);
        Dessinable body = new RectanglePlein(middleWidth - 40, 170, 80, 100, PlancheADessin.VERT);

        Dessinable arm_1 = new Ligne(middleWidth - body_width / 2, 200, middleWidth - body_width * 2, 230, PlancheADessin.BLEU);
        Dessinable arm_2 = new Ligne(middleWidth + body_width / 2, 200, middleWidth + body_width * 2, 230, PlancheADessin.BLEU);
        Dessinable leg_1 = new Ligne(middleWidth - body_width / 4, 100 + body_height, middleWidth - body_width / 4,
                100 + body_height + 100, PlancheADessin.BLEU);
        Dessinable leg_2 = new Ligne(middleWidth + body_width / 4, 100 + body_height, middleWidth + body_width / 4,
                100 + body_height + 100, PlancheADessin.BLEU);

        pad.ajouter(title);
        pad.ajouter(head);
        pad.ajouter(neck);
        pad.ajouter(body);
        pad.ajouter(arm_1);
        pad.ajouter(arm_2);
        pad.ajouter(leg_1);
        pad.ajouter(leg_2);

    }
}
