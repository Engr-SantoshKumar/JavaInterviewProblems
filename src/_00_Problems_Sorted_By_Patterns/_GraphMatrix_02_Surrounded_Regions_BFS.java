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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _GraphMatrix_02_Surrounded_Regions_BFS {
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static char[][] matrixSurrounded(char[][] matrix){

        int row = matrix.length, col = matrix[0].length;

        //scanning the boarders
        //Moving over first and last row
        for (int c = 0; c < col; c++){
            if(matrix[0][c]=='0'){
                queue.offer(new int[]{0,c});
                matrix[0][c] ='#';
                BFS(matrix, 0, c, queue);
            }
            if(matrix[row-1][c]=='0'){
                queue.offer(new int[]{row-1,c});
                matrix[row-1][c] ='#';
                BFS(matrix, row-1, c, queue);
            }
        }
        //Moving over first and last col
        for (int r = 0; r < row; r++){
            if(matrix[r][0]=='0'){
                queue.offer(new int[]{r,0});
                matrix[r][0] ='#';
                BFS(matrix, r, 0, queue);
            }
            if(matrix[r][col-1]=='0'){
                queue.offer(new int[]{r,col-1});
                matrix[r][col-1] ='#';
                BFS(matrix, r, col-1, queue);
            }
        }

        // update the matrix again
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(matrix[r][c] == '0')
                    matrix[r][c] = 'X';
                if(matrix[r][c] == '#')
                    matrix[r][c] = '0';
            }
        }
        return matrix;
    }

    private static void BFS(char[][] matrix, int r, int c, Queue<int[]> queue) {
        while(!queue.isEmpty()){
            int[] curCell = queue.poll();
            for(int i=0; i<4; i++){
                int nextRow= curCell[0]+dir[i][0];
                int nextCol= curCell[1]+dir[i][1];

                //validations
                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) continue;
                if (matrix[nextRow][nextCol] !='0' ) continue;
                queue.offer(new int[]{nextRow, nextCol});
                matrix[nextRow][nextCol]='#';
            }
        }

    }

    public static void main(String args[]) {
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', 'X', '0'},
                {'X', '0', 'X', 'X'},
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
