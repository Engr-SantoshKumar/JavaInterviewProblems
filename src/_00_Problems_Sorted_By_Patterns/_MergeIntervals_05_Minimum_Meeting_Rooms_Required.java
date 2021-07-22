/* [ _MergeIntervals_05_ ] [ 253. Meeting Rooms II ]
_______________________________________________________________________________
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

intervals = [[0,30],[5,10],[15,20]]
Output: 2
intervals = [[7,10],[2,4]]
Output: 1

Logic:
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.
OneWay to solve this by using the technique of maximum Fights in air. [_Goo_39_Flights_In_Air]
* AnotherWay using PQ technique similar to _oA_16_Merge_given_Intervals
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;

public class _MergeIntervals_05_Minimum_Meeting_Rooms_Required {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int roomCount = 0;
        int[] startArray = new int[intervals.length];
        int[] endArray = new int[intervals.length];

        // load both array with start and end time
        for(int i=0; i<intervals.length; i++) {
            startArray[i] = intervals[i][0];
            endArray[i] = intervals[i][1];
        }
        // sort both array
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        /*For eg:
        Starts 1,5,6,9,10   Ends 8,11,12,13,14
        so meeting 1,5,6 start before first meeting ends at 8 so we need 3 rooms.
        For 9 and 8 we just move i++ and j++ ( think of as it took the spot of the meeting ended at 8.)
        then for 10 and 11.. all previous rooms are occupied and one of them ends after 10...
        so we need a room for a meeting starting at 10 so total 4 rooms */
        int rooms = 0;
        int j = 0;
        for(int i=0; i<startArray.length; i++) {
            if(startArray[i]<endArray[j])
                rooms++;
            else
                j++;
        }
        return rooms;
    }
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 6}, {2, 8}, {10, 16}, {7, 12}};
        System.out.println(minMeetingRooms(intervals));
    }
}
