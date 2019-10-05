/**
 [60] [01] Find Number Of Island
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
package GooPrep;

import java.util.ArrayDeque;
import java.util.Queue;

public class _Goo_60_01_Number_Of_Island {

    public static int No_of_Islands(int[][] grid){
        int count =0;

        // iterate through every cell in this 2D array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if(grid[row][col] ==1){
                    createIsland(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    public static void createIsland(int[][] grid, int row, int col){

        Queue<IsLandCells> queue = new ArrayDeque<>();
        queue.add(new IsLandCells(row, col));
        //once you put the current r/c make into queue make it zero
        grid[row][col] =0;
        //All all four directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()){
            IsLandCells cl = queue.poll();
            for(int[] dir: directions){
                int rowN = cl.row + dir[0];
                int colN = cl.col + dir[1];
                if(rowN >= 0 && rowN <grid.length && colN>=0 && colN<grid[0].length )
                {
                    if(grid[rowN][colN] == 1){
                        queue.add(new IsLandCells(rowN, colN));
                        //once you put the current r/c make it zero
                        grid[rowN][colN] =0;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println("Number of islands is: " + No_of_Islands(M));
    }

}

class IsLandCells{
    int row;
    int col;
    public IsLandCells(int r, int c){
        this.row = r;
        this.col = c;
    }
}
