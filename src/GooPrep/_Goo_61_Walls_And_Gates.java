/**  61 [Walls And Gate]
 ____________________________________________________________________________________________________________________
 You are given a m x n 2D grid initialized with these three possible values.
 [ -1 ]  –> A wall or an obstacle.
 [ 0 ]   -> A gate.
 [INF]   –> Infinity means an empty room. We use the value 231 – 1 = 2147483647 to represent INF
 as you may assume that the distance to a gate is less than 2147483647.
 Q. Fill each empty room with the distance to its nearest gate.

Given :                         OutPut:
 INF   -1   0   INF             3  -1   0   1
 INF  INF  INF   -1   -->       2   2   1  -1
 INF   -1  INF   -1             1  -1   2  -1
   0   -1  INF  INF             0  -1   3   4

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 Logic: you always just need to update INF cells, if value is something else its already being updated with distance
 step1: load queue with all 0s --> q[0(r0,c2), 0(r3,c0)]
 step2: pull zero and visit is adjutant cell, if cell value is INF then update cell value with [currentCell's value + 1]
 and add cell to queue. After working with all 0's adjutant cells, queue will looks like
 pull 0(r0,c2) --> q[0(r3,c0), 1(r1,c2), 1(r0,c3)] --> now pull 0(r3,c0)
 --> q[1(r1,c2), 1(r0,c3), 1(r2, c0]

 */
package GooPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _Goo_61_Walls_And_Gates {


    public static void shortestPathToGate(int[][] grid){

        if(grid==null || grid.length==0||grid[0].length==0)
            return;
        //All all four directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Cell> queue = new ArrayDeque<>();

        //scan for 0 and put all 0s in the queue
        for(int row =0; row<grid.length; row++){
            for(int col =0; col<grid[0].length; col++){
                if(grid[row][col] ==0){
                    queue.offer(new Cell(row, col));
                }
            }
        }
        // pull the 0 and check its adjutant cells is this value is MaxInteger update it
        while (!queue.isEmpty()){
            Cell cl = queue.poll();
            for(int[] dir: directions){
                int rowN = cl.row + dir[0];
                int colN = cl.col + dir[1];
                if(rowN >= 0 && rowN <grid.length && colN>=0 && colN<grid[0].length )
                {
                    if(grid[rowN][colN] == Integer.MAX_VALUE){
                        int currentCellValue = grid[cl.row][cl.col];
                        grid[rowN][colN] = currentCellValue +1;
                        queue.offer(new Cell(rowN, colN));
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        int[][] grid = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        for (int[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
        shortestPathToGate(grid);
        System.out.println("\n\n\nUpdate grid with path");

        for (int[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
    }
}
class Cell{
    int row;
    int col;
    public Cell(int r, int c){
        this.row = r;
        this.col = c;
    }
}
