/**
 [ Goo2_08] [ SkyLine Problem ]
 ____________________________________________________________________________________________________________________
 Leetcode 218. The Skyline Problem
 Time complexity is O(nlogn)
 Space complexity is O(n)

 Logic:
 a. for start point, convert the height into negative height value
 b. end point has normal height value
 c. use max PQ.. when starting point add to pq and when end remove from pq
 */

package PrepSetTwo;
import java.util.*;
public class _Goo2_08_1_Skyline_problem_WithoutObj {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]}); // start point has negative height value
            height.add(new int[]{b[1], b[2]}); // end point has normal height value
        }

        // sort height, based on the first value, if necessary, use the second to break ties
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int[] h:height){
            System.out.println(Arrays.toString(h));
        }

        // Use a maxHeap to store possible heights (max at top)
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // same as PriorityQueue<>(Collections.reverseOrder())

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;


        for(int[] h:height) {
            // a start point, add height
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
            // this is the end point, so no need to keep the height of this building
                pq.remove(h[1]);
            }
            // current max height;
            int curMax = pq.peek();

            // compare current max height with previous max height, update result and previous max height if necessary
            if(prev != curMax) {
                result.add(new int[]{h[0], curMax});
                prev = curMax;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        _Goo2_08_1_Skyline_problem_WithoutObj sd = new _Goo2_08_1_Skyline_problem_WithoutObj();
        List<int[]> criticalPoints = sd.getSkyline(buildings);
        criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));
    }
}
