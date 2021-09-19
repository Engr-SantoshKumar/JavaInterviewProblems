/* [ _ModifiedBS_10_ ] [ 1011. Capacity To Ship Packages Within D Days ]
_______________________________________________________________________________
    A conveyor belt has packages that must be shipped from one port to another within days days.
    The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with
    packages on the conveyor belt (in the order given by weights).
    We may not load more weight than the maximum weight capacity of the ship.

    Return the least weight capacity of the ship that will result in all the packages on the conveyor
    belt being shipped within given days.

    Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
    Output: 15
    Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
        1st day: 1, 2, 3, 4, 5
        2nd day: 6, 7
        3rd day: 8
        4th day: 9
        5th day: 10

    Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting
    the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_12_Capacity_To_Ship_Packages_Within_D_Days {
    /*
          Logic is excitedly same as last problem
          ● minCapacity required: max weight size --> days == sizeOfWeightsArray
          ● maxCapacity required: allWeightsTogether --> days == 1 day
          ● Range, answer will be somewhere between minCapacity - maxCapacity
          ● Time complexity: O(n * log(sum of array))
                The binary search costs O(log(sum of array)) *
                the time complexity is O(n) since we only need to go through the whole array.
     */
    public static int splitArray(int[] weights, int givenDays) {
        int maxSingleWeight = 0;
        int totalWeightsTogether = 0;
        for (int num : weights) {
            maxSingleWeight = Math.max(num, maxSingleWeight);
            totalWeightsTogether += num;
        }
        //  ●   high
        if (givenDays == 1)
            return totalWeightsTogether;
        //  ●   low
        if (givenDays == weights.length)
            return maxSingleWeight;
        
        //  ●   inBetween : lets Do binary search
        int lo = maxSingleWeight;
        int hi = totalWeightsTogether;
        int result = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/ 2;
            if (isPossible(weights, givenDays, mid)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }
    public static boolean isPossible(int[] weights, int givenDays, int target) {
        int curDaysReq = 1;
        int curWeight = 0;
        for(int weight : weights) {
            curWeight += weight;
            if (curWeight > target) {
                curDaysReq++;
                curWeight = weight; // we will include the number in the next sum, so we can ensure all numbers are less than target
                                    // reset currentWeightSum to current weight as now its goto new belt
            }
        }
        return curDaysReq <= givenDays;  //finished the job before target? yes reduceTarget else increaseTarget
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int givenTime = 5;
        System.out.println(splitArray(arr, givenTime));
    }
}
