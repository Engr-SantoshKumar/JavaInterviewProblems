/* [ _MergeInterval_02_ ] [435.  Non-overlapping Intervals ]
_______________________________________________________________________________
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum
 number of intervals you need to remove to make the rest of the intervals non-overlapping.
 Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

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

package _00_Problems_Sorted_By_Patterns;
import java.util.Arrays;
public class _MergeIntervals_02_Non_overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int overlapping = 0;          // result
        // minEnd is Key parameter "active set" for overlapping intervals;
        int minEnd = Integer.MAX_VALUE;
        Arrays.sort(intervals,((a,b) ->(a[0]-b[0])));  // ascending order
        for (int[] in : intervals) {
            int curStart = in[0];
            int curEnd = in[1];
            if (curStart >= minEnd) {        // changing some start , start new " don't overlapp "
                overlapping++;
                minEnd = curEnd;
            } else {
                minEnd = Math.min(minEnd, curEnd);
            }
        }
        return intervals.length - overlapping - 1; // there are overlapping + 1 : overlapping
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,5}, {2,6}, {3,4},{4,6}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
