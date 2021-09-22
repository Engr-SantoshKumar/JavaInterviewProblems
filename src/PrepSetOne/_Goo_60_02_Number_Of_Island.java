/**
[60] [02] Find Number Of Island
-----------------------------------------------------------------------------------------------------
    PROBLEM STATEMENT:
     Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
     and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges
     of the grid are all surrounded by water.

 Input:
 11000
 11000
 00100
 00011

 Output: 3

 */
package PrepSetOne;

import java.util.LinkedList;
import java.util.Queue;

public class _Goo_60_02_Number_Of_Island {

    //All all eight possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0};
    static int[] colDirections = {0 , 0, -1, +1};
    static Queue<Integer> rowQ = new LinkedList<>();
    static Queue<Integer> colQ = new LinkedList<>();


    public static int No_of_Islands(int[][] grid){
        int count =0;
        // iterate through every cell in this 2D array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] ==1){
                    rowQ.add(row);
                    colQ.add(col);
                    grid[row][col] = 0;
                    createIsland(grid);
                    count++;
                }
            }
        }
        return count;
    }

    public static void createIsland(int[][]grid){

        while(!rowQ.isEmpty()) {
            int curRow = rowQ.poll();
            int curCol = colQ.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + rowDirections[i];
                int nextCol = curCol + colDirections[i];
                //boundary check
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
                //skip already visited cell or blocked
                if (grid[nextRow][nextCol] == 0) continue;
                rowQ.add(nextRow);
                colQ.add(nextCol);
                grid[nextRow][nextCol] = 0;
            }
        }

    }



    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println("Number of islands is: " + No_of_Islands(M));
    }

}
