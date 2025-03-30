import java.util.Scanner;

public class Calculator {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w kalkulatorze! \nPodaj liczbe: ");
        double a = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj znak (+, -, *, /, %, ^): ");
        char f = scanner.nextLine().charAt(0);

        System.out.println("Podaj droga liczbe: ");
        double b = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Wynik: ");

        if (f == '+') {
            System.out.println(a + b);
            return;
        }

        if (f == '-') {
            System.out.println(a - b);
            return;
        }

        if (f == '*') {
            if (a == 0 || b == 0) {
                System.out.println("Nie mozona mnozyc 0");
                return;
            }

            System.out.println(a * b);
            return;
        }

        if (f == '/') {
            if (b == 0) {
                System.out.println("Nie mozona dzielic przez 0");
                return;
            }

            System.out.println(a / b);
            return;
        }

        if (f == '%') {
            System.out.println(a % b);
            return;
        }

        if (f == '^') {
            System.out.println(Math.pow(a, b));
        }
    }
}
