package org.example;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptInt(String prompt) {

        System.out.print(prompt);
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input"); // this could cause it to think the next line is invalid
            scanner.nextLine();
            return promptInt(prompt);
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
        } else if (in.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input.");
            return promptPlayAgain();
        }
    }

    public int promptPVP() {

        String prompt = "1: Player vs Player\n";
        prompt += "2: Player vs Computer\n";
        prompt += "3: Computer vs Player\n";
        int in;
        do {
            in = promptInt(prompt);
        } while (in < 1 || in > 3);

        return in;

    }
}
