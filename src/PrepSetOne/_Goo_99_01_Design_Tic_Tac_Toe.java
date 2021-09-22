/**
 [ Goo 99 01 ] [ Tic Tac Toe ]
 ____________________________________________________________________________________________________________________
 Design a Tic-tac-toe game that is played between two players on a n x n grid.

 You may assume the following rules:

 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.


 */
package PrepSetOne;
public class _Goo_99_01_Design_Tic_Tac_Toe {

    static int[][] grid;

    /** Initialize your data structure here. */
    public _Goo_99_01_Design_Tic_Tac_Toe(int n) {
        grid = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */

    public static int move(int row, int col, int player) {
        //Some validations
        if (row >= grid.length || col >= grid.length) return 0;
        if (grid[row][col] != 0) return 0;

        //which player is playing
        grid[row][col] = player == 1 ? 1 : 2;

        //check for winner
        if (checkPlayedColumn(col, player)) return player;
        if (checkPlayedRow(row, player)) return player;
        if (checkDiagonallyWin(row, col, player)) return player;

        return 0;
    }

    public static boolean checkPlayedColumn(int col, int player){
        for(int i = 0; i< grid[0].length; i++){
            if (grid[i][col] != player) return false;
        }
        return true;
    }
    public static boolean checkPlayedRow(int row, int player){
        for(int i = 0; i< grid[0].length; i++){
            if (grid[row][i] != player) return false;
        }
        return true;
    }
    public static boolean checkDiagonallyWin(int row, int col, int player) {
        //check if its a diagonal cell or not
        if (row != col && row+col != grid.length-1) return false;

        boolean topLeftToBottomRight = true;
        boolean topRightToBottomLeft = true;

        //diagonal check
        for (int i=0; i<grid.length; i++) {
            if (grid[i][i] != player) topLeftToBottomRight = false;
        }
        //Anti diagonal check
        for (int i=0; i<grid.length; i++) {
            if (grid[i][grid.length-1-i] != player) topRightToBottomLeft = false;
        }

        return topRightToBottomLeft || topLeftToBottomRight;
    }

    public static void main(String[] args) {

        new _Goo_99_01_Design_Tic_Tac_Toe(3);
        System.out.println(move(0, 0, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(0, 2, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 2, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(1, 1, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 0, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(1, 0, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 1, 1)); //-> Returns 1 (player 1 wins)
    }
}
