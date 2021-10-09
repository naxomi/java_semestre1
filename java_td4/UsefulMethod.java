package java_td4;

import java.util.Random;
import PaD.*;

public abstract class UsefulMethod {

    protected static java.awt.Color[] listColor = { PlancheADessin.BLEU, PlancheADessin.CYAN, PlancheADessin.GRIS,
            PlancheADessin.GRIS_CLAIR, PlancheADessin.GRIS_FONCÉ, PlancheADessin.JAUNE, PlancheADessin.MAGENTA,
            PlancheADessin.NOIR, PlancheADessin.ORANGE, PlancheADessin.ROSE, PlancheADessin.ROUGE };

    protected static Random random = new Random();

    private UsefulMethod() {
        throw new IllegalStateException("Utility class");
    }

    public static java.awt.Color randomColor() {
        return listColor[random.nextInt(listColor.length)];
    }

    public static Integer randomInteger(Integer min, Integer max) {
        return random.nextInt(max - min) + min;
    }
}
