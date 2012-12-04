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

        int quizIndex = 0;
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                Cell cell = new Cell();
                cell.row = row;
                cell.col = col;
                cell.value = quiz.substring(quizIndex, quizIndex + 1);
                quizIndex++;
                board.add(cell);
            }
        }
    }

    public void fill_all_obvious() {
    }

    public String getCurrentBoard() {
        StringBuilder answer = new StringBuilder();
        for(int row = 0; row < ROW_SIZE; row++) {
            List<String> r = getRow(row);
            for(String c : r) {
                answer.append(c);
            }
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

    public String dump() {
        int emptyCount = 0;
        StringBuilder dump = new StringBuilder();
        for(int row = 0; row < ROW_SIZE; row++) {
            if(row > 0 && row % 3 == 0) {
                dump.append("---+---+---\n");
            }

            List<String> r = getRow(row);
            for(int col = 0; col < COL_SIZE; col++) {
                if(col > 0 && col % 3 == 0) {
                    dump.append("|");
                }
                dump.append(r.get(col));
                if(EMPTY.equals(r.get(col))) {
                    emptyCount++;
                }
            }
            dump.append("\n");
        }
        dump.append("\n" + emptyCount + " Empty Cell(s)\n");
        return dump.toString();
    }

}
