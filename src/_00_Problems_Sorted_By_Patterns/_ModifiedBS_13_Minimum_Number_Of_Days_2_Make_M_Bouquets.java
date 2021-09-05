/* [ _ModifiedBS_13_ ] [ Minimum Number of Days to Make m Bouquets ]
_______________________________________________________________________________
    Given an integer array bloomDay, an integer m and an integer k.
    We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

    The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
    Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
    If it is impossible to make m bouquets return -1.

    Input: bloomDay = [1,10,3,10,2], m (bouquets) = 3, k(adjacentFlowers) = 1
        Output: 3  ---> Let's see what happened in the first three days. x means flower bloomed and _ means flower
        didn't bloom in the garden. We need 3 bouquets each should contain 1 flower.
            After day 1: [x, _, _, _, _]   // we can only make one bouquet.
            After day 2: [x, _, _, _, x]   // we can only make two bouquets.
            After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

    Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
    Output: -1  --> We need 3 bouquets each has 2 flowers, that means we need 6 flowers.
    We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_13_Minimum_Number_Of_Days_2_Make_M_Bouquets {
    /*
        Given mid days, we can know which flowers blooms. Now the problem is, given an array of true and false,
        find out how many adjacent true bouquet in total.
        If bouquet < bouquets, mid is still small for bouquets bouquet.
            So we turn left = mid + 1
            If bouquet >= bouquets, mid is big enough for bouquets bouquet.
            So we turn right = mid
        ● Time Complexity: O(nLog(maxdays))
     */
    public static int minDays(int[] bloomDay, int bouquets, int adjFlowers) {
        //check if we have enough flowers
        if (bloomDay.length < bouquets * adjFlowers)
            return -1;
        int minDaysToBloom = Integer.MAX_VALUE;
        int maxDaysToBloom = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            maxDaysToBloom = Math.max(maxDaysToBloom, day);
            minDaysToBloom = Math.min(minDaysToBloom, day);
        }
        //  low
        if (bouquets == 1 && adjFlowers == 1)
            return minDaysToBloom;
        //  high
        if (bouquets == bloomDay.length)
            return maxDaysToBloom;
    
        //  inBetween : lets Do binary search, boundary starting from min to the max day in the bloomDay.
        int lo = minDaysToBloom;
        int hi = maxDaysToBloom;
        int result = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(bloomDay, bouquets, adjFlowers, mid)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }
    
    // This method is to find, if possible to formed given bouquets in given day(targetDay).
    private static boolean isPossible(int[] bloomDay, int bouquets, int adjFlowers, int targetDay) {
        int curBouquets = 0;
        int flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= targetDay) {  // If the current flower bloomed by targetDay, increase flowersCollected.
                flowersCollected++;
                if (flowersCollected == adjFlowers) {  //If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
                    curBouquets++;
                    flowersCollected = 0;
                }
            } else {  //If there is a flower in between that takes more number of days then the given day, then resent the counter.
                flowersCollected = 0;
            }
        }
        return curBouquets >= bouquets; //created more bouquets than required in targetDays? yes reduceTarget else increase
    }
    public static void main(String[] args) {
        int[] bloomDay = new int[]{1,10,3,10,2, 5,15};
        int days = 3;
        int adjFlowers = 2;
        System.out.println(minDays(bloomDay, days, adjFlowers));
    }
    
}
