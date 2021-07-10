/* [ _Board_01_ ] [ Matrix distance from 0 ]
_______________________________________________________________________________
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
this question is very similar with _Goo_61_Walls_And_Gates, same logic.
    [1, 1, 0, 1]            [2, 1, 0, 1]
    [1, 1, 1, 1]    -->     [2, 2, 1, 2]
    [1, 1, 1, 1]            [1, 2, 2, 3]
    [0, 1, 1, 1]            [0, 1, 2, 3]


*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _GraphMatrix_01_Matrix_BFS {

    public static int[][] matrixSolver(int[][] matrix){
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        updateMatrix(matrix, queue, visited, dir);
        return matrix;
    }

    private static void updateMatrix(int[][] matrix, Queue<int[]> queue, boolean[][] visited, int[][] dir) {

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dir[i][0];
                int nextCol = curCol + dir[i][1];

                //validations
                if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) continue;
                if (visited[nextRow][nextCol]) continue;

                //update
                visited[nextRow][nextCol] = true;
                matrix[nextRow][nextCol] = matrix[curRow][curCol] + 1;
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }

    public static void main(String args[]) {
        int[][] grid = {
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        for (int[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
        matrixSolver(grid);
        System.out.println("\n\n\nUpdate grid with path");

        for (int[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
    }
}

