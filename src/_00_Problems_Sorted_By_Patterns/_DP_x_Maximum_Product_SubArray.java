/* [ _DP_02_ ] [ LC152: Maximum Product SubArray ]
_______________________________________________________________________________
watch for:
Zeros:Zeros will reset your combo chain. store until now high in placeholder result. restart combo chain after zero.
Negative numbers: A single negative number can flip the largest combo chain to a very small number.

While going through numbers in nums, we will have to keep track of the maximum product up to that number
(we will call max_so_far) and minimum product up to that number (we will call min_so_far).
The reason behind keeping track of max_so_far is to keep track of the accumulated product of positive numbers.
The reason behind keeping track of min_so_far is to properly handle negative numbers.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;
public class _DP_x_Maximum_Product_SubArray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            //at each index we compute max and min and update maxSiFar and minSoFar
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            //update global max
            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

}



