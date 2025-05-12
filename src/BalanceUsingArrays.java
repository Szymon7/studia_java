import java.util.Arrays;
import java.util.Scanner;

public class BalanceUsingArrays {
    public static double sum(double[] values) {
        return Arrays.stream(values).sum();
    }

    public static double min(double[] values) {
        return Arrays.stream(values).min().orElse(0);
    }

    public static double max(double[] values) {
        return Arrays.stream(values).max().orElse(0);
    }

    public static double average(double[] values) {
        return Arrays.stream(values).average().orElse(0);
    }

    public static void wyswietl_dochody(double[] dochody) {
        System.out.println("\nDochody:");
        for (int i = 0; i < dochody.length; i++) {
            System.out.printf("Miesiąc %d: %.2f%n", i + 1, dochody[i]);
        }
    }

    public static void srednia_suma_dochodow(double[] dochody) {
        System.out.printf("Suma dochodów: %.2f%n", sum(dochody));
        System.out.printf("Średni dochód: %.2f%n", average(dochody));
    }

    public static void maksymalny_minimalny_dochod(double[] dochody) {
        System.out.printf("Minimalny dochód: %.2f%n", min(dochody));
        System.out.printf("Maksymalny dochód: %.2f%n", max(dochody));
    }

    public static void sortuj(double[] dochody) {
        Arrays.sort(dochody);
        System.out.println("Dochody posortowane rosnąco.");
    }

    public static void pod_nad_srednim_dochodem(double[] dochody) {
        double avg = average(dochody);
        System.out.println("\nDochody powyżej średniego (" + avg + "):");
        for (double d : dochody) {
            if (d > avg) {
                System.out.printf("%.2f%n", d);
            }
        }
        System.out.println("\nDochody poniżej średniego (" + avg + "):");
        for (double d : dochody) {
            if (d < avg) {
                System.out.printf("%.2f%n", d);
            }
        }
    }

    public static double[] getIncome() {
        double[] income = new double[12];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter income for each month:");

        for (int i = 0; i < 12; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            income[i] = scanner.nextDouble();
        }

        return income;
    }

    public static double[] getexpenses() {
        double[] expenses = new double[12];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expenses for each month:");

        for (int i = 0; i < 12; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            expenses[i] = scanner.nextDouble();
        }

        return expenses;
    }

    public static void displayTable(double[] income, double[] expenses) {
        System.out.println("\nMonthly Balance Sheet:");
        System.out.printf("%-10s%-15s%-15s%-15s%-10s%n", "Month", "Income", "Expenses", "Net", "Status");
        for (int i = 0; i < income.length; i++) {
            double net = income[i] - expenses[i];
            String status = (net > 0) ? "Profit" : (net < 0) ? "Loss" : "Zero";
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f%-10s%n", i + 1, income[i], expenses[i], net, status);
        }
    }

    public static void displaySummary(double[] income, double[] expenses) {
        displayTable(income, expenses);
        System.out.println("\nSummary:");
        System.out.println("Total income: " + sum(income));
        System.out.println("Total expenses: " + sum(expenses));
        System.out.println("Net profit/loss: " + (sum(income) - sum(expenses)));
        System.out.println("\nIncome statistics:");
        System.out.println("Minimum: " + min(income) + ", Maximum: " + max(income) + ", Average: " + average(income));
        System.out.println("\nExpenses statistics:");
        System.out.println("Minimum: " + min(expenses) + ", Maximum: " + max(expenses) + ", Average: " + average(expenses));
    }

    public static void wyswietl_menu() {
        System.out.println("\n--- Annual Balance ---");
        System.out.println("1. Enter monthly income");
        System.out.println("2. Enter monthly expenses");
        System.out.println("3. Display summary");
        System.out.println("4. Wyświetl dochody");
        System.out.println("5. Średnia i suma dochodów");
        System.out.println("6. Maksymalny i minimalny dochód");
        System.out.println("7. Sortuj dochody");
        System.out.println("8. Dochody poniżej i powyżej średniego");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        double[] income = new double[12];
        double[] expenses = new double[12];
        int choice;

        do {
            wyswietl_menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    income = getIncome();
                    break;
                case 2:
                    expenses = getexpenses();
                    break;
                case 3:
                    displaySummary(income, expenses);
                    break;
                case 4:
                    wyswietl_dochody(income);
                    break;
                case 5:
                    srednia_suma_dochodow(income);
                    break;
                case 6:
                    maksymalny_minimalny_dochod(income);
                    break;
                case 7:
                    sortuj(income);
                    break;
                case 8:
                    pod_nad_srednim_dochodem(income);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 9);
    }
}
