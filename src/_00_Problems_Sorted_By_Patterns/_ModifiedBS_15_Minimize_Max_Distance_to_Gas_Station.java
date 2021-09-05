/* [ _ModifiedBS_15_ ] [ Minimize Max Distance to Gas Station ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
You are given an integer array stations that represents the positions of the gas stations on the x-axis.
You are also given an integer k.

You should add k new gas stations. You can add the stations anywhere on the x-axis, and not necessarily on an integer position.

Let penalty() be the maximum distance between adjacent gas stations after adding the k new stations.

Return the smallest possible value of penalty(). Answers within 10-6 of the actual answer will be accepted.

Example 1:

Input: stations = [1,2,3,4,5,6,7,8,9,10], k = 9
Output: 0.50000
Example 2:

Input: stations = [23,24,36,39,46,56,57,65,84,98], k = 1
Output: 14.00000

*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_15_Minimize_Max_Distance_to_Gas_Station {
    
    public static double minMaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mid = (lo + hi) / 2.0;
            if (isPossible(stations, K, mid))
                hi = mid;
            else
                lo = mid;
        }
        return lo;
    }
    
    public static boolean isPossible(int[] stations, int K, double mid) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i)
            used += (int) ((stations[i+1] - stations[i]) / mid);
        return used <= K;
    }
    
    public static void main(String[] args) {
        int[] stations = new int[]{23,24,36,39,46,56,57,65,84,98};
        int[] stations1 = new int[]{1, 4, 10};
        int K = 1;
        //System.out.println(minMaxGasDist(stations, K));
        System.out.println(minMaxGasDist(stations1, K));
    }
}
