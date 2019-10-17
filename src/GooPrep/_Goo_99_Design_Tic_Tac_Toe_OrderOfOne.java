/**
[ Goo 99 A ] [ Tic Tac Toe O(1)]
____________________________________________________________________________________________________________________
 Design a Tic-tac-toe game that is played between two players on a n x n grid.

 You may assume the following rules:

 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
package GooPrep;
public class _Goo_99_Design_Tic_Tac_Toe_OrderOfOne {

    private static int[] rows;
    private static int[] cols;
    private static int diagonal;
    private static int antiDiagonal;

    /** Initialize your data structure here. */
    public _Goo_99_Design_Tic_Tac_Toe_OrderOfOne(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public static int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }

        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size  ||
                Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }

    public static void main(String[] args) {

        new _Goo_99_Design_Tic_Tac_Toe_OrderOfOne(3);
        System.out.println(move(0, 0, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(0, 2, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 2, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(1, 1, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 0, 1)); //-> Returns 0 (no one wins)
        System.out.println(move(1, 0, 2)); //-> Returns 0 (no one wins)
        System.out.println(move(2, 1, 1)); //-> Returns 1 (player 1 wins)
    }


}
