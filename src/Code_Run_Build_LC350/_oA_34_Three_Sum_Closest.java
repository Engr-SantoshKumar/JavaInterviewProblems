/* [ _oA_34_ ] [ 3Sum Closest ]
_______________________________________________________________________________
Given an array nums of n integers and an integer target, find three integers in
 nums such that the sum is closest to target. Return the sum of the three integers.
 You may assume that each input would have exactly one solution.

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
package Code_Run_Build_LC350;

import java.util.Arrays;

public class _oA_34_Three_Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int l = i + 1, r = sz - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                //to take care of duplicates
                while(l < r && nums[l]==nums[l+1]) l++;
                while(l < r && nums[r]==nums[r-1]) r--;

                if (sum < target)
                    ++l;
                else
                    --r;
            }
            //to take care of duplicates
            if(nums[i]==nums[i+1]) i++;
        }
        return target - diff;
    }
}
