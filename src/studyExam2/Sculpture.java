package studyExam2;

public class Sculpture extends Oeuvre {
    private final Matiere matiere;

    public Sculpture(int year, String artist, Matiere mat) {
        super(year, artist);
        this.matiere = mat;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    @Override
    public String DisplayDetails() {
        return this.getArtist() + " | " + this.getYear() + " | Likes: " + this.getLike();
    }
}
