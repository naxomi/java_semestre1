package td0;

import java.util.Calendar;
import java.util.Scanner;

public class BirthYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your name : ");
        String name = sc.nextLine();

        System.out.print("Your age : ");
        int age = sc.nextInt();

        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);

        System.out.println(name + " You were born in " + (currentYear - age));

        sc.close();
    }
}