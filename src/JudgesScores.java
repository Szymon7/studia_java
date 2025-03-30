import java.util.Scanner;

public class JudgesScores {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program do obliczania średniej ocen sędziów po odrzuceniu skrajnych wartości.");

        while (true) {
            int numberOfJudges;
            do {
                System.out.print("Podaj liczbę sędziów (min 3, max 10): ");
                numberOfJudges = scanner.nextInt();
            } while (numberOfJudges < 3 || numberOfJudges > 10);

            double sum = 0, min = 10, max = 0;
            int counter = 0;

            while (counter < numberOfJudges) {
                System.out.print("Podaj ocenę sędziego " + (counter + 1) + " (0-10): ");
                double score = scanner.nextDouble();

                if (score < 0 || score > 10) {
                    System.out.println("Nieprawidłowa ocena! Wprowadź wartość od 0 do 10.");
                    continue;
                }

                sum += score;
                if (score < min) min = score;
                if (score > max) max = score;
                counter++;
            }

            double average = (sum - min - max) / (numberOfJudges - 2);
            System.out.printf("Średnia ocen po odrzuceniu skrajnych wartości: %.2f\n", average);

            System.out.print("Czy chcesz ocenić nowego zawodnika? (tak/nie): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("tak")) {
                System.out.println("Zakończenie programu.");
                break;
            }
        }
    }
}
