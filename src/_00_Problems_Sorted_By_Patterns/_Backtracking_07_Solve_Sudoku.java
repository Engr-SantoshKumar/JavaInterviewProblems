/* [ _Backtracking_07_ ] [ Sudoku Solver ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

    TimeComplexity = 9^81
*/
package _00_Problems_Sorted_By_Patterns;
public class _Backtracking_07_Solve_Sudoku {
    public static boolean solveSudoku(char[][] board) {
        return doSolve(board, 0);
    }
    
    private static boolean doSolve(char[][] board, int row) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) { // trial. Try 1 through 9
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;                // Put num for this cell
                        if (doSolve(board, i)) {          // call doSolve again to solve new empty place
                            return true; // if all positions filled
                        }
                        // here means last value was not correct put back '.'
                        // and back tract to previous stage to try different value
                        board[i][j] = '.';
                    }
                }
                return false;  // non of the value worked given sudoku is wrong
            }
        }
        return true;
    }
    
    private static boolean isValid(char[][] board, int row, int col, char num) {
        int blockRow = (row / 3) * 3; // Block no. is i/3, first element is i/3*3
        int blockCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num || board[blockRow + i / 3][blockCol + i % 3] == num)
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solveSudoku(board));
    }
}
