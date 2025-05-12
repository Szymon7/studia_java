package ClassTasks;

import java.util.Scanner;

public class Rational {
    private final int licznik;
    private final int mianownik;

    public Rational(int licznik, int mianownik) {
        if (mianownik == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerem!");
        }
        int nwd = nwd(Math.abs(licznik), Math.abs(mianownik));
        this.licznik = licznik / nwd;
        this.mianownik = mianownik / nwd;
    }

    private int nwd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Rational add(Rational arg) {
        int nowyLicznik = this.licznik * arg.mianownik + arg.licznik * this.mianownik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public Rational mul(Rational arg) {
        return new Rational(this.licznik * arg.licznik, this.mianownik * arg.mianownik);
    }

    public Rational sub(Rational arg) {
        int nowyLicznik = this.licznik * arg.mianownik - arg.licznik * this.mianownik;
        int nowyMianownik = this.mianownik * arg.mianownik;
        return new Rational(nowyLicznik, nowyMianownik);
    }

    public Rational div(Rational arg) {
        if (arg.licznik == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero!");
        }
        return new Rational(this.licznik * arg.mianownik, this.mianownik * arg.licznik);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rational)) return false;
        Rational other = (Rational) obj;
        return this.licznik == other.licznik && this.mianownik == other.mianownik;
    }

    public int compareTo(Rational arg) {
        int left = this.licznik * arg.mianownik;
        int right = arg.licznik * this.mianownik;
        return Integer.compare(left, right);
    }

    @Override
    public String toString() {
        return licznik + "/" + mianownik;
    }

    public static void wyswietlMenu() {
        System.out.println("\n--- Rational Number Tester ---");
        System.out.println("1. Dodaj dwie liczby wymierne");
        System.out.println("2. Odejmij dwie liczby wymierne");
        System.out.println("3. Pomnóż dwie liczby wymierne");
        System.out.println("4. Podziel dwie liczby wymierne");
        System.out.println("5. Porównaj dwie liczby wymierne");
        System.out.println("0. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Rational a = null;
        Rational b = null;

        do {
            wyswietlMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    a = wczytajRational("Pierwsza liczba");
                    b = wczytajRational("Druga liczba");
                    System.out.println("Wynik: " + a.add(b));
                    break;
                case 2:
                    a = wczytajRational("Pierwsza liczba");
                    b = wczytajRational("Druga liczba");
                    System.out.println("Wynik: " + a.sub(b));
                    break;
                case 3:
                    a = wczytajRational("Pierwsza liczba");
                    b = wczytajRational("Druga liczba");
                    System.out.println("Wynik: " + a.mul(b));
                    break;
                case 4:
                    a = wczytajRational("Pierwsza liczba");
                    b = wczytajRational("Druga liczba");
                    try {
                        System.out.println("Wynik: " + a.div(b));
                    } catch (ArithmeticException e) {
                        System.out.println("Błąd: " + e.getMessage());
                    }
                    break;
                case 5:
                    a = wczytajRational("Pierwsza liczba");
                    b = wczytajRational("Druga liczba");
                    int result = a.compareTo(b);
                    if (result == 0) {
                        System.out.println("Liczby są równe");
                    } else if (result < 0) {
                        System.out.println(a + " jest mniejsze niż " + b);
                    } else {
                        System.out.println(a + " jest większe niż " + b);
                    }
                    break;
                case 0:
                    System.out.println("Wyjście...");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static Rational wczytajRational(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt + ":");
        System.out.print("Podaj licznik: ");
        int licznik = scanner.nextInt();
        System.out.print("Podaj mianownik: ");
        int mianownik = scanner.nextInt();
        return new Rational(licznik, mianownik);
    }
}
