import java.util.Scanner;

public class Balance {
    static double incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun,
            incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec;

    static double expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun,
            expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec;

    public static double sum(double... values) {
        double total = 0;
        for (double v : values) {
            total += v;
        }
        return total;
    }

    public static double min(double... values) {
        double min = values[0];
        for (double v : values) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public static double max(double... values) {
        double max = values[0];
        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static double average(double... values) {
        return sum(values) / values.length;
    }

    public static void displayTable() {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        double[] income = {incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun, incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec};
        double[] expenses = {expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun, expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec};

        System.out.println("\nMonthly Balance Sheet:");
        System.out.printf("%-10s%-15s%-15s%-15s%-10s%n", "Month", "Income", "Expenses", "Net", "Status");
        for (int i = 0; i < 12; i++) {
            double net = income[i] - expenses[i];
            String status = (net > 0) ? "Profit" : (net < 0) ? "Loss" : "Zero";
            System.out.printf("%-10s%-15.2f%-15.2f%-15.2f%-10s%n", months[i], income[i], expenses[i], net, status);
        }
    }

    public static void enterIncome(Scanner scanner) {
        System.out.println("Enter income for each month:");
        incomeJan = scanner.nextDouble();
        incomeFeb = scanner.nextDouble();
        incomeMar = scanner.nextDouble();
        incomeApr = scanner.nextDouble();
        incomeMay = scanner.nextDouble();
        incomeJun = scanner.nextDouble();
        incomeJul = scanner.nextDouble();
        incomeAug = scanner.nextDouble();
        incomeSep = scanner.nextDouble();
        incomeOct = scanner.nextDouble();
        incomeNov = scanner.nextDouble();
        incomeDec = scanner.nextDouble();
    }

    public static void enterExpenses(Scanner scanner) {
        System.out.println("Enter expenses for each month:");
        expenseJan = scanner.nextDouble();
        expenseFeb = scanner.nextDouble();
        expenseMar = scanner.nextDouble();
        expenseApr = scanner.nextDouble();
        expenseMay = scanner.nextDouble();
        expenseJun = scanner.nextDouble();
        expenseJul = scanner.nextDouble();
        expenseAug = scanner.nextDouble();
        expenseSep = scanner.nextDouble();
        expenseOct = scanner.nextDouble();
        expenseNov = scanner.nextDouble();
        expenseDec = scanner.nextDouble();
    }

    public static void displaySummary() {
        displayTable();
        System.out.println("\nSummary:");
        double totalIncome = sum(incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun, incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec);
        double totalExpenses = sum(expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun, expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec);
        System.out.println("Total income: " + totalIncome);
        System.out.println("Total expenses: " + totalExpenses);
        System.out.println("Net profit/loss: " + (totalIncome - totalExpenses));
        System.out.println("\nIncome statistics:");
        System.out.println("Minimum: " + min(incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun, incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec));
        System.out.println("Maximum: " + max(incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun, incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec));
        System.out.println("Average: " + average(incomeJan, incomeFeb, incomeMar, incomeApr, incomeMay, incomeJun, incomeJul, incomeAug, incomeSep, incomeOct, incomeNov, incomeDec));
        System.out.println("\nExpenses statistics:");
        System.out.println("Minimum: " + min(expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun, expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec));
        System.out.println("Maximum: " + max(expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun, expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec));
        System.out.println("Average: " + average(expenseJan, expenseFeb, expenseMar, expenseApr, expenseMay, expenseJun, expenseJul, expenseAug, expenseSep, expenseOct, expenseNov, expenseDec));
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
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
                case 1: {
                    enterIncome(scanner);
                    break;
                }
                case 2: {
                    enterExpenses(scanner);
                    break;
                }
                case 3: {
                    displaySummary();
                    break;
                }
                case 4: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        } while (choice != 4);
    }
}
