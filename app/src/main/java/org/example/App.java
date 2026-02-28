package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.print("Welcome to Tic Tac Toe\n");

    Scanner scanner = new Scanner(System.in);
    String choice = "y";
    Board board = new Board();
    do {
    System.out.print("Your move: ");
    int position = scanner.nextInt();
    scanner.nextLine();
    board.move(position);

    if (board.gameOver) {
    System.out.println(board.endMessage);
    System.out.print("Would you like to play again? (y/n): ");
    choice = scanner.nextLine();
    if (choice.equals("y")) {board = new Board();}
    }
  } while (choice.equals("y"));

  scanner.close();
}
}
