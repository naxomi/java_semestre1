package td4;

import PaD.*;

import java.util.Random;

public abstract class Helper {

    protected static final java.awt.Color[] listColor = { PlancheADessin.BLEU, PlancheADessin.CYAN, PlancheADessin.GRIS,
            PlancheADessin.GRIS_CLAIR, PlancheADessin.GRIS_FONCÉ, PlancheADessin.JAUNE, PlancheADessin.MAGENTA,
            PlancheADessin.NOIR, PlancheADessin.ORANGE, PlancheADessin.ROSE, PlancheADessin.ROUGE };

    protected static final Random random = new Random();

    public static java.awt.Color randomColor() {
        return listColor[random.nextInt(listColor.length)];
    }

    public static Integer randomInteger(Integer min, Integer max) {
        return random.nextInt(max - min) + min;
    }
}
