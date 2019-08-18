package hard;

import java.util.HashSet;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuCell(0,0, board);
    }

    private void solveSudokuCell(int row, int col, char[][] board) {
        HashSet set = new HashSet();
        if (col == board[row].length) {
            col = 0;
            row++;

            if (row == board.length) {
                return;
            }
        }

        if(board[row][col] == '.') {
            for(int i=1; i<=board.length; i++) {
                char charToPlace = (char) (i + '0');
                if(canPlaceValue(row, col, board, charToPlace)) {
                    board[row][col] = charToPlace;

                    solveSudokuCell(row, col+1, board);
                    return;
                }
            }
        } else {
            solveSudokuCell(row, col+1, board);
            return;
        }


    }

    private boolean canPlaceValue(int row, int col, char[][] board, char charToPlace) {
        // check col and row
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == charToPlace || board[row][i] == charToPlace)
                return false;
        }

        // check in sub square
        int subSize = (int) Math.sqrt(board.length);
        int r = row/subSize;
        int c = col/subSize;

        int topLeftRow = subSize * r;
        int tolLeftCol = subSize * c;

        for(int i=0; i<subSize; i++) {
            for(int j=0; j<subSize; j++) {
                if(charToPlace == board[topLeftRow + i][tolLeftCol + j])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        new SudokuSolver().solveSudoku(sudoku);

    }
}
