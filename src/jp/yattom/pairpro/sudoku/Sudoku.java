package jp.yattom.pairpro.sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {
    static final public int ROW_SIZE = 9;
    static final public int COL_SIZE = 9;
    static final public String EMPTY = ".";

    private List<Cell> board;

    public Sudoku(String quiz) {
        board = new ArrayList<>();

        String[] rows = quiz.split("\n");
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                Cell cell = new Cell();
                cell.row = row;
                cell.col = col;
                cell.value = String.valueOf(rows[row].charAt(col));
                board.add(cell);
            }
        }
    }

    public void fill_all_obvious() {
    }

    public String getAnswer() {
        StringBuilder answer = new StringBuilder();
        for(int row = 0; row < ROW_SIZE; row++) {
            List<String> r = getRow(row);
            for(String c : r) {
                answer.append(c);
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    public void fill(int row, int col) {
        Cell target = getAt(row, col);
        if (getPossibleFromRow(row).size() == 1) {
            target.value = getPossibleFromRow(row).iterator().next();
        }
    }

    private Set<String> getPossibleFromRow(int row) {
        return getPossible(getRow(row));
    }

    private Set<String> getPossible(Collection<String> from) {
        Set<String> allNumbers = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            allNumbers.add(String.valueOf(i));
        }
        allNumbers.removeAll(from);
        return allNumbers;
    }

    private List<String> getRow(int row) {
        List<String> cells = new ArrayList<>();
        for (Cell cell : board) {
            if (cell.row == row) {
                cells.add(cell.value);
            }
        }
        return cells;
    }

    private Cell getAt(int row, int col) {
        for (Cell cell : board) {
            if (cell.row == row && cell.col == col) {
                return cell;
            }
        }
        throw new IllegalArgumentException("wrong position (" + row + ", "
                + col + ")");
    }

}
