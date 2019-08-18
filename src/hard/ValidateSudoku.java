package hard;

import java.util.HashSet;

public class ValidateSudoku {

    /**
     * solution 1
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != '.') {
                    if(!seen.add("row-"+i+"-"+board[i][j]))
                        return false;
                    if(!seen.add("col-"+j+"-"+board[i][j]))
                        return false;
                    if(!seen.add("block-"+i/3+"-"+j/3+"-"+board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean validateSudoku(int row, int col, char[][] board) {
        if(col == board[row].length) {
            col = 0;
            row++;

            if(row == board.length)
                return true;
        }

        if(board[row][col] != '.') {
            if(validateCell(row, col, board)) {
                return validateSudoku(row, col+1, board);
            } else
                return false;
        } else {
            return validateSudoku(row, col+1, board);
        }
    }

    private boolean validateCell(int row, int col, char[][] board) {
        // check col
        for(int i=row+1; i<board.length; i++) {
            if(board[i][col] == board[row][col])
                return false;
        }

        for(int i=col+1; i<board.length; i++) {
            if(board[row][i] == board[row][col])
                return false;
        }

        // check subboard
        int subSize = (int) Math.sqrt(board.length);
        int r = row/subSize;
        int c = col/subSize;

        int topLeftRow = subSize * r;
        int topLeftCol = subSize * c;

        for(int i=0; i<subSize; i++) {
            for(int j=0; j<subSize; j++) {
                if((topLeftRow+i) != row && (topLeftCol+j) != col && board[topLeftRow + i][topLeftCol + j] == board[row][col])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(new ValidateSudoku().isValidSudoku1(board));
        System.out.println(new ValidateSudoku().validateSudoku(0,0, board));
    }
}
