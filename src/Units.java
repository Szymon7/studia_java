import java.util.Scanner;

public class Units {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj metry: ");
        double meters = scanner.nextDouble();

        double inches = meters * 39.3700787;
        double foot = meters * 3.2808399;
        double yard = meters * 1.0936133;
        double miles = meters * 0.000621371192;

        System.out.println(meters + " metrow to:");
        System.out.println(inches + " cali");
        System.out.println(foot + " stop");
        System.out.println(yard + " jardow");
        System.out.println(miles + " mil");

        scanner.close();
    }
}
