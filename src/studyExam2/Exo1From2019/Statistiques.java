package studyExam2.Exo1From2019;

public class Statistiques {
    private Double[] stats;

    public Statistiques() {
        this.stats = new Double[4];
    }

    public void calcul(Double[] notes) {
        // Nombre de notes utilisees
        double nbNotes = notes.length;
        this.stats[0] = nbNotes;

        // Calcul Moyenne | Note min | Note max
        double moyenne = 0.0;
        double min = 20.0;
        double max = 0.0;

        for (double note : notes) {
            moyenne += note;

            if (note < min) {
                min = note;
            }
            if (note > max) {
                max = note;
            }
        }
        moyenne /= nbNotes;

        this.stats[1] = moyenne;
        this.stats[2] = min;
        this.stats[3] = max;
    }

    public Double[] getStats() {
        return this.stats;
    }
}
