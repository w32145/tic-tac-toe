package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void winTest1() {
        Board board = new Board();
        board.move(1);
        board.move(2);
        board.move(5);
        board.move(3);
        board.move(9);
        assertEquals("Player X wins", board.endMessage.substring(0,13));
    }

    @Test
    public void winTest2() {
        Board board = new Board();
        board.move(2);
        board.move(1);
        board.move(3);
        board.move(5);
        board.move(8);
        board.move(9);

        assertEquals("Player O wins", board.endMessage.substring(0,13));
    }

    @Test
    public void resetTest() {
        Board b = new Board();
        b.move(2);
        b.reset();
        assertEquals(b.board[1], '2');
    }
}
