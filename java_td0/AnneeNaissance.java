import java.util.Scanner;
import java.util.Calendar;

public class AnneeNaissance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Votre prenom : ");
		String prenom = sc.nextLine();

		System.out.print("Votre age : ");
		int age = sc.nextInt();

		Calendar c = Calendar.getInstance();
		int anneeCourante = c.get(Calendar.YEAR);

		System.out.println(prenom + " vous etes ne en " + (anneeCourante - age));

		sc.close();
	}
}