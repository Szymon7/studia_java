import java.util.Random;
import java.util.Scanner;

public class TooMuchTooLittle {
    private static int targetNumber;
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("Witaj w grze 'Za duzo, za malo'! Podaj zakres liczb do zgadywania.");
        int min, max;

        System.out.print("Podaj minimalna liczbe: ");
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba! Podaj poprawna wartosc.");
            scanner.next();
        }
        min = scanner.nextInt();

        System.out.print("Podaj maksymalna liczbe: ");
        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba! Podaj poprawna wartosc.");
            scanner.next();
        }
        max = scanner.nextInt();

        if (min >= max) {
            System.out.println("Niepoprawny zakres! Min musi byc mniejsze od max.");
            return;
        }

        targetNumber = new Random().nextInt(max - min + 1) + min;

        System.out.println("Zgadnij liczbe od " + min + " do " + max + ".");
        int guess;
        do {
            System.out.print("Podaj liczbe: ");
            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba! Podaj liczbe w wybranym zakresie.");
                scanner.next();
            }
            guess = scanner.nextInt();

            if (guess < targetNumber) {
                System.out.println("Za malo!");
                continue;
            }
            if (guess > targetNumber) {
                System.out.println("Za duzo!");
                continue;
            }
            System.out.println("Gratulacje! Zgadles liczbe: " + targetNumber);
        } while (guess != targetNumber);
    }
}
