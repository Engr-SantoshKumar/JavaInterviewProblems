/**
 [89] [Find All Path from S --> D]
 -----------------------------------------------------------------------------------------------------
 The idea is to BFS (breadth first search) on matrix cells. Note that we can always use BFS to find shortest path if
 graph is unweighted.

 Store each cell as a node with their row, column values and distance from source cell.
 Start BFS with source cell.
 Make a visited array with all having “false” values except ‘0’cells which are assigned “true”
 values as they can not be traversed.
 Keep updating distance from source value in each move.
 Return distance when destination is met, else return -1 (no path exists in between source and destination).

 */

package GooPrep;
import java.util.*;
public class _Goo_89_Find_All_Path_from_Source_to_Destination {

    static int[] rowDirections = {-1, +1, 0, 0};
    static int[] colDirections = {0, 0, -1, +1};

    public static void findAllPossiblePath(char[][] grid) {

        List<LinkedHashSet<Integer>> allPathsResult = new ArrayList<LinkedHashSet<Integer>>();
        Queue<headWithPath> allTraveledPath = new ArrayDeque<>();
        int totalWaysToGetDestination =0;

        int[] entryCell = new int[0];

        // search for entry and exit door cell
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 's') {
                    entryCell = new int[]{r, c};
                }
            }
        }

        // first put the source in Queue as (source and destination)
        LinkedHashSet<Integer> path = new LinkedHashSet<>();
        int intValueOfCell = entryCell[0]*grid[0].length + entryCell[1];
        path.add(intValueOfCell);
        allTraveledPath.add(new headWithPath(entryCell, path));

        //BFS
        while(!allTraveledPath.isEmpty()){
            headWithPath curPath = allTraveledPath.poll();
            //extract the current row AND cell from cell position
            int curR = curPath.head[0];
            int curC = curPath.head[1];

            // check if we are exit cell
            if(grid[curR][curC] == 'd'){
                allPathsResult.add(curPath.pathTraveled);
                totalWaysToGetDestination++;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newR = curR + rowDirections[i];
                int newC = curC + colDirections[i];

                intValueOfCell = newR * (grid[0].length) + newC;

                //skip outOfBounds cells
                if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) continue;
                //skip already visited cell or blocked
                if (curPath.pathTraveled.contains(intValueOfCell) || grid[newR][newC] == '#') continue;

                LinkedHashSet<Integer> newPath = new LinkedHashSet<>();
                newPath.addAll(curPath.pathTraveled);
                newPath.add(intValueOfCell);
                allTraveledPath.add(new headWithPath(new int[]{newR, newC}, newPath));
            }
        }

        System.out.println("Total possible Paths : " + totalWaysToGetDestination);
        //to print the all the path
        for(LinkedHashSet<Integer> ll : allPathsResult){
            System.out.println(ll);
        }
    }

    public static void main(String[] args) {
        char grid[][] = {   { '*', '*', '*', 's' },
                            { '*', '#', '*', '*' },
                            { '*', '#', '#', '*' },
                            { '*', '*', '*', '*' },
                            { '*', 'd', '*', '#' }};
        for (char[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
        findAllPossiblePath(grid);
    }
}

class headWithPath {
    int[] head;
    LinkedHashSet<Integer> pathTraveled;
    public headWithPath(int[] head, LinkedHashSet<Integer> pathTraveled){
        this.head = head;
        this.pathTraveled = pathTraveled;
    }
}

/*
[*, *, *, s]
[*, #, *, *]
[*, #, #, *]
[*, *, *, *]
[*, d, *, #]
Total possible Paths : 12
[3, 7, 11, 15, 14, 18, 17]
[3, 7, 11, 15, 14, 13, 17]
[3, 7, 11, 15, 14, 13, 12, 16, 17]
[3, 2, 6, 7, 11, 15, 14, 18, 17]
[3, 2, 6, 7, 11, 15, 14, 13, 17]
[3, 2, 1, 0, 4, 8, 12, 16, 17]
[3, 2, 1, 0, 4, 8, 12, 13, 17]
[3, 7, 6, 2, 1, 0, 4, 8, 12, 16, 17]
[3, 7, 6, 2, 1, 0, 4, 8, 12, 13, 17]
[3, 2, 6, 7, 11, 15, 14, 13, 12, 16, 17]
[3, 2, 1, 0, 4, 8, 12, 13, 14, 18, 17]
[3, 7, 6, 2, 1, 0, 4, 8, 12, 13, 14, 18, 17]
 */