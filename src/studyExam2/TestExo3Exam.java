package studyExam2;

public class TestExo3Exam {
    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.add(new Peinture(1925, "Picasso"), 0);
        collection.add(new Peinture(1890, "Renoir"), 1);
        collection.add(new Sculpture(2007, "César", Matiere.metal), 2);
        collection.add(new Sculpture(1508, "MichelAnge", Matiere.pierre), 10);
        collection.add(new Sculpture(1986, "Buren", Matiere.pierre), 20);

        collection.displayYears(1800, 1930);
        System.out.println("---------------");
        collection.displayYears(1970, 1990);
    }
}
