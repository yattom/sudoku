package jp.yattom.pairpro.sudoku;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class SudokuTest {

    @Ignore
    @Test
    public void 自明なセルをすべて埋められる() {
        String quiz =
                "7.4.....1" +
                "....14..." +
                "3.1...469" +
                "62.581734" +
                "1..4....." +
                "483.62195" +
                "837945216" +
                "94612.3.." +
                "5128..947";
        Sudoku sudoku = new Sudoku(quiz);
        sudoku.fill_all_obvious();
        String actual = sudoku.getCurrentBoard();
        String expected = 
                "764359821" +
                "298614573" +
                "351278469" +
                "629581734" +
                "175493682" +
                "483762195" +
                "837945216" +
                "946127358" +
                "512836947";
        assertThat(actual, is(expected));
    }

    @Test
    public void 横一行を見て埋められる() {
        String quiz =
                ".64359821" +
                ".98614573" +
                ".51278469" +
                ".29581734" +
                ".75493682" +
                ".83762195" +
                ".37945216" +
                ".46127358" +
                ".12836947";
        Sudoku sudoku = new Sudoku(quiz);
        sudoku.fill(0, 0);
        String actual = sudoku.getCurrentBoard();
        String expected =
                "764359821" +
                ".98614573" +
                ".51278469" +
                ".29581734" +
                ".75493682" +
                ".83762195" +
                ".37945216" +
                ".46127358" +
                ".12836947";
        assertThat(actual, is(expected));
    }
}
