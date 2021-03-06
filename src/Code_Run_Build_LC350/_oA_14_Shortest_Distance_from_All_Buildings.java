/* [ oA_14] [ Find Shortest_Distance_from_All_Buildings ]
 ____________________________________________________________________________________________________________
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 Example:

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 Output: 7

 Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 the point (1,2) is an ideal empty land to build a house, as the total
 travel distance of 3+3+1=7 is minimal. So return 7.

 Logic: we need 3 matrix of same size of input grid
       1. distSumToEachBuilding[][] --> to capture sum of dist from a cell to all building
       2. reach[][] --> to track how many building can be reached from each cells
       3. isVisited[][] --> to track visited cells

 */
package Code_Run_Build_LC350;
import java.util.ArrayDeque;
import java.util.Queue;
public class _oA_14_Shortest_Distance_from_All_Buildings {
    // some global variables --> all possible directions + Queue for BFS
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Queue<int[]> queue = new ArrayDeque<>();

    static int[][] distSumToEachBuilding; // --> to capture sum of dist from a cell to all building
    static int[][] reach; //--> to track how many building can be reached from each cells

    public static int shortestDistToAll(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        distSumToEachBuilding = new int[grid.length][grid[0].length];
        reach = new int[grid.length][grid[0].length];
        int totalBuildingsInGrid = 0;

        /* Step 1: start from every building mark i.e. 1, doing BFS traversal to fill out all the empty spaces (0) */
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    totalBuildingsInGrid++;
                    dfs(grid, distSumToEachBuilding, row, col);
                }
            }
        }
        // lets scan the grid , distSumToEachBuilding and reach to get the min dist
        int minDist = Integer.MAX_VALUE;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0 && reach[r][c] == totalBuildingsInGrid) {
                    minDist = Math.min(minDist, distSumToEachBuilding[r][c]);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    /* Step 2: find minimum distance from dp array*/
    public static void dfs(int[][] grid, int[][] distSumToEachBuilding, int row, int col) {
        int level = 1; //need a variable to track how far from current building
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{row, col});
        isVisited[row][col] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                for (int[] dir: directions) {
                    int nextRow = curCell[0] + dir[0];
                    int nextCol = curCell[1] + dir[1];
                    //some condition checks
                    if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
                    if (grid[nextRow][nextCol] != 0 || isVisited[nextRow][nextCol]) continue;
                    //update the distance matrix by adding current level
                    distSumToEachBuilding[nextRow][nextCol] += level;
                    isVisited[nextRow][nextCol] = true;
                    reach[nextRow][nextCol] ++;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            level++;
        }
    }
    public static void main (String[]args){
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        System.out.println(shortestDistToAll(grid));
    }
}
