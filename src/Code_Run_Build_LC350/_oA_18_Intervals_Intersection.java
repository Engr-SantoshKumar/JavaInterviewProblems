/*
 * [ _oA_18 ] [ [Pattern: Merge Intervals --> Intervals Intersection ]
 * _______________________________________________________________________________________________________________
Given two lists of intervals, find the intersection of these two lists.
Each list consists of disjoint intervals sorted on their start time.
Example 1:
Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
Example 2:
Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
 * */
package Code_Run_Build_LC350;

import java.util.ArrayList;
import java.util.List;

public class _oA_18_Intervals_Intersection {
    public static int[][] intervalIntersection(int[][] intervalListA, int[][] intervalListB) {
        //base cases
        if(intervalListA == null || intervalListA.length==0 || intervalListB == null || intervalListB.length==0 ){
            return new int[][]{};
        }

        int i=0, j=0;
        List<int[]> result = new ArrayList<>();
        //loop through both intervals together and find the overlapping area
        while(i < intervalListA.length && j < intervalListB.length){

            // Logic: interval A = [4 -->7]; interval B = [5--> 10]
            // so the overlapping is [5-->7] i.e maxOfStart(4,5) i.e 5 and minOfEnd(7,10) i.e 7
            int maxOfStart = Math.max(intervalListA[i][0], intervalListB[j][0]);
            int minOfEnd   = Math.min(intervalListA[i][1], intervalListB[j][1]);

            //Now how do we know if maxOfStart and minOfEnd is part of Overlapping
            //only is maxStart(start) < maxEnd(end) in other word : interval start time must be before the end time
            // e.g  A=[2,5] B=[7,9];--> maxStart,minEnd = [7, 5] --> invalid, not part of overlapping
            // e.g  A=[2,8] B=[5,9];--> maxStart,minEnd = [5, 8] --> valid, part of overlapping
            if(maxOfStart <= minOfEnd){
                result.add(new int[]{maxOfStart, minOfEnd});
            }
            // only increment the counter if current interval is ending
            if(intervalListA[i][1] == minOfEnd) i++;
            if(intervalListB[j][1] == minOfEnd) j++;
        }

        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] givenIntervals1 = new int[][]{{1, 3}, {5, 6}, {7, 9}};
        int[][] givenIntervals2 = new int[][]{{2, 3}, {5, 7}};
        printMatrix(givenIntervals1);
        printMatrix(givenIntervals2);
        int[][] result = intervalIntersection(givenIntervals1, givenIntervals2);
        printMatrix(result);
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(" " + anInt + " ");
            }
            System.out.print("] ");
        }
    }
}
