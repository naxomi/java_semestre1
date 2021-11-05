package studyExam2.Exo1From2019;

public class TestStatistiques {
    public static void main(String[] args) {
        Statistiques stat = new Statistiques();

        Double[] listNotes = new Double[]{2.0, 18.0, 12.0, 14.0};
        stat.calcul(listNotes);
        Double[] statis = stat.getStats();

        for (Double note : statis) {
            System.out.println(note);
        }

    }
}
