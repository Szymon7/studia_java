import java.util.Scanner;
import java.util.Arrays;

public class StringOperations {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nString Operations Menu:");
            System.out.println("1. Odwrócony napis");
            System.out.println("2. Przestawione słowa");
            System.out.println("3. Szyfruj (Cezar)");
            System.out.println("4. Odszyfruj (Cezar)");
            System.out.println("5. Uporządkuj napis");
            System.out.println("6. Liczba wystąpień znaku");
            System.out.println("7. Histogram liter");
            System.out.println("8. Czy palindrom?");
            System.out.println("9. Czy anagram?");
            System.out.println("0. Powrót do głównego menu");
            System.out.print("\nWybierz opcję: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // pochłania enter po liczbie

            if (option == 0) break;

            System.out.print("Podaj napis: ");
            String input = scanner.nextLine();

            switch (option) {
                case 1 -> System.out.println("Odwrócony: " + odwrocony(input));
                case 2 -> System.out.println("Przestawione słowa: " + przestawioneSlowa(input));
                case 3 -> {
                    System.out.print("Podaj klucz szyfrowania: ");
                    int klucz = scanner.nextInt();
                    System.out.println("Zaszyfrowany: " + szyfruj(input, klucz));
                }
                case 4 -> {
                    System.out.print("Podaj klucz deszyfrowania: ");
                    int klucz = scanner.nextInt();
                    System.out.println("Odszyfrowany: " + odszyfruj(input, klucz));
                }
                case 5 -> System.out.println("Uporządkowany: " + uporzadkuj(input));
                case 6 -> {
                    System.out.print("Podaj znak: ");
                    char znak = scanner.nextLine().charAt(0);
                    System.out.println("Liczba wystąpień: " + liczbaWystapien(input, znak));
                }
                case 7 -> {
                    int[] hist = histogram(input);
                    for (char c = 'A'; c <= 'Z'; c++) {
                        System.out.println(c + ": " + hist[c - 'A']);
                    }
                }
                case 8 -> System.out.println("Czy palindrom: " + palindrom(input));
                case 9 -> {
                    System.out.print("Podaj drugi napis: ");
                    String input2 = scanner.nextLine();
                    System.out.println("Czy anagram: " + anagram(input, input2));
                }
                default -> System.out.println("Nieprawidłowa opcja.");
            }
        }
    }

    public static String odwrocony(String napis) {
        return new StringBuilder(napis).reverse().toString();
    }

    public static String przestawioneSlowa(String napis) {
        String[] slowa = napis.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = slowa.length - 1; i >= 0; i--) {
            sb.append(slowa[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static String szyfruj(String napis, int klucz) {
        StringBuilder zaszyfrowany = new StringBuilder();
        for (char c : napis.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                zaszyfrowany.append((char) ((c - base + klucz) % 26 + base));
            } else {
                zaszyfrowany.append(c);
            }
        }
        return zaszyfrowany.toString();
    }

    public static String odszyfruj(String napis, int klucz) {
        return szyfruj(napis, 26 - (klucz % 26));
    }

    public static String uporzadkuj(String napis) {
        return napis.trim()
                .replaceAll("\\s+", " ")
                .replaceAll("\\s*([,.!?])\\s*", "$1 ")
                .replaceAll("\\s+$", "");
    }

    public static int liczbaWystapien(String napis, char znak) {
        int count = 0;
        for (char c : napis.toCharArray()) {
            if (c == znak) count++;
        }
        return count;
    }

    public static int[] histogram(String napis) {
        int[] hist = new int[26];
        napis = napis.toUpperCase();
        for (char c : napis.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                hist[c - 'A']++;
            }
        }
        return hist;
    }

    public static boolean palindrom(String napis) {
        String cleaned = napis.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static boolean anagram(String napis1, String napis2) {
        char[] arr1 = napis1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] arr2 = napis2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}