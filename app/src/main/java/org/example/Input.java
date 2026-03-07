package org.example;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptMove() {

        System.out.print("Your move: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input");
            scanner.nextLine();
            return promptMove();
        }
        
        int in = scanner.nextInt();
        scanner.nextLine();
        return in;
    }

    public Boolean promptPlayAgain() {
        
        System.out.print("Would you like to play again? (y/n): ");
        if (!scanner.hasNextLine()) {
            System.out.println("Invalid input");
            return promptPlayAgain();
        }

        String in = scanner.nextLine();

        if (in.equals("y")) {
            return true;
        }
        else if (in.equals("n")) {
            return false;
        }
        else {
            System.out.println("Invalid input.");
            return promptPlayAgain();
        }
    }
}
