import java.util.*;

public class JudgesScores {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program do obliczania średniej ocen sędziów po odrzuceniu skrajnych wartości.");

        while (true) {
            int numberOfJudges = getNumberOfJudges(scanner);
            double average = calculateAverageScore(scanner, numberOfJudges);
            System.out.printf(Locale.US, "Średnia ocen po odrzuceniu skrajnych wartości: %.2f\n", average);

            if (!askToContinue(scanner)) {
                System.out.println("Zakończenie programu.");
                break;
            }
        }
    }

    private static int getNumberOfJudges(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Podaj liczbę sędziów (min 3, max 10): ");
                int numberOfJudges = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfJudges >= 3 && numberOfJudges <= 10) {
                    return numberOfJudges;
                }
                System.out.println("Liczba sędziów musi być w przedziale 3-10.");
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa wartość! Wprowadź liczbę całkowitą.");
            }
        }
    }

    private static double calculateAverageScore(Scanner scanner, int numberOfJudges) {
        List<Double> scores = new ArrayList<>();

        for (int i = 1; i <= numberOfJudges; i++) {
            scores.add(getValidScore(scanner, i));
        }

        double min = Collections.min(scores);
        double max = Collections.max(scores);
        double sum = scores.stream().mapToDouble(Double::doubleValue).sum();

        return (sum - min - max) / (numberOfJudges - 2);
    }

    private static double getValidScore(Scanner scanner, int judgeNumber) {
        while (true) {
            try {
                System.out.print("Podaj ocenę sędziego " + judgeNumber + " (0-10): ");
                double score = Double.parseDouble(scanner.nextLine().trim());
                if (score >= 0 && score <= 10) {
                    return score;
                }
                System.out.println("Nieprawidłowa ocena! Wprowadź wartość od 0 do 10.");
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa wartość! Wprowadź liczbę.");
            }
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        System.out.print("Czy chcesz ocenić nowego zawodnika? (tak/nie): ");
        return scanner.nextLine().trim().equalsIgnoreCase("tak");
    }
}
