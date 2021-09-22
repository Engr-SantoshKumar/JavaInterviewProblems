/**
[  ] [  ]
____________________________________________________________________________________________________________________
****** Don't pass result as a param to BFS it always keep changing as it is a local variable
Find the longest sequence length from nxn matrix
[1 2 9
 5 3 8
 4 6 7]
 This contains three sequences of adjacent numbers
 [1,2,3],[4,5],[6,7,8,9] longest sequence length is 4
 */

package PrepSetOne;

import java.util.*;

public class _Goo_90_Longest_Sequences_in_Matrix {

    //All all four possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0};
    static int[] colDirections = {0 , 0, -1, +1};
    static Queue<Integer> rowQ = new ArrayDeque<>();
    static Queue<Integer> colQ = new ArrayDeque<>();


    public static List<Set<Integer>> LongestSequence(int[][] grid){
        List<Set<Integer>> result = new ArrayList<>();

        if(grid==null || grid.length==0||grid[0].length==0)
            return result;

        //scan for 0 and put all 0s in the queue
        for(int row =0; row<grid.length; row++){
            for(int col =0; col<grid[0].length; col++){
                boolean[][] isVisited = new boolean[grid.length][grid[0].length];
                if(!isVisited[row][col]) {
                    rowQ.add(row);
                    colQ.add(col);
                    isVisited[row][col] = true;
                    result.add(exploreNeighbours( grid, isVisited));
                }
            }
        }
        return result;
    }

    public static Set<Integer> exploreNeighbours(int[][] grid, boolean[][] isVisited){
        Set<Integer> currentList = new HashSet<>();
        while (!rowQ.isEmpty()) {
            int curRow = rowQ.poll();
            int curCol = colQ.poll();
            currentList.add(grid[curRow][curCol]);
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + rowDirections[i];
                int nextCol = curCol + colDirections[i];
                //some condition checks
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
                if (isVisited[nextRow][nextCol]) continue;
                if (grid[nextRow][nextCol] == grid[curRow][curCol] + 1 ) {
                    isVisited[nextRow][nextCol] = true;
                    rowQ.add(nextRow);
                    colQ.add(nextCol);
                }
            }
        }
        return currentList;
    }

    public static void main(String args[]) {
        int[][] M = new int[][]{
                {2, 1, 3},
                {5, 9, 8},
                {4, 6, 7}};
        int[][] M1 = new int[][]{
                {1, 2, 5},
                {2, 2, 3},
                {5, 3, 3}};
        List<Set<Integer>> result = LongestSequence(M);
        List<Set<Integer>> result1 = LongestSequence(M1);
        System.out.println(" final result:" + Arrays.toString(result.toArray()));
        System.out.println(" final result:" + Arrays.toString(result1.toArray()));
    }
}
