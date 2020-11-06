/*
 * [ _oA_16_] [ [Pattern: Merge Intervals ] Merge given Intervals  ]
______________________________________________________________________________________________________________
* Given a collection of intervals, merge all overlapping intervals.
 Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
* Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
One way to solve is creating interval class solved in :
 _Goo_13_b_Merge Interval
 https://github.com/Engr-SantoshKumar/JavaInterviewProblems/blob/master/src/GooPrep/_Goo_13_b_Merge_Intervals.java
 */
package Code_Run_Build_LC350;
import java.util.*;
public class _oA_16_Merge_given_Intervals {

    public static int[][] mergeGivenInterval(int[][] givenIntervals) {
        //base cases
        if (givenIntervals.length <= 1) return givenIntervals;

        //Sort the intervals by their starting points
        Arrays.sort(givenIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List to store result
        List<int[]> result = new ArrayList<>();

        // take the first interval and compare its end with the next intervals starts.
        // if overlap (currentEnd > nextStart), we update the end with max(currentEnd, nextEnd)
        // Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
        int[] currentInterval = givenIntervals[0];
        result.add(currentInterval);
        for (int[] nextInterval : givenIntervals) {
            // if overlap (currentEnd > nextStart), we update the end with max(currentEnd, nextEnd)
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } // Disjoint intervals, update currentInterval to nextInterval and add to the list
            else {
                result.add(nextInterval);
                currentInterval = nextInterval;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] givenIntervals = {{6, 7}, {2, 4}, {5, 9}};
        printMatrix(givenIntervals);
        int[][] result = mergeGivenInterval(givenIntervals);
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
