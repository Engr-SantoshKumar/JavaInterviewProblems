package GooPrep02;

import java.util.*;

/**
 * [  ] [  ]
 * ____________________________________________________________________________________________________________________
 */
public class _Goo2_19_G_Keys_And_Doors {

    static int[] rowDirections = {-1, +1 , 0, 0};
    static int[] colDirections = {0 , 0, -1, +1};
    static Queue<Integer> rowQ = new LinkedList<>();
    static Queue<Integer> colQ = new LinkedList<>();
    static Queue<PathWithKeys> pathQ = new LinkedList<>();

    private static List<int[]> shortestPath(Character[][] grid){

            // iterate through every cell in this 2D array
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if(grid[row][col] =='@'){
                        rowQ.add(row);
                        colQ.add(col);

                        //setting the object
                        Character key = ' ';
                        int[] currentStep = {row, col};
                        List<int[]> curPath = new ArrayList<>();
                        curPath.add(currentStep);
                        pathQ.add(new PathWithKeys(new ArrayList<>(key), curPath ));

                        //
                        findPath(grid);

                    }
                }
            }
            return null;
    }

    public static void findPath(Character[][] grid){
        int curRow = rowQ.poll();
        int curCol = colQ.poll();
        PathWithKeys curPathWithKey = pathQ.poll();

        if(grid[curRow][curRow] == '+'){
            System.out.println("Print Path");
            List<int[]> pathToSource = curPathWithKey.path;
        }
        for (int i = 0; i < 4; i++) {
            int nextRow = curRow + rowDirections[i];
            int nextCol = curCol + colDirections[i];
        if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
        if (grid[nextRow][nextCol] == '#') continue;

            if (grid[nextRow][nextCol] == 'a' || grid[nextRow][nextCol] == 'b') {
                Character newKey = grid[nextRow][nextCol];
                List<Character> addNewKey = new ArrayList<>();
                addNewKey.addAll(curPathWithKey.keys);
                addNewKey.add(newKey);
            }

            if (grid[nextRow][nextCol] == 'A' || grid[nextRow][nextCol] == 'B') {
                // need to check if your curPathWithKey.key contains a, b
                //if yes add current cell to your path

            }

            int[] newStep = {nextRow, nextCol};
            List<int[]> curPath = new ArrayList<>();
            curPath.addAll(curPathWithKey.path);
            curPath.add(newStep);
    }
    }




    static class PathWithKeys{
        List<Character> keys = new ArrayList<>();
        List<int[]> path =  new ArrayList<>();

        public PathWithKeys(List<Character> key, List<int[]> path){
            this.keys = key;
            this.path = path;
        }
    }
}
