/*
 * [ _oA_19_ ] [Pattern: Merge Intervals --> Minimum Meeting Rooms ]
______________________________________________________________________________________________________________
Given a list of intervals representing the start and end time of ‘N’ meetings,
find the minimum number of rooms required to hold all the meetings.
Example 1:
Meetings: [[1,4], [2,5], [7,9]]
Output: 2
Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
occur in any of the two rooms later.
OneWay to solve this by using the technique of maximum Fights in air. [_Goo_39_Flights_In_Air]
* AnotherWay using PQ technique similar to _oA_16_Merge_given_Intervals
 */
package Code_Run_Build_LC350;
import java.util.Arrays;
public class _oA_19_MinimumMeetingRooms {
    public static int minimumMeetingRoomsRequired(int[][] intervals){

        // some base case
        if(intervals == null || intervals.length ==0) return 0;
        if(intervals.length ==1) return 1;

        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        // load both arrays
        for(int i =0; i< intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        //Logic: sort the start and end in increasing order and two pointer
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        /*For eg:
        Starts 1,5,6,9,10   Ends 8,11,12,13,14
        so meeting 1,5,6 start before first meeting ends at 8 so we need 3 rooms.
        For 9 and 8 we just move i++ and j++ ( think of as it took the spot of the meeting ended at 8.)
        then for 10 and 11.. all previous rooms are occupied and one of them ends after 10...
        so we need a room for a meeting starting at 10 so total 4 rooms */
        int rooms = 0;
        int j = 0;
        for (int startTime : startTimes) {
            if (startTime < endTimes[j])
                rooms++;
            else
                j++;
        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] meetings = {{1, 3}, {5, 6}, {7, 9}, {2, 3}, {5, 7}};
        int[][] meetings1 = {{1, 3}, {5, 6}, {7, 9}, {2, 3}, {5, 7}};
        int c = minimumMeetingRoomsRequired(meetings);
        System.out.println(c);
    }
}
