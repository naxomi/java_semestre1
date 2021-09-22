public class Test2 {
    public static void main(String[] args) {
        Valeur vAs = Valeur.as;
        System.out.println(vAs);

        System.out.println("### Color values : ");
        for (Couleur c : Couleur.values()) {
            System.out.println(c + " : " + c.ordinal());
        }

        System.out.println("### Card values : ");
        for (Valeur v : Valeur.values()) {
            System.out.println(v + " : " + v.valeur());
        }
        
    }
}
