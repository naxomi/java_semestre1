package studyExam2;

public class Collection {

    private Oeuvre[] collection;

    public Collection() {
        this.collection = new Oeuvre[100];
    }

    public void add(Oeuvre o, int i) {
        if (i >= 0 && i <= 99) {
            this.collection[i] = o;
        }
    }

    public void like(int i) {
        Oeuvre oeuvreChoisie = null;
        if (i >= 0 && i <= 99) {
            oeuvreChoisie = this.collection[i];
        }
        if (oeuvreChoisie != null) {
            oeuvreChoisie.like();
        }
    }

    public void displayYears(int start, int end) {
        for (int i = 0; i < 100; i++) {
            Oeuvre oeuvre = this.collection[i];
            if (oeuvre != null) {
                if (oeuvre.getYear() >= start && oeuvre.getYear() <= end) {
                    System.out.println(oeuvre.getClass().getSimpleName() + " from " + oeuvre.getArtist() + " created in " + oeuvre.getYear());
                }
            }
        }
    }
}
