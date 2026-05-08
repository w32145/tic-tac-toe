package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

   System.out.print("Welcome to Tic Tac Toe\n");

    Scanner scanner = new Scanner(System.in);
    Input input = new Input(scanner);
    FileOutput output = new FileOutput("output.txt");

    Boolean pve = false;
    Boolean computerTurn = false; // keeps track of the computer's turn
    // true: x
    // false: o

    switch (input.promptPVP()) {
      case 1:
      //player vs player
      pve = false;
      break;
      
      case 2:
      //player vs computer
      pve = true;
      computerTurn = false;
      break;

      case 3:
      //computer vs player
      pve = true;
      computerTurn = true;
      break;
    }
    
    computerPlayer cpu = new computerPlayer(computerTurn);
    Board board = new Board();

  while (true) {
  
    int position;

    if (pve && board.turn == computerTurn) {
      // computer's turn
      position = cpu.decideMove(board);
      System.out.println("Opponent selected: " + position + "\n");
    }
    else {
      // player's turn
      position = input.promptInt("Your move: ");
    }

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
  output.write(board.scoreBoard());
}
}
