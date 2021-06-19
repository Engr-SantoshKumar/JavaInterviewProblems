/**
 * [ _0A_ ] [ Sub Array Sum Equals K ]
 * ____________________________________________________________________________________________________________
 https://www.youtube.com/watch?v=HbbYPQc-Oo4&t=306s
 Given an array of integers and an integer k, you need to find the total number of continuous
 subArrays whose sum equals to k.
NOTE: Sliding window -- will NoT work, contains negative number
 Input:nums = [1,1,1], k = 2
 Output: 2
Logic: we can use the logic of two sum with some modification
 we just need to go through the array, calculate the current sum and
 save number of all seen PreSum to a HashMap((sum_i, no. of occurrences of sum_i).
 Time complexity O(n), Space complexity O(n).

 equation:
 => currentSum -K = value;
 => currentSum = value + k;

 */
package Code_Run_Build_LC350;

import java.util.HashMap;
import java.util.Map;

public class _oA_13_SubArray_Sum_Equals_K {
        static int subArraySum(int[] arr, int k){
            int result =0;
            int sum=0;
            // preSumMap(sum, noOfOccurrenceOfSum)
            Map<Integer, Integer> preSumMap = new HashMap<>();
            // default value in preSumMap (sum =0, noOfOccurrenceOfSum =1)
            preSumMap.put(0,1);

            for(int i=0; i<arr.length; i++){
                sum += arr[i];
                /* check preSumMap : if present, it means there is some sum value v between 0 and x,
                which makes sum of array [x + 1 to i] == k, and the frequency is  x */
                if(preSumMap.containsKey(sum-k)){
                    result+=preSumMap.get(sum-k);
                }
                preSumMap.put(sum,preSumMap.getOrDefault(sum, 0) +1);
            }
            return result;
        }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1};
        //System.out.println(subArraySum(arr, 2));
        int[] arr1 = {1,1,0,-1,1,1};
        System.out.println(subArraySum(arr1, 2));
    }

}
