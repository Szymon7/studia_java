import java.util.Scanner;

public class FiguryASCII {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nWybierz figurę do narysowania:");
            System.out.println("1. Kwadrat");
            System.out.println("2. Trójkąt 1");
            System.out.println("3. Trójkąt 2");
            System.out.println("4. Ramka");
            System.out.println("5. Ramka z przekątnymi");
            System.out.println("6. Piramidka");
            System.out.println("0. Wyjście");
            System.out.print("Twój wybór: ");
            wybor = scanner.nextInt();

            if (wybor == 0) break;

            System.out.print("Podaj wielkość figury: ");
            int n = scanner.nextInt();

            switch (wybor) {
                case 1 -> kwadrat(n);
                case 2 -> trojkat1(n);
                case 3 -> trojkat2(n);
                case 4 -> ramka(n);
                case 5 -> ramkaZPrzekatnymi(n);
                case 6 -> piramidka(n);
                default -> System.out.println("Nieprawidłowy wybór.");
            }

        } while (wybor != 0);
        System.out.println("Koniec programu.");
    }

    static void kwadrat(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(n));
        }
    }

    static void trojkat1(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
    }

    static void trojkat2(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n - i));
            System.out.println("*".repeat(i));
        }
    }

    static void ramka(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                System.out.println("*".repeat(n));
            } else {
                System.out.print("*");
                System.out.print(" ".repeat(n - 2));
                System.out.println("*");
            }
        }
    }

    static void ramkaZPrzekatnymi(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1 || j == i || j == n - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void piramidka(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i - 1));
            System.out.println("*".repeat(2 * i + 1));
        }
    }
}
