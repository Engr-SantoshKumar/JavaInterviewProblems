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
Move to time line from left to right and add when pickUp and subtract when dropOff and count count should not over the capacity
So what we need:
1. need trips in sorted order on pickup time
Way to solve created an array of size of lastDrop of point say 9 (array size 9+1=10) and scan the trips and
update start=index=+pickUpPassengerCount and end=index=-dropOffPassengerCount
                  ↑                                       ↑
        arr[trip[1]] = +trip[0]                 arr[trip[2]] = -trip[0]
2. Another way to use map(sortedMap) --> treeMap
    Key:StartPoint Value:+PassengerCount
    Key:EndPoint   Value:-PassengerCount

*/
package _00_Problems_Sorted_By_Patterns;
public class _MergeIntervals_04_Car_Pooling {
    public static boolean carPoolingUsingArray(int[][] trips, int capacity) {
        int maxArraySize =0;
        for(int[] curTrip: trips){
            int curTripEnd = curTrip[2];
            maxArraySize=Math.max(maxArraySize,curTripEnd);

        }
        int[] distArray = new int[maxArraySize+1];

        //scan array and update distance array index
        for(int[] curTrip: trips) {
            int curPassenger = curTrip[0];
            int curTripStart = curTrip[1];
            int curTripEnd   = curTrip[2];
            //updateArray
            distArray[curTripStart] += curPassenger;
            distArray[curTripEnd] -= curPassenger;
        }
        //fill the array with accumulative sum and at the same time check for maxCapacity
        for(int i=1; i<distArray.length; i++){
            distArray[i] += distArray[i-1];
            if(distArray[i]>capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = new int[][]{{3,2,7},{3,7,9},{8,3,9}};
        System.out.println(carPoolingUsingArray(trips, 11));
    }
}
