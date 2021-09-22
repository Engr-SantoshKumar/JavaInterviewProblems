/**
 * [ _Goo2 ] [ Find all Path in 2d boolean matrix ]
______________________________________________________________________________________________________________
 Given a MxN matrix where each element can either be 0 or 1. We need to find the path
 between a given source cell to a destination cell.

 */

package PrepSetTwo;

import java.util.*;

public class _Goo2_23_G_FindAllPathIn2DMaze {

    public static void findAllPossiblePath(int[][] grid){
        int[] source = {0,0};
        int[] dest = {4,4,};
        boolean[][] visitedMatrix=new boolean[grid.length][grid[0].length];
        visitedMatrix[0][0] = true;

        int[] rDir = {1, -1, 0, 0};
        int[] cDir = {0, 0, 1, -1};

        Queue<SourceWithPath> queue = new ArrayDeque<>();

        List<LinkedHashSet<int[]>> results = new ArrayList<>();

        LinkedHashSet<int[]> currentPath = new LinkedHashSet<>();
        currentPath.add(source);
        queue.offer(new SourceWithPath(source, currentPath));

        while(!queue.isEmpty()){
            SourceWithPath current = queue.poll();
            int curRow = current.source[0];
            int curCol = current.source[1];

            if(curRow == dest[0] && curCol == dest[1]){
                results.add(current.pathTraveled);
                break;
            }
            for (int i = 0; i < 4; i++){
                int nRow = curRow + rDir[i];
                int nCol = curCol + cDir[i];

                // some validations
                if (nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length) continue;
                //if (visitedMatrix[nRow][nCol]) continue;
                if (grid[nRow][nCol]==0)continue;

                //update source and path with new cell
                int[] newSource = {nRow,nCol};

                if(current.pathTraveled.contains(newSource)) continue;


                LinkedHashSet<int[]> newPath = new LinkedHashSet<>();
                newPath.addAll(current.pathTraveled);
                newPath.add(newSource);

                //add to Q and update boolean matrix
                queue.add(new SourceWithPath(newSource, newPath));
                //visitedMatrix[nRow][nCol]=true;
            }
        }

        //print result
        for(LinkedHashSet<int[]> cur: results){
            for(int[] i : cur){
                System.out.print(Arrays.toString(i));
            }
        }
    }

    public static void main(String[] args) {
        int grid[][] = {    {1, 0, 0, 0, 0},
                            {1, 0, 1, 1, 1},
                            {1, 0, 1, 0, 1},
                            {1, 0, 1, 0, 1},
                            {1, 1, 1, 0, 1}};

        findAllPossiblePath(grid);
    }
}

class SourceWithPath{
    int[] source;
    LinkedHashSet<int[]> pathTraveled;
    public SourceWithPath(int[] source, LinkedHashSet<int[]> pathTraveled){
        this.source = source;
        this.pathTraveled = pathTraveled;
    }
}