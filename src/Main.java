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
            System.out.println("\nSelect program: ");

            try {
                selectedProgram = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextInt();
                System.out.println("Invalid input. Please enter an integer.");
                System.out.println("\n==========================================\n");
                continue;
            }

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
