package td2;

public class Test2 {
    public static void main(String[] args) {
        CardValue vAs = CardValue.as;
        System.out.println(vAs);

        System.out.println("### Color values : ");
        for (CardColor c : CardColor.values()) {
            System.out.println(c + " : " + c.ordinal());
        }

        System.out.println("### Card values : ");
        for (CardValue v : CardValue.values()) {
            System.out.println(v + " : " + v.getValue());
        }

    }
}
