import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PrzetwarzanieTowarow {
    private static ArrayList<String> nazwy = new ArrayList<>();
    private static ArrayList<Double> ceny = new ArrayList<>();
    private static ArrayList<Integer> sztuki = new ArrayList<>();
    private static String aktualnyPlik = "";

    public static void wyswietlMenu() {
        System.out.println("\n--- System Przetwarzania Towarów ---");
        System.out.println("1. Wczytaj dane z pliku");
        System.out.println("2. Znajdź liczbę sztuk towaru");
        System.out.println("3. Zastosuj rabaty i zapisz do pliku");
        System.out.println("4. Wyświetl aktualne dane");
        System.out.println("0. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            wyswietlMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> obslugaWczytajPlik(scanner);
                case 2 -> obslugaZnajdzTowar(scanner);
                case 3 -> obslugaRabatyIZapis();
                case 4 -> obslugaWyswietlDane();
                case 0 -> System.out.println("Wyjście...");
                default -> System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void obslugaWczytajPlik(Scanner scanner) {
        System.out.print("Podaj nazwę pliku: ");
        aktualnyPlik = scanner.nextLine();
        wczytajDaneZPliku(aktualnyPlik);
    }

    private static void obslugaZnajdzTowar(Scanner scanner) {
        if (!sprawdzCzyDaneZaladowane()) return;

        System.out.print("Podaj nazwę towaru: ");
        String nazwaTowaru = scanner.nextLine();
        int ilosc = znajdzLiczbeSztuk(nazwaTowaru);

        if (ilosc != -1) {
            System.out.println("Liczba sztuk towaru '" + nazwaTowaru + "': " + ilosc);
        } else {
            System.out.println("Nie znaleziono towaru '" + nazwaTowaru + "'");
        }
    }

    private static void obslugaRabatyIZapis() {
        if (!sprawdzCzyDaneZaladowane()) return;

        zastosujRabaty();
        zapiszDoPliku(aktualnyPlik);
        System.out.println("Zastosowano rabaty i zapisano do pliku.");
    }

    private static void obslugaWyswietlDane() {
        if (!sprawdzCzyDaneZaladowane()) return;
        wyswietlDane();
    }

    private static boolean sprawdzCzyDaneZaladowane() {
        if (nazwy.isEmpty()) {
            System.out.println("Najpierw wczytaj dane z pliku!");
            return false;
        }
        return true;
    }

    private static void wczytajDaneZPliku(String nazwaPliku) {
        nazwy.clear();
        ceny.clear();
        sztuki.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(" ");
                if (parts.length == 3) {
                    nazwy.add(parts[0]);
                    ceny.add(Double.parseDouble(parts[1]));
                    sztuki.add(Integer.parseInt(parts[2]));
                }
            }
            System.out.println("Wczytano " + nazwy.size() + " towarów z pliku.");
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        }
    }

    private static int znajdzLiczbeSztuk(String nazwaTowaru) {
        for (int i = 0; i < nazwy.size(); i++) {
            if (nazwy.get(i).equals(nazwaTowaru)) {
                return sztuki.get(i);
            }
        }
        return -1;
    }

    private static void zastosujRabaty() {
        for (int i = 0; i < sztuki.size(); i++) {
            if (sztuki.get(i) >= 100) {
                double staraCena = ceny.get(i);
                double nowaCena = staraCena * 0.9;
                ceny.set(i, nowaCena);
                System.out.println("Zastosowano rabat 10% dla " + nazwy.get(i) +
                        ": " + staraCena + " → " + nowaCena);
            }
        }
    }

    private static void zapiszDoPliku(String nazwaPliku) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nazwaPliku))) {
            for (int i = 0; i < nazwy.size(); i++) {
                pw.println(nazwy.get(i) + " " + ceny.get(i) + " " + sztuki.get(i));
            }
        } catch (IOException e) {
            System.err.println("Błąd zapisu do pliku: " + e.getMessage());
        }
    }

    private static void wyswietlDane() {
        System.out.println("\nAktualne dane:");
        System.out.println("Nazwa\t\tCena\tLiczba sztuk");
        System.out.println("------------------------------");
        for (int i = 0; i < nazwy.size(); i++) {
            System.out.printf("%-10s\t%.2f\t%d\n", nazwy.get(i), ceny.get(i), sztuki.get(i));
        }
    }
}