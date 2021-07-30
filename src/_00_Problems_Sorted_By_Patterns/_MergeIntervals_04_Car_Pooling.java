/* [ _MergeIntervals_04_ ] [ Car Pooling ]
_______________________________________________________________________________
Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains
information about the i-th trip: the number of passengers that must be picked up, and the locations to
pick them up and drop them off.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false (there was a time when passenger were more than capacity e.g at 3 ,4 on overlapping

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
   PickPassengers-->   +3   +8            -3drop/+3pick           drop -3 and -8
        timeLine   ----|----|--------------|----------------------|---
   Start/End           2    3             7                       9

Logic:

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _MergeIntervals_04_Car_Pooling {

    public static boolean carPoolingUsingMergeInterval(int[][] trips, int capacity) {
        //same logic of problem: min meeting room
        Arrays.sort(trips, (a, b)->(a[1]-b[1]));
        //pq sort on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[2]-b[2]));
        int passengerCount =0;
        for(int[] curTrip : trips){
            // if curTrip starts after the oldTrip(currently in PQ) ends, then passenger -= oldTrp=> pq.poll()[0];
            while(!pq.isEmpty() && curTrip[1] > pq.peek()[2]){
                passengerCount -= pq.poll()[0];
            }
            passengerCount += curTrip[0];
            if(passengerCount > capacity) return false;
            // add curTRip to pq
            pq.add(curTrip);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = new int[][]{{3,2,7},{3,7,9},{8,3,9}};
        System.out.println(carPoolingUsingMergeInterval(trips, 11));
    }
}
