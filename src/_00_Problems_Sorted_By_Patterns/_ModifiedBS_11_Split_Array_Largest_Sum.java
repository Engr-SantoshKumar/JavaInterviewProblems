/* [ _ModifiedBS_10_S ] [ 410. Split Array Largest Sum  ]
_______________________________________________________________________________
    Given an array nums which consists of non-negative integers and an integer m,
    you can split the array into m non-empty continuous subarrays.

    Input: nums = [7,2,5,10,8], m = 2
    all possible ways: 7|2+5+10+8   7+2|5+10+8   7+2+5|10+8   7+2+5+10|8
 
        Output: 18 -->  [7,2,5] and [10,8]  ---> 14|18 -->
        where the largest sum among the two subArrays is only 18.
    
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_11_Split_Array_Largest_Sum {
    /*
      ●  What we learned from given explanation: Minimum of maximum largest sum
            ○ When dividing array to each cells the minimum Max will be 10 (when noOfDivision = noOfElements)
            ○ Or When just one division allowed minMax = sumOfAllElements = 7+2+5+10+8 = 35 (when noOfDivisionAllowed = 1)
      ●  The answer is between maximum value of input array numbers and sum of those numbers.
            Use binary search to approach the correct answer. We have
            ○  lo = max number of array; hi = sum of all numbers in the array;
            ○  Every time we do mid = lo + (hi - lo) / 2;
      ●  Use greedy to narrow down left and right boundaries in binary search.
        ○  Cut the array from mid. Try our best to make sure that the sum of numbers between each
            two cuts (inclusive) is large enough but still less than mid.
        ○  We'll end up with two results: either we can divide the array into more than m subArrays or we cannot.
          ●  If we can, it means that the mid value we pick is too small because we've already tried
               our best to make sure each part holds as many non-negative numbers as we can but we still
               have numbers left. So, it is impossible to cut the array into m parts and make sure each
               parts is no larger than mid. We should increase m. This leads to l = mid + 1;
          ●  If we can't, it is either we successfully divide the array into m parts and the sum of each part
               is less than mid, or we used up all numbers before we reach m. Both of them mean that we should
               lower mid because we need to find the minimum one. This leads to r = mid - 1;
     
               ● Time complexity: O(n * log(sum of array))
                The binary search costs O(log(sum of array)) *
                the time complexity is O(n) since we only need to go through the whole array.
     */
    
        public static int splitArray(int[] array, int noOfSplits) {
            int maxElement = 0;
            int totalSum = 0;
            for (int num : array) {
                maxElement = Math.max(num, maxElement);
                totalSum += num;
            }
            //  ●   high
            if (noOfSplits == 1) return totalSum;
            //  ●   low
            if (noOfSplits == array.length) return maxElement;
            
            //  ●   inBetween : lets Do binary search
            int lo = maxElement;
            int hi = totalSum;
            int result = 0;
            while (lo <= hi) {
                int mid = lo + (hi-lo)/ 2;
                if (isPossible(array, noOfSplits, mid)) {
                    result = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return result;
        }
        public static boolean isPossible(int[] array, int noOfSplitsAllowed, int target) {
            int count = 1;
            int total = 0;
            for(int ar : array) {
                total += ar;
                if (total > target) {
                    count++;
                    total = ar; // we will include the number in the next sum, so we can ensure all numbers are less than target
                                // reset currentPageSum to current book page count as now its assign to new guy
                }
            }
            return count <= noOfSplitsAllowed;
        }
    
    public static void main(String[] args) {
        int[] arr = new int[]{7,2,5,10,8};
        int splitInto = 2;
        System.out.println(splitArray(arr, splitInto));
    }

}
