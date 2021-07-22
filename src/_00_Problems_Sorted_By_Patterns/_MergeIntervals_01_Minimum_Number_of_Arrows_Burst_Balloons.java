package _00_Problems_Sorted_By_Patterns;/* [  ] [ 452. Minimum Number of Arrows to Burst Balloons ]
_______________________________________________________________________________
There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start
and end coordinates of the horizontal diameter.

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6
(bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
                                                          ↑
                                                    10    ↑                      16
                                                    |-----↑-----------------------| ← B2
               1        ↑      6       7                  ↑   12
          B3 → |--------↑-----|       |-------------------↑---| ← B4
                        ↑                                 ↑
                  2     ↑                 8               ↑
                  |-----↑-----------------| ← B1          ↑
                        ↑                                 ↑
                        ↑                                 ↑
                        ↑                               Arrow 2
                      Arrow 1

Logic: problem type Overlapping Interval Problem
1. Sort intervals/pairs in increasing order of the start position.
2. Scan the sorted intervals, and maintain an "active set" for overlapping intervals. At most times,
    we do not need to use an explicit set to store them. Instead, we just need to maintain several key parameters,
    e.g. the number of overlapping intervals (count), the minimum ending point among all overlapping intervals (minEnd).
3. If the interval that we are currently checking overlaps with the active set,
    which can be characterized by cur.start > minEnd, we need to renew those key parameters or change some states.
4. If the current interval does not overlap with the active set, record some parameters,
    and create a new active set that contains the current interval.
*/

import java.util.Arrays;

public class _MergeIntervals_01_Minimum_Number_of_Arrows_Burst_Balloons {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int arrowCount = 0;
        // minEnd : Key parameter "active set" for overlapping intervals,
        // e.g. curEnd will determine what are all overlapping with current (anyOne stat before curEnd will overlap
        int minEnd = Integer.MAX_VALUE;
        //sort array with start point/time
        Arrays.sort(points, ((a, b) -> (a[0] - b[0])));
        for (int[] cur : points) {
            int curStart = cur[0];
            int curEnd = cur[1];
            //suppose the incoming one starts after the min end then there is a gap no overlapping
            if (curStart > minEnd) {
                minEnd = curEnd;
                arrowCount++;
            } else {
                // renew key parameters of the active set (suppose 1st was 2-->6 and 2nd 3-->4 so the min end needs to be updated
                minEnd = Math.min(minEnd, curEnd);
            }
        }
        return arrowCount + 1; //+1 for the last shot for remaining overlapped/single balloon
    }
    public static void main(String[] args) {
        int[][] balloons = new int[][]{{1, 6}, {2, 8}, {10, 16}, {7, 12}};
        System.out.println(findMinArrowShots(balloons));

    }
}
