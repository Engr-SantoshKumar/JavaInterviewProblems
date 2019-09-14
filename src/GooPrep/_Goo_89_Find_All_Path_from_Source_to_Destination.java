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


    public static void findAllPossiblePath(char[][] grid) {

        // some global variables
        List<LinkedHashSet<Integer>> allPathsResult = new ArrayList<LinkedHashSet<Integer>>();
        Queue<pathNode> queue = new ArrayDeque<>();

        int rSiz = grid.length;
        int cSiz = grid[0].length;

        int gateCell =  0;
        int exitCell =  0;

        // search for entry and exit door cell
        for (int r = 0; r < rSiz; r++) {
            for (int c = 0; c < cSiz; c++) {
                if (grid[r][c] == 's') {
                    gateCell = r*(rSiz-1) + c;  // eg: [0, 3] == 3

                }
                if(grid[r][c] == 'd') {
                    exitCell = r*(rSiz-1) + c;  // eg: [4, 1] == 4*4+1 = 17
                }
            }
        }

        // first put the source in Queue as (source and destination)
        LinkedHashSet<Integer> path = new LinkedHashSet<>();
        path.add(gateCell);
        queue.add(new pathNode(gateCell, path));

        //BFS
        while(!queue.isEmpty()){

            pathNode curNode = queue.poll();

            if(curNode.nodeNo == exitCell){
                allPathsResult.add(curNode.pathTraveled);
            }
            ArrayList<Integer> adjacentCells  =  exploreNeighbours(curNode.nodeNo, curNode.pathTraveled, grid );

            for(int cell : adjacentCells){
                LinkedHashSet<Integer> newPath = new LinkedHashSet<>();
                newPath.addAll(curNode.pathTraveled);
                newPath.add(cell);
                queue.add(new pathNode(cell, newPath));
            }
        }

        //to print the all the path
        for(LinkedHashSet<Integer> ll : allPathsResult){
            System.out.println(ll);
        }

    }

    //this is the simplest way to find Neighbour
    public static ArrayList<Integer> exploreNeighbours(int curCell, LinkedHashSet<Integer> curPath, char[][] grid) {
        int totalNeighbours = 4; // only four sides, no corners
        ArrayList<Integer> adjCells = new ArrayList<>();

        //extract the current row AND cell from cell position
        int curR = curCell / grid[0].length;
        int curC = curCell % grid[0].length;
        int[] rowDirections = {-1, +1, 0, 0};
        int[] colDirections = {0, 0, -1, +1};

        for (int i = 0; i < totalNeighbours; i++) {
            int newR = curR + rowDirections[i];
            int newC = curC + colDirections[i];

            int cellPosition = newR * (grid[0].length) + newC;

            //skip outOfBounds cells
            if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) continue;

            //skip already visited cell or blocked
            if (curPath.contains(cellPosition) || grid[newR][newC] == '#') continue;
            adjCells.add(cellPosition);

        }
        return adjCells;
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

class pathNode{
    int nodeNo;
    LinkedHashSet<Integer> pathTraveled;
    public pathNode(int nodeNo, LinkedHashSet pathTraveled){
        this.nodeNo = nodeNo;
        this.pathTraveled = pathTraveled;
    }
}