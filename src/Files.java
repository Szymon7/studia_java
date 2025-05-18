import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Files {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nWybierz zadanie do uruchomienia:");
            System.out.println("1. Zadanie 1 - Liczby losowe");
            System.out.println("2. Zadanie 2 - Domy wiejskie parterowe");
            System.out.println("3. Zadanie 3 - Statystyka tekstu");
            System.out.println("0. Wyjście");
            System.out.print("Twój wybór: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> liczbyLosowe();
                case 2 -> domyWiejskoParterowe();
                case 3 -> statystykaTekstu();
                case 0 -> System.out.println("Koniec programu.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    public static void liczbyLosowe() {
        File liczbyPlik = new File("liczby.txt");
        File wiekszeOdSredniej = new File("wieksze_od_sredniej.txt");
        File mniejszeOdSredniej = new File("mniejsze_od_sredniej.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(liczbyPlik))) {
            Random random = new Random();
            int[] liczby = new int[1000];
            int suma = 0;

            for (int i = 0; i < 1000; i++) {
                liczby[i] = random.nextInt(1000);
                suma += liczby[i];
                writer.write(liczby[i] + "\n");
            }

            double srednia = suma / 1000.0;

            try (BufferedWriter wiekszeWriter = new BufferedWriter(new FileWriter(wiekszeOdSredniej));
                 BufferedWriter mniejszeWriter = new BufferedWriter(new FileWriter(mniejszeOdSredniej))) {

                for (int liczba : liczby) {
                    if (liczba > srednia) {
                        wiekszeWriter.write(liczba + "\n");
                    } else if (liczba < srednia) {
                        mniejszeWriter.write(liczba + "\n");
                    }
                }
            }

            System.out.println("Zadanie wykonane: liczby zapisano w plikach.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    public static void domyWiejskoParterowe() {
        File domyPlik = new File("domy.txt");
        File parteroweWiejsko = new File("parterowe_wiejsko.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(domyPlik));
             BufferedWriter writer = new BufferedWriter(new FileWriter(parteroweWiejsko))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] dane = line.split("-");
                String nazwa = dane[0];
                double cena = Double.parseDouble(dane[1]);
                int liczbaKondygnacji = Integer.parseInt(dane[2]);
                String lokalizacja = dane[3];

                if (liczbaKondygnacji == 1 && "Wies".equalsIgnoreCase(lokalizacja)) {
                    cena *= 0.9;
                    writer.write(nazwa + "-" + cena + "-" + liczbaKondygnacji + "-" + lokalizacja + "\n");
                }
            }

            System.out.println("Zadanie wykonane: przetworzono plik.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    public static void statystykaTekstu() {
        File tekstPlik = new File("tekst.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(tekstPlik))) {
            int liczbaSlow = 0;
            int liczbaZnakow = 0;
            int liczbaZdan = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] slowa = line.split("\\s+");
                liczbaSlow += slowa.length;

                for (char znak : line.toCharArray()) {
                    liczbaZnakow++;
                    if (znak == '.') {
                        liczbaZdan++;
                    }
                }
            }

            double sredniaDlugoscZdania = liczbaZdan > 0 ? (double) liczbaZnakow / liczbaZdan : 0;

            System.out.println("Statystyka tekstu:");
            System.out.println("Liczba słów: " + liczbaSlow);
            System.out.println("Średnia długość zdania: " + sredniaDlugoscZdania);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}