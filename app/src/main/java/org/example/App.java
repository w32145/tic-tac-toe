package org.example;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
        board.reset();
      }
      else {
        break;
      }
        
    }
  }
  scanner.close();

  try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String scores = board.scoreBoard();
            byte[] dataBytes = scores.getBytes();
            fos.write(dataBytes);
            System.out.println("Data successfully written to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
}
}
