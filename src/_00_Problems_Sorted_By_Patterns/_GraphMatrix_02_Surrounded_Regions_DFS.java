/* [ _GraphMatrix_01 ] [ L130 Surrounded Regions ]
_______________________________________________________________________________
Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Problem key Points:
1. Let's analyze when an 'O' cannot be flipped,
  ---  if cell has atleast one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O'
       which lies on boundary of board (same as water trapping, water can't be trapped in these cells)

        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X]
        [X X X X X]                   [X X X X X]

  --- So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped
Steps :
    1. Move over the boundary of board, and find O's
    2. Every time we find an O, perform DFS from it's position
    3. In DFS convert all 'O' to '#' (why?? so that we can differentiate which 'O' can be flipped and which cannot be)
    4. After all DFSs have been performed, board contains three elements,#,O and X
    5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
    6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;

public class _GraphMatrix_02_Surrounded_Regions_DFS {
    public static char[][] matrixSurrounded(char[][]board){
        int m = board.length;
        int n = board[0].length;

        //Moving over first and last column
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O')
                DFS(board, i, 0, m, n);
            if(board[i][n-1] == 'O')
                DFS(board, i, n-1, m, n);
        }

        //Moving over first and last row
        for(int j=0; j<n; j++) {
            if(board[0][j] == 'O')
                DFS(board, 0, j, m, n);
            if(board[m-1][j] == 'O')
                DFS(board, m-1, j, m, n);
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
        return board;
    }

    private static void DFS(char[][] board, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O') return;
        board[i][j] = '#';
        DFS(board, i-1, j, m, n);
        DFS(board, i+1, j, m, n);
        DFS(board, i, j-1, m, n);
        DFS(board, i, j+1, m, n);
    }

    public static void main(String args[]) {
        char[][] grid = {
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'0', 'X', 'X', 'X'}};
        for (char[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
        matrixSurrounded(grid);

        System.out.println("\n\n\nUpdate grid with path");
        for (char[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
    }
}

