package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public boolean gameOver;
    public String endMessage;

    //true: x
    //false: o
    private boolean turn;
    private final char[] emptyBoard =  { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private char[] board = emptyBoard.clone();

     private ArrayList<Integer> xPositions = new ArrayList<Integer>();
     private ArrayList<Integer> oPositions = new ArrayList<Integer>();
     private List<List> winning = new ArrayList<List>();

     private int playerXWins = 0;
     private int playerOWins = 0;
     private int ties = 0;

    public Board() {
        gameOver = false;
        turn = true;
        printBoard();

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
    }

    public void move(int position) {
        if (position > 9 || position < 1) {
            System.out.println("Enter a number between 1-9");
        } else if (board[position - 1] == 'X' || board[position - 1] == 'O') {
            System.out.println("Spot already taken");
        } else {
            char player;
            if (turn) {
                player = 'X';
                xPositions.add(position);
            }
            else {
                player = 'O';
                oPositions.add(position);
            }
            board[position - 1] = player;
            turn = !turn;
        }

        endMessage = checkWinner();
        if (gameOver) {endMessage += scoreBoard();}
        printBoard();
    }

    private String checkWinner() {
        gameOver = true;
        for (List l : winning) {
            if (xPositions.containsAll(l)) {
                playerXWins++;
                turn = false;
                return "Player X wins! ";
            }
            else if (oPositions.containsAll(l)) {
                playerOWins++;
                turn = true;
                return "Player O wins! ";
            }
            else if (xPositions.size() + oPositions.size() == 9) {
                ties++;
                return "Tie! ";
            }
        }
        gameOver = false;
        return "n";
    }

    private void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("+---+---+");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("+---+---+");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public void reset() {
        board = emptyBoard.clone();
        gameOver = false;
        xPositions = new ArrayList<Integer>();
        oPositions = new ArrayList<Integer>();
        printBoard();
    }

    public String scoreBoard() {
        String out = "The current log is: \n";
        out += "\nPlayer X Wins: " + playerXWins;
        out += "\nPlayer O Wins: " + playerOWins;
        out += "\nTies:          " + ties + "\n";
        return out;
    }
}