import java.util.Scanner;

public class FiguryPlaskie {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        System.out.println("Program do obliczania pól i obwodów figur płaskich");

        do {
            System.out.println("\nWybierz figurę:");
            System.out.println("1. Kwadrat");
            System.out.println("2. Prostokąt");
            System.out.println("3. Koło");
            System.out.println("4. Trójkąt");
            System.out.println("5. Trapez");
            System.out.println("0. Wyjście");
            System.out.print("Twój wybór: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> obslugaFigury("kwadrat", scanner);
                case 2 -> obslugaFigury("prostokat", scanner);
                case 3 -> obslugaFigury("kolo", scanner);
                case 4 -> obslugaFigury("trojkat", scanner);
                case 5 -> obslugaFigury("trapez", scanner);
                case 0 -> System.out.println("Koniec programu.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    public static void obslugaFigury(String figura, Scanner scanner) {
        int wybor;
        System.out.println("\nCo chcesz obliczyć?");
        System.out.println("1. Pole");
        System.out.println("2. Obwód");
        System.out.print("Twój wybór: ");
        wybor = scanner.nextInt();

        switch (figura) {
            case "kwadrat" -> {
                double a = pobierzDodatniaLiczbe("Podaj bok kwadratu: ", scanner);
                if (wybor == 1) System.out.println("Pole: " + (a * a));
                else System.out.println("Obwód: " + (4 * a));
            }
            case "prostokat" -> {
                double a = pobierzDodatniaLiczbe("Podaj bok a: ", scanner);
                double b = pobierzDodatniaLiczbe("Podaj bok b: ", scanner);
                if (wybor == 1) System.out.println("Pole: " + (a * b));
                else System.out.println("Obwód: " + (2 * (a + b)));
            }
            case "kolo" -> {
                double r = pobierzDodatniaLiczbe("Podaj promień: ", scanner);
                if (wybor == 1) System.out.println("Pole: " + (Math.PI * r * r));
                else System.out.println("Obwód: " + (2 * Math.PI * r));
            }
            case "trojkat" -> {
                double a = pobierzDodatniaLiczbe("Podaj bok a: ", scanner);
                double h = pobierzDodatniaLiczbe("Podaj wysokość: ", scanner);
                if (wybor == 1) System.out.println("Pole: " + (0.5 * a * h));
                else {
                    double b = pobierzDodatniaLiczbe("Podaj bok b: ", scanner);
                    double c = pobierzDodatniaLiczbe("Podaj bok c: ", scanner);
                    System.out.println("Obwód: " + (a + b + c));
                }
            }
            case "trapez" -> {
                double a = pobierzDodatniaLiczbe("Podaj podstawę a: ", scanner);
                double b = pobierzDodatniaLiczbe("Podaj podstawę b: ", scanner);
                double h = pobierzDodatniaLiczbe("Podaj wysokość: ", scanner);
                if (wybor == 1) System.out.println("Pole: " + (0.5 * (a + b) * h));
                else {
                    double c = pobierzDodatniaLiczbe("Podaj bok c: ", scanner);
                    double d = pobierzDodatniaLiczbe("Podaj bok d: ", scanner);
                    System.out.println("Obwód: " + (a + b + c + d));
                }
            }
            default -> System.out.println("Nieznana figura.");
        }
    }

    public static double pobierzDodatniaLiczbe(String komunikat, Scanner scanner) {
        double liczba;
        do {
            System.out.print(komunikat);
            liczba = scanner.nextDouble();
            if (liczba <= 0) System.out.println("Wartość musi być większa od zera.");
        } while (liczba <= 0);
        return liczba;
    }
}
