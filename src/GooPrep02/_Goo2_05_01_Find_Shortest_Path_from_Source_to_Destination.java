package GooPrep02;

import java.util.*;

public class _Goo2_05_01_Find_Shortest_Path_from_Source_to_Destination {

    // some global variables
    static int[] rowDirections = {-1, +1 , 0, 0};
    static int[] colDirections = {0 , 0, -1, +1};
    //storing
    static Queue<Integer> rowQ = new ArrayDeque<>();
    static Queue<Integer> colQ = new ArrayDeque<>();

    public static int findShortestPath(char[][] grid){

       int rSiz = grid.length;
       int cSiz = grid[0].length;
       boolean visitedGrid[][] = new boolean[rSiz][cSiz];
       int totalStepsToDist =0;
       // find the starting point
       for(int r = 0; r < rSiz; r++){
           for(int c =0; c < cSiz; c++){
               if(grid[r][c]=='s'){
                   rowQ.add(r);
                   colQ.add(c);
                   visitedGrid[r][c] = true;
               }
           }
       }

       while(!rowQ.isEmpty()){
           int size = rowQ.size(); // here using the logic of level order printing
           while(size > 0){
               int curR = rowQ.poll();
               int curC = colQ.poll();
               if(grid[curR][curC] == 'd'){
                   return totalStepsToDist;
               }
               exploreNeighbours(curR, curC, grid, visitedGrid);
               size--;
           }
           totalStepsToDist++;
       }
        return -1;
    }

    //this is the simplest way to find Neighbour
    public static void exploreNeighbours(int curR, int curC, char[][] grid, boolean[][] visitedGrid){
        int totalNeighbours = 4; // only four sides, no corners
        for(int i =0; i < totalNeighbours; i++){
            int newR = curR + rowDirections[i];
            int newC = curC + colDirections[i];
            //skip outOfBounds cells
            if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) continue;
            //skip already visited cell or blocked
            if(visitedGrid[newR][newC] || grid[newR][newC] == '#') continue;
            //add new valid neighbours to rowQ and colQ respectively
            rowQ.add(newR);
            colQ.add(newC);
            // mark current r and c visited
            visitedGrid[newR][newC] = true;
         }
    }
    public static void main(String[] args) {
        char grid[][] = { { '#', '*', '#', 's' },
                          { '*', '*', '*', '*' },
                          { '*', '#', '#', '*' },
                          { '*', 'd', '*', '*' } };
        for (char[] x : grid) {
            System.out.println(Arrays.toString(x));
        }

        System.out.println("Minimum steps required to s --> d is :"+findShortestPath(grid));
    }
}
