package ModernAppliances;

import java.io.IOException;
import java.util.Scanner;

import ManagementSystem.ModernAppliances;
import ManagementSystem.MyModernAppliances;

public class Program {

    public static void main(String[] args) throws IOException {
        // Initialize the ModernAppliances with MyModernAppliances implementation
        ModernAppliances modernAppliances = new MyModernAppliances();
        int option = 0;

        Scanner scanner = new Scanner(System.in);

        while (option != 5) {
            modernAppliances.displayMenu();

            String input = scanner.nextLine();
            try {
                option = Integer.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option entered. Please try again.");
                continue;
            }

            switch (option) {
                case 1:
                    modernAppliances.checkout();
                    break;
                case 2:
                    modernAppliances.find();
                    break;
                case 3:
                    modernAppliances.displayType();
                    break;
                case 4:
                    modernAppliances.randomList();
                    break;
                case 5:
                    modernAppliances.save();
                    break;
                default:
                    System.out.println("Invalid option entered. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
