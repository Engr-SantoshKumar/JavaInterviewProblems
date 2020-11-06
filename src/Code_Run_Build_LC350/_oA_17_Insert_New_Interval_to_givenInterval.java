/*
 * [ _oA_17_ ] [ [Pattern: Merge Intervals ] Insert Interval ]
 * ___________________________________________________________________________________________________________
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
package Code_Run_Build_LC350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _oA_17_Insert_New_Interval_to_givenInterval {

    public static int[][] mergeNewIntervalToGivenInterval(int[][] givenIntervals, int[] newInterval) {
        //base cases
        if (givenIntervals.length <= 1) return givenIntervals;

        //Sort the given intervals by their starting points
        Arrays.sort(givenIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List to store result
        List<int[]> result = new ArrayList<>();
        int newIntervalStart = newInterval[0];
        int newIntervalEnd   = newInterval[1];
        int index=0; int len = givenIntervals.length;

        //lets put all the intervals which ends before the new interval's startt
        while(index < len && givenIntervals[index][1] < newIntervalStart){
            result.add(givenIntervals[index]);
            index++;
        }
        // merge case: combine all given intervals which has end < newInterval *END*
        //int[] mergeInterval = new int[2];
        // now we need to combine these intervals by keep on updating the newIntervalStart and newIntervalEnd
        //while loop as there could be multiple merge of intervals e.g {[3,5],[6,7],[8,10]} + [4,8] --> [3,10]
        while(index < len && givenIntervals[index][0] <= newIntervalEnd){
            newIntervalStart = Math.min(givenIntervals[index][0], newIntervalStart);
            newIntervalEnd =  Math.max(givenIntervals[index][1], newIntervalEnd );
            ++index;
        }
        result.add(new int[]{newIntervalStart, newIntervalEnd});

        // lets add the remaining to result i.e remaining as start > newInterval's End
        while(index < len){
            result.add(givenIntervals[index++]);
        }

        return result.toArray(new int[0][0]);

    }

    public static void main(String[] args) {
        int[][] givenIntervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};
        printMatrix(givenIntervals);
        int[][] result = mergeNewIntervalToGivenInterval(givenIntervals, newInterval);
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
