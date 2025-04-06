import java.util.Scanner;

public class UkladRownan {

    public static double det2(double[][] t) {
        return t[0][0] * t[1][1] - t[0][1] * t[1][0];
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rozwiązywanie układu równań metodą wyznaczników:");
        System.out.println("A1x + B1y = C1");
        System.out.println("A2x + B2y = C2");

        System.out.print("Podaj A1: ");
        double A1 = scanner.nextDouble();
        System.out.print("Podaj B1: ");
        double B1 = scanner.nextDouble();
        System.out.print("Podaj C1: ");
        double C1 = scanner.nextDouble();

        System.out.print("Podaj A2: ");
        double A2 = scanner.nextDouble();
        System.out.print("Podaj B2: ");
        double B2 = scanner.nextDouble();
        System.out.print("Podaj C2: ");
        double C2 = scanner.nextDouble();

        double D = det2(new double[][] { { A1, B1 }, { A2, B2 } });
        double Dx = det2(new double[][] { { C1, B1 }, { C2, B2 } });
        double Dy = det2(new double[][] { { A1, C1 }, { A2, C2 } });

        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            System.out.printf("Rozwiązanie: x = %.4f, y = %.4f\n", x, y);
            return;
        }

        if (Dx == 0 && Dy == 0) {
            System.out.println("Układ ma nieskończenie wiele rozwiązań.");
            return;
        }

        System.out.println("Układ sprzeczny – brak rozwiązań.");
    }
}
