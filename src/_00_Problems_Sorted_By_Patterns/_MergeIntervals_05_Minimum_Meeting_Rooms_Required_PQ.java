/* [ _MergeIntervals_05_ ] [ 253. Meeting Rooms II ]
_______________________________________________________________________________
Given an array of meeting time intervals intervals where intervals[i] = [start-i, end-i],
return the minimum number of conference rooms required.

intervals = [[0,30],[5,10],[15,20]]
Output: 2
intervals = [[7,10],[2,4]]
Output: 1


*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _MergeIntervals_05_Minimum_Meeting_Rooms_Required_PQ {

        public static int findMinimumRoomRequiredPQ ( int[][] meetings){
            // some base case
            if (meetings == null || meetings.length == 0) return 0;
            if (meetings.length == 1) return 1;

            // sort the meetings to start time lambda style comparator
            Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
            //need a PQ to track and compare ended meetings so that first ending will be at top
            Queue<int[]> minPQ = new PriorityQueue<>((a, b) -> a[1]- b[1]);
            int minMeetingRoom=meetings.length;
            for (int[] currMeeting : meetings) {
                // If the current meeting starts before any ended meeting then we need a new meeting room.
                if (minPQ.size() == 0 || currMeeting[0] < minPQ.peek()[1]) {
                    minPQ.add(currMeeting);
                    minMeetingRoom = Math.min(minMeetingRoom, minPQ.size());
                } else {
                    // Re-use the meeting room of the meeting that finished earliest.
                    minPQ.remove();// remove the finished one and add the current running one
                    minPQ.add(currMeeting);
                }
            }
            return minPQ.size();
        }
        public static void main (String[]args){
            int[][] meetings = {{1, 3}, {5, 6}, {7, 9}, {2, 3}, {5, 7}};
            int c = findMinimumRoomRequiredPQ(meetings);
            System.out.println(c);
        }
}
