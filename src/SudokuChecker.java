import java.util.HashSet;

public class SudokuChecker {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> chars = new HashSet<Character>();
        int rows = board.length;
        int cols = board[0].length;

        // check all rows
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!test(board, i, j, chars)) {
                    return false;
                }
            }
            chars.clear();
        }

        // check all rows
        for (int j = 0; j<cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (!test(board, i, j, chars)) {
                    return false;
                }
            }
            chars.clear();
        }


        int x = 0;
        int y = 0;
        for (int z=0; z<9; z++) {
            for (int i = x; i<x+3; i++){
                for (int j = y; j < y+3; j++) {
                    if (!test(board, i, j, chars)) {
                        return false;
                    }
                }
            }
            if (y+3 > cols) {
                y = 0;
                x = x + 3;
            } else {
                y = y + 3;
            }
            chars.clear();
        }

        return true;
    }

    private boolean test(char[][] board, int i, int j, HashSet<Character> chars) {
        if (board[i][j] != '.') {
            if (chars.contains(board[i][j])) {
                return false;
            } else {
                chars.add(board[i][j]);
                return true;
            }
        } else {
            return false;
        }
    }
}
