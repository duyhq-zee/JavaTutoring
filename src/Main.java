import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // instance / object
        Player p1 = new Player("Devin Booker", 2500.00f, "All Star", 26, 1, "Suns");

        System.out.println(p1.getName());

        p1.setName("abc");

        System.out.println(p1.getName());

    }
}
