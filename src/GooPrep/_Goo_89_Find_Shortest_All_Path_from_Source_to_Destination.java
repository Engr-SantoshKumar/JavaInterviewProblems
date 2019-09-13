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

public class _Goo_89_Find_Shortest_All_Path_from_Source_to_Destination {


    public static void findShortestPath(char[][] grid) {

        Queue<>
        List<LinkedHashSet<String>> allPathsResult = new ArrayList<LinkedHashSet<String>>();

        int rSiz = grid.length;
        int cSiz = grid[0].length;

        for (int r = 0; r < rSiz; r++) {
            for (int c = 0; c < cSiz; c++) {
                if (grid[r][c] == 's') {
                    //rowQ.add(r);
                    //colQ.add(c);
                    break;
                }
            }
        }

        Queue<Integer> rowQ = new ArrayDeque<>();


        while(!rowQ.isEmpty()){ // we can even use colQ because both wil always have same elements

        }
    }

    //this is the simplest way to find Neighbour
    public static void exploreNeighbours(int curR, int curC, char[][] grid, boolean[][] visitedGrid){
        int totalNeighbours = 4; // only four sides, no corners

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

class pathNode{
    int nodeNo;
    int row;
    int col;
    LinkedHashSet<Integer> pathTraveled;
    public pathNode(int nodeNo, int row, int col, LinkedHashSet pathTraveled){
        this.nodeNo = nodeNo;
        this.row = row;
        this.col = col;
        this.pathTraveled = pathTraveled;
    }
}