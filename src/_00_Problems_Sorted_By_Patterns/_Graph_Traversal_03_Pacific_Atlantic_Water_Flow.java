/* [ _Graph_Traversal_03_ ] [ 417. Pacific Atlantic Water Flow ]
_______________________________________________________________________________
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

Each cells represents height above sea level, rain water can flow to neighboring cells directly north, south, east,
and west if the neighboring cell's height is less than or equal to the current cell's height.

Question is to find whether water flows from the grid to the ocean, not from the ocean to the grids.
Return those grids only from where water can flow to both ocean.

e.g:
Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

Logic:
Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
Keep a visited matrix for each queue. In the end, add the cell visited by two queue to the result.
We start from edge, Since water can only flow from high/equal cell to low cell,
add the neighbor cell with height larger or equal to current cell to the queue and mark as visited.

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _Graph_Traversal_03_Pacific_Atlantic_Water_Flow {

    //global variable direction
    static int[][] direction = new int[][]{{0,1},{0, -1}, {-1, 0},{1, 0}};

    public static List<int[]> pacificAtlanticWaterFlow(int[][] matrix){
        List<int[]> result = new LinkedList<>();
        int r = matrix.length, c = matrix[0].length;
        //Visited grid for each (we can use single visited: pacific == -1, atlantic == -2, both == -3
        boolean[][] pacificVisited= new boolean[r][c];
        boolean[][] atlanticVisited = new boolean[r][c];
        Queue<int[]> pQueue = new ArrayDeque<>();
        Queue<int[]> aQueue = new ArrayDeque<>();

        //load top/bottom Horizontal border to their respective queue
        for(int i=0; i<c; i++){
            pQueue.offer(new int[]{0,i}); //topRow
            aQueue.offer(new int[]{r-1,i}); //bottomRow
            pacificVisited[0][i] = true; //update visited grid too
            atlanticVisited[r-1][i]=true;
        }
        //Vertical borders
        for(int i=0; i<r; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, c - 1});
            pacificVisited[i][0] = true;
            atlanticVisited[i][c - 1] = true;
        }

        // fill the visited grid for both
        bfs(matrix,pQueue,pacificVisited);
        bfs(matrix, aQueue, atlanticVisited);

        //scan both visited and find common
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(pacificVisited[row][col] && atlanticVisited[row][col] ){
                    result.add(new int[]{row,col});
                }
            }
        }
        return result;
    }

    private static void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int row = matrix.length, col = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:direction){
                int nextRow = cur[0]+d[0];
                int nextCol = cur[1]+d[1];
                if(nextRow<0 || nextRow>=row || nextCol<0 || nextCol>=col)continue;
                if(visited[nextRow][nextCol]) continue;
                if(matrix[nextRow][nextCol] < matrix[cur[0]][cur[1]])continue; // as we are going from sea to land we look for higher or equal ground

                visited[nextRow][nextCol] = true;
                System.out.println(nextRow + ", " +nextCol);
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{   {1,2,2,3,5},
                                        {3,2,3,4,4},
                                        {2,4,5,3,1},
                                        {6,7,1,4,5},
                                        {5,1,1,2,4}
                                    };

        List<int[]> result = pacificAtlanticWaterFlow(matrix);
        System.out.println(result);

    }

}
