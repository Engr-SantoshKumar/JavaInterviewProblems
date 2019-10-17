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
 step2: pull zero and visit is adjutant cell, if cell value is INF then update cell value with [currentCell's value+1]
 and add cell to queue. After working with all 0's adjutant cells, queue will looks like
 pull 0(r0,c2) --> q[0(r3,c0), # 1(r1,c2), 1(r0,c3)] --> now pull 0(r3,c0)
 --> q[1(r1,c2), 1(r0,c3), 1(r2, c0]

 */
package GooPrep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _Goo_61_Walls_And_Gates {

    //All all four possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0};
    static int[] colDirections = {0 , 0, -1, +1};
    static Queue<Integer> rowQ = new LinkedList<>();
    static Queue<Integer> colQ = new LinkedList<>();


    public static void shortestPathToGate(int[][] grid){
        if(grid==null || grid.length==0||grid[0].length==0)
            return;

        //scan for 0 and put all 0s in the queue
        for(int row =0; row<grid.length; row++){
            for(int col =0; col<grid[0].length; col++){
                if(grid[row][col] ==0){
                    rowQ.add(row);
                    colQ.add(col);
                }
            }
        }
        // pull the 0 and check its adjutant cells is this value is MaxInteger update it
        while (!rowQ.isEmpty()) {
            int curRow = rowQ.poll();
            int curCol = colQ.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + rowDirections[i];
                int nextCol = curCol + colDirections[i];
                //some condition checks
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
                if (grid[nextRow][nextCol] == -1) continue;

                if (grid[nextRow][nextCol] == Integer.MAX_VALUE) {
                    grid[nextRow][nextCol] = grid[curRow][curCol] + 1;
                    rowQ.add(nextRow);
                    colQ.add(nextCol);
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