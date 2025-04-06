import java.util.Random;
import java.util.Arrays;

public class Macierze {

    public static int[][] wypelnijTablice(int[][] t, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
        return t;
    }

    public static int[][] wypelnijTabliceZJednkami(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i == j || i + j == t.length - 1) {
                    t[i][j] = 1;
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return t;
    }

    public static int[][] transponujTablice1(int[][] t) {
        int[][] wynik = new int[t[0].length][t.length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                wynik[j][i] = t[i][j];
            }
        }
        return wynik;
    }

    public static int[][] transponujTablice2(int[][] t) {
        if (t.length != t[0].length) return null;
        for (int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                int temp = t[i][j];
                t[i][j] = t[j][i];
                t[j][i] = temp;
            }
        }
        return t;
    }

    public static int[][] mnozenieMacierzy(int[][] A, int[][] B) {
        if (A[0].length != B.length) return null;

        int[][] wynik = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    wynik[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return wynik;
    }

    // Narzędziowa funkcja do wyświetlania tablicy
    public static void wyswietlTablice(int[][] t) {
        for (int[] wiersz : t) {
            System.out.println(Arrays.toString(wiersz));
        }
        System.out.println();
    }

    // Program testowy
    public static void run() {
        int[][] macierzA = new int[3][4];
        int[][] macierzB = new int[4][2];
        int[][] kwadratowa = new int[4][4];

        System.out.println("Macierz A (3x4) losowa:");
        wypelnijTablice(macierzA, -5, 5);
        wyswietlTablice(macierzA);

        System.out.println("Macierz B (4x2) losowa:");
        wypelnijTablice(macierzB, -5, 5);
        wyswietlTablice(macierzB);

        System.out.println("Macierz A * B:");
        int[][] C = mnozenieMacierzy(macierzA, macierzB);
        wyswietlTablice(C);

        System.out.println("Macierz kwadratowa z jedynkami na przekątnych:");
        wypelnijTabliceZJednkami(kwadratowa);
        wyswietlTablice(kwadratowa);

        System.out.println("Transpozycja macierzy A (kopiowanie):");
        int[][] transponowanaA = transponujTablice1(macierzA);
        wyswietlTablice(transponowanaA);

        System.out.println("Transpozycja kwadratowej (in-place):");
        transponujTablice2(kwadratowa);
        wyswietlTablice(kwadratowa);
    }
}
