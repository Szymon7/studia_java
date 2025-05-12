import ClassTasks.Rational;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int selectedProgram = getUserInput(scanner);
            if (selectedProgram == -1) continue;
            if (selectedProgram == 0) break;
            executeProgram(selectedProgram);
        }

        System.out.println("Exiting program...");
    }

    private static void showMenu() {
        System.out.println("MENU: ");
        System.out.println("1. Convert meters");
        System.out.println("2. Kalkulator");
        System.out.println("3. Za duzo za malo");
        System.out.println("4. Oblicz przychody");
        System.out.println("5. Program sedziowski");
        System.out.println("6. Figury Plaskie");
        System.out.println("7. Figury ASCII");
        System.out.println("8. Uklad rownan");
        System.out.println("9. Macierze");
        System.out.println("10. Oblicz przychody (tablicami)");
        System.out.println("11. Operacje na napisach");
        System.out.println("12. Liczby wymierne");
        System.out.println("0. Exit");
        System.out.print("\nSelect program: ");
    }

    private static int getUserInput(Scanner scanner) {
        if (!scanner.hasNext()) {
            System.out.println("No input detected. Exiting...");
            return 0;
        }

        String input = scanner.next();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.\n");
            return -1;
        }
    }

    private static void executeProgram(int selectedProgram) {
        System.out.println("\n=============================\n");
        switch (selectedProgram) {
            case 1 -> Units.run();
            case 2 -> Calculator.run();
            case 3 -> TooMuchTooLittle.run();
            case 4 -> Balance.run();
            case 5 -> JudgesScores.run();
            case 6 -> FiguryPlaskie.run();
            case 7 -> FiguryASCII.run();
            case 8 -> UkladRownan.run();
            case 9 -> Macierze.run();
            case 10 -> BalanceUsingArrays.run();
            case 11 -> StringOperations.run();
            case 12 -> Rational.run();
            default -> System.out.println("Invalid option. Please try again.");
        }
        System.out.println("\n==========================================\n");
    }
}
