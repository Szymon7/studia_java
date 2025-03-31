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
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("MENU: ");
        System.out.println("1. Convert meters");
        System.out.println("2. Kalkulator");
        System.out.println("3. Za duzo za malo");
        System.out.println("4. Oblicz przychody");
        System.out.println("5. Program sedziowski");
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
            default -> System.out.println("Invalid option. Please try again.");
        }
        System.out.println("\n==========================================\n");
    }
}
