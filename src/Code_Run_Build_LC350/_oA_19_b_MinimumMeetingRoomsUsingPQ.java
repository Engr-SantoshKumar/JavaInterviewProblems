/* [ _oA_19_b_ ] [Pattern: Merge Intervals --> Minimum Meeting Rooms using PQ]
______________________________________________________________________________________________________________
    Given a list of intervals representing the start and end time of ‘N’ meetings,
    find the minimum number of rooms required to hold all the meetings.
    Example 1:
    Meetings: [[1,4], [2,5], [7,9]]
    Output: 2

 Logic:  we need a minHip(PQ) to track the first ending meeting at top and compare with current
*/

package Code_Run_Build_LC350;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _oA_19_b_MinimumMeetingRoomsUsingPQ {

    public static int findMinimumRoomRequiredPQ(int[][] meetings){
        // some base case
        if(meetings == null || meetings.length ==0) return 0;
        if(meetings.length ==1) return 1;

        // sort the meetings to start time lambda style comparator
        Arrays.sort(meetings, (a, b) -> a[0]- b[0]);
        //need a PQ to track and compare ended meetings so that first ending will be at top
        Queue<int[]> minPQ = new PriorityQueue<>((a, b) -> a[1]- b[1]);

        for (int[] currMeeting : meetings) {
            // If the current meeting starts before the earliest meeting ends then we need a new meeting room.
            if (minPQ.size() == 0 || currMeeting[0] < minPQ.peek()[1]) {
                minPQ.add(currMeeting);
            } else {
                // Re-use the meeting room of the meeting that finished earliest.
                // remove the finished one and add the current running one
                minPQ.remove();
                minPQ.add(currMeeting);
            }
        }
        return minPQ.size();
    }
    public static void main(String[] args) {
        int[][] meetings = {{1, 3}, {5, 6}, {7, 9}, {2, 3}, {5, 7}};
        int c = findMinimumRoomRequiredPQ(meetings);
        System.out.println(c);
    }



}
