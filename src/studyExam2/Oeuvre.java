package studyExam2;

public class Oeuvre {
    private final Integer year;
    private final String artist;
    private Integer like;

    public Oeuvre(int year, String artist) {
        this.year = year;
        this.artist = artist;
        this.like = 0;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public String DisplayDetails() {
        return artist + " | " + year + " | Likes: " + like;
    }

    public void like() {
        like++;
    }
}
