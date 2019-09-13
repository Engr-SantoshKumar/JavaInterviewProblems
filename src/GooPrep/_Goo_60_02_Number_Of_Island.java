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
package GooPrep;

import java.util.LinkedList;
import java.util.Queue;

public class _Goo_60_02_Number_Of_Island {

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

        Queue<Integer> queue = new LinkedList<>();
        int rowLength = grid.length;
        int colLength = grid[0].length;

        grid[row][col] = 0;
        //as we are solving this problem using BFS..put the current position to queue

        // find the position  --> currentRow Position * RowLength + colPosition => [3][4] --> 3*5+4 = 15+4 =19
        int position = row * rowLength + col;
        queue.add(position);

        while(!queue.isEmpty()){
            position = queue.poll();
        int i = position / rowLength;
        int j = position % rowLength;
            //search upward and mark adjacent '1's as '0'.
            if(i>0 && grid[i-1][j]=='1'){
                    queue.offer((i-1)*rowLength+j);
                    grid[i-1][j]='0';
                }
            //down
            if(i<rowLength-1 && grid[i+1][j]=='1'){
                    queue.offer((i+1)*rowLength+j);
                    grid[i+1][j]='0';
                }
            //left
            if(j>0 && grid[i][j-1]=='1'){
                    queue.offer(i*rowLength+j-1);
                    grid[i][j-1]='0';
                }
            //right
            if(j<colLength-1 && grid[i][j+1]=='1'){
                    queue.offer(i*rowLength+j+1);
                    grid[i][j+1]='0';
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
