/* [ _MergeIntervals_02_ ] [ 6. Interval List Intersections ]
_______________________________________________________________________________
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

 A  -->       |--------↓-----|     |------|      |-----------------------|
              ↓        ↓     ↓     ↓      ↓      ↓         ↓
 B --->   |---↓----|   |-----↓-----↓------↓------↓---------|
              ↓    ↓   ↓     ↓     ↓      ↓      ↓         ↓
              ↓    ↓   ↓     ↓     ↓      ↓      ↓         ↓
intersection     1st     2nd          3rd             4th

Logic:
1. Start Point of intersection will be MaxOf(StartOfA, StartOfB)
2. End Point of intersection will be MinOf(EndOfA, EndOfB)
3. Remove the interval of smallest end point(move i or j in A or B)
*/


package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _MergeIntervals_02_Interval_List_Intersections {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startPoint of the intersection
            // hi - the endPoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) //--> if low is less than high then there is overlapping
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervalsA = new int[][]{{3,6}, {7,8}, {9,15}};
        int[][] intervalsB = new int[][]{{1,4}, {5,11}};
        int[][] result = intervalIntersection(intervalsA, intervalsB);
        for(int[] cur: result){
            System.out.println(Arrays.toString(cur));
        }
    }
}
