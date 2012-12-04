package jp.yattom.pairpro.sudoku;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

    @Test
    public void 自明なセルをすべて埋められる() {
        String quiz =
                "7.4.....1\n" +
                "....14...\n" +
                "3.1...469\n" +
                "62.581734\n" +
                "1..4.....\n" +
                "483.62195\n" +
                "837945216\n" +
                "94612.3..\n" +
                "5128..947\n";
        Sudoku sudoku = new Sudoku(quiz);
        String actual = sudoku.fill_all_obvious();
        String expected = 
                "764359821\n" +
                "298614573\n" +
                "351278469\n" +
                "629581734\n" +
                "175493682\n" +
                "483762195\n" +
                "837945216\n" +
                "946127358\n" +
                "512836947\n";
        assertThat(actual, is(expected));
    }
}
