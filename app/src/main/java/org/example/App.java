package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

   System.out.print("Welcome to Tic Tac Toe\n");

    Board board = new Board();
    Scanner scanner = new Scanner(System.in);
    Input input = new Input(scanner);

  while (true) {
  
    int position = input.promptMove();
    board.move(position);

    if (board.gameOver) {
      System.out.println(board.endMessage);
      
      if (input.promptPlayAgain()) {
      board = new Board();
      }
      else {
        break;
      }
        
    }
  }
  scanner.close();
}
}
