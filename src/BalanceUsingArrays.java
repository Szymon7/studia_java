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

    public static void displayTable(double[] income, double[] expenses) {
        System.out.println("\nMonthly Balance Sheet:");
        System.out.printf("%-10s%-15s%-15s%-15s%-10s%n", "Month", "Income", "Expenses", "Net", "Status");
        for (int i = 0; i < income.length; i++) {
            double net = income[i] - expenses[i];
            String status = (net > 0) ? "Profit" : (net < 0) ? "Loss" : "Zero";
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f%-10s%n", i + 1, income[i], expenses[i], net, status);
        }
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        double[] income = new double[12];
        double[] expenses = new double[12];
        int choice;

        do {
            System.out.println("\n--- Annual Balance ---");
            System.out.println("1. Enter monthly income");
            System.out.println("2. Enter monthly expenses");
            System.out.println("3. Display summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter income for each month:");
                    for (int i = 0; i < 12; i++) {
                        System.out.print("Month " + (i + 1) + ": ");
                        income[i] = scanner.nextDouble();
                    }
                    break;
                case 2:
                    System.out.println("Enter expenses for each month:");
                    for (int i = 0; i < 12; i++) {
                        System.out.print("Month " + (i + 1) + ": ");
                        expenses[i] = scanner.nextDouble();
                    }
                    break;
                case 3:
                    displayTable(income, expenses);
                    System.out.println("\nSummary:");
                    System.out.println("Total income: " + sum(income));
                    System.out.println("Total expenses: " + sum(expenses));
                    System.out.println("Net profit/loss: " + (sum(income) - sum(expenses)));
                    System.out.println("\nIncome statistics:");
                    System.out.println("Minimum: " + min(income) + ", Maximum: " + max(income) + ", Average: " + average(income));
                    System.out.println("\nExpenses statistics:");
                    System.out.println("Minimum: " + min(expenses) + ", Maximum: " + max(expenses) + ", Average: " + average(expenses));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
