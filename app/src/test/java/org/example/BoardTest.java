package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class BoardTest {
    @Test
    public void winTest1() {
        TestBoard board = new TestBoard();
        board.move(1);
        board.move(2);
        board.move(5);
        board.move(3);
        board.move(9);
        assertEquals("Player X wins", board.endMessage.substring(0,13));
    }

    @Test
    public void winTest2() {
        TestBoard board = new TestBoard();
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
        TestBoard b = new TestBoard();
        b.move(2);
        b.reset();
        assertEquals(b.getBoard()[1], '2');
    }

    @Test
    public void getBoardTest() {
        TestBoard b = new TestBoard();
       char[] test = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
       assertEquals(true, Arrays.equals(test, b.getBoard()));
    }

}
