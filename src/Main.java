import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selectedProgram;

        while (true) {
            System.out.println("MENU: ");
            System.out.println("1. Convert meters");
            System.out.println("2. Kalkulator");
            System.out.println("3. Za duzo za malo");
            System.out.println("4. Oblicz przychody");
            System.out.println("5. Program sedziowski");
            System.out.println("0. Exit");
            System.out.print("\nSelect program: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
                System.out.println("\n==========================================\n");
                continue;
            }

            selectedProgram = scanner.nextInt();
            System.out.println("\n=============================\n");

            switch (selectedProgram) {
                case 1:
                    Units.run();
                    break;
                case 2:
                    Calculator.run();
                    break;
                case 3:
                    TooMuchTooLittle.run();
                    break;
                case 4:
                    Balance.run();
                    break;
                case 5:
                    JudgesScores.run();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println("\n==========================================\n");
        }
    }
}
