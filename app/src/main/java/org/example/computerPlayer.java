package org.example;

import java.util.Arrays;
import java.util.Random;

public class computerPlayer {
    private final char[] emptyBoard = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private char playerSymbol;

        public char swap(char c) {
        if (c == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public computerPlayer(char computerTurn) {
        playerSymbol = swap(computerTurn);
    }

    // returns number between 1 and 9
    public int decideMove (Board b) {
        char[] board = b.getBoard();
        int move = b.move;

        if (Arrays.equals(board, emptyBoard))  {
            // randomely select one of the corners
            Random rand = new Random();
            int randomNum = rand.nextInt(4) + 1;
            switch (randomNum) {
                case 1:
                return 1;
                
                case 2:
                return 3;

                case 3:
                return 7;

                default:
                return 9;
            }
        }
        else if (move == 2 && board[4] == '5') {
        return 5;
        }
        else {
            int block = block(board);
            
            if (block != -1) {
                return block;
            }
            
            return randomMove(board);
        }
    }

    // checks for way to block player from winning
    private int block(char[] board) {
        char b1 = board[0];
        char b2 = board[1];
        char b3 = board[2];
        char b4 = board[3];
        char b5 = board[4];
        char b6 = board[5];
        char b7 = board[6];
        char b8 = board[7];
        char b9 = board[8];

        // Rows
        if (b1 == b2 && b1 == playerSymbol && b3 == '3') { return 3; }
        if (b2 == b3 && b2 == playerSymbol && b1 == '1') { return 1; }
        if (b1 == b3 && b1 == playerSymbol && b2 == '2') { return 2; }

        if (b4 == b5 && b4 == playerSymbol && b6 == '6') { return 6; }
        if (b5 == b6 && b5 == playerSymbol && b4 == '4') { return 4; }
        if (b4 == b6 && b4 == playerSymbol && b5 == '5') { return 5; }

        if (b7 == b8 && b7 == playerSymbol && b9 == '9') { return 9; }
        if (b8 == b9 && b8 == playerSymbol && b7 == '7') { return 7; }
        if (b7 == b9 && b7 == playerSymbol && b8 == '8') { return 8; }

        // Columns
        if (b1 == b4 && b1 == playerSymbol && b7 == '7') { return 7; }
        if (b4 == b7 && b4 == playerSymbol && b1 == '1') { return 1; }
        if (b1 == b7 && b1 == playerSymbol && b4 == '4') { return 4; }

        if (b2 == b5 && b2 == playerSymbol && b8 == '8') { return 8; }
        if (b5 == b8 && b5 == playerSymbol && b2 == '2') { return 2; }
        if (b2 == b8 && b2 == playerSymbol && b5 == '5') { return 5; }

        if (b3 == b6 && b3 == playerSymbol && b9 == '9') { return 9; }
        if (b6 == b9 && b6 == playerSymbol && b3 == '3') { return 3; }
        if (b3 == b9 && b3 == playerSymbol && b6 == '6') { return 6; }

        // Diagonals
        if (b1 == b5 && b1 == playerSymbol && b9 == '9') { return 9; }
        if (b5 == b9 && b5 == playerSymbol && b1 == '1') { return 1; }
        if (b1 == b9 && b1 == playerSymbol && b5 == '5') { return 5; }

        if (b3 == b5 && b3 == playerSymbol && b7 == '7') { return 7; }
        if (b5 == b7 && b5 == playerSymbol && b3 == '3') { return 3; }
        if (b3 == b7 && b3 == playerSymbol && b5 == '5') { return 5; }

        return -1;
    }

    // finds random empty square
    private int randomMove(char[] board) {
        Random rand = new Random();
        int randomNum;
        do {
            randomNum = rand.nextInt(9); // one through nine;
        } while (board[randomNum] == 'X' || board[randomNum] == 'O');
        return randomNum + 1;
    }
}
